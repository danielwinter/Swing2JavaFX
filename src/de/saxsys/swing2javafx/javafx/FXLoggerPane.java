package de.saxsys.swing2javafx.javafx;

import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class FXLoggerPane extends StackPane {

    public FXLoggerPane() {
        this.initGui();
    }
    
    private void initGui() {       
        TextArea loggerArea = new TextArea("Logging text");       
        this.getChildren().addAll(loggerArea);        
    }
}
