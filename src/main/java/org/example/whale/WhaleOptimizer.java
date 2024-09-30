package org.example.whale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Point;
import org.example.model.Rastrigin;

import java.security.SecureRandom;

public class WhaleOptimizer {

    int popSize;
    int iterations;
    int dimensions;
    int ub=100;
    int lb=-100;
    double[] fitness;
    
    double[] bestSolution;
    double minValueOfSolution;
    double leaderDistance;
    double[][] positions;
    
    double a;
    double a2;
    double  p;

    SecureRandom random = new SecureRandom();

    private static final Logger logger = LogManager.getLogger(WhaleOptimizer.class);
    
    public WhaleOptimizer(int iterations, int popSize, int dimensions) {
        this.iterations = iterations;
        this.popSize = popSize;
        this.dimensions = dimensions;
        positions = new double[popSize][dimensions];
        fitness = new double[popSize];


        for (int i = 0; i < popSize; i++) {
            for (int j = 0; j < dimensions; j++) {
                positions[i][j] = lb + random.nextDouble() * (ub - lb);
            }
        }
        
        for (int i = 0; i < popSize; i++) {
            fitness[i] = fitnessCalculator(positions[i]);
        }
        
        int bestIndex = indexOfSmallest(fitness);
        bestSolution = positions[bestIndex];
        minValueOfSolution = smallestInArray(fitness);
    }

    private double smallestInArray(double[] array) {
        if (array.length == 0) {
            return -1;
        }
        int index = 0;
        double min = array[index];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private int indexOfSmallest(double[] array) {
        if (array.length == 0) {
            return -1;
        }
        int index = 0;
        double min = array[index];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    private double fitnessCalculator(double[] candidate) {
        Point pFitness = new Point(candidate);
        Rastrigin rast = new Rastrigin(10, dimensions);
        return rast.f(pFitness);
    }

    public void optimze() {
        for(int i=0; i<iterations; i++) {
            for (int j = 0; j < popSize; j++) {
                positions[j] = simpleBounds(positions[j], lb, ub);
                double fNew = fitnessCalculator(positions[j]);

                if (fNew < minValueOfSolution) {
                    bestSolution = positions[j].clone();
                    minValueOfSolution = fNew;
                }
            }

            for (int j = 0; j < popSize; j++) {
                a = 2 - i * ((2.0) / iterations);
                a2 =  -1 + 1 * ((-1.0) / iterations);
                double r1 = random.nextDouble();
                double r2 = random.nextDouble();

                double aCalc = 2 * a * r1 - a;
                double cCalc = 2 * r2;

                int b = 1;
                double l = (a2 - 1) * random.nextDouble() + 1;
                p = random.nextDouble();

                for (int k = 0; k < dimensions; k++) {
                    if (p < 0.5) {
                        if (Math.abs(aCalc) >= 1) {
                           int randLeanderIndex = (int)Math.floor(popSize * random.nextDouble());
                           double[] xRand = positions[randLeanderIndex].clone();
                           double val = cCalc * xRand[k] - positions[j][k];
                           double dXrand = Math.abs(val);
                           positions[j][k] = xRand[k] - aCalc * dXrand;
                        } else if (Math.abs(aCalc) < 1){
                            double val = cCalc * bestSolution[j] - positions[j][k];
                            leaderDistance = Math.abs(val);
                            positions[j][k] = bestSolution[k] - aCalc * leaderDistance;

                        }
                    } else if (p >= 0.5) {
                        double distance2Leader = Math.abs(bestSolution[j] - positions[j][k]);
                        positions[j][k] = distance2Leader * Math.exp(b * l) * Math.cos(2 * Math.PI * l) + bestSolution[j];
                    }
                }


            }
            logger.info("Iteration: {} best fitness is = {}", i, minValueOfSolution);
        }
    }

    private double[] simpleBounds(double[] val, double lower, double upper) {
        double[] result = new double[val.length];
        for (int i = 0; i < val.length; i++) {
            if (val[i] < lower){
                result[i] = lower;
            }
            else if (val[i] > upper){
                result[i] = upper;
            }
            else
            {
                result[i]=val[i];
            }
        }
        return result;
    }

}
