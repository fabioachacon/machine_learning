package com.activations;

public class Activations {
    private double[] act;


    public Activations() {

    }

    public Activations(double[] input, String activation) {
        try {
            selectActivation(input, activation);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public double[] sigmoid(double z[]) {
        double[] h = new double[z.length];
        for (int i = 0; i < z.length; i++)
            h[i] = 1 / (1 + Math.exp(-z[i]));

        return h;
    }

    public double[] generalizedRelu(double[] z, double alpha) {
        double[] h = new double[z.length];
        for (int i = 0; i < z.length; i++)
            h[i] = relu(z)[i] + alpha * Math.min(0, z[i]);

        return h;
    }

    public double[] relu(double[] z) {
        double[] h = new double[z.length];
        for (int i = 0; i < z.length; i++)
            h[i] = Math.max(0, z[i]);

        return h;
    }

    public double[] leakyRelu(double[] z) {
        return generalizedRelu(z, 0.01);
    }

    public double[] absoluteValueRectification(double[] z) {
        return generalizedRelu(z, -1.0);
    }

    public double[] tanh(double[] z) {
        double[] z_updated = z;
        double[] h = new double[z.length];
        for (int i = 0; i < z.length; i++)
            z_updated[i] *= 2;

        for (int i = 0; i < z.length; i++)
            h[i] = 2 * sigmoid(z_updated)[i] - 1;

        return h;
    }

    public double[] softmax(double[] z) {
        double[] h = new double[z.length];
        double norm = 0;
        for (int j = 0; j < z.length; j++)
            norm += Math.exp(z[j]);

        for (int i = 0; i < z.length; i++)
            h[i] = Math.exp(z[i]) / norm;

        return h;
    }

    public void selectActivation(double[] input, String activation) throws IllegalArgumentException {
        double[] output = new double[input.length];
        if (activation.isEmpty()) {
            output = input;
        }
        activation.toLowerCase();

        switch (activation) {
            case "relu":
                output = relu(input);
                break;
            case "leakyrelu":
                output = leakyRelu(input);
                break;
            case "absolutevalueretification":
                output = absoluteValueRectification(input);
                break;
            case "tanh":
                output = tanh(input);
                break;
            case "sigmoid":
                output = sigmoid(input);
                break;
            case "softmax":
                output = softmax(input);
                break;
            case "linear":
                output = input;
            default:
                act = output;
        }

    }

    public double[] getActivations() {
        return act;
    }
}