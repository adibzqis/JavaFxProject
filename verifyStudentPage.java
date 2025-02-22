package CSC3104PROJECT;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class verifyPageStudent extends Application {

    @Override
    public void start(Stage stage) {

        // Back Button
        Image backImage = new Image(getClass().getResourceAsStream("undo.png"));
        ImageView backIV = new ImageView(backImage);
        backIV.setFitWidth(23);
        backIV.setFitHeight(23);

        Button backButton = new Button("", backIV);
        backButton.setCursor(Cursor.HAND);
        backButton.setOnAction(e -> {
            studentPage studentPage = new studentPage();
            studentPage.start(stage);            
        });

        HBox goBack = new HBox(backButton);
        goBack.setAlignment(Pos.TOP_LEFT); 
        
        Image logoImage = new Image(getClass().getResourceAsStream("logo.png"));
    	ImageView logoIV = new ImageView(logoImage);
    	logoIV.setFitHeight(120);
    	logoIV.setFitWidth(120);
    	
    	HBox logoIVBox = new HBox(logoIV);
    	logoIVBox.setAlignment(Pos.CENTER);
    	logoIVBox.setPadding(new Insets(0 ,0 ,-50 ,0));
        
        // Title Label
        Label titleLabel = new Label("UPM Student");
        titleLabel.setPadding(new Insets(25, 0, 0, 0));
        titleLabel.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; " +
                "-fx-font-size: 28px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: #FF4444;");
        
        Label titleLabel2 = new Label("Verification");
        titleLabel2.setPadding(new Insets(5, 0, 0, 0));
        titleLabel2.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; " +
                "-fx-font-size: 28px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: #FF4444;");
        
        VBox titleBox = new VBox(-5, titleLabel, titleLabel2);
        titleBox.setAlignment(Pos.CENTER);

        // Matriculation Number Input
        Label matricLabel = new Label("Matric Number :");
        matricLabel.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 12px;");

        TextField matricField = new TextField();
        matricField.setPromptText("Enter your matric number");
        matricField.setPrefWidth(200);
        matricField.setPrefHeight(35);

        HBox matricLabelBox = new HBox(matricLabel);
        matricLabelBox.setPadding(new Insets(0, 0, 0, 61));

        HBox matricFieldBox = new HBox(matricField);
        matricFieldBox.setAlignment(Pos.CENTER);

        VBox matricBox = new VBox(5, matricLabelBox, matricFieldBox);

        // Password Input
        Label passwordLabel = new Label("Password :");
        passwordLabel.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 12px;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setPrefWidth(200);
        passwordField.setPrefHeight(35);

        HBox passwordLabelBox = new HBox(passwordLabel);
        passwordLabelBox.setPadding(new Insets(0, 0, 0, 61));

        HBox passwordFieldBox = new HBox(passwordField);
        passwordFieldBox.setAlignment(Pos.CENTER);

        VBox passwordBox = new VBox(5, passwordLabelBox, passwordFieldBox);

        // Verify Button
        Button verifyButton = new Button("Verify");
        verifyButton.setPrefHeight(20);
        verifyButton.setPrefWidth(80);
        verifyButton.setCursor(Cursor.HAND);
        verifyButton.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-background-color: #FF4444; -fx-text-fill: white;");
        verifyButton.setOnAction(e -> {
            signupPageStudent signupPageStudent = new signupPageStudent();
            signupPageStudent.start(stage);
        });

        HBox verifyBox = new HBox(verifyButton);
        verifyBox.setAlignment(Pos.CENTER);

        // Layout
        VBox layout = new VBox(25, goBack,logoIVBox,  titleBox, matricBox, passwordBox, verifyBox);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        // Scene and Stage
        Scene scene = new Scene(layout, 360, 640);
        stage.setTitle("Student Verification");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}  
