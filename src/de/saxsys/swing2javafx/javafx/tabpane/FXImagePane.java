package de.saxsys.swing2javafx.javafx.tabpane;

import java.io.File;
import java.net.MalformedURLException;

import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.model.DetailImageListener;
import de.saxsys.swing2javafx.model.DetailImageModel;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.adapter.ReadOnlyJavaBeanStringProperty;
import javafx.beans.property.adapter.ReadOnlyJavaBeanStringPropertyBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FXImagePane extends VBox implements DetailImageListener {

    private Controller controller;
    
    private TextField pathField;
    private TextField sizeField;
    
    private ImageView image;
    
    public FXImagePane(Controller controller) {
        this.controller = controller;
        this.controller.addDetailListener(this);
        this.initGui();
    }
    
    private void initGui() {
        
        this.pathField = new TextField();
        this.pathField.setEditable(false);
              
        
//        try {
//            this.pathField.textProperty().bind(ReadOnlyJavaBeanStringPropertyBuilder.create().
//                    bean(controller.getDetailImageModel()).name("path").build());
//        } catch (NoSuchMethodException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        this.sizeField = new TextField();
        this.sizeField.setEditable(false);
//        try {
//            this.sizeField.textProperty().bind(ReadOnlyJavaBeanStringPropertyBuilder.create().
//                    bean(controller.getDetailImageModel()).name("size").build());
//        } catch (NoSuchMethodException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        this.image = new ImageView();
//        this.image.imageProperty().bind(this.controller.getDetailImageModel().imageProperty());
        
       
        this.getChildren().addAll(this.pathField, this.sizeField,  this.image);
    }

    @Override
    public void updateDetailImageModel(final DetailImageModel imageModel) {
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                pathField.setText(imageModel.getPath());
                sizeField.setText(imageModel.getSize());
                
                try {
                    image.setImage(new Image(new File(imageModel.getPath()).toURI().toURL().toExternalForm(), true));
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        
    }
    
}
