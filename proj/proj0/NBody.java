// simulate a universe specified in one of the data files.

import java.util.List;
import java.util.ArrayList;

public class NBody {

  // method 1: return radius of the universe
  public static double readRadius(String filename) {
    In in = new In(filename);
    int num = in.readInt();
    double radius = in.readDouble();
    return radius;
  }

  // method 2: return an array of planets
  public static Body[] readBodies(String filename) {
    In in = new In(filename);
    /** 
     *  Create an empty array list first called planets 
     *  beacuase we have not known the number of planets yet
     */
    List<Body> planets = new ArrayList<Body>();
    // skip the first two lines (number and radius)
    int num = in.readInt();
    double radius = in.readDouble();
    /** 
      to avoid offset of the first string, assign it to a variable called x for later use
      readString(): Reads the next token and returns the String
    */ 
    String x = in.readString();
    // [!] is the sign of end reading planets
    while (!(x.equals("[!]"))) {
      // assign to variables  
      double xxPos = Double.parseDouble(x);
      double yyPos = Double.parseDouble(in.readString());
      double xxVel = Double.parseDouble(in.readString());
      double yyVel = Double.parseDouble(in.readString());
      double mass = Double.parseDouble(in.readString());
      String img = in.readString();
      // read next line
      x = in.readString();
      // create a instance and add to the arrayList
      Body planet = new Body(xxPos, yyPos, xxVel, yyVel, mass, img);
      planets.add(planet);
    }
    /**  
     *  Create an array(planetsArray) from the ArrayList(planets)
     *  Because we need to return an array but now we have a ArrayList
     *  when using Array, must assign the size!
    */
    Body[] planetsArray = new Body[planets.size()];
    planets.toArray(planetsArray);

    return planetsArray;
  }

    /** 
     * main function arguments: T, dt, filename
    */
  public static void main(String[] args) {
    /** 
     * convert String to Double: 
     * double .. = Double.parseDouble(..)
    */
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];

    double radius = readRadius(filename);
    Body[] planetsArray = readBodies(filename);

    // Create the animation
    StdDraw.enableDoubleBuffering();
    StdDraw.setScale(-radius, radius);
    StdDraw.clear();

    // Drawing more than one body
    for (int t = 0; t <= T; t += dt) {
      double[] xForces = new double[planetsArray.length];
      double[] yForces = new double[planetsArray.length];

      for (int m = 0; m < planetsArray.length; m++) {
          xForces[m] = planetsArray[m].calcNetForceExertedByX(planetsArray);
          yForces[m] = planetsArray[m].calcNetForceExertedByY(planetsArray);
      }

      for (int m = 0; m < planetsArray.length; m++) {
        planetsArray[m].update(dt, xForces[m], yForces[m]);
      }

      // Draw the background first
      StdDraw.picture(0, 0, "images/starfield.jpg");

      // Draw all of the planets
      for (int n = 0; n < planetsArray.length; n++) {
        planetsArray[n].draw();
      }

      StdDraw.show();
      StdDraw.pause(10);
    }

    // print the universe
    StdOut.printf("%d\n", planetsArray.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < planetsArray.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
          planetsArray[i].xxPos, planetsArray[i].yyPos, planetsArray[i].xxVel,
          planetsArray[i].yyVel, planetsArray[i].mass, planetsArray[i].imgFileName);   
    }

  }
}