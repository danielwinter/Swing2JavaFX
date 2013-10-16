package de.saxsys.swing2javafx.javafx.tabpane;

import de.saxsys.swing2javafx.model.AboutInformation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FXAboutPane extends BorderPane {

    /**
     * Resource path of the eteo logo.
     */
    private static final String RESOURCES_LOGO_ETEO_JPG = "/resources/ETEO_Brand_on_white_CMYK.png";
    
    public FXAboutPane() {
        this.initGui(new AboutInformation("ETEO ist ein Warenzeichen der Saxonia Systems AG.", 
                "01059 Dresden, FFP 2",  "Registierungsnummer: 0123456789", "Scrumboard V1.0"));
    }
    
    public FXAboutPane(AboutInformation aboutInfo) {
        this.initGui(aboutInfo);
    }
    
    private void initGui(final AboutInformation aboutInfo) {
        final Image eteoTitle = new Image(FXAboutPane.RESOURCES_LOGO_ETEO_JPG, 400d, 100d, true, true);
        final ImageView titleView = new ImageView(eteoTitle);

        final VBox titleInformationBox = this.getTitleInformationBox(aboutInfo);

        final HBox titleInfos = new HBox();
        titleInfos.getChildren().addAll(titleView, titleInformationBox);
        titleInfos.setSpacing(75);
        titleInfos.setAlignment(Pos.CENTER);

        final Text bottomText = this.getBottomText(aboutInfo);

        this.setCenter(titleInfos);
        this.setBottom(bottomText);
        this.setPadding(new Insets(10, 10, 10, 10));
        BorderPane.setAlignment(bottomText, Pos.CENTER);
    }

    private VBox getTitleInformationBox(final AboutInformation aboutInfo) {
        final VBox titleBox = new VBox();

        final Text titleText = new Text(aboutInfo.getVersion());
        final Text registryNumberText = new Text(aboutInfo.getRegistryNumber());
        final Text addressText = new Text(aboutInfo.getAddress());

        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().addAll(titleText, registryNumberText, addressText);
        return titleBox;
    }

    private Text getBottomText(final AboutInformation aboutInfo) {
        final Text bottomText = new Text(aboutInfo.getTrademark());
        return bottomText;
    }
  
}
