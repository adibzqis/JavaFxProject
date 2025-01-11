package sem_3_project_driver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sem3_project.accountPage;
import sem3_project.logOut;

public class driverUI extends Application {

    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Cab");
        setupMainScene(primaryStage);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void setupMainScene(Stage primaryStage) {
        // Logo image
        Image logoImage = new Image(getClass().getResourceAsStream("/logoAppNew.png"));
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitHeight(100);
        logoView.setFitWidth(100);
        logoView.setScaleX(2);  // Double the width
        logoView.setScaleY(2);

        // Create an HBox for the logo and center it
        HBox logoHBox = new HBox();
        logoHBox.setAlignment(Pos.CENTER); // Center the logo
        logoHBox.getChildren().add(logoView); // Add the logo to the HBox

        // Taskbar at the bottom
        HBox taskbar = new HBox(10);
        taskbar.setPadding(new Insets(10));
        taskbar.setAlignment(Pos.CENTER);
        taskbar.setStyle("-fx-border-color: #d3d3d3; -fx-border-width: 1px 0 0 0; -fx-background-color: white;");

        Button myAccountButton = createTaskbarButton("Account", "account.png");
        Button myOrderButton = createTaskbarButton("Orders", "order.png");
        Button logOutButton = createTaskbarButton("Log Out", "logout.png");

        // Add actions for buttons (you can modify the actions later)
		myAccountButton.setOnAction(e -> accountPage.showAccountPage(primaryStage, mainScene));
        myOrderButton.setOnAction(e -> { /* Action for Orders */ });
		logOutButton.setOnAction(e -> logOut.confirmLogout(primaryStage, mainScene));

        taskbar.getChildren().addAll(myAccountButton, myOrderButton, logOutButton);

        // Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(logoHBox);
        mainLayout.setBottom(taskbar);
        mainLayout.setStyle("-fx-background-color: linear-gradient(to bottom, #FFE4E1, #FFFFFF);");

        mainScene = new Scene(mainLayout, 360, 640);
    }

    private Button createTaskbarButton(String text, String imagePath) {
        Image image = new Image(getClass().getResourceAsStream("/" + imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        Button button = new Button(text, imageView);
        button.setContentDisplay(ContentDisplay.TOP);
        button.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 12px;");

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
