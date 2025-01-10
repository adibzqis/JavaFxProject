package sem3_project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class placeDetailsPage {

    public static void showPlaceDetails(Stage primaryStage, Scene mainScene, String title, String details, String imagePath) {
        showPage(primaryStage, mainScene, title, details, imagePath);
    }

    private static void showPage(Stage primaryStage, Scene mainScene, String title, String details, String imagePath) {
        VBox detailBox = new VBox(20);
        detailBox.setPadding(new Insets(20));
        detailBox.setAlignment(Pos.CENTER);
        detailBox.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        // Title Label
        Label titleLabel = new Label(title);
        titleLabel.setFont(new javafx.scene.text.Font(20));

        // Image View
        Image image = new Image(placeDetailsPage.class.getResourceAsStream("/" + imagePath)); // Load image
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200); // Adjust image height
        imageView.setFitWidth(300); // Adjust image width

        // Long Content Label
        Label detailsLabel = new Label(details);
        detailsLabel.setWrapText(true); // Enable text wrapping
        detailsLabel.setFont(new javafx.scene.text.Font(12));
        detailsLabel.setMaxWidth(400);
        detailsLabel.setStyle("-fx-text-alignment: center; -fx-padding: 5;-fx-background-color: white;");

        // Wrapper Pane for consistent background
        VBox wrapper = new VBox(detailsLabel);
        wrapper.setPadding(new Insets(10));

        // Scroll Pane for long content
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(wrapper);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: white;-fx-background: white;");
        scrollPane.setPrefHeight(400); // Set the height for scrolling

        // Back Button
        Image backArrow = new Image(placeDetailsPage.class.getResourceAsStream("/undo.png"));
		ImageView backArrowImage = new ImageView(backArrow);
		backArrowImage.setFitHeight(23); // Adjust height
		backArrowImage.setFitWidth(23);  // Adjust width
		Button backButton = new Button();
		backButton.setGraphic(backArrowImage); // Set the ImageView as the button graphic
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        detailBox.getChildren().addAll(titleLabel, imageView, scrollPane, backButton);

        Scene detailScene = new Scene(detailBox, 360, 640); // Set the size for the scene
        primaryStage.setScene(detailScene);
    }
}
