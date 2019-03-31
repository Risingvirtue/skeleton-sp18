public class Planet {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;

  public Planet(double xP, double yP, double xV,
    double yV, double m, String img) {
      xxPos = xP;
      yyPos = yP;
      xxVel = xV;
      yyVel = yV;
      mass = m;
      imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;

  }

  public double calcDistance(Planet p) {
    double xSqr = (xxPos - p.xxPos) * (xxPos - p.xxPos);
    double ySqr = (yyPos - p.yyPos) * (yyPos - p.yyPos);
    return Math.sqrt(xSqr + ySqr);
  }

  public double calcForceExertedBy(Planet p) {
    final double G = 6.67 * Math.pow(10, -11);
    final double r = calcDistance(p);
    return (G * mass * p.mass) / (r * r);
  }

  public double calcForceExertedByX(Planet p) {
    final double dx = p.xxPos - xxPos;
    final double r = calcDistance(p);
    final double f1 = calcForceExertedBy(p);
    return (f1 * dx) / (r);
  }

  public double calcForceExertedByY(Planet p) {
    final double dy = p.yyPos - yyPos;
    final double r = calcDistance(p);
    final double f1 = calcForceExertedBy(p);
    return (f1 * dy) / (r);
  }

  public void update(double dt, double xxF, double yyF) {
    xxVel += dt * (xxF / mass);
    yyVel += dt * (yyF / mass);
    xxPos += dt * xxVel;
    yyPos += dt * yyVel;
  }


}
