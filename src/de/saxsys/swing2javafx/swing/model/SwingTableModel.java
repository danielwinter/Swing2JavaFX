package de.saxsys.swing2javafx.swing.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import de.saxsys.swing2javafx.model.LicenseModel;

public class SwingTableModel extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = 8879703398271622975L;

    final private List<LicenseModel> licenses;

    public SwingTableModel(List<LicenseModel> licenses) {
        this.licenses = licenses;
    }

    @Override
    public int getRowCount() {
        return this.licenses.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, final int columnIndex) {
        LicenseModel model = this.licenses.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.getLibraryName();
            case 1:
                return model.getLibraryVersion();
            case 2:
                return model.getLicenseName();
            case 3:
                return model.getLicenseUrl();
            default:
                return "No value";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Bibliothek";
            case 1:
                return "Version";
            case 2:
                return "Name";
            case 3:
                return "URL";
            default:
                return "No value";
        }
    }
    
    
}
