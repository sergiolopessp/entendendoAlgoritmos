package org.example.service;

import org.example.model.Point;

public class Rastrigin {
    private double a;
    private double n;

    public Rastrigin(double a, double n){
        this.a = a;
        this.n = n;
    }

    public double f(Point x) {
        double sum = 0;
        //o = numpy.sum(x ** 2 - 10 * numpy.cos(2 * math.pi * x)) + 10 * dim
        for (int i = 0; i < x.dim; i++) {
            sum += Math.pow(x.p[i], 2) - a*Math.cos(2*Math.PI*x.p[i]);
        }
        return a*n + sum;
    }
}
