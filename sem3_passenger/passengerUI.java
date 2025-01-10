package sem3_project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class passengerUI extends Application {

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
	 
	    
		Label fromLabel = new Label("From");
		Label toLabel = new Label("To");
		Label paxLabel = new Label("Pax");
        Label priceLabel = new Label("Price: ");

        TextField priceTextField = new TextField();
        priceTextField.setEditable(false);
        priceTextField.setStyle("-fx-background-color: white; " + "-fx-border-color: black; " + "-fx-border-width: 1px; "
				+ "-fx-background-radius: 15px; " + "-fx-border-radius: 15px;");
		
		// Create ComboBoxes for suggestions
		ObservableList<String> locations = FXCollections.observableArrayList("KC", "KTDI", "KPZ", "K12", "PFC",
				"IOI CITY MALL", "RESTAURANT PKS", "SULTAN ABDUL SAMAD LIBRARY", "MRT UPM");

		ObservableList<String> pax = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");

		ComboBox<String> fromComboBox = new ComboBox<>(locations);
		fromComboBox.setEditable(false);
		fromComboBox.setStyle("-fx-background-color: white; " + "-fx-border-color: black; " + "-fx-border-width: 1px; "
				+ "-fx-background-radius: 15px; " + "-fx-border-radius: 15px;");
		fromComboBox.setPromptText("Enter location");
		fromComboBox.setMaxWidth(Double.MAX_VALUE);
		// Apply GridPane constraint to make it grow
		GridPane.setHgrow(fromComboBox, Priority.ALWAYS);

		ComboBox<String> toComboBox = new ComboBox<>(locations);
		toComboBox.setEditable(false);
		toComboBox.setStyle("-fx-background-color: white; " + "-fx-border-color: black; " + "-fx-border-width: 1px; "
				+ "-fx-background-radius: 15px; " + "-fx-border-radius: 15px;");
		toComboBox.setPromptText("Enter location");
		toComboBox.setMaxWidth(Double.MAX_VALUE);
		GridPane.setHgrow(toComboBox, Priority.ALWAYS);

		ComboBox<String> paxComboBox = new ComboBox<>(pax);
		paxComboBox.setEditable(false);
		paxComboBox.setStyle("-fx-background-color: white; " + "-fx-border-color: black; " + "-fx-border-width: 1px; "
				+ "-fx-background-radius: 15px; " + "-fx-border-radius: 15px;");
		paxComboBox.setPromptText("Enter pax");
		paxComboBox.setMaxWidth(Double.MAX_VALUE);
		GridPane.setHgrow(paxComboBox, Priority.ALWAYS);

		Button orderButton = new Button("Order cab");
		orderButton.setMaxWidth(Double.MAX_VALUE);
		orderButton.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white; -fx-font-size: 14px;");
		// Action for Order button
		orderButton.setOnAction(e -> {
		    // Get the selected values from the combo boxes and price
		    String fromLocation = fromComboBox.getValue();
		    String toLocation = toComboBox.getValue();
		    String paxCount = paxComboBox.getValue();
		    String price = priceTextField.getText();

		    // Check if all required fields are selected
		    if (fromLocation != null && toLocation != null && paxCount != null && !price.isEmpty()) {
		    	if (fromLocation.equals(toLocation)) {
			        ErrorPage2.showErrorPopup2(primaryStage);
		    	}else {
		    	// Pass the selected data to the order page
		        orderCabMethod.showOrderPage(primaryStage, mainScene, fromLocation, toLocation, paxCount, price);
		    	}
		    	
		    } else {
		        ErrorPage.showErrorPopup(primaryStage);
		    }});

		// Layout
		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.add(fromLabel, 0, 0);
		gridPane.add(fromComboBox, 1, 0);
		gridPane.add(toLabel, 0, 1);
		gridPane.add(toComboBox, 1, 1);
		gridPane.add(paxLabel, 0, 2);
		gridPane.add(paxComboBox, 1, 2);
		gridPane.add(priceLabel, 0, 3);
		gridPane.add(priceTextField, 1,3);
		
		  // Update the price when the combo box values change
        fromComboBox.setOnAction(e -> updatePrice(fromComboBox, toComboBox,  priceTextField));
        toComboBox.setOnAction(e -> updatePrice(fromComboBox, toComboBox,  priceTextField));
        paxComboBox.setOnAction(e -> updatePrice(fromComboBox, toComboBox,  priceTextField));

		// Recently viewed places
		Label recentLabel = new Label("Popular Places");
		recentLabel.setFont(new Font(16));

		TilePane tilePane = new TilePane();
		tilePane.setStyle("-fx-background-color: white;");
		tilePane.setHgap(10);
		tilePane.setVgap(10);
		tilePane.setPrefColumns(1); // Set 1 column to force buttons to use available width
		tilePane.setPadding(new Insets(10));
		tilePane.setAlignment(Pos.CENTER); // Align content

		// Sample places
		String[][] places = { { "Sultan Abdul Samad Library",
				"The Sultan Abdul Samad Library at Universiti Putra Malaysia (UPM) is a central hub for academic resources and research materials, supporting the university's educational mission. Located within UPM's main campus in Serdang, Selangor, the library offers a wide range of print and digital resources, including books, journals, and multimedia content.\n\n It provides various facilities such as study rooms, computer stations, and access to specialized databases, helping students and faculty with research and academic work. The library also organizes events, workshops, and information literacy programs to enhance the learning experience.",
				"Perpustakaan_Sultan_Abdul_Samad.png" },
				{ "MRT UPM",
						"Easily accessible public transportation hub. The UPM MRT Station, located in Serdang, Selangor, Malaysia, serves as a key transit hub for Universiti Putra Malaysia (UPM) and surrounding areas. Opened on March 16, 2023, as part of the MRT Putrajaya Line, the station features an island platform design and offers amenities such as lifts, escalators, a surau (prayer room), and a Park and Ride facility. \n \n It is conveniently located near UPM's Faculty of Agriculture and University Housing Complex, with easy access to nearby attractions like Farm Fresh @ UPM, Serdang Hospital, MARDI, MAEPS, and IOI City Mall. The station is connected to the campus and residential areas via feeder buses and provides a seamless commuting experience for students, staff, and the public.",
						"mrtUPM.jpg" },
				{ "IOI City Mall",
						"Shopping mall with various attractions and dining. IOI City Mall, located in IOI Resort City, Sepang, Selangor, Malaysia, is the largest shopping mall in the country and Southeast Asia, with a total net lettable area of 2.5 million square feet and over 700 retail outlets following its Phase II expansion in August 2022. \n\n Developed by IOI Properties Group, the mall features diverse retail and dining options, an Olympic-sized ice-skating rink, an indoor adventure theme park (District 21), and an edutainment space called IOI City Farm. It also houses Golden Screen Cinemas with IMAX and luxury halls, a rooftop sports center, and a grand exhibition hall. Accessible via major highways and 30 minutes from KLIA, the mall offers 14,000 parking bays with automated systems and emphasizes sustainability with solar panels and energy-efficient technologies.",
						"IOI_City_Mall.jpg" },
				{ "Restaurant PKS",
						"Restoran PKS Maju, situated in Taman Sri Serdang, Seri Kembangan, Selangor, is a well-loved Indian Muslim (Mamak) eatery that has become a favorite among locals for its flavorful and affordable dishes. Known for its 24-hour service, the restaurant caters to a variety of tastes, offering an extensive menu that includes traditional favorites such as Nasi Briyani, Roti Canai, Nasi Lemak, and a range of curries, grilled meats, and fried rice dishes. \n\n The restaurant's casual and welcoming atmosphere makes it an ideal spot for both quick meals and casual gatherings. It also serves a selection of beverages, from the classic Teh Tarik to refreshing fruit juices and soft drinks. With its strategic location along major roads in Seri Kembangan, it is easily accessible and offers ample parking space for its patrons. The restaurant’s ability to consistently serve high-quality, tasty dishes at all hours of the day has earned it a loyal following. Whether it's early in the morning or late at night, Restoran PKS Maju remains a popular choice for those craving authentic Indian Muslim cuisine in the area.",
						"pks.png" } };

		for (String[] place : places) {
			// Load image
			Image image = new Image(getClass().getResourceAsStream("/" + place[2])); // Load image from resources
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(50); // Set height of the image
			imageView.setFitWidth(50); // Set width of the image

			Button placeButton = new Button(place[0], imageView);
			placeButton.setStyle("-fx-border-color: #d3d3d3; -fx-background-color: white;");
			placeButton.setMaxWidth(Double.MAX_VALUE);
			placeButton.setContentDisplay(ContentDisplay.LEFT);
			placeButton.setAlignment(Pos.CENTER_LEFT);

			placeButton.setOnAction(
					e -> placeDetailsPage.showPlaceDetails(primaryStage, mainScene, place[0], place[1], place[2]));
			tilePane.getChildren().add(placeButton);

		}

		ScrollPane scrollPane = new ScrollPane(tilePane);
		scrollPane.setFitToWidth(true);
		scrollPane.setPrefHeight(150);

		VBox vbox = new VBox(20);
		vbox.getChildren().addAll(logoHBox,gridPane, orderButton, recentLabel, scrollPane);
		vbox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #FFCCCC, #FFFFFF);");

		// Taskbar at the bottom
		HBox taskbar = new HBox(10);
		taskbar.setPadding(new Insets(10));
		taskbar.setAlignment(Pos.CENTER);
		taskbar.setStyle("-fx-border-color: #d3d3d3; -fx-border-width: 1px 0 0 0; -fx-background-color: white;");

		Button myAccountButton = createTaskbarButton("Account", "account.png");
		Button myOrderButton = createTaskbarButton("Orders", "order.png");
		Button logOutButton = createTaskbarButton("Log Out", "logout.png");

		myAccountButton.setOnAction(e -> accountPage.showAccountPage(primaryStage, mainScene));
		myOrderButton.setOnAction(e -> order.showMyOrdersPage(primaryStage,mainScene));
		logOutButton.setOnAction(e -> logOut.confirmLogout(primaryStage, mainScene));

		taskbar.getChildren().addAll(myAccountButton, myOrderButton, logOutButton);
		BorderPane mainLayout = new BorderPane();
		mainLayout.setCenter(vbox);
		mainLayout.setBottom(taskbar);

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
    private void updatePrice(ComboBox<String> fromComboBox, ComboBox<String> toComboBox, TextField priceTextField) {
        String fromLocation = fromComboBox.getValue();
        String toLocation = toComboBox.getValue();

        if (fromLocation != null && toLocation != null ) {
            double travelPrice = PriceCalculator.calculatePrice(fromLocation, toLocation);

            if (travelPrice >= 0) {
                priceTextField.setText(String.format("RM %.2f", travelPrice));
            } else {
                priceTextField.setText("Invalid locations");
            }
        }
    }
	public static void main(String[] args) {
		launch(args);
	}
}
