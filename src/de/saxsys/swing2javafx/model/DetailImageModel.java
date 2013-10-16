package de.saxsys.swing2javafx.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class DetailImageModel {

    private String path;
    private String size;

    private ObjectProperty<Image> imageProperty;

    private List<DetailImageListener> listeners;
    
    public DetailImageModel() {
        this.listeners = new ArrayList<DetailImageListener>();
        this.imageProperty = new SimpleObjectProperty<>();
    }

    public String sizeProperty() {
        return "size";
    }
    
    public String pathProperty() {
        return "path";
    }
    
    public void setData(String path, String size) {
        this.setSize(size);
        this.setPath(path);
        this.notifyListener();
    }
   
    public ObjectProperty<Image> imageProperty() {
        return this.imageProperty;
    }

    public void setImage(final String path) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    imageProperty.set(new Image(new File(path).toURI().toURL().toExternalForm(), true));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        this.notifyListener();
    }

    public String getPath() {
        return this.path;
    }

    public String getSize() {
        return this.size;
    }

    public void addListener(DetailImageListener listener) {
        this.listeners.add(listener);
    }

    private void notifyListener() {
        for (DetailImageListener listener : this.listeners) {
            listener.updateDetailImageModel(this);
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(String size) {
        this.size = size;   
    }
}
