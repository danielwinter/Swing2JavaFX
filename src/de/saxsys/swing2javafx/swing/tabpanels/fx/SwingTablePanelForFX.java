package de.saxsys.swing2javafx.swing.tabpanels.fx;

import java.util.List;

import javax.swing.SwingUtilities;

import de.saxsys.swing2javafx.model.CsvLicenseImporter;
import de.saxsys.swing2javafx.model.LicenseModel;
import de.saxsys.swing2javafx.swing.tabpanels.SwingTablePanel;
import javafx.embed.swing.SwingNode;

public class SwingTablePanelForFX extends SwingNode {

    public SwingTablePanelForFX() {
        this.initGui();
    }
    
    private void initGui() {
        CsvLicenseImporter importer = new CsvLicenseImporter();
        final List<LicenseModel> importCsvLicences = importer.importCsvLicences("/resources/license.csv");
        
        SwingUtilities.invokeLater(new Runnable() {            
            @Override
            public void run() {
                SwingTablePanelForFX.this.setContent(new SwingTablePanel(importCsvLicences));                
            }
        });
    }
}
