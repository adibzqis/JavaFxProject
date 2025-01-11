package sem_3_project_driver;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class accountPageDriver {
    public static void showAccountPage(Stage primaryStage, Scene mainScene) {
        VBox accountBox = new VBox(20);
        accountBox.setPadding(new Insets(20));
        accountBox.setAlignment(Pos.TOP_CENTER); // Align elements to the top
        accountBox.setStyle("-fx-padding: 20; -fx-alignment: top-center; -fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        // Create HBox for Back Button
        HBox backButtonBox = new HBox();
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white; -fx-font-size: 14px;");
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        // Add the back button to the backButtonBox and align it to the top
        backButtonBox.setAlignment(Pos.TOP_LEFT);
        backButtonBox.getChildren().add(backButton);

        // Logo image
        Image logoImage = new Image("file:///C:/Users/Asus/eclipse-workspace/sem3_project/src/account.png");
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitHeight(100);
        logoView.setFitWidth(100);
        
        // Create an HBox for the logo and center it
        HBox logoHBox = new HBox();
        logoHBox.setAlignment(Pos.CENTER); // Center the logo
        logoHBox.getChildren().add(logoView); // Add the logo to the HBox
        
        Label titleLabel = new Label("My Account");
        titleLabel.setFont(new Font(20));

        Label accountDetailsLabel = new Label("Account details will be shown here.");
        accountDetailsLabel.setWrapText(true);
        accountDetailsLabel.setFont(new Font(12));
        accountDetailsLabel.setAlignment(Pos.CENTER);

        Label username = new Label("Username:");
        username.setFont(new Font(12));
        username.setAlignment(Pos.CENTER);
        username.setStyle("-fx-font-weight: bold;");
        
        Label matricNumber = new Label("Matric Number: ");
        matricNumber.setFont(new Font(12));
        matricNumber.setAlignment(Pos.CENTER);
        matricNumber.setStyle("-fx-font-weight: bold;");

        Label email = new Label("Email:");
        email.setFont(new Font(12));
        email.setAlignment(Pos.CENTER);
        email.setStyle("-fx-font-weight: bold;");
        
        // Add all elements to the main VBox
        accountBox.getChildren().addAll(backButtonBox, logoHBox, titleLabel, accountDetailsLabel, username, email, matricNumber);

        Scene accountScene = new Scene(accountBox, 360, 640);
        primaryStage.setScene(accountScene);
    }
}

