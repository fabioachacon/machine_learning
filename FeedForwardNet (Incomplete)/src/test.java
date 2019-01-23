import com.models.Sequential;
import com.layers.Dense;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        double[] input = {4, 5, 6, 1, 3, 5};
        Sequential model = new Sequential();
        model.addLayer(new Dense(512, "relu", true, input.length));
        model.addLayer(new Dense(34, "relu", true, 6));
        model.addLayer(new Dense(12, "relu", true, 5));
        model.addLayer(new Dense(1, "sigmoid", true, 3));
        model.propagate(input);
        System.out.printf("%s", Arrays.toString(model.getModelOutput()));
    }
}
