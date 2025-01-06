package CSC3104PROJECT;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay; 
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import CSC3104PROJECT.studentPage;

import java.io.File;

import CSC3104PROJECT.driverPage;

public class signupPageStudent extends Application {
	
	private TextField usernameTF;
	private TextField passwordTF;
	private TextField emailTF;
	
    @Override
    public void start(Stage stage) {
    	
    	Button backButton = new Button("Back");
    	backButton.setOnAction(e -> {
            studentPage studentPage = new studentPage();
            studentPage.start(stage);
    	});
    	
    	HBox goBack = new HBox (backButton);
    	goBack.setAlignment(Pos.CENTER_LEFT);
    	
    	Label signupLabel = new Label("Sign Up");
    	signupLabel.setPadding((new Insets(25 ,0 ,0 ,0)));
    	signupLabel.setStyle(
    	"-fx-font-size : 20px;" +
    	"-fx-font-weight : bold;"
    			);
    	
    	HBox signUp = new HBox(signupLabel);
    	signUp.setAlignment(Pos.CENTER);
    	
    	usernameTF = new TextField();
    	usernameTF.setPromptText("Enter Your Name");
    	usernameTF.setPrefWidth(200);
    	usernameTF.setPrefHeight(35);
    	
    	HBox usernameBox = new HBox(usernameTF);
    	usernameBox.setAlignment(Pos.CENTER);
    	   	
    	emailTF = new TextField();
    	emailTF.setPromptText("Enter Your Email");
    	emailTF.setPrefWidth(200);
    	emailTF.setPrefHeight(35);
    	
    	HBox emailBox = new HBox(emailTF);
    	emailBox.setAlignment(Pos.CENTER);
    	    	
    	passwordTF = new TextField();
    	passwordTF.setPromptText("Enter Your Password");
    	passwordTF.setPrefWidth(200);
    	passwordTF.setPrefHeight(35);
    	
    	HBox passwordBox = new HBox(passwordTF);
    	passwordBox.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Please upload a proof\nthat you are a student :)");
    	HBox labelFile = new HBox(label);
    	labelFile.setAlignment(Pos.CENTER);
    	
    	Button fileChooserButton = new Button("Open a file");
    	ImageView imgView = new ImageView();
    	
    	fileChooserButton.setOnAction(actionEvent -> {
    		FileChooser fileChooser = new FileChooser();
    		fileChooser.setTitle("Open a file");
    		fileChooser.setInitialDirectory(new File("C:\\"));
    		fileChooser.getExtensionFilters().addAll(
    				new FileChooser.ExtensionFilter("JPEG image", "*.jpg"),
    				new FileChooser.ExtensionFilter("PNG image", "*.png"),
    				new FileChooser.ExtensionFilter("PDF image", "*.pdf"), 
    				new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png")
    				);
    		File selectedFile = fileChooser.showOpenDialog(stage);
    		if(selectedFile != null) {
    			label.setText(selectedFile.getName());
    			Image image = new Image(selectedFile.getPath());
    			imgView.setImage(image);
    		}
    	});
    	
    	HBox fileChooserBox = new HBox( fileChooserButton, imgView);
    	fileChooserBox.setAlignment(Pos.CENTER);
    	
    	Button signupButton = new Button("Sign Up");
    	signupButton.setStyle(
    			"-fx-font-size : 20px;" +
    			"-fx-text-fill : white;" +
    			"-fx-background-color: lightblue;"
    			);
    	
    	HBox signupButtonBox = new HBox(10, signupButton);
    	signupButtonBox.setAlignment(Pos.CENTER);
    	    	
    	VBox wholeVertical = new VBox(15, goBack, signUp, usernameBox, emailBox, passwordBox, labelFile, fileChooserBox, signupButtonBox);
        wholeVertical.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");
    	    	    	
    	Scene scene = new Scene(wholeVertical, 360, 640);
    	
        stage.setTitle("Sign Up Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
