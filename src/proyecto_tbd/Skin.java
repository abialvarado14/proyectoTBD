/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tbd;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Wilmer
 */
public class Skin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // TODO code application logic here
        
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel()); //
            Inicio inicio = new  Inicio();
            inicio.setLocationRelativeTo(null);
            inicio.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Skin.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
