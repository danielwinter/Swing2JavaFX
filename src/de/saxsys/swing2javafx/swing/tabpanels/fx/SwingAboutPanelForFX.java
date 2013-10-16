package de.saxsys.swing2javafx.swing.tabpanels.fx;

import javax.swing.SwingUtilities;

import de.saxsys.swing2javafx.model.AboutInformation;
import de.saxsys.swing2javafx.swing.tabpanels.SwingAboutPanel;
import javafx.embed.swing.SwingNode;

public class SwingAboutPanelForFX extends SwingNode {

    public SwingAboutPanelForFX() {
        this.initGui();
    }
    
    private void initGui() {
        final AboutInformation about = new AboutInformation("ETEO ist ein Warenzeichen der Saxonia Systems AG.", 
                "01059 Dresden, FFP 2",  "Registierungsnummer: 0123456789", "Scrumboard V1.0");
        
        SwingUtilities.invokeLater(new Runnable() {            
            @Override
            public void run() {
                SwingAboutPanelForFX.this.setContent(new SwingAboutPanel(about));                
            }
        });
    }
}
