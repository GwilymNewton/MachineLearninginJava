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
public class MachineLearningLinearRegression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File test_data = new File("TestTraining");
        TrainingSet test_data_set = new TrainingSet(test_data);
        LinearHypothesis hypothesis = new LinearHypothesis(test_data_set);
        
        hypothesis.learn();
        
        System.out.println("Step F"+" T0="+hypothesis.getT0()+" T1="+hypothesis.getT1()+" Prediction of 100 = "+hypothesis.Predict(100)+" Cost="+hypothesis.SquareCostFunction());
    }
}
