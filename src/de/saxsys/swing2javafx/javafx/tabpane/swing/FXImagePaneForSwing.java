package de.saxsys.swing2javafx.javafx.tabpane.swing;

import java.util.List;

import de.saxsys.swing2javafx.javafx.tabpane.FXImagePane;
import de.saxsys.swing2javafx.javafx.tabpane.FXTablePane;
import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.model.CsvLicenseImporter;
import de.saxsys.swing2javafx.model.LicenseModel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class FXImagePaneForSwing extends JFXPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -1707854010823917581L;

    public FXImagePaneForSwing(final Controller controller) {

        //wichtig, immer auf den richtigen Gui-Thread arbeiten, sonst Exception
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                FXImagePaneForSwing.this.setScene(new Scene(new FXImagePane(controller)));
            }
        });
    }
}
