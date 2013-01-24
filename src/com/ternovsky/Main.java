package com.ternovsky;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ternovsky
 * Date: 22.01.13
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static List<Particle> particles = new ArrayList<Particle>();
    public static final double PARAM = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("5A.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] coordinates = line.split("\\s+");
            double x = Double.parseDouble(coordinates[0]);
            double y = Double.parseDouble(coordinates[1]);
            double z = Double.parseDouble(coordinates[2]);
            particles.add(new Particle(x, y, z));
        }

        System.out.println(getEnergy(particles));
    }

    public static double getEnergy(List<Particle> particles) {
        double energy = 0;
        for (int i = 0; i < particles.size(); i++) {
            for (int j = i + 1; j < particles.size(); j++) {
                double r = getDistance(particles.get(i), particles.get(j));
                energy += Math.pow(Math.E, PARAM * (1 - r)) * (Math.pow(Math.E, PARAM * (1 - r)) - 2);
            }
        }

        return energy;
    }

    public static double getDistance(Particle particle1, Particle particle2) {
        double dx2 = Math.pow(particle1.x - particle2.x, 2);
        double dy2 = Math.pow(particle1.y - particle2.y, 2);
        double dz2 = Math.pow(particle1.z - particle2.z, 2);
        return Math.pow(dx2 + dy2 + dz2, 0.5);
    }
}
