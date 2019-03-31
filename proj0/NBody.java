public class NBody {
  public NBody() {

  }

  public static double readRadius(String file) {
    In in = new In(file);
    int numPlanets = in.readInt();
    double radius = in.readDouble();
    return radius;
  }

  public static Planet[] readPlanets(String file) {
    In in = new In(file);
    int numPlanets = in.readInt();
    double radius = in.readDouble();
    Planet[] planets = new Planet[numPlanets];

    for (int i = 0; i < numPlanets; i++) {
      double xxPos = in.readDouble();
      double yyPos = in.readDouble();
      double xxVel = in.readDouble();
      double yyVel = in.readDouble();
      double mass = in.readDouble();
      String name = in.readString();


      planets[i] =
        new Planet(xxPos, yyPos, xxVel, yyVel, mass, name);

    }
    return planets;

  }

  public static void main(String[] args) {


  }
}
