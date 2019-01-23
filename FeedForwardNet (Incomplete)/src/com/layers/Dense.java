package com.layers;
import java.util.Random;
import com.activations.Activations;

public class Dense extends Layer {
    protected int numberUnits;
    protected String activationType;
    protected boolean includeBias;
    protected double[][] weightMatrix;
    protected double[] bias;
    protected double[] output;
    protected static int counter = 0;

    public Dense(int numberUnits, String activationType,  boolean includeBias){
        this(numberUnits, activationType, includeBias, getMatrixSize());
    }

    public Dense(int numberUnits, String activationType, boolean includeBias, int inputSize){
        this.numberUnits = numberUnits;
        this.activationType = activationType;
        this.includeBias = includeBias;
        setWeights(numberUnits, inputSize);
        ++counter;
    }

    public void setActivations(double[] inputTensor){
        double[] z = new double[this.numberUnits];
        double[][] weights = getWeightMatrix();
        bias = new double[this.numberUnits];
        if (includeBias) {
            setBias(this.numberUnits);
            bias = getBias();
        }
        else
            java.util.Arrays.fill(bias, 0.0);

        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[i].length; j++)
                z[i] = weights[i][j] * inputTensor[j] + bias[i];

        Activations activations = new Activations(z, this.activationType);
        this.output = activations.getActivations();

    }

    public void setWeights(int units, int inputSize){
        Random rand = new java.util.Random();
        double[][] W = new double[units][inputSize];
        for (int i = 0; i < W.length; i++)
            for (int j = 0; j < W[i].length; j++)
                W[i][j] = 0.01 * rand.nextDouble();

            weightMatrix = W;
    }

    public void setmatrixSize(int input, int nUntis){

    }

    public int getMatrixSize(){
        return weightMatrix[0].length * weightMatrix.length;
    }

    public void setBias(int nUnits){
        Random rand = new Random();
        java.util.Arrays.fill(bias, 0.1);
    }

    public double[][] getWeightMatrix(){
        return weightMatrix;
    }

    public double[] getBias(){
        return bias;
    }

    public double[] getLayerOutput(){
        return output;
    }

    public int getNumberUnits(){
        return numberUnits;
    }

    public boolean isIncludeBias() {
        return includeBias;
    }

}
