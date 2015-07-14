
package machine.learning.linear.regression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Brains on the Menu
 * @author Gwilym Newton
 */
public class TrainingSet {
    
    private Set<TrainingPair> training_data;

    private TrainingSet(Set<TrainingPair> training_data) {
        this.training_data = training_data;
    }

    public Set<TrainingPair> getTraining_data() {
        return training_data;
    }
    
    
    
    public TrainingSet(File f) {
        BufferedReader br= null;
        
        training_data = new HashSet<TrainingPair>();
        
        try {
            
            br = new BufferedReader(new FileReader(f));
            String sCurrentLine;
            
            while ((sCurrentLine = br.readLine()) != null) 
            {
                String[] splitline = sCurrentLine.split(",");
                TrainingPair pair = new TrainingPair(Float.parseFloat(splitline[0]),Float.parseFloat(splitline[1]));
                training_data.add(pair);
                System.out.println(pair);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrainingSet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrainingSet.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally 
        {
            try {
                    if (br != null)br.close();
            } 
            catch (IOException ex) 
            {
                    ex.printStackTrace();
            }
        }
    }

}
