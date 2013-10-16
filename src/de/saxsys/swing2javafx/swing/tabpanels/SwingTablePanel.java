package de.saxsys.swing2javafx.swing.tabpanels;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.saxsys.swing2javafx.model.CsvLicenseImporter;
import de.saxsys.swing2javafx.model.LicenseModel;
import de.saxsys.swing2javafx.swing.model.SwingTableModel;

public class SwingTablePanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 6300547584592137475L;

    public SwingTablePanel() {        
        CsvLicenseImporter importer = new CsvLicenseImporter();
        final List<LicenseModel> importCsvLicences = importer.importCsvLicences("/resources/license.csv");
        
        this.initGui(importCsvLicences);
    }
    
    public SwingTablePanel(final List<LicenseModel> importCsvLicences) {        
        this.initGui(importCsvLicences);
    }
    
    private void initGui(List<LicenseModel> importCsvLicences) {
        this.setLayout(new BorderLayout());
        
        SwingTableModel tableModel = new SwingTableModel(importCsvLicences);
        JTable licenseTable = new JTable(tableModel);
        
        JScrollPane tablePane = new JScrollPane(licenseTable);
        
        this.add(tablePane, BorderLayout.CENTER);
    }
}
