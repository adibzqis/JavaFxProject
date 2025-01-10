package CSC3104PROJECT;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class forgotPassPage extends Application {

    @Override
    public void start(Stage stage) {
        // Back Button
        Image backImage = new Image(getClass().getResourceAsStream("undo.png"));
        ImageView backIV = new ImageView(backImage);
        backIV.setFitWidth(23);
        backIV.setFitHeight(23);
        
        Image logoImage = new Image(getClass().getResourceAsStream("logo.png"));
    	ImageView logoIV = new ImageView(logoImage);
    	logoIV.setFitHeight(120);
    	logoIV.setFitWidth(120);
    	
    	HBox logoIVBox = new HBox(logoIV);
    	logoIVBox.setAlignment(Pos.CENTER);
    	logoIVBox.setPadding(new Insets(0 ,0 ,-50 ,0));

        Button backButton = new Button("", backIV);
        backButton.setCursor(Cursor.HAND);
        backButton.setOnAction(e -> {
            studentPage studentPage = new studentPage();
            studentPage.start(stage);
        });

        HBox goBack = new HBox(backButton);
        goBack.setPadding(new Insets(10, 10, 10, 10));

        // Title
        Label titleLabel = new Label("Forgot Password");
        titleLabel.setStyle(
            "-fx-font-size: 24px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: #FF4444;"
        );

        // Instruction Text
        Label instructionLabel = new Label("Enter your registered email to reset your password:");
        instructionLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #333333;");

        // Email Input
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setMaxWidth(280);

        // Submit Button
        Button submitButton = new Button("Send Reset Link");
        submitButton.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: #FFCCCC;" +
            "-fx-text-fill: #660000;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;"
        );
        submitButton.setCursor(Cursor.HAND);
        submitButton.setOnAction(e -> {
            String email = emailField.getText().trim();
            if (email.isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "Please enter your email.");
            } else if (!isValidEmail(email)) {
                showAlert(AlertType.ERROR, "Invalid Email", "Please enter a valid email address.");
            } else {
                showAlert(AlertType.INFORMATION, "Success", "Password reset link sent to your email.");
                emailField.clear();
            }
        });

        // Code Submission Section
        Label codeLabel = new Label("Enter the verification code sent to your email:");
        codeLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #333333;");

        TextField codeField = new TextField();
        codeField.setPromptText("Enter verification code");
        codeField.setMaxWidth(280);

        Button verifyCodeButton = new Button("Verify Code");
        verifyCodeButton.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: #CCFFCC;" +
            "-fx-text-fill: #006600;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;"
        );
        verifyCodeButton.setCursor(Cursor.HAND);
        verifyCodeButton.setOnAction(e -> {
            String code = codeField.getText().trim();
            if (code.isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "Please enter the verification code.");
            } else if (!isValidCode(code)) {
                showAlert(AlertType.ERROR, "Invalid Code", "The code you entered is incorrect.");
            } else {
                showAlert(AlertType.INFORMATION, "Success", "Code verified. You may now reset your password.");
                codeField.clear();
            }
        });

        // Layout
        VBox content = new VBox(15, titleLabel, instructionLabel, emailField, submitButton, codeLabel, codeField, verifyCodeButton);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(20));

        VBox wholeVertical = new VBox(goBack, logoIVBox, content);
        wholeVertical.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        Scene scene = new Scene(wholeVertical, 360, 640);

        stage.setScene(scene);
        stage.setTitle("Forgot Password");
        stage.show();
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    private boolean isValidCode(String code) {
        // Mock validation for the code (replace with actual logic if needed)
        return code.equals("123456");
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
