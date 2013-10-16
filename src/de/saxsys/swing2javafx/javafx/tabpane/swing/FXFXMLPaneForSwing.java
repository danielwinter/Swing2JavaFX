package de.saxsys.swing2javafx.javafx.tabpane.swing;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import de.saxsys.swing2javafx.javafx.fxml.TestFXMLController;
import de.saxsys.swing2javafx.javafx.tabpane.FXTablePane;
import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.model.CsvLicenseImporter;
import de.saxsys.swing2javafx.model.LicenseModel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;

public class FXFXMLPaneForSwing extends JFXPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -1707854010823917581L;

    public FXFXMLPaneForSwing(final Controller controller) {

        try {
            URL location = getClass().getResource("/de/saxsys/swing2javafx/javafx/fxml/test.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(location);

            final Parent root = (Parent) fxmlLoader.load();

            TestFXMLController fxmlController = (TestFXMLController) fxmlLoader.getController();
            controller.addDetailListener(fxmlController);

            // wichtig, immer auf den richtigen Gui-Thread arbeiten, sonst Exception
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    FXFXMLPaneForSwing.this.setScene(new Scene(root));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
