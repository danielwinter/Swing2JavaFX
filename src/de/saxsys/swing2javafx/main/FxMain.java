package de.saxsys.swing2javafx.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.saxsys.swing2javafx.javafx.JavaFX2SwingPane;

public class FxMain extends Application {

    public static void main(final String[] args) {
        FxMain.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX2Swing");

        JavaFX2SwingPane pane = new JavaFX2SwingPane(new Controller());
        Scene scene = new Scene(pane, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
