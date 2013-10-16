package de.saxsys.swing2javafx.javafx;

import de.saxsys.swing2javafx.main.Controller;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class JavaFX2SwingPane extends StackPane {

    private Controller controller;
    
    private Pane configPane;
    private Pane loggerPane;
    private Pane tabbPane;
    
   
    public JavaFX2SwingPane(Controller controller) {        
        this.controller = controller;
        this.initGui();
    }
    
    private void initGui() { 
        
        Pane configPane = this.getConfigPane();
        Pane loggerPane = this.getLoggerPane();
        Pane tabbPane = this.getTabbPane();       
        
        SplitPane vertPane = new SplitPane();
        vertPane.getItems().addAll(configPane, tabbPane);
        
        SplitPane horiPane = new SplitPane();
        horiPane.setOrientation(Orientation.VERTICAL);
        horiPane.getItems().addAll(vertPane, loggerPane);
        
        this.getChildren().add(horiPane);
    }   
    
    private Pane getConfigPane() {
        if(this.configPane == null) {
            this.configPane = new FXConfigPane(this.controller);
        }
        
        return this.configPane;
    }
    
    private Pane getLoggerPane() {
        if(this.loggerPane == null) {
            this.loggerPane = new FXLoggerPane();
        }
        
        return this.loggerPane;
    }
    
    private Pane getTabbPane() {
        if(this.tabbPane == null) {
            this.tabbPane = new FXTabPane(this.controller);
        }
        
        return this.tabbPane;
    }
}
