package de.saxsys.swing2javafx.javafx.tabpane;

import java.util.List;

import de.saxsys.swing2javafx.model.CsvLicenseImporter;
import de.saxsys.swing2javafx.model.LicenseModel;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

public class FXTablePane extends StackPane {

    private final ObservableList<LicenseModel> obsLicences;
    
    private TableView<LicenseModel> licenseTable;    

    private TableColumn<LicenseModel, String> libaryNameColumn;
    private TableColumn<LicenseModel, String> libaryVersionColumn;
    private TableColumn<LicenseModel, String> licenceName;
    private TableColumn<LicenseModel, String> licenceUrl;
    
    public FXTablePane() {
        CsvLicenseImporter importer = new CsvLicenseImporter();
        final List<LicenseModel> importCsvLicences = importer.importCsvLicences("/resources/license.csv");
        
        this.obsLicences = FXCollections.observableArrayList(importCsvLicences);        
        this.initGui();
    }
    
    public FXTablePane(final List<LicenseModel> licences) {
        this.obsLicences = FXCollections.observableArrayList(licences);        
        this.initGui();
    }
    
    public void initGui() {
        this.licenseTable = this.getTableView();
        this.getChildren().add(this.licenseTable);
    }
    
    private TableView<LicenseModel> getTableView() {
        if(this.licenseTable == null) {
            this.licenseTable = new TableView<LicenseModel>();

            this.libaryNameColumn = new TableColumn<>("Bibliothek");
            this.libaryNameColumn.setCellValueFactory(new PropertyValueFactory<LicenseModel, String>(
                    "libraryName"));

            this.libaryVersionColumn = new TableColumn<>("Version");
            this.libaryVersionColumn.setCellValueFactory(new PropertyValueFactory<LicenseModel, String>(
                    "libraryVersion"));

            this.licenceName = new TableColumn<>("Name");
            this.licenceName.setCellValueFactory(new PropertyValueFactory<LicenseModel, String>(
                    "licenseName"));

            this.licenceUrl = new TableColumn<>("URL");
            this.licenceUrl
                    .setCellValueFactory(new PropertyValueFactory<LicenseModel, String>("licenseUrl"));
            this.licenceUrl.setCellFactory(new LicenseCellFactory());

            this.licenseTable.setItems(this.obsLicences);
            this.licenseTable.getColumns().setAll(libaryNameColumn, libaryVersionColumn, licenceName, licenceUrl);
            this.licenseTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//            this.licenseTable.getColumns().addListener(new LicenseTableColumnChangeListener());
        }
        
        return this.licenseTable;
    }
    
    /**
     * CellFactory for the license table.
     * 
     * @author daniel.winter
     */
    private class LicenseCellFactory implements
            Callback<TableColumn<LicenseModel, String>, TableCell<LicenseModel, String>> {
        @Override
        public TableCell<LicenseModel, String> call(final TableColumn<LicenseModel, String> arg0) {
            final TableCell<LicenseModel, String> cell = new TableCell<LicenseModel, String>() {
                @Override
                public void updateItem(final String item, final boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(empty ? null : this.getString());
                    this.setGraphic(null);
                }

                private String getString() {
                    return this.getItem() == null ? "" : this.getItem().toString();
                }
            };

            return cell;
        }
    }

    /**
     * Listener to forbid the reordering of the table columns.
     * 
     * @author daniel.winter
     */
    private class LicenseTableColumnChangeListener implements ListChangeListener<Object> {
        @SuppressWarnings("unchecked")
        @Override
        public void onChanged(final ListChangeListener.Change<? extends Object> change) {
            change.next();
            if (change.wasReplaced()) {
                FXTablePane.this.licenseTable.getColumns().clear();
                licenseTable.getColumns().setAll(FXTablePane.this.libaryNameColumn,
                        FXTablePane.this.libaryVersionColumn, FXTablePane.this.licenceName,
                        FXTablePane.this.licenceUrl);
            }
        }
    }
}
