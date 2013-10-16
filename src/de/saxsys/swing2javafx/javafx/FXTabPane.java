package de.saxsys.swing2javafx.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import de.saxsys.swing2javafx.javafx.fxml.TestFXMLController;
import de.saxsys.swing2javafx.javafx.tabpane.FXAboutPane;
import de.saxsys.swing2javafx.javafx.tabpane.FXImagePane;
import de.saxsys.swing2javafx.javafx.tabpane.FXTablePane;
import de.saxsys.swing2javafx.main.Controller;
import de.saxsys.swing2javafx.swing.tabpanels.fx.SwingAboutPanelForFX;
import de.saxsys.swing2javafx.swing.tabpanels.fx.SwingImagePanelForFX;
import de.saxsys.swing2javafx.swing.tabpanels.fx.SwingTablePanelForFX;

public class FXTabPane extends StackPane {

    private Controller controller;
    
    public FXTabPane(Controller controller) {
        this.controller = controller;
        this.initGui();
    }
    
    private void initGui() {        
        TabPane tabPane = new TabPane();
        Tab swingTableTab = new Tab("Swing-Tabelle");
        swingTableTab.setContent(new SwingTablePanelForFX());
        Tab fxTableTab = new Tab("FX-Tabelle");
        fxTableTab.setContent(new FXTablePane());
        Tab swingAboutTab = new Tab("Swing-About");
        swingAboutTab.setContent(new SwingAboutPanelForFX());
        Tab fxAboutTab = new Tab("FX-About");
        fxAboutTab.setContent(new FXAboutPane());
        Tab swingImageTab = new Tab("Swing-Bild");
        swingImageTab.setContent(new SwingImagePanelForFX(this.controller));
        Tab fxImageTab = new Tab("FX-Bild");
        fxImageTab.setContent(new FXImagePane(this.controller));
        
        Tab fxmlTab = new Tab("FX-FXML");
        try {
            URL location = getClass().getResource("/de/saxsys/swing2javafx/javafx/fxml/test.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            
            Parent root = (Parent) fxmlLoader.load();            
            fxmlTab.setContent(root);
            
            TestFXMLController fxmlController = (TestFXMLController) fxmlLoader.getController();
            this.controller.addDetailListener(fxmlController);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        tabPane.getTabs().addAll(swingTableTab, fxTableTab, swingImageTab, fxImageTab, swingAboutTab, fxAboutTab, fxmlTab );        
       
        this.getChildren().add(tabPane);
    }
}
