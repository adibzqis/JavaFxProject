package CSC3104PROJECT;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class signupPageDriver extends Application {

    private TextField usernameTF;
    private TextField passwordTF;
    private TextField emailTF;
    private TextField carBrandTF;
    private TextField licensePlateTF;

    @Override
    public void start(Stage stage) {

        Image backImage = new Image(getClass().getResourceAsStream("undo.png"));
        ImageView backIV = new ImageView(backImage);
        backIV.setFitWidth(23);
        backIV.setFitHeight(23);

        Button backButton = new Button("", backIV);
        backButton.setCursor(Cursor.HAND);
        backButton.setOnAction(e -> {
            driverPage driverPage = new driverPage();
            driverPage.start(stage);
        });

        HBox goBack = new HBox(backButton);
        goBack.setPadding(new Insets(10, 10, 10, 10));

        Image logoImage = new Image(getClass().getResourceAsStream("logo.png"));
        ImageView logoIV = new ImageView(logoImage);
        logoIV.setFitHeight(120);
        logoIV.setFitWidth(120);

        HBox logoIVBox = new HBox(logoIV);
        logoIVBox.setAlignment(Pos.CENTER);
        logoIVBox.setPadding(new Insets(0, 0, -50, 0));

        Label signupLabel = new Label("Sign Up");
        signupLabel.setPadding((new Insets(25, 0, -10, 0)));
        signupLabel.setStyle(
            "-fx-font-size : 20px;" +
            "-fx-font-weight : bold;"
        );

        HBox signUp = new HBox(signupLabel);
        signUp.setAlignment(Pos.CENTER);
        signUp.setPadding(new Insets(-10, 0, -10, 0));

        // Username Section
        Label usernameLabel = new Label("Username");
        usernameLabel.setPadding(new Insets(0, 140, 0, 0));
        usernameLabel.setStyle(
            "-fx-font-family: 'Arial Rounded MT Bold'; " +
            "-fx-font-size : 12px;"
        );

        TextField usernameTF = new TextField();
        usernameTF.setPromptText("Enter Your Name");
        usernameTF.setMaxWidth(200);
        usernameTF.setMinHeight(35);

        VBox usernameBox = new VBox(5, usernameLabel, usernameTF);
        usernameBox.setAlignment(Pos.CENTER);

        // Email Section
        Label emailLabel = new Label("Email");
        emailLabel.setPadding(new Insets(0, 165, 0, 0));
        emailLabel.setStyle(
            "-fx-font-family: 'Arial Rounded MT Bold'; " +
            "-fx-font-size : 12px;"
        );

        TextField emailTF = new TextField();
        emailTF.setPromptText("Enter Your Email");
        emailTF.setMaxWidth(200);
        emailTF.setMinHeight(35);

        VBox emailBox = new VBox(5, emailLabel, emailTF);
        emailBox.setAlignment(Pos.CENTER);

        // Password Section
        Label passwordLabel = new Label("Password");
        passwordLabel.setPadding(new Insets(0, 141, 0, 0));
        passwordLabel.setStyle(
            "-fx-font-family: 'Arial Rounded MT Bold'; " +
            "-fx-font-size : 12px;"
        );

        PasswordField passwordTF = new PasswordField();
        passwordTF.setPromptText("Enter Your Password");
        passwordTF.setMaxWidth(200);
        passwordTF.setMinHeight(35);

        VBox passwordBox = new VBox(5, passwordLabel, passwordTF);
        passwordBox.setAlignment(Pos.CENTER);

        // Car Brand Section
        Label carBrandLabel = new Label("Car Brand");
        carBrandLabel.setPadding(new Insets(0, 140, 0, 0));
        carBrandLabel.setStyle(
            "-fx-font-family: 'Arial Rounded MT Bold'; " +
            "-fx-font-size : 12px;"
        );

        TextField carBrandTF = new TextField();
        carBrandTF.setPromptText("Enter Your Car Brand");
        carBrandTF.setMaxWidth(200);
        carBrandTF.setMinHeight(35);

        VBox carBrandBox = new VBox(5, carBrandLabel, carBrandTF);
        carBrandBox.setAlignment(Pos.CENTER);

        // License Plate Section
        Label licensePlateLabel = new Label("License Plate");
        licensePlateLabel.setPadding(new Insets(0, 120, 0, 0));
        licensePlateLabel.setStyle(
            "-fx-font-family: 'Arial Rounded MT Bold'; " +
            "-fx-font-size : 12px;"
        );

        TextField licensePlateTF = new TextField();
        licensePlateTF.setPromptText("Enter Your License Plate");
        licensePlateTF.setMaxWidth(200);
        licensePlateTF.setMinHeight(35);

        VBox licensePlateBox = new VBox(5, licensePlateLabel, licensePlateTF);
        licensePlateBox.setAlignment(Pos.CENTER);

        // Main Layout
        VBox formLayout = new VBox(15, usernameBox, emailBox, passwordBox, carBrandBox, licensePlateBox);
        formLayout.setAlignment(Pos.CENTER);
        formLayout.setPadding(new Insets(20));

        Button signupButton = new Button("Sign Up");
        signupButton.setStyle(
            "-fx-font-size : 16px;" +
            "-fx-text-fill : white;" +
            "-fx-background-color: #FF4444;"
        );

        HBox signupButtonBox = new HBox(signupButton);
        signupButtonBox.setPadding(new Insets(-10,0,0,0));
        signupButtonBox.setAlignment(Pos.CENTER);

        VBox wholeVertical = new VBox(15, goBack, logoIVBox, signUp, formLayout, signupButtonBox);
        wholeVertical.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

        Scene scene = new Scene(wholeVertical, 360, 640);

        stage.setTitle("Sign Up Page (Driver)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
