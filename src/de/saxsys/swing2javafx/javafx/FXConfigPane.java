package de.saxsys.swing2javafx.javafx;

import java.io.File;

import javax.swing.BoxLayout;

import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.model.ImageListener;
import de.saxsys.swing2javafx.model.ImageModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView; 
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class FXConfigPane extends VBox {

    private Controller controller;
    
    private TextField pathLabel;
    private ListView<File> listView;
    ObservableList<File> model;
    
    public FXConfigPane(Controller controller) {
        this.controller = controller;
        this.initGui();
        this.model = FXCollections.observableArrayList();
    }

    private void initGui() {
        this.pathLabel = new TextField();
        this.pathLabel.setEditable(false);

        Button button = new Button("Bildordner auswählen");
        button.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent arg0) {
                DirectoryChooser chooser = new DirectoryChooser();
                File selectedFile = chooser.showDialog(null);
                FXConfigPane.this.controller.loadImages(selectedFile.getAbsolutePath());
                FXConfigPane.this.pathLabel.setText(selectedFile.getAbsolutePath());
            }
        });
        
        this.listView = new ListView<>();
        this.listView.itemsProperty().bind(this.controller.getImageModel().fileList());
        this.listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<File>() {
            @Override
            public void changed(ObservableValue<? extends File> arg0, File oldFile, File newFile) {
               FXConfigPane.this.controller.loadImage(arg0.getValue().getAbsolutePath());                  
            }
        });
        
        VBox.setMargin(this.pathLabel, new Insets(5));
        VBox.setMargin(button, new Insets(5));
        VBox.setMargin(this.listView, new Insets(5));
        VBox.setVgrow(this.listView, Priority.ALWAYS);
        VBox.setVgrow(this.pathLabel, Priority.SOMETIMES);
        this.getChildren().addAll(this.pathLabel, button, this.listView);        
    }
   
}
