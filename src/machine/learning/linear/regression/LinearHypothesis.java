
package machine.learning.linear.regression;

/**
 * Brains on the Menu
 * @author Gwilym Newton
 */
public class LinearHypothesis {
    
    
    private float  T0;
    private float  T1;
    private float learning_rate_T0=0.2f;
    private float learning_rate_T1=0.000001f;
    private float m;
    private TrainingSet training_data;

    public LinearHypothesis(TrainingSet training_data) {
        this.T0 =0;
        this.T1 =0;    
        this.training_data = training_data;
        this.m=training_data.getTraining_data().size();
    }

    public LinearHypothesis(float T0, float T1, TrainingSet training_data) {
        this.T0 = T0;
        this.T1 = T1;
        this.training_data = training_data;
        this.m=training_data.getTraining_data().size();
    }
    
    
        public float getLearning_rate() {
        return learning_rate_T1;
    }

    public void setLearning_rate(float learning_rate) {
        this.learning_rate_T1 = learning_rate;
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
    
    public void StepOfGradientDecent()
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
    
    public float Predict(float x)
    {
        return HypothesisFunction(x);
    }
        
    public void learn()
    {
        for(int i=0;i<Integer.MAX_VALUE;i++)
        {
        
        StepOfGradientDecent();
        if (Math.round(SquareCostFunction())==0)
        {
            // to impove this, it should be when the cost has not changed for
            // X steps
            //We should also let the user set the max steps, and return a value
            //based on what triggers the break
            
            break;
        }
        }    
    }
    

}
