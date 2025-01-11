package sem_3_project_driver;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class logOutDriver {

    public static void showConfirmationPage(Stage primaryStage, Scene mainScene, String title, String message, Runnable onConfirm) {
        VBox confirmBox = new VBox(20);
        Label titleLabel = new Label(title);
        titleLabel.setFont(new Font(20));

        Label messageLabel = new Label(message);
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> onConfirm.run());

        noButton.setOnAction(e -> primaryStage.setScene(mainScene));

        HBox buttonBox = new HBox(10, yesButton, noButton);
        buttonBox.setAlignment(Pos.CENTER);

        confirmBox.getChildren().addAll(titleLabel, messageLabel, buttonBox);
        confirmBox.setStyle("-fx-padding: 20; -fx-alignment: center;-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");


        Scene confirmScene = new Scene(confirmBox, 360, 640);
        primaryStage.setScene(confirmScene);
    }

    public static void showLogoutPage(Stage primaryStage, Scene mainScene) {
        VBox logoutBox = new VBox(20);
        logoutBox.setPadding(new Insets(20));
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        
        Label titleLabel = new Label("Log Out");
        titleLabel.setFont(new Font(20));

        Label logoutMessageLabel = new Label("You have been logged out.");
        logoutMessageLabel.setWrapText(true);
        logoutMessageLabel.setFont(new Font(12));
        logoutMessageLabel.setAlignment(Pos.CENTER);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        logoutBox.getChildren().addAll(titleLabel, logoutMessageLabel, backButton);

        Scene logoutScene = new Scene(logoutBox, 360, 640);
        primaryStage.setScene(logoutScene);
    }

    public static void confirmLogout(Stage primaryStage, Scene mainScene) {
        showConfirmationPage(primaryStage, mainScene, "Log out Confirmation", "Are you sure you want to log out?", () -> {
            showLogoutPage(primaryStage, mainScene);
        });
    }
}

