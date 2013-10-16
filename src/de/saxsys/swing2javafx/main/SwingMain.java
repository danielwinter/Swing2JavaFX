package de.saxsys.swing2javafx.main;

import java.util.List;

import javax.swing.SwingUtilities;

import de.saxsys.swing2javafx.model.CsvLicenseImporter;
import de.saxsys.swing2javafx.model.LicenseModel;
import de.saxsys.swing2javafx.swing.Swing2JavaFxFrame;

public class SwingMain {
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {            
            @Override
            public void run() {  
                Swing2JavaFxFrame mainFrame = new Swing2JavaFxFrame(new Controller());
                mainFrame.setVisible(true);                
            }
        }); 
    }
}

