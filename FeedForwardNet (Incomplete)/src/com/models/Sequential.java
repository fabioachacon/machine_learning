package com.models;

import java.nio.file.StandardWatchEventKinds;
import java.util.Stack;
import com.layers.Dense;
import com.layers.Layer;

public class Sequential {
    private Stack<Layer> sequential = new Stack<Layer>();
    double[] output;
    public void addLayer(Layer layer){
        sequential.add(layer);
    }
    public void propagate(double[] inputs){
        Stack<Layer> layers = getStackLayers();
        double[] inputNext = inputs;
        for (int i = 0; i < sequential.size(); i++){
            if (layers.get(i) instanceof Dense) {
                    ((Dense) layers.get(i)).setActivations(inputNext);
                    inputNext = ((Dense) layers.get(i)).getLayerOutput();
            }
        }
        this.output = ((Dense) layers.get(layers.size()-1)).getLayerOutput();
    }

    public Stack<Layer> getStackLayers(){
        return sequential;
    }

    public double[] getModelOutput(){
        return output;
    }
}
