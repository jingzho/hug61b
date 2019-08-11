/**
  Project 0: Nbody Simulation
 */

public class Body {
  
  // instance variables
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;

  /** 
   * constructor 1: 
   * initialize a planet object.
  */
  public Body(double xP, double yP, double xV, double yV, double m, String img){
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  };

  /** 
   * constructor 2: 
   * initialize an identical Planet object as b.
   */
  public Body(Body b){
    xxPos = b.xxPos;
    yyPos = b.yyPos;
    xxVel = b.xxVel;
    yyVel = b.yyVel;
    mass = b.mass;
    imgFileName = b.imgFileName;
  };

  /** 
   * method 1: 
   * calculate the distance between two bodies
  */
  public double calcDistance(Body b) {
    double dist = Math.pow((b.xxPos - this.xxPos),2.0) + Math.pow((b.yyPos - this.yyPos),2.0);
    return Math.sqrt(dist);
  }

  /** 
   * method 2: 
   * calculate the force exerted on this body by the given body
  */
  public double calcForceExertedBy(Body b) {
    double G = 6.67e-11; 
    double radisSqr = Math.pow(this.calcDistance(b), 2.0);
    return (G * b.mass * this.mass) / radisSqr;
  }

  /** 
   * method 3: 
   * calculate the force exerted in the X directions
  */
  public double calcForceExertedByX(Body b) {
    double force = this.calcForceExertedBy(b);
    double radis = this.calcDistance(b);
    double dx = b.xxPos - this.xxPos;
    return (force * dx) / radis;
  }

  /** 
   * method 4: 
   * calculate the force exerted in the Y directions
  */
  public double calcForceExertedByY(Body b) {
    double force = this.calcForceExertedBy(b);
    double radis = this.calcDistance(b);
    double dy = b.yyPos - this.yyPos;
    return (force * dy) / radis;
  }

  /** 
   * method 5: 
   * calculate the net X force exerted by all bodies in that array upon the current Body.
  */
  public double calcNetForceExertedByX(Body[] bs) {
    double fX = 0;
    // for (int i = 0; i < bs.length; i++) {
    //   if (!this.equals(bs[i])) {
    //     fx += this.calcForceExertedByX(bs[i]);
    //   }
    // }
    for (Body element : bs) {
      if(!this.equals(element)) {
        fX += this.calcForceExertedByX(element);
      }
    }
    return fX;
  }
  
  /** 
   * method 6: 
   * calculate the net Y force exerted by all bodies in that array upon the current Body.
  */
  public double calcNetForceExertedByY(Body[] bs) {
    double fY = 0;
    // for (int i = 0; i < bs.length; i++) {
    //   if (!this.equals(bs[i])) {
    //     fy += this.calcForceExertedByY(bs[i]);
    //   }
    // }
    for (Body element : bs) {
      if(!this.equals(element)) {
        fY += this.calcForceExertedByY(element);
      }
    }
    return fY;
  }

  public void update(double dt, double fX, double fY) {
    // Calculate the acceleration using the provided x- and y-forces.
      double aX = fX / this.mass;
      double aY = fY / this.mass;
    /** 
     * Calculate the new velocity by using the acceleration and current velocity. 
     * Recall that acceleration describes the change in velocity per unit time
     * so the new velocity is (vx+dt⋅ax,vy+dt⋅ay).
    */
      this.xxVel += dt * aX;
      this.yyVel += dt * aY;
    /** 
     * Calculate the new position by using the velocity computed in step 2 and the current position.
     * The new position is (px+dt⋅vx,py+dt⋅vy)
    */
      this.xxPos += dt * this.xxVel;
      this.yyPos += dt * this.yyVel; 
  }

    /** 
     * Drawing One Body:
     * Uses the StdDraw API mentioned above to draw the Planet’s image at the Planet’s position.
    */
    public void draw() {
      String imgpath = "./images/" + this.imgFileName;
      StdDraw.picture(this.xxPos, this.yyPos, imgpath);
  }
  
}