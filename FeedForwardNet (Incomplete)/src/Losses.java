import com.activations.Activations;

public class Losses {

    public double sigmoidCrossentroy(double[] input, int yLabel, int batchSize) {
        Activations act = new Activations();
        double loss = 0.0;
        for (int i = 0; i < batchSize; i++)
            loss += yLabel * Math.log(act.sigmoid(input)[i]) + (1 - yLabel) * Math.log(1 - act.sigmoid(input)[i]);

        return loss;
    }
}
