package de.saxsys.swing2javafx.swing.tabpanels.fx;

import javax.swing.SwingUtilities;

import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.swing.tabpanels.SwingImagePanel;
import javafx.embed.swing.SwingNode;

public class SwingImagePanelForFX extends SwingNode {

    public SwingImagePanelForFX(final Controller controller) {
        this.initGui(controller);
    }
    
    private void initGui(final Controller controller) {        
        SwingUtilities.invokeLater(new Runnable() {            
            @Override
            public void run() {
                SwingImagePanelForFX.this.setContent(new SwingImagePanel(controller));                
            }
        });
    }
}
