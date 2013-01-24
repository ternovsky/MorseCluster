package com.ternovsky;

public class Particle {

    public double x;
    public double y;
    public double z;

    public Particle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")\n";
    }
}