package sem3_project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorPage2 {
    public static void showErrorPopup2(Stage ownerStage) {
        // Create a new stage for the error popup
        Stage errorStage = new Stage();
        errorStage.initModality(Modality.APPLICATION_MODAL); // Block interaction with the main window
        errorStage.initOwner(ownerStage); // Set the owner stage for the popup
        errorStage.setTitle("Error");

        VBox errorBox = new VBox(20);
        errorBox.setPadding(new Insets(20));
        errorBox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");
        errorBox.setAlignment(Pos.CENTER);

        // Add an error image
        Image errorImage = new Image("file:///C:/Users/Asus/eclipse-workspace/sem3_project/src/error.png"); // Replace with the correct path to your image file
        ImageView errorImageView = new ImageView(errorImage);
        errorImageView.setFitWidth(70); // Set the width of the image
        errorImageView.setFitHeight(70); // Set the height of the image

        Label errorMessageLabel = new Label("From and To locations cannot be the same.");
        errorMessageLabel.setWrapText(true);
        errorMessageLabel.setFont(new Font("Arial", 14));
        errorMessageLabel.setStyle("-fx-text-fill: #333333;");
        errorMessageLabel.setAlignment(Pos.CENTER);
        errorMessageLabel.setMaxWidth(300);

        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
        closeButton.setFont(new Font("Arial", 14));
        closeButton.setOnAction(e -> errorStage.close()); // Close the popup

        errorBox.getChildren().addAll(errorImageView, errorMessageLabel, closeButton);

        Scene errorScene = new Scene(errorBox, 360, 200); // Adjust size for a small popup
        errorStage.setScene(errorScene);

        // Show the popup
        errorStage.showAndWait();
    }
}
