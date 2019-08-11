// simulate a universe specified in one of the data files.

import java.util.List;
import java.util.ArrayList;

public class NBody {

  // method 1: return radius of the universe
  public static double readRadius(String fn) {
    In in = new In(fn);
    int num = in.readInt();
    double radius = in.readDouble();
    return radius;
  }

  // method 2: return an array of planets
  public static Body[] readBodies(String fn) {
    In in = new In(fn);
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
    System.out.println(planets.size());
    planets.toArray(planetsArray);

    return planetsArray;
  }
}