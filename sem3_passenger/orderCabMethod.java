package sem3_project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class orderCabMethod {
    static String orderDetails="";  // Store the confirmed order details
    static String orderTimeSaved="";
    static boolean hasOrder = false; // Flag indicating if there is an order

    // Method to set order details and time
    public static void setOrderDetails(String details, String time) {
    	orderDetails = details;
        orderTimeSaved = time;
        hasOrder = true; // Mark that there is an order now

    }
	  public static void showOrderPage(Stage primaryStage,Scene mainScene,String fromLocation, String toLocation, String paxCount, String price) {
	        VBox orderBox = new VBox(20);
	        orderBox.setPadding(new Insets(20));
	        orderBox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");
	        orderBox.setAlignment(Pos.CENTER);

	        Label titleLabel = new Label("My Orders");
	        titleLabel.setFont(new Font(20));
	        titleLabel.setStyle("-fx-allignment: center;");
	        titleLabel.setFont(new Font("Arial", 24));
	        titleLabel.setStyle("-fx-text-fill: #2a3d66; -fx-font-weight: bold;");
	        
	        // Create a VBox styled to look like a box
	        VBox detailsBox = new VBox(10); // Add spacing between details
	        detailsBox.setPadding(new Insets(15));
	        detailsBox.setStyle("-fx-border-color: #d3d3d3; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-color: white; -fx-background-radius: 10px;");
	        
	        // Create labels to display the order details
	        Label fromLabel = new Label("From: " + fromLocation);
	        Label toLabel = new Label("To: " + toLocation);
	        Label paxLabel = new Label("Pax: " + paxCount);
	        Label priceLabel = new Label("Price: " + price);

	        // Add labels to the details box
	        detailsBox.getChildren().addAll(fromLabel, toLabel, paxLabel, priceLabel);
	        
	     // Style the labels
	        for (Label label : new Label[]{fromLabel, toLabel, paxLabel, priceLabel}) {
	            label.setFont(new Font("Arial", 16));
	            label.setStyle("-fx-text-fill: #333333;");
	        }
	        Label orderDetailsLabel = new Label("Your order details will be displayed here");
	        orderDetailsLabel.setWrapText(true);
	        orderDetailsLabel.setFont(new Font(15));
	        orderDetailsLabel.setAlignment(Pos.CENTER);
	        


	        // Create Confirm button
	        Button confirmButton = new Button("Confirm Order");
	        confirmButton.setOnAction(e -> {
	            String details = "Order Details:\nFrom: " + fromLocation + "\nTo: " + toLocation +
	                             "\nPax: " + paxCount + "\nPrice: " + price;
	            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	            orderCabMethod.setOrderDetails(details, time); // Update order details
	            orderCabMethod.showMyOrdersPage(primaryStage, mainScene); // Navigate to the orders page
	        });
	        Button backButton = new Button("Back");
	        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

	        orderBox.getChildren().addAll(titleLabel,orderDetailsLabel,detailsBox,confirmButton,backButton);

	        Scene orderScene = new Scene(orderBox, 360, 640);
	        primaryStage.setScene(orderScene);
	    }
	  
	   private static void showMyOrdersPage(Stage primaryStage,Scene mainScene) {
		   // Get the current time when the order is confirmed
	        LocalDateTime orderTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedTime = orderTime.format(formatter);
	        orderTimeSaved = orderTime.format(formatter);
	        
		   	VBox myOrdersBox = new VBox(20);
	        myOrdersBox.setPadding(new Insets(20));
	        myOrdersBox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");
	        myOrdersBox.setAlignment(Pos.CENTER);

	        Label titleLabel = new Label("Order Confirmed");
	        titleLabel.setFont(new Font("Arial", 24));
	        titleLabel.setStyle("-fx-text-fill: #2a3d66; -fx-font-weight: bold;");

	        // Create an ImageView for the order image
	        Image orderImage = new Image("file:///C:/Users/Asus/eclipse-workspace/sem3_project/src/success.png");  // Replace with your image path or URL
	        ImageView imageView = new ImageView(orderImage);
	        imageView.setFitWidth(50);
	        imageView.setFitHeight(50);

	        // Create an HBox to hold the order details label and image horizontally
	        HBox orderDetailsBox = new HBox(10);  // 10px spacing between elements
	        orderDetailsBox.setAlignment(Pos.CENTER);  // Align to the left
	        orderDetailsBox.setPadding(new Insets(10));

	        // Create a Label for the order details
	        Label orderDetailsLabel = new Label(orderCabMethod.orderDetails);  // Use the stored order details
	        orderDetailsLabel.setWrapText(true);
	        orderDetailsLabel.setFont(new Font("Arial", 14));
	        orderDetailsLabel.setStyle("-fx-text-fill: #333333;");
	        orderDetailsLabel.setMaxWidth(200);  // Limit the width for better text wrapping
	        orderDetailsLabel.setPadding(new Insets(10));
	        orderDetailsLabel.setStyle("-fx-border-color: #4CAF50; -fx-border-width: 2; -fx-background-color: white;-fx-alignment: center;");

	        // Add both the order details and image to the HBox
	        orderDetailsBox.getChildren().addAll(imageView);
	        
	        // Add the order time label
	        Label orderTimeLabel = new Label("Order Time: " + formattedTime);
	        orderTimeLabel.setFont(new Font("Arial", 12));
	        orderTimeLabel.setStyle("-fx-text-fill: #555555;");


	        Button backButton = new Button("Back");
	        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

	        myOrdersBox.getChildren().addAll(titleLabel,orderDetailsBox, orderDetailsLabel,orderTimeLabel, backButton);

	       
	        Scene myOrdersScene = new Scene(myOrdersBox, 360, 640);
	        primaryStage.setScene(myOrdersScene);
	    }
	}
	    
