package CSC3104PROJECT;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class firstPage extends Application {

    @Override
    public void start(Stage stage) {
        // Top Label
        Label topLabel = new Label("Which One Are You?");
        topLabel.setStyle(
        	"-fx-font-family: 'Arial Rounded MT Bold'; " +
            "-fx-font-size: 28px; " + // Larger font for mobile readability
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #FF4444;"
            + ""
        );

        // Images
        Image driverImage = new Image(getClass().getResourceAsStream("driverLOGO.png"));
        Image studentImage = new Image(getClass().getResourceAsStream("studentLOGO.png"));

        ImageView driverIV = new ImageView(driverImage);
        driverIV.setFitWidth(200); // Suitable size for mobile
        driverIV.setFitHeight(200);

        ImageView studentIV = new ImageView(studentImage);
        studentIV.setFitWidth(200);
        studentIV.setFitHeight(200);

        // Driver Button
        Button driverButton = new Button("Driver", driverIV);
        driverButton.setContentDisplay(ContentDisplay.TOP);
        driverButton.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #660000;" +
            "-fx-background-color: #FFCCCC;" +
            "-fx-border-color: #cccccc;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10;" // Explicit padding
        );
        driverButton.setOnMouseEntered(e -> driverButton.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #660000;" +
            "-fx-background-color: #FF9999;" +
            "-fx-border-color: #cccccc;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10;" // Maintain consistent padding
        ));
        driverButton.setOnMouseExited(e -> driverButton.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #660000;" +
            "-fx-background-color: #FFCCCC;" +
            "-fx-border-color: #cccccc;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10;" // Maintain consistent padding
        ));
        driverButton.setOnAction(e -> {
            driverPage driverPage = new driverPage();
            driverPage.start(stage);
        });

        // Student Button
        Button studentButton = new Button("Student", studentIV);
        studentButton.setContentDisplay(ContentDisplay.TOP);
        studentButton.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #660000;" +
            "-fx-background-color: #FFCCCC;" +
            "-fx-border-color: #cccccc;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10;"
        );
        
        studentButton.setOnMouseEntered(e -> studentButton.setStyle(
        	    "-fx-font-size: 18px;" +
        	    "-fx-font-weight: bold;" +
        	    "-fx-text-fill: #660000;" +
        	    "-fx-background-color: #FF9999;" +
        	    "-fx-border-color: #cccccc;" +
        	    "-fx-border-radius: 10;" +
        	    "-fx-background-radius: 10;" +
        	    "-fx-padding: 10;" // Maintain consistent padding
        	));
        studentButton.setOnMouseExited(e -> studentButton.setStyle(
        	    "-fx-font-size: 18px;" +
        	    "-fx-font-weight: bold;" +
        	    "-fx-text-fill: #660000;" +
        	    "-fx-background-color: #FFCCCC;" +
        	    "-fx-border-color: #cccccc;" +
        	    "-fx-border-radius: 10;" +
        	    "-fx-background-radius: 10;" +
        	    "-fx-padding: 10;" // Maintain consistent padding
        	));
        studentButton.setOnAction(e -> {
            studentPage studentPage = new studentPage();
            studentPage.start(stage);
        });
        
        // Driver Button Transition
        TranslateTransition driverTransition = new TranslateTransition(Duration.millis(800), driverButton);
        driverTransition.setFromY(-20);
        driverTransition.setToY(0);
        driverTransition.play();

        // Student Button Transition
        TranslateTransition studentTransition = new TranslateTransition(Duration.millis(800), studentButton);
        studentTransition.setFromY(-20);
        studentTransition.setToY(0);
        studentTransition.setDelay(Duration.millis(200)); // Add a slight delay for a staggered effect
        studentTransition.play();

        // Layout
        VBox layout = new VBox(20, topLabel, driverButton, studentButton); // Vertical layout with spacing
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 30;"); // Padding around the edges
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");
        
        // Scene (Portrait Dimensions for Mobile)
        Scene scene = new Scene(layout, 360, 640); // Mobile portrait dimensions
        stage.setScene(scene);
        stage.setTitle("First Page");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
