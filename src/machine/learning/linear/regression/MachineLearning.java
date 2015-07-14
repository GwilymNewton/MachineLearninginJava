/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning.linear.regression;

import java.io.File;

/**
 *
 * @author Panda
 */
public class MachineLearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File test_data = new File("TestTraining");
        TrainingSet test_data_set = new TrainingSet(test_data);
        LinearHypothesis hypothesis = new LinearHypothesis(test_data_set);
        int step = hypothesis.learn(1000000,5f);
        System.out.println("Step "+step+" T0="+hypothesis.getT0()+" T1="+hypothesis.getT1()+" Prediction of 100 = "+hypothesis.Predict(100)+" Cost="+hypothesis.SquareCostFunction());
    }
}
