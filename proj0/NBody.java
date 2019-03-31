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
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String fileName = args[2];
    Planet[] planets = readPlanets(fileName);
    double radius = readRadius(fileName);

    StdDraw.setScale(-radius, radius);



    StdDraw.enableDoubleBuffering();


    double time = 0;
    double[] xForces = new double[planets.length];
    double[] yForces = new double[planets.length];
    while (time < T) {
      time += dt;
      /* Clears the drawing window. */
  		StdDraw.clear();
      /* Stamps three copies of advice.png in a triangular pattern. */
  		StdDraw.picture(0, 0, "/images/starfield.jpg");

      for (int i = 0; i < planets.length; i++) {
        xForces[i] = planets[i].calcNetForceExertedByX(planets);
        yForces[i] = planets[i].calcNetForceExertedByY(planets);
      }

      for (int i = 0; i < planets.length; i++) {
        planets[i].update(dt, xForces[i], yForces[i]);
        planets[i].draw();
      }
      StdDraw.show();
    }

    StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < planets.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
    }

  }
}
