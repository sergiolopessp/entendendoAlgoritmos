package org.example.graywolves;

import org.example.model.Point;
import org.example.service.Rastrigin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;

public class GrayWolfOptimizer {
    int popSize;
    int iterations;
    int dimensions;

    double ub=5.12;
    double lb=-5.12;

    double[] fitness;

    double[] bestSolution;

    double alpha = 0.5;
    double betamin = 0.20;

    double minValueOfSolution;
    double[][] positions;
    double[][] positions1;

    int[] sortedIndex;

    double[] alphaPosition;
    double[] betaPosition;
    double[] deltaPosition;

    double alphaScore=10000000;
    double betaScore=10000000;
    double deltaScore=10000000;

    private static final Logger logger =  LogManager.getLogger(GrayWolfOptimizer.class);

    SecureRandom random = new SecureRandom();

    public GrayWolfOptimizer(int iterations, int popSize, int dimensions) {
        this.iterations = iterations;
        this.popSize = popSize;
        this.dimensions = dimensions;
        positions = new double[popSize][dimensions];
        positions1 = new double[popSize][dimensions];
        fitness = new double[popSize];
        alphaPosition = new double[dimensions];
        betaPosition = new double[dimensions];
        deltaPosition = new double[dimensions];

        for(int i=0; i< popSize; i++) {
            for (int j=0; j<dimensions; j++) {
                positions[i][j] = lb + random.nextDouble() * (ub - lb);
            }
        }

    }

    private double fitnessCalculator(double[] candidate) {
        Point p = new Point(candidate);
        Rastrigin rast = new Rastrigin(10, dimensions);
        return rast.f(p);
    }


    private void updateWolvesPosition(double a)
    {

        for (int i=0;i<popSize;i++)
        {
            for (int j=0;j<dimensions;j++){
                double r1 = random.nextDouble();
                double r2 = random.nextDouble();
                double a1 = 2 * a * r1 - a;
                double c1 = 2 * r2;

                double  dAlpha = Math.abs(c1 * alphaPosition[j] - positions[i][j]);
                double x1 = alphaPosition[j] - a1 * dAlpha;
                r1 = random.nextDouble();
                r2 = random.nextDouble();
                double a2 = 2 * a * r1 - a;
                double c2 = 2 * r2;

                double dBeta = Math.abs(c2 * betaPosition[j] - positions[i][j]);
                double x2 = betaPosition[j] - a2 * dBeta;
                r1 = random.nextDouble();
                r2 = random.nextDouble();
                double a3 = 2 * a * r1 - a;
                double c3 = 2 * r2;
// update the position of delta wolves
                double dDelta = Math.abs(c3 * deltaPosition[j] - positions[i][j]);
                double x3 = deltaPosition[j] - a3 * dDelta;
                positions[i][j] = (x1 + x2 + x3) / 3  ;// Equation (2.8)
            }
        }
    }

    public void optimize() {
        for(int it=0; it<iterations; it++) {
            for(int i=0; i<popSize; i++) {
                fitness[i] = fitnessCalculator(positions[i]);
                if (fitness[i] < alphaScore) {
                   deltaScore = betaScore;
                   deltaPosition = betaPosition.clone();
                   betaScore = alphaScore;
                   betaPosition = alphaPosition.clone();
                   alphaScore = fitness[i];
                   alphaPosition = positions[i].clone();
                }

                if (fitness[i] > alphaScore && fitness[i] < betaScore) {
                    deltaScore = betaScore;
                    deltaPosition = betaPosition.clone();
                    betaScore = fitness[i];
                    betaPosition = positions[i].clone();
                }

                if (fitness[i] > alphaScore && fitness[i] > betaScore && fitness[i] < deltaScore) {
                    deltaScore = fitness[i];
                    deltaPosition = positions[i].clone();
                }

                double a = 2 - it * ((2.0) / iterations);
                updateWolvesPosition(a);

            }

            logger.info("best score after iteration: {} = {}",it, alphaScore);
        }
    }


}
