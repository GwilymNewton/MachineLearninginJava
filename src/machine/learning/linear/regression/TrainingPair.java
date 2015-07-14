
package machine.learning.linear.regression;

/**
 * Brains on the Menu
 * @author Gwilym Newton
 */
public class TrainingPair {
    
    private float x;
    private float y;

    public TrainingPair(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }





    @Override
    public String toString() {
        return x+","+y;
    }
           

}
