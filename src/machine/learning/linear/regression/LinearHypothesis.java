
package machine.learning.linear.regression;

/**
 * Brains on the Menu
 * @author Gwilym Newton
 */
public class LinearHypothesis {
    
    
    private float  T0;
    private float  T1;
    private float learning_rate_T0=0.1f;
    private float learning_rate_T1=0.1f;
    private float m;
    private TrainingSet training_data;

    public LinearHypothesis(TrainingSet training_data) {
        this.T0 =0;
        this.T1 =0;    
        this.training_data = training_data;
        this.m=training_data.getTraining_data().size();
    }

    /**
     *
     * @param T0 intial value for Tau0 
     * @param T1 intial value for Tau1
     * @param training_data The training set
     */
    public LinearHypothesis(float T0, float T1, TrainingSet training_data) {
        this.T0 = T0;
        this.T1 = T1;
        this.training_data = training_data;
        this.m=training_data.getTraining_data().size();
    }
    

    public float getT0() {
        return T0;
    }

    public float getT1() {
        return T1;
    }
    
    
    private float HypothesisFunction( float x)
    {
        return (T0 +(T1*x));
    }
    
    public float SquareCostFunction()
    {
        float cost = 0;
        for (TrainingPair t : training_data.getTraining_data())
        {
            cost += Math.pow((HypothesisFunction(t.getX()) - t.getY()), 2);
        }
        
        cost=(cost/(2*m));
        
        return cost;
    }
    
    private void StepOfGradientDecent()
    {
        float new_T0=0;
        float new_T1=0;
        float grad_T0=0;
        float grad_T1=0;
        for (TrainingPair t : training_data.getTraining_data())
        {
            grad_T0 +=  HypothesisFunction(t.getX()) - t.getY();
            grad_T1 += ((HypothesisFunction(t.getX()) - t.getY())*t.getX());
        }
        grad_T0 =grad_T0/m;
        grad_T1 =grad_T1/m;    
        
        
        new_T0 =T0-(learning_rate_T0*grad_T0); 
        new_T1 =T1-(learning_rate_T1*grad_T1);
        
        T0=new_T0;
        T1=new_T1;      
        
    }
    
    /**
     *
     * @param x Pridicts y, based on x and the current hypothesis 
     * @return
     */
    public float Predict(float x)
    {
        return HypothesisFunction(x);
    }
        
    /**
     *
     * @param max The maximum number of learning attempts
     * @param goal A goal amount for the error cost to be under.
     * 
     * @return The number of steps before error < goal or 0 if 
     * steps maxed out.
     */
    public int learn(int max, float goal)
    {
        for(int i=0;i<max;i++)
        { 
            StepOfGradientDecent();
            if (SquareCostFunction() < goal)
            {
                return i;
            }
        }    
    return 0;
    }
    /**
     *
     * @param max The maximum number of learning attempts
     * @param goal A goal amount for the error cost to be under.
     * @param ltt0 learning rate for Tau0
     * @param ltr1 learning rate for Tau1
     * 
     * @return The number of steps before error < goal or 0 if 
     * steps maxed out.
     */
    public int learn(int max, float goal, float lrt0, float lrt1)
    {
    this.learning_rate_T0=lrt0;
    this.learning_rate_T1=lrt1;
    return learn(max,goal);    
        
    }
    
    
    

}
