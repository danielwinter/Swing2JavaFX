package de.saxsys.swing2javafx.javafx.tabpane.swing;

import de.saxsys.swing2javafx.javafx.tabpane.FXAboutPane;
import de.saxsys.swing2javafx.model.AboutInformation;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class FXAboutPaneForSwing extends JFXPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -1707854010823917581L;

    public FXAboutPaneForSwing() {       

        final AboutInformation about = new AboutInformation("ETEO ist ein Warenzeichen der Saxonia Systems AG.", 
                "01059 Dresden, FFP 2",  "Registierungsnummer: 0123456789", "Scrumboard V1.0");
        
        //wichtig, immer auf den richtigen Gui-Thread arbeiten, sonst Exception
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                FXAboutPaneForSwing.this.setScene(new Scene(new FXAboutPane(about)));
            }
        });
    }
}
