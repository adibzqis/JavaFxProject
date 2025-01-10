package CSC3104PROJECT;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class driverPage extends Application {
	
	private TextField usernameTF;
	private TextField passwordTF;

    @Override
    public void start(Stage stage) {
    	
    	Image backImage = new Image(getClass().getResourceAsStream("undo.png"));
    	ImageView backIV = new ImageView(backImage);
    	backIV.setFitWidth(23);
    	backIV.setFitHeight(23);
    	
    	Button backButton = new Button("",backIV);
    	backButton.setCursor(Cursor.HAND);
    	backButton.setOnAction(e -> {
            firstPage firstPage = new firstPage();
            firstPage.start(stage);
    	});
    	
    	HBox goBack = new HBox (backButton);
    	goBack.setPadding(new Insets(10,10,10,10));
    	
    	Image logoImage = new Image(getClass().getResourceAsStream("logo.png"));
    	ImageView logoIV = new ImageView(logoImage);
    	logoIV.setFitHeight(120);
    	logoIV.setFitWidth(120);
    	
    	HBox logoIVBox = new HBox(logoIV);
    	logoIVBox.setAlignment(Pos.CENTER);
    	logoIVBox.setPadding(new Insets(0 ,0 ,-50 ,0));
    	
    	Label loginLabel = new Label("Login");
    	loginLabel.setPadding((new Insets(25 ,0 ,0 ,0)));
    	loginLabel.setStyle(
    	"-fx-font-family: 'Arial Rounded MT Bold'; " +
    	"-fx-font-size : 28px;" +
    	"-fx-font-weight : bold;" +
    	"-fx-text-fill: #FF4444;"
    			);
    	
    	HBox loginBox = new HBox(10, loginLabel);
    	loginBox.setAlignment(Pos.CENTER);
    	
    	Label usernameLabel = new Label("Username");
    	usernameLabel.setStyle(
    	"-fx-font-family: 'Arial Rounded MT Bold'; " +
    	"-fx-font-size : 12px;"		
    			);
    	
    	usernameTF = new TextField();
    	usernameTF.setPromptText("Enter your username");
    	usernameTF.setPrefWidth(200);
    	usernameTF.setPrefHeight(35);
    	
    	HBox usernameLabelBox = new HBox(10, usernameLabel);
    	usernameLabelBox.setPadding(new Insets(0, 0, 0, 81));
    	
    	HBox usernameTFBox = new HBox(usernameTF);
    	usernameTFBox.setAlignment(Pos.CENTER);
    	
    	VBox verticalUser = new VBox(5, usernameLabelBox, usernameTFBox);
    	
    	Label passwordLabel = new Label("Password");
    	passwordLabel.setStyle(
    	"-fx-font-family: 'Arial Rounded MT Bold'; " +
    	"-fx-font-size : 12px;"		
    			);
    	
    	passwordTF = new TextField();
    	PasswordField passwordTF = new PasswordField(); // Use PasswordField for password input
    	passwordTF.setPromptText("Enter your password");
    	passwordTF.setPrefWidth(200);
    	passwordTF.setPrefHeight(35);
    	
    	HBox passwordLabelBox = new HBox(10, passwordLabel);
    	passwordLabelBox.setPadding(new Insets(0, 0, 0, 81));
    	
    	HBox passwordTFBox = new HBox(passwordTF);
    	passwordTFBox.setAlignment(Pos.CENTER);
    	
    	Label forgotLabel = new Label("Forgot Password?");
    	forgotLabel.setCursor(Cursor.HAND);
    	forgotLabel.setPadding(new Insets (0,0,0,81));
    	forgotLabel.setStyle(
    			"-fx-font-size: 10px; " +
    			"-fx-text-fill: darkblue; " +
    			"-fx-underline: true;"	
    			);
    	
    	forgotLabel.setOnMouseClicked( event -> {
    		forgotPassPage forgotPassPage = new forgotPassPage();
    		forgotPassPage.start(stage);
    	});
    	
    	VBox verticalPassword = new VBox(5, passwordLabelBox, passwordTFBox, forgotLabel);
    	
    	Button signinButton = new Button("Sign In");
    	signinButton.setPrefHeight(20);
    	signinButton.setPrefWidth(80);
    	signinButton.setCursor(Cursor.HAND);
    	signinButton.setStyle(
    			"-fx-font-size : 14px;" +
    			"-fx-font-weight : bold;"
    			);
    	signinButton.setOnAction(event -> signinMethod());
    	
    	HBox signinBox = new HBox(signinButton);
    	signinBox.setAlignment(Pos.CENTER);
    	
    	Button signupButton = new Button("Sign Up");
    	signupButton.setPrefHeight(20);
    	signupButton.setPrefWidth(80);
    	signupButton.setCursor(Cursor.HAND);
    	signupButton.setStyle(
    			"-fx-font-size : 14px;" +
    		    "-fx-font-weight : bold"
    			);
    	signupButton.setOnAction(e -> {
    		verifyPageDriver verifyPageDriver = new verifyPageDriver();
    		verifyPageDriver.start(stage);
    	});
    	
    	HBox signupBox = new HBox(10, signupButton);
    	signupBox.setAlignment(Pos.CENTER);
    	
    	VBox wholeVertical = new VBox(30, goBack, logoIVBox, loginBox, verticalUser, verticalPassword, signinBox, signupBox);
        wholeVertical.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        // Create an empty scene
        Scene scene = new Scene(wholeVertical, 360, 640);

        // Configure the stage
        stage.setScene(scene);
        stage.setTitle("Driver Page");
        stage.show();
    }
    
    public void signinMethod() {
    	if(passwordTF.getText().isEmpty() || usernameTF.getText().isEmpty()) {
    		Alert errorText = new Alert(AlertType.ERROR);
    		errorText.setTitle("ERROR");
    		errorText.setHeaderText("The Username nad Password field are empty");
    		errorText.setContentText("Please fill out both fields");
    		errorText.showAndWait();
    	};
    }
    public static void main(String[] args) {
        launch(args);
    }
}
