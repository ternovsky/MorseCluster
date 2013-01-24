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

        Conformation conformation = new Conformation();
        conformation.setParameter(PARAM);
        conformation.setParticles(particles);
        conformation.getEnergy();
        System.out.print(conformation.toString());
    }
}
