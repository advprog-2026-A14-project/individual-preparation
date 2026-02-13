package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {

    public double[] add(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return new double[]{0.0, 0.0, 0.0};
    }

    public double[] subtract(double[] v1, double[] v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Vectors cannot be null");
        }

        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vector lengths do not match");
        }

        double[] result = new double[v1.length];

        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] - v2[i];
        }

        return result;
    }

    public double[] multiply(double[] v1, int x) {
        // TODO: Implement me properly!
        return new double[]{0.0, 0.0, 0.0};
    }

    public double dotProduct(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double norm(double[] v1) {
        if (v1 == null) {
            throw new IllegalArgumentException("Vector cannot be null");
        }
        double sum = 0.0;
        for (double val : v1) {
            sum += val * val;
        }
        return Math.sqrt(sum);
    }
}
