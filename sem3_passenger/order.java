package sem3_project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class order {
    private static String orderStatus = "Pending"; // Default order status

    public static void showMyOrdersPage(Stage primaryStage, Scene mainScene) {
        // Add the order time label (retrieved from orderCabMethod)
        Label orderTimeLabel = new Label("Order Time: " + 
            (orderCabMethod.orderTimeSaved != null ? orderCabMethod.orderTimeSaved : "N/A"));  
        orderTimeLabel.setFont(new Font("Arial", 12));
        orderTimeLabel.setStyle("-fx-text-fill: #555555;");

        // Create a VBox for the layout
        VBox myOrdersBox = new VBox(20);
        myOrdersBox.setPadding(new Insets(20));
        myOrdersBox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");
        myOrdersBox.setAlignment(Pos.CENTER);

        // Title label
        Label titleLabel = new Label(orderCabMethod.hasOrder ? "Order Successful" : "No Orders Yet");
        titleLabel.setFont(new Font(20));
        titleLabel.setStyle("-fx-alignment: center; -fx-text-fill: #2a3d66;");

        // Order details label
        Label orderDetailsLabel = new Label(orderCabMethod.hasOrder ? orderCabMethod.orderDetails : "No details available.");
        orderDetailsLabel.setWrapText(true);
        orderDetailsLabel.setFont(new Font(12));
        orderDetailsLabel.setPadding(new Insets(10));
        orderDetailsLabel.setStyle("-fx-border-color: #4CAF50; -fx-border-width: 2; -fx-background-color: white;");

     // Status button
        Button statusButton = new Button();
        statusButton.setDisable(!orderCabMethod.hasOrder); // Disable if no order
        statusButton.setStyle("-fx-background-color: #FFA500; -fx-text-fill: white; -fx-border-radius: 20; -fx-padding: 10 20;");

        // Dynamically set the button text based on the current order status
        if (orderCabMethod.hasOrder) {
            statusButton.setText("Status: " + orderStatus);
        } else {
            statusButton.setText("No Order");
        }

        // Update status dynamically on button click
        statusButton.setOnAction(e -> {
            if (orderCabMethod.hasOrder) {
                // Toggle between Pending and Successful
                orderStatus = orderStatus.equals("Pending") ? "Successful" : "Pending";
                statusButton.setText("Status: " + orderStatus);
            }
        });

        
        // Chat button
        Button chatButton = new Button("Chat Driver");
        chatButton.setDisable(!orderCabMethod.hasOrder); // Disable if no order
        chatButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 20; -fx-padding: 10 20;");
        chatButton.setOnAction(e -> openChatWindow(primaryStage));

        // Back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));
        backButton.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white; -fx-font-size: 14px;");

        // Add components to VBox
        myOrdersBox.getChildren().addAll(titleLabel, orderDetailsLabel, orderTimeLabel, statusButton, chatButton, backButton);

        // Create the scene
        Scene myOrdersScene = new Scene(myOrdersBox, 360, 640);
        primaryStage.setScene(myOrdersScene);
    }

    private static void openChatWindow(Stage ownerStage) {
        // Placeholder chat window
        Stage chatStage = new Stage();
        chatStage.initOwner(ownerStage);
        chatStage.setTitle("Chat with Driver");

        VBox chatBox = new VBox(20);
        chatBox.setPadding(new Insets(20));
        chatBox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #E6F7FF, #FFFFFF);");
        chatBox.setAlignment(Pos.CENTER);

        Label chatTitle = new Label("Chat with Driver");
        chatTitle.setFont(new Font(18));
        chatTitle.setStyle("-fx-text-fill: #2a3d66;");

        Label chatPlaceholder = new Label("Chat functionality coming soon!");
        chatPlaceholder.setFont(new Font(14));
        chatPlaceholder.setStyle("-fx-text-fill: #555555;");

        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
        closeButton.setOnAction(e -> chatStage.close());

        chatBox.getChildren().addAll(chatTitle, chatPlaceholder, closeButton);

        Scene chatScene = new Scene(chatBox, 300, 200);
        chatStage.setScene(chatScene);
        chatStage.show();
    }

    // Method to set order status and mark order presence
    public static void setOrderDetails(String details, String time) {
        orderCabMethod.orderDetails = details;
        orderCabMethod.orderTimeSaved = time;
        orderStatus = "Pending"; // Reset to Pending when a new order is made
        orderCabMethod.hasOrder = true; // Mark as having an order
    }

    public static void clearOrder() {
        orderCabMethod.orderDetails = null;
        orderCabMethod.orderTimeSaved = null;
        orderStatus = "No Order";
        orderCabMethod.hasOrder = false; // Mark as no order
    }
}