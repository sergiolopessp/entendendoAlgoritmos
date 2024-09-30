package org.example.model;

public class Point {
    public double[] p;
    public int[] ip;
    public int dim;

    public Point(double[] p){
        this.dim = p.length;
        this.p = p.clone();
    }

    public Point(int[] p){
        this.dim = p.length;
        this.ip = p.clone();
    }

    public Point(int dim){
        this.dim = dim;
        p = new double[dim];
    }

    public double norm(){
        double sum = 0;
        for (int i = 0; i < dim; i++) {
            sum += Math.pow(this.p[i],2);
        }
        return Math.sqrt(sum);
    }

    public double dist(Point b) {
        double sum = 0;
        for (int i = 0; i < dim; i++) {
            sum += Math.pow(this.p[i] - b.p[i], 2);
        }
        return Math.sqrt(sum);
    }

    public static Point add(Point a, Point b) throws IllegalArgumentException{
        if (a.dim != b.dim) {
            throw new IllegalArgumentException("Adicionando pontos de diferentes dimensões");
        }
        int dim = a.dim;
        double[] cp = new double[dim];
        for (int i = 0; i < dim; i++) {
            cp[i] = a.p[i] + b.p[i];
        }

        return new Point(cp);
    }

    public static Point mid(Point a, Point b) throws IllegalArgumentException{
        if (a.dim != b.dim) {
            throw new IllegalArgumentException("Pontos Incompatíveis");
        }
        int dim = a.dim;
        double[] cor = new double[dim];
        for (int i = 0; i < dim; i++) {
            cor[i] = (a.p[i] + b.p[i]) / 2.0;
        }
        return new Point(cor);
    }

    public Point mull(double a){
        double[] pMull = new double[this.dim];
        Point m =  new Point(pMull);
        for (int i = 0; i < this.dim; i++) {
            m.p[i] = this.p[i] * a;
        }
        return m;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Ponto: [");
       if (this.p != null) {
           for (int i = 0; i < this.dim; i++) {
               s.append((float)p[i]);
               if (i == this.dim - 1) {
                   s.append("]");
               } else {
                   s.append(",");
               }
           }
           return s.toString();
       } else {
           for (int i = 0; i < this.dim; i++){
               s.append(ip[i]);
               if (i == this.dim - 1) {
                   s.append("]");
               } else {
                   s.append(",");
               }
           }
           return s.toString();
       }
    }
}
