package de.saxsys.swing2javafx.javafx.tabpane.swing;

import java.util.List;

import de.saxsys.swing2javafx.javafx.tabpane.FXTablePane;
import de.saxsys.swing2javafx.model.CsvLicenseImporter;
import de.saxsys.swing2javafx.model.LicenseModel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class FXTablePaneForSwing extends JFXPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -1707854010823917581L;

    public FXTablePaneForSwing() {
        CsvLicenseImporter importer = new CsvLicenseImporter();
        final List<LicenseModel> importCsvLicences = importer.importCsvLicences("/resources/license.csv");

        //wichtig, immer auf den richtigen Gui-Thread arbeiten, sonst Exception
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
                FXTablePaneForSwing.this.setScene(new Scene(new FXTablePane(importCsvLicences)));
//            }
//        });
    }
}
