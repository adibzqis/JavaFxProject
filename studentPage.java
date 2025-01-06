package CSC3104PROJECT;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
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
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class studentPage extends Application {
	
	private TextField usernameTF;
	private TextField passwordTF;

    @Override
    public void start(Stage stage) {
    	
    	Button backButton = new Button("Back");
    	backButton.setOnAction(e -> {
            firstPage firstPage = new firstPage();
            firstPage.start(stage);
    	});
    	
    	HBox goBack = new HBox (backButton);
    	goBack.setAlignment(Pos.CENTER_LEFT);
    	
    	Label loginLabel = new Label("Login");
    	loginLabel.setPadding((new Insets(25 ,0 ,0 ,0)));
    	loginLabel.setStyle(
    	"-fx-font-size : 20px;" +
    	"-fx-font-weight : bold;"
    			);
    	
    	HBox loginBox = new HBox(10, loginLabel);
    	loginBox.setAlignment(Pos.CENTER);
    	
    	Label usernameLabel = new Label("Username");
    	usernameLabel.setStyle(
    	"-fx-font-size : 12px;"		
    			);
    	
    	usernameTF = new TextField();
    	usernameTF.setPromptText("Enter your username");
    	usernameTF.setPrefWidth(200);
    	usernameTF.setPrefHeight(25);
    	
    	HBox usernameLabelBox = new HBox(10, usernameLabel);
    	usernameLabelBox.setPadding(new Insets(0, 0, 0, 202));
    	
    	HBox usernameTFBox = new HBox(usernameTF);
    	usernameTFBox.setAlignment(Pos.CENTER);
    	
    	VBox verticalUser = new VBox(5, usernameLabelBox, usernameTFBox);
    	
    	Label passwordLabel = new Label("Password");
    	passwordLabel.setStyle(
    	"-fx-font-size : 12px;"		
    			);
    	
    	passwordTF = new TextField();
    	passwordTF.setPromptText("Enter your password");
    	passwordTF.setPrefWidth(200);
    	passwordTF.setPrefHeight(25);
    	
    	HBox passwordLabelBox = new HBox(10, passwordLabel);
    	passwordLabelBox.setPadding(new Insets(0, 0, 0, 202));
    	
    	HBox passwordTFBox = new HBox(passwordTF);
    	passwordTFBox.setAlignment(Pos.CENTER);
    	
    	VBox verticalPassword = new VBox(5, passwordLabelBox, passwordTFBox);
    	
    	Button signinButton = new Button("Sign In");
    	signinButton.setOnAction(event -> signinMethod());
    	
    	HBox signinBox = new HBox(signinButton);
    	signinBox.setAlignment(Pos.CENTER);
    	
    	Label forgotLabel = new Label("Forgot Password?");
    	forgotLabel.setStyle(
    	"-fx-font-size : 10px;"		
    			);
    	
    	forgotLabel.setOnMouseClicked( event -> {});
    	
    	forgotLabel.setOnMouseEntered(event -> forgotLabel.setStyle(
    			"-fx-font-size: 10px; -fx-text-fill: darkblue; -fx-underline: true;"
    			));
    	
        forgotLabel.setOnMouseExited(event -> forgotLabel.setStyle(
        		"-fx-font-size: 10px; -fx-text-fill: blue; -fx-underline: true;"
        		));
    	
    	HBox forgotBox = new HBox(10, forgotLabel);
    	forgotBox.setAlignment(Pos.CENTER);
    	
    	Button signupButton = new Button("Sign Up");
    	signupButton.setOnAction(event -> signupMethod());
    	
    	HBox signupBox = new HBox(10, signupButton);
    	signupBox.setAlignment(Pos.CENTER);
    	
    	VBox wholeVertical = new VBox(25, goBack, loginBox, verticalUser, verticalPassword, signinBox, forgotBox, signupBox);
        wholeVertical.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        // Create an empty scene
        Scene scene = new Scene(wholeVertical, 360, 640);

        // Configure the stage
        stage.setScene(scene);
        stage.setTitle("Student Page");
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
    
    public void signupMethod() {
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}
