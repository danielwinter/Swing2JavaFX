package de.saxsys.swing2javafx.javafx.fxml;

import java.io.File;
import java.net.MalformedURLException;

import de.saxsys.swing2javafx.model.DetailImageListener;
import de.saxsys.swing2javafx.model.DetailImageModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class TestFXMLController implements DetailImageListener {

    @FXML
    private ImageView imageView;

  
    public TextField pathField;
    
    @FXML
    private TextField sizeField;


    @Override
    public void updateDetailImageModel(final DetailImageModel imageModel) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pathField.setText(imageModel.getPath());
                sizeField.setText(imageModel.getSize());
                
                try {
                    imageView.setImage(new Image(new File(imageModel.getPath()).toURI().toURL().toExternalForm(),
                            true));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
