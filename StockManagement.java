import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StockManagement extends Application{
	private static Product[] Products = new Product[10];
	private static UserInfo userInfo = new UserInfo();
	
	private Scene startScene;
	private Scene optionScene;
	private Scene Refrigerator;
	private Scene TV;
	private Scene Washer;
	private Scene AC;
	private Scene menuScene;
	private Scene SceneViewProduct;
	private Scene SceneAddStock;
	private Scene SceneDeductStock;
	private Scene SceneDiscontinueProduct;
	
	
	private String RefriName;
	private String RefriDoor;
	private String RefriColor;
	private double RefriCapacity;
	private int RefriQuantity;
	private double RefriPrice;
	private int RefriNum;
	
	private String TVName;
	private String TVScreen;
	private String TVResolution;
	private int TVDisplay;
	private int TVQuantity;
	private double TVPrice;
	private int TVNum;
	
	private String WasherName;
	private String WasherColor;
	private double WasherHeight;
	private double WasherWidth;
	private double WasherDepth;
	private double WasherWeight;
	private int WasherQuantity;
	private double WasherPrice;
	private int WasherNum;
	
	private String ACName;
	private String ACType;
	private double ACHorsePower;
	private double ACNoiseLevel;
	private double ACWeight;
	private int ACWarranty;
	private int ACQuantity;
	private double ACPrice;
	private int ACNum;
	
	private String username;
	private int selectItemNum;
	private int quantityToAdd;
	private int quantityToDeduct;
	private Product selectedProduct = null;
	private static int count = 0;
	private int maxProd = 0;
	
	
	@Override
	public void start(Stage primaryStage) {

		//Scene Start
		BorderPane startBP = new BorderPane();
		startBP.setStyle("-fx-background:rgb(223,213,255);\n -fx-background-color:rgb(223,213,255)");
		Pane textpane1 = new Pane();
		
		Text txt01 = new Text(65,130,"==WELCOME==");
		txt01.setFont(Font.font("Lucida Calligraphy", FontWeight.EXTRA_BOLD,
				 FontPosture.REGULAR, 80));
		
		Text txt02 = new Text(367,180,"TO");
		txt02.setFont(Font.font("Serif", FontWeight.BOLD,
				 FontPosture.REGULAR, 50));
		
		Text txt03 = new Text(155,340,"SMS");
		txt03.setFont(Font.font("Elephant", FontWeight.BOLD,
				 FontPosture.REGULAR, 200));
		
		//Group Member
		Text txt04 = new Text(225,400,"Dickson Shee Wei Hau");
		txt04.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		Text txt05 = new Text(280,430,"Khew Sei Fong");
		txt05.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		Text txt06 = new Text(290,460,"Lip Zhen Yi");
		txt06.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		Text txt07 = new Text(275,490,"Tham Yik Siong");
		txt07.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
        Text time = new Text(225,370,currentDate + " " + currentTime.format(formatter));
		time.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.ITALIC,18));
		time.setFill(Color.CORNFLOWERBLUE);
		LinearGradient linear1 = new LinearGradient(0,0,600,400,false,CycleMethod.NO_CYCLE,
				new Stop(0, javafx.scene.paint.Color.PINK), new Stop(1,javafx.scene.paint.Color.PURPLE));
		
		LinearGradient linear2 = new LinearGradient(120,120,600,400,false,CycleMethod.NO_CYCLE,
				new Stop(0, javafx.scene.paint.Color.LIGHTGREEN), new Stop(1,javafx.scene.paint.Color.BLUE));
	
		LinearGradient linear3 = new LinearGradient(120,120,600,650,false,CycleMethod.NO_CYCLE,
				new Stop(0, javafx.scene.paint.Color.YELLOW), new Stop(0.5,javafx.scene.paint.Color.ORANGE),
				new Stop(1,javafx.scene.paint.Color.RED));
		
		txt01.setFill(linear1);
		txt02.setFill(linear1);
		txt03.setFill(linear2);
		txt04.setFill(linear3);
		txt05.setFill(linear3);
		txt06.setFill(linear3);
		txt07.setFill(linear3);
		
		textpane1.getChildren().addAll(txt01,txt02,txt03,txt04,txt05,txt06,txt07, time);
		startBP.setTop(textpane1);
		
		
        
        
        
		VBox vb1 = new VBox(10);
		
		//Enter User Name
		Font font1 = Font.font("Arial", FontWeight.BOLD, 20);
		Font font2 = Font.font("Times New Roman", FontWeight.BOLD, 18);
		Font font3 = Font.font("Arial", FontWeight.BOLD, 18);
		HBox hbForName = new HBox(15);
		hbForName.setAlignment(Pos.CENTER);
		
		Label usrname = new Label("Please Enter Your Full Name :");
		usrname.setFont(font1);
		TextField tfName = new TextField();
		tfName.setAlignment(Pos.CENTER_LEFT);
		
		
		hbForName.getChildren().addAll(usrname, tfName);
		
		
		vb1.getChildren().add(hbForName);
		tfName.setOnAction(n -> {
		
			username = tfName.getText();
			HBox hbForMax = new HBox(10);
			hbForMax.setAlignment(Pos.CENTER);
			Label max = new Label("Enter Maximum Number of Products to Store:");
			max.setFont(font1);
			TextField tfMax = new TextField();
			tfMax.setAlignment(Pos.CENTER_LEFT);
			
			tfName.setEditable(false);
			
			
			hbForMax.getChildren().addAll(max, tfMax);
			vb1.getChildren().add(hbForMax);
			
			tfMax.requestFocus();
			tfMax.selectAll();
			
			tfMax.setOnAction(t-> {
		
				tfMax.setEditable(false);
				//Enter Maximum Product
				String maxProdText = tfMax.getText();
				if (!maxProdText.isEmpty()) {
					try {
						int maxProdValue = Integer.parseInt(maxProdText);
			            
			            if (maxProdValue >= 0) { 
			            	maxProd = Integer.parseInt(maxProdText);
			            	Products = new Product[maxProd];
				    
				
			            	//Add Product (Model)
			            	HBox hbForAddProd = new HBox(10);	
			            	hbForAddProd.setAlignment(Pos.CENTER);
			            	Label AddProd = new Label("Do You Want to Add Any Product?");
			            	AddProd.setFont(font1);
			            	hbForAddProd.getChildren().add(AddProd);
		
		
			            	HBox hbForBt = new HBox(5);
			            	hbForBt.setAlignment(Pos.CENTER);
			            	Button btYes = new Button("YES");
			            	btYes.setFont(font3);
			            	Button btNo = new Button("NO");
			            	btNo.setFont(font3);
			            	hbForBt.getChildren().addAll(btYes, btNo);
		
			            	vb1.getChildren().addAll(hbForAddProd,hbForBt);
		
			            	btYes.setOnAction(e-> primaryStage.setScene(optionScene));
					
					
			            	VBox VBoption = new VBox(20);
			            	BorderPane BPoption = new BorderPane();
			            	BPoption.setStyle("-fx-background:rgb(255,180,252);\n -fx-background-color:rgb(255,180,252)");
			            	
			            	Button btRefri = new Button("1. Refrigerator");
			            	btRefri.setFont(Font.font("Verdana", FontWeight.BOLD,
			            			FontPosture.REGULAR,20));
			            	HBox HBRefri = new HBox(10);
			            	HBRefri.setAlignment(Pos.CENTER);
			            	HBRefri.getChildren().add(btRefri);
				
			            	Button btTV = new Button("2. TV");
			            	btTV.setFont(Font.font("Verdana", FontWeight.BOLD,
			            			FontPosture.REGULAR,20));
			            	HBox HBTV = new HBox(10);
			            	HBTV.setAlignment(Pos.CENTER);
			            	HBTV.getChildren().add(btTV);
			
			            	Button btWasher = new Button("3. Washer");
			            	btWasher.setFont(Font.font("Verdana", FontWeight.BOLD,
			            			FontPosture.REGULAR,20));
			            	HBox HBWasher = new HBox(10);
			            	HBWasher.setAlignment(Pos.CENTER);
			            	HBWasher.getChildren().add(btWasher);
				
			            	Button btAC = new Button("4. Air Conditioner");
			            	btAC.setFont(Font.font("Verdana", FontWeight.BOLD,
			            			FontPosture.REGULAR,20));
			            	HBox HBAC = new HBox(10);
			            	HBAC.setAlignment(Pos.CENTER);
			            	HBAC.getChildren().add(btAC);
			            	
			            	VBoption.getChildren().addAll(HBRefri, HBTV, HBWasher, HBAC);
			            	VBoption.setAlignment(Pos.CENTER);
				
			            	btRefri.setAlignment(Pos.CENTER);
			            	btRefri.setPrefSize(500,65);
			            	btTV.setAlignment(Pos.CENTER);
			            	btTV.setPrefSize(500,65);
			            	btWasher.setAlignment(Pos.CENTER);
			            	btWasher.setPrefSize(500,65);
			            	btAC.setAlignment(Pos.CENTER);
			            	btAC.setPrefSize(500,65);
		
			            	btRefri.setOnAction(R-> primaryStage.setScene(Refrigerator));
			            	btTV.setOnAction(R-> primaryStage.setScene(TV));
			            	btWasher.setOnAction(R-> primaryStage.setScene(Washer));
			            	btAC.setOnAction(R-> primaryStage.setScene(AC));
			            	
			            	BPoption.setCenter(VBoption);
			            	optionScene = new Scene(BPoption,800,800);
			            	
		
		
			            	btNo.setOnAction(e-> primaryStage.setScene(menuScene));
			            }
			            
			            else {
			                //when user enters negative value
			                Alert alert = new Alert(Alert.AlertType.ERROR);
			                alert.setTitle("Input Error");
			                alert.setHeaderText("Invalid Value");
			                alert.setContentText("Only 0 and positive values are acceptable. ");
			                alert.showAndWait();
			                tfMax.clear();
			                tfMax.setEditable(true);
			            }
			        } catch (NumberFormatException e) {
			            //when user enters invalid data type
			            Alert alert = new Alert(Alert.AlertType.ERROR);
			            alert.setTitle("Input Error");
			            alert.setHeaderText("Invalid Data Type");
			            alert.setContentText("Please enter a valid integer number.");
			            alert.showAndWait();
			            tfMax.clear();
			            tfMax.setEditable(true);
			        }
			    } 
				else {
			        //when user do not enter value
			        Alert alert = new Alert(Alert.AlertType.ERROR);
			        alert.setTitle("Input Error");
			        alert.setHeaderText("Empty value");
			        alert.setContentText("Please enter a value.");
			        alert.showAndWait();
			        tfMax.setEditable(true);
				}
			});
		
		});
		startBP.setCenter(vb1);
		startScene = new Scene(startBP, 800, 800);
		
		
		
		//Scene Refrigerator
		VBox VBRefri = new VBox(20);
		HBox hb1 = new HBox(20);
		HBox hb2 = new HBox(20);
		HBox hb3 = new HBox(20);
		HBox hb4 = new HBox(20);
		HBox hb5 = new HBox(20);
		HBox hb6 = new HBox(20);
		HBox hb7 = new HBox(20);
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		TextField tf5 = new TextField();
		TextField tf6 = new TextField();
		TextField tf7 = new TextField();
		Label label1 = new Label("Name: ");
		Label label2 = new Label("Door Design: ");
		Label label3 = new Label("Color: ");
		Label label4 = new Label("Capacity: ");
		Label label5 = new Label("Quantity Available in Stock: ");
		Label label6 = new Label("Price: ");
		Label label7 = new Label("Item Number: ");
		label1.setFont(font3);
		label2.setFont(font3);
		label3.setFont(font3);
		label4.setFont(font3);
		label5.setFont(font3);
		label6.setFont(font3);
		label7.setFont(font3);
		hb1.getChildren().addAll(label1,tf1);
		hb2.getChildren().addAll(label2,tf2);
		hb3.getChildren().addAll(label3,tf3);
		hb4.getChildren().addAll(label4,tf4);
		hb5.getChildren().addAll(label5,tf5);
		hb6.getChildren().addAll(label6,tf6);
		hb7.getChildren().addAll(label7,tf7);
		
		
		Button btRefriDone = new Button("Done");
		btRefriDone.setFont(font3);
		Button btRefriBack = new Button("Back");
		btRefriBack.setFont(font3);
		VBRefri.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,hb6,hb7,btRefriDone,btRefriBack);
		
		tf1.setOnAction(t -> tf2.requestFocus());
		tf2.setOnAction(t -> tf3.requestFocus());
		tf3.setOnAction(t -> tf4.requestFocus());
		tf4.setOnAction(t -> tf5.requestFocus());
		tf5.setOnAction(t -> tf6.requestFocus());
		tf6.setOnAction(t -> tf7.requestFocus());
		tf7.setOnAction(t -> btRefriDone.requestFocus());

		btRefriBack.setOnAction(b-> primaryStage.setScene(optionScene));
		
		btRefriDone.setOnAction(d -> {
		    try {
		        RefriName = tf1.getText();
		        RefriDoor = tf2.getText();
		        RefriColor = tf3.getText();
		        RefriCapacity = Double.parseDouble(tf4.getText());
		        RefriQuantity = Integer.parseInt(tf5.getText());
		        RefriPrice = Double.parseDouble(tf6.getText());
		        RefriNum = Integer.parseInt(tf7.getText());

		        Refrigerator RefriProd = new Refrigerator(RefriNum, RefriName, RefriDoor, RefriColor, RefriCapacity, RefriQuantity, RefriPrice);

		        for (int i = 0; i < Products.length; i++) {
		            if (Products[i] == null) {
		                Products[i] = RefriProd;
		                Products[i].setStatus(true);
		                break;
		            }
		        }
		        count++;

		        Label success1 = new Label("\nRefrigerator product added successfully!");
		        success1.setFont(font2);
		        Label AddMoreRefri = new Label("Do You Want to Add More Product?");
		        AddMoreRefri.setFont(font1);
		        Button btRefriYesDone = new Button("YES");
		        btRefriYesDone.setFont(font3);
		        Button btRefriNoDone = new Button("NO");
		        btRefriNoDone.setFont(font3);

		        VBRefri.getChildren().addAll(success1, AddMoreRefri, btRefriYesDone, btRefriNoDone);

		        btRefriNoDone.setOnAction(n -> primaryStage.setScene(menuScene));

		        btRefriYesDone.setOnAction(y -> {
		        	tf1.clear();
		            tf2.clear();
		            tf3.clear();
		            tf4.clear();
		            tf5.clear();
		            tf6.clear();
		            tf7.clear();
		            VBRefri.getChildren().removeAll(success1, AddMoreRefri, btRefriYesDone, btRefriNoDone);
		            
		            if(count == maxProd) {
		            	Label exceed = new Label("You only can add "+maxProd+" product/s.");
		            	exceed.setFont(font1);
		            	Button btOK = new Button("OK");
		            	btOK.setFont(font3);
		            	VBRefri.getChildren().addAll(exceed,btOK);
		            	
		            	btOK.setOnAction(ok-> primaryStage.setScene(menuScene));
		            }
		            else {
		            	primaryStage.setScene(optionScene);
		            }
		        });

		        

		    } catch (NumberFormatException ex) {
		    	Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setTitle("Input Error");
		        alert.setHeaderText("Invalid input format");
		        alert.setContentText("Please make sure to enter valid numbers for Capacity, Quantity Available in Stock, Price and Item Number.");
		        alert.showAndWait();
		        tf1.clear();
		        tf2.clear();
		        tf3.clear();
		        tf4.clear();
		        tf5.clear();
		        tf6.clear();
		        tf7.clear();
		    }
		});
		Pane RefriPane = new Pane();
		VBRefri.setLayoutX(200);
		VBRefri.setLayoutY(50);
		RefriPane.getChildren().add(VBRefri);
		RefriPane.setStyle("-fx-background:rgb(207,253,188);\n -fx-background-color:rgb(207,253,188)");
		
		Refrigerator = new Scene(RefriPane, 800, 800);
		
		
		
		//Scene TV
		
		VBox VBTV = new VBox(20);
		HBox hb8 = new HBox(20);
		HBox hb9 = new HBox(20);
		HBox hb10 = new HBox(20);
		HBox hb11 = new HBox(20);
		HBox hb12 = new HBox(20);
		HBox hb13 = new HBox(20);
		HBox hb14 = new HBox(20);
		TextField tf8 = new TextField();
		TextField tf9 = new TextField();
		TextField tf10 = new TextField();
		TextField tf11 = new TextField();
		TextField tf12 = new TextField();
		TextField tf13 = new TextField();
		TextField tf14 = new TextField();
		Label label8 = new Label("Name: ");
		Label label9 = new Label("Screen Type: ");
		Label label10 = new Label("Resolution: ");
		Label label11 = new Label("Display Size: ");
		Label label12 = new Label("Quantity Available in Stock: ");
		Label label13 = new Label("Price: ");
		Label label14 = new Label("Item Number: ");
		label8.setFont(font3);
		label9.setFont(font3);
		label10.setFont(font3);
		label11.setFont(font3);
		label12.setFont(font3);
		label13.setFont(font3);
		label14.setFont(font3);
		hb8.getChildren().addAll(label8,tf8);
		hb9.getChildren().addAll(label9,tf9);
		hb10.getChildren().addAll(label10,tf10);
		hb11.getChildren().addAll(label11,tf11);
		hb12.getChildren().addAll(label12,tf12);
		hb13.getChildren().addAll(label13,tf13);
		hb14.getChildren().addAll(label14,tf14);
		
		
		Button btTVDone = new Button("Done");
		btTVDone.setFont(font3);
		Button btTVBack = new Button("Back");
		btTVBack.setFont(font3);
		VBTV.getChildren().addAll(hb8,hb9,hb10,hb11,hb12,hb13,hb14,btTVDone,btTVBack);
		
		tf8.setOnAction(t -> tf9.requestFocus());
		tf9.setOnAction(t -> tf10.requestFocus());
		tf10.setOnAction(t -> tf11.requestFocus());
		tf11.setOnAction(t -> tf12.requestFocus());
		tf12.setOnAction(t -> tf13.requestFocus());
		tf13.setOnAction(t -> tf14.requestFocus());
		tf14.setOnAction(t -> btTVDone.requestFocus());

		btTVBack.setOnAction(b-> primaryStage.setScene(optionScene));
		
		btTVDone.setOnAction(d->{
			try {
				TVName = tf8.getText();
				TVScreen = tf9.getText();
				TVResolution = tf10.getText();
				TVDisplay = Integer.parseInt(tf11.getText());
				TVQuantity = Integer.parseInt(tf12.getText());
				TVPrice = Double.parseDouble(tf13.getText());
				TVNum = Integer.parseInt(tf14.getText());
			
				TV TVProd = new TV(TVNum,TVName,TVScreen,TVResolution,TVDisplay, TVQuantity, TVPrice);
			
				for (int i = 0; i < Products.length; i++) {
	            	if (Products[i] == null) {
	                	Products[i] = TVProd;
		                Products[i].setStatus(true);
	                	break;
	                
	            	}
				}
				count++;
			
				Label success1 = new Label("\nTV product added successfully!");
				success1.setFont(font2);
				Label AddMoreTV = new Label("Do You Want to Add More Product?");			
				AddMoreTV.setFont(font1);
				Button btTVYesDone = new Button("YES");
				btTVYesDone.setFont(font3);
				Button btTVNoDone = new Button("NO");
				btTVNoDone.setFont(font3);
			
				VBTV.getChildren().addAll(success1,AddMoreTV,btTVYesDone,btTVNoDone);
			
				btTVNoDone.setOnAction(n-> primaryStage.setScene(menuScene));

				btTVYesDone.setOnAction(y->{
				
					tf8.clear();
					tf9.clear();
					tf10.clear();
					tf11.clear();
					tf12.clear();
					tf13.clear();
					tf14.clear();
					VBTV.getChildren().remove(AddMoreTV);
					VBTV.getChildren().remove(btTVYesDone);
					VBTV.getChildren().remove(btTVNoDone);
					VBTV.getChildren().remove(success1);
					
					if(count == maxProd) {
		            	Label exceed = new Label("You only can add "+maxProd+" product/s.");
		            	exceed.setFont(font1);
		            	Button btOK = new Button("OK");
		            	btOK.setFont(font3);
		            	VBTV.getChildren().addAll(exceed,btOK);
		            	
		            	btOK.setOnAction(ok-> primaryStage.setScene(menuScene));
		            }
		            else {
		            	primaryStage.setScene(optionScene);
		            }
		    	});
			} catch  (NumberFormatException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setTitle("Input Error");
		        alert.setHeaderText("Invalid input format");
		        alert.setContentText("Please make sure to enter valid numbers for Display Size, Quantity Available in Stock, Price and Item Number.");
		        alert.showAndWait();
		        tf8.clear();
		        tf9.clear();
		        tf10.clear();
		        tf11.clear();
		        tf12.clear();
		        tf13.clear();
		        tf14.clear();
			}
		});
		Pane TVPane = new Pane();
		VBTV.setLayoutX(200);
		VBTV.setLayoutY(50);
		TVPane.getChildren().add(VBTV);
		TVPane.setStyle("-fx-background:rgb(207,253,188);\n -fx-background-color:rgb(207,253,188)");
		TV = new Scene(TVPane,800,800);
		
		
		
		//Scene Washer
		
		VBox VBWasher = new VBox(20);
		HBox hb15 = new HBox(20);
		HBox hb16 = new HBox(20);
		HBox hb17 = new HBox(20);
		HBox hb18 = new HBox(20);
		HBox hb19 = new HBox(20);
		HBox hb20 = new HBox(20);
		HBox hb21 = new HBox(20);
		HBox hb22 = new HBox(20);
		HBox hb23 = new HBox(20);
		TextField tf15 = new TextField();
		TextField tf16 = new TextField();
		TextField tf17 = new TextField();
		TextField tf18 = new TextField();
		TextField tf19 = new TextField();
		TextField tf20 = new TextField();
		TextField tf21 = new TextField();
		TextField tf22 = new TextField();
		TextField tf23 = new TextField();
		Label label15 = new Label("Name: ");
		Label label16 = new Label("Color: ");
		Label label17 = new Label("Height: ");
		Label label18 = new Label("Width: ");
		Label label19 = new Label("Depth: ");
		Label label20 = new Label("Weigth: ");
		Label label21 = new Label("Quantity Available in Stock: ");
		Label label22 = new Label("Price: ");
		Label label23 = new Label("Item Number: ");
		label15.setFont(font3);
		label16.setFont(font3);
		label17.setFont(font3);
		label18.setFont(font3);
		label19.setFont(font3);
		label20.setFont(font3);
		label21.setFont(font3);
		label22.setFont(font3);
		label23.setFont(font3);
		hb15.getChildren().addAll(label15,tf15);
		hb16.getChildren().addAll(label16,tf16);
		hb17.getChildren().addAll(label17,tf17);
		hb18.getChildren().addAll(label18,tf18);
		hb19.getChildren().addAll(label19,tf19);
		hb20.getChildren().addAll(label20,tf20);
		hb21.getChildren().addAll(label21,tf21);
		hb22.getChildren().addAll(label22,tf22);
		hb23.getChildren().addAll(label23,tf23);
		
		Button btWasherDone = new Button("Done");
		btWasherDone.setFont(font3);
		Button btWasherBack = new Button("Back");
		btWasherBack.setFont(font3);
		VBWasher.getChildren().addAll(hb15,hb16,hb17,hb18,hb19,hb20,hb21,hb22,hb23,btWasherDone,btWasherBack);
		
		tf15.setOnAction(t -> tf16.requestFocus());
		tf16.setOnAction(t -> tf17.requestFocus());
		tf17.setOnAction(t -> tf18.requestFocus());
		tf18.setOnAction(t -> tf19.requestFocus());
		tf19.setOnAction(t -> tf20.requestFocus());
		tf20.setOnAction(t -> tf21.requestFocus());
		tf21.setOnAction(t -> tf22.requestFocus());
		tf22.setOnAction(t -> tf23.requestFocus());
		tf23.setOnAction(t -> btWasherDone.requestFocus());
		
		btWasherBack.setOnAction(b-> primaryStage.setScene(optionScene));
		
		btWasherDone.setOnAction(d->{
			try {
				WasherName = tf15.getText();
				WasherColor = tf16.getText();
				WasherHeight = Double.parseDouble(tf17.getText());
				WasherWidth = Double.parseDouble(tf18.getText());
				WasherDepth = Double.parseDouble(tf19.getText());
				WasherWeight = Double.parseDouble(tf20.getText());
				WasherQuantity = Integer.parseInt(tf21.getText());
				WasherPrice = Double.parseDouble(tf22.getText());
				WasherNum = Integer.parseInt(tf23.getText());
				
				Washer WasherProd = new Washer(WasherNum,WasherName,WasherHeight,WasherWidth,WasherDepth,WasherWeight,WasherColor,WasherQuantity,WasherPrice);
			
				for (int i = 0; i < Products.length; i++) {
					if (Products[i] == null) {
						Products[i] = WasherProd;
		                Products[i].setStatus(true);
						break;
	                
					}
				}
				count++;
				
				Label success1 = new Label("\nWasher product added successfully!");
				success1.setFont(font2);
				Label AddMoreWasher = new Label("Do You Want to Add More Product?");			
				AddMoreWasher.setFont(font1);
				Button btWasherYesDone = new Button("YES");
				btWasherYesDone.setFont(font3);
				Button btWasherNoDone = new Button("NO");
				btWasherNoDone.setFont(font3);
			
				VBWasher.getChildren().addAll(success1,AddMoreWasher,btWasherYesDone,btWasherNoDone);
			
				btWasherNoDone.setOnAction(n-> primaryStage.setScene(menuScene));
			
				btWasherYesDone.setOnAction(y->{
				
					tf15.clear();
					tf16.clear();
					tf17.clear();
					tf18.clear();
					tf19.clear();
					tf20.clear();
					tf21.clear();
					tf22.clear();
					tf23.clear();
					VBWasher.getChildren().remove(AddMoreWasher);
					VBWasher.getChildren().remove(btWasherYesDone);
					VBWasher.getChildren().remove(btWasherNoDone);
					VBWasher.getChildren().remove(success1);
				
					if(count == maxProd) {
		            	Label exceed = new Label("You only can add "+maxProd+" product/s.");
		            	exceed.setFont(font1);
		            	Button btOK = new Button("OK");
		            	btOK.setFont(font3);
		            	VBWasher.getChildren().addAll(exceed,btOK);
		            	
		            	btOK.setOnAction(ok-> primaryStage.setScene(menuScene));
		            }
		            else {
		            	primaryStage.setScene(optionScene);
		            }
				});
				
			} catch (NumberFormatException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setTitle("Input Error");
		        alert.setHeaderText("Invalid input format");
		        alert.setContentText("Please make sure to enter valid numbers for Height, Width, Depth, Weight, Quantity Available in Stock, Price and Item Number.");
		        alert.showAndWait();
		        tf15.clear();
		        tf16.clear();
		        tf17.clear();
		        tf18.clear();
		        tf19.clear();
		        tf20.clear();
		        tf21.clear();
		        tf22.clear();
		        tf23.clear();
			}
	
		});
		Pane WasherPane = new Pane();
		VBWasher.setLayoutX(200);
		VBWasher.setLayoutY(50);
		WasherPane.getChildren().add(VBWasher);
		WasherPane.setStyle("-fx-background:rgb(207,253,188);\n -fx-background-color:rgb(207,253,188)");
		Washer = new Scene(WasherPane,800,800);
		
		//Scene AC
		
		VBox VBAC = new VBox(20);
		HBox hb24 = new HBox(20);
		HBox hb25 = new HBox(20);
		HBox hb26 = new HBox(20);
		HBox hb27 = new HBox(20);
		HBox hb28 = new HBox(20);
		HBox hb29 = new HBox(20);
		HBox hb30 = new HBox(20);
		HBox hb31 = new HBox(20);
		HBox hb32 = new HBox(20);
		TextField tf24 = new TextField();
		TextField tf25 = new TextField();
		TextField tf26 = new TextField();
		TextField tf27 = new TextField();
		TextField tf28 = new TextField();
		TextField tf29 = new TextField();
		TextField tf30 = new TextField();
		TextField tf31 = new TextField();
		TextField tf32 = new TextField();
		Label label24 = new Label("Name: ");
		Label label25 = new Label("Type: ");
		Label label26 = new Label("Horse Power: ");
		Label label27 = new Label("Noise Level: ");
		Label label28 = new Label("Weight: ");
		Label label29 = new Label("Warranty: ");
		Label label30 = new Label("Quantity Available in Stock: ");
		Label label31 = new Label("Price: ");
		Label label32 = new Label("Item Number: ");
		label24.setFont(font3);
		label25.setFont(font3);
		label26.setFont(font3);
		label27.setFont(font3);
		label28.setFont(font3);
		label29.setFont(font3);
		label30.setFont(font3);
		label31.setFont(font3);
		label32.setFont(font3);
		hb24.getChildren().addAll(label24,tf24);
		hb25.getChildren().addAll(label25,tf25);
		hb26.getChildren().addAll(label26,tf26);
		hb27.getChildren().addAll(label27,tf27);
		hb28.getChildren().addAll(label28,tf28);
		hb29.getChildren().addAll(label29,tf29);
		hb30.getChildren().addAll(label30,tf30);
		hb31.getChildren().addAll(label31,tf31);
		hb32.getChildren().addAll(label32,tf32);

		Button btACDone = new Button("Done");
		btACDone.setFont(font3);
		Button btACBack = new Button("Back");
		btACBack.setFont(font3);
		VBAC.getChildren().addAll(hb24,hb25,hb26,hb27,hb28,hb29,hb30,hb31,hb32,btACDone,btACBack);
		
		tf24.setOnAction(t -> tf25.requestFocus());
		tf25.setOnAction(t -> tf26.requestFocus());
		tf26.setOnAction(t -> tf27.requestFocus());
		tf27.setOnAction(t -> tf28.requestFocus());
		tf28.setOnAction(t -> tf29.requestFocus());
		tf29.setOnAction(t -> tf30.requestFocus());
		tf30.setOnAction(t -> tf31.requestFocus());
		tf31.setOnAction(t -> tf32.requestFocus());
		tf32.setOnAction(t -> btWasherDone.requestFocus());	
		
		btACBack.setOnAction(b-> primaryStage.setScene(optionScene));
		
		btACDone.setOnAction(d->{
			try {
				ACName = tf24.getText();
				ACType = tf25.getText();
				ACHorsePower = Double.parseDouble(tf26.getText());
				ACNoiseLevel = Double.parseDouble(tf27.getText());
				ACWeight = Double.parseDouble(tf28.getText());
				ACWarranty = Integer.parseInt(tf29.getText());
				ACQuantity = Integer.parseInt(tf30.getText());
				ACPrice = Double.parseDouble(tf31.getText());
				ACNum = Integer.parseInt(tf32.getText());
				
				AirConditioner ACProd = new AirConditioner(ACNum,ACName,ACType,ACHorsePower,ACNoiseLevel,ACWeight,ACWarranty,ACQuantity, ACPrice);
			
				for (int i = 0; i < Products.length; i++) {
					if (Products[i] == null) {
						Products[i] = ACProd;
		                Products[i].setStatus(true);
						break;
	                
					}
				}
				count++;
			
				Label success1 = new Label("\nAir Conditioner product added successfully!");
				success1.setFont(font2);
				Label AddMoreAC = new Label("Do You Want to Add More Product?");			
				AddMoreAC.setFont(font1);
			
				Button btACYesDone = new Button("YES");
				btACYesDone.setFont(font3);
				Button btACNoDone = new Button("NO");
				btACNoDone.setFont(font3);
			
				VBAC.getChildren().addAll(success1,AddMoreAC,btACYesDone,btACNoDone);
			
				btACNoDone.setOnAction(n-> primaryStage.setScene(menuScene));

				btACYesDone.setOnAction(y->{
				
					tf24.clear();
					tf25.clear();
					tf26.clear();
					tf27.clear();
					tf28.clear();
					tf29.clear();
					tf30.clear();
					tf31.clear();
					tf32.clear();
					VBAC.getChildren().remove(AddMoreAC);
					VBAC.getChildren().remove(btACYesDone);
					VBAC.getChildren().remove(btACNoDone);
					VBAC.getChildren().remove(success1);
				
					if(count == maxProd) {
		            	Label exceed = new Label("You only can add "+maxProd+" product/s.");
		            	exceed.setFont(font1);
		            	Button btOK = new Button("OK");
		            	btOK.setFont(font3);
		            	VBAC.getChildren().addAll(exceed,btOK);
		            	
		            	btOK.setOnAction(ok-> primaryStage.setScene(menuScene));
		            }
		            else {
		            	primaryStage.setScene(optionScene);
		            }
				});
				
			} catch (NumberFormatException ex) {
		    	Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setTitle("Input Error");
		        alert.setHeaderText("Invalid input format");
		        alert.setContentText("Please make sure to enter valid numbers for Type, Horse Power, Noise Level, Weight, Warranty, Quantity Available in Stock, Price and Item Number.");
		        alert.showAndWait();
		        tf24.clear();
		        tf25.clear();
		        tf26.clear();
		        tf27.clear();
		        tf28.clear();
		        tf29.clear();
		        tf30.clear();
		        tf31.clear();
		        tf32.clear();
			}
			
		});
		Pane ACPane = new Pane();
		VBAC.setLayoutX(200);
		VBAC.setLayoutY(50);
		ACPane.getChildren().add(VBAC);
		ACPane.setStyle("-fx-background:rgb(207,253,188);\n -fx-background-color:rgb(207,253,188)");
		AC = new Scene(ACPane,800,800);
		
		
		
		
		
		//Scene Menu
		BorderPane menuBP = new BorderPane();
		menuBP.setStyle("-fx-background:rgb(208,239,255);\n -fx-background-color:rgb(208,239,255)");
		Pane textpane = new Pane();
		
		Text txt1 = new Text(65,130,"SMS");
		txt1.setFont(Font.font("Elephant", FontWeight.EXTRA_BOLD,
				 FontPosture.REGULAR, 150));
		
		Text txt2 = new Text(367,180,"MENU");
		txt2.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD,
				 FontPosture.REGULAR, 50));
	
		Text time1 = new Text(225,205,currentDate + " " + currentTime.format(formatter));
		time1.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.ITALIC,18));
		time1.setFill(Color.CORNFLOWERBLUE);
		
		//Group Member
		Text txt3 = new Text(225,250,"Dickson Shee Wei Hau");
		txt3.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		Text txt4 = new Text(280,280,"Khew Sei Fong");
		txt4.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		Text txt5 = new Text(290,310,"Lip Zhen Yi");
		txt5.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		Text txt6 = new Text(275,340,"Tham Yik Siong");
		txt6.setFont(Font.font("Monospaced", FontWeight.BOLD,
				 FontPosture.REGULAR, 30));
		
		
		txt1.setFill(linear2);
		txt2.setFill(linear1);
		txt3.setFill(linear3);
		txt4.setFill(linear3);
		txt5.setFill(linear3);
		txt6.setFill(linear3);
		
		textpane.getChildren().addAll(txt1,txt2,time1,txt3,txt4,txt5,txt6);
		menuBP.setTop(textpane);
		
		Button btViewProduct = new Button("View Product");
		btViewProduct.setFont(Font.font("Verdana", FontWeight.BOLD,
				FontPosture.REGULAR,20));
		Button btAddStock = new Button("Add Product");
		btAddStock.setFont(Font.font("Verdana", FontWeight.BOLD,
				FontPosture.REGULAR,20));
		Button btDeductStock = new Button("Deduct Product");
		btDeductStock.setFont(Font.font("Verdana", FontWeight.BOLD,
				FontPosture.REGULAR,20));
		Button btDiscontinueProduct = new Button("Discontinue Product");
		btDiscontinueProduct.setFont(Font.font("Verdana", FontWeight.BOLD,
				FontPosture.REGULAR,20));
		Button btExit = new Button("Exit");
		btExit.setFont(Font.font("Verdana", FontWeight.BOLD,
				FontPosture.REGULAR,20));
		
		btViewProduct.setPrefSize(500,65);
		btAddStock.setPrefSize(500,65);
		btDeductStock.setPrefSize(500,65);
		btDiscontinueProduct.setPrefSize(500,65);
		btExit.setPrefSize(500,65);
		
		
		
		
		VBox content1 = new VBox();
		VBox content2 = new VBox();
		VBox content3 = new VBox();
		VBox content4 = new VBox();
		ScrollPane scrollPane1 = new ScrollPane();
		scrollPane1.setPrefSize(600,400);
		scrollPane1.setStyle("-fx-background:rgb(198,230,251);\n -fx-background-color:rgb(198,230,251)");
		ScrollPane scrollPane2 = new ScrollPane();
		scrollPane2.setPrefSize(700,300);
		scrollPane2.setStyle("-fx-background:rgb(198,230,251);\n -fx-background-color:rgb(198,230,251)");
		ScrollPane scrollPane3 = new ScrollPane();
		scrollPane3.setPrefSize(700,350);
		scrollPane3.setStyle("-fx-background:rgb(198,230,251);\n -fx-background-color:rgb(198,230,251)");
		ScrollPane scrollPane4 = new ScrollPane();
		scrollPane4.setPrefSize(700,350);
		scrollPane4.setStyle("-fx-background:rgb(198,230,251);\n -fx-background-color:rgb(198,230,251)");
		
		
		
		btViewProduct.setOnAction(e-> {
			
			content1.getChildren().clear();
			
			for (Product product : Products) {
				if(product != null) {
					Label productLabel = new Label(product+"\n");
					productLabel.setFont(font2);
					content1.getChildren().add(productLabel);
				}
			}
			scrollPane1.setContent(content1);
			
			primaryStage.setScene(SceneViewProduct);
			primaryStage.setTitle("View Product");
		});
		
		btAddStock.setOnAction(e-> {
			
			content2.getChildren().clear();
			
			for (Product product : Products) {
				if(product != null) {
					Label productLabel = new Label(product+"\n");
					productLabel.setFont(font2);
					content2.getChildren().add(productLabel);
				}
			}
			scrollPane2.setContent(content2);
			
			primaryStage.setScene(SceneAddStock);
			primaryStage.setTitle("Add Stock");
		});

		btDeductStock.setOnAction(e-> {
			
			content3.getChildren().clear();
			
			for (Product product : Products) {
				if(product != null) {
					Label productLabel = new Label(product+"\n");
					productLabel.setFont(font2);
					content3.getChildren().add(productLabel);
				}
			}
			scrollPane3.setContent(content3);
			
			primaryStage.setScene(SceneDeductStock);
			primaryStage.setTitle("Deduct Stock");
			
		});

		btDiscontinueProduct.setOnAction(e-> {
			
			content4.getChildren().clear();
			
			for (Product product : Products) {
				if(product != null) {
					Label productLabel = new Label(product+"\n");
					productLabel.setFont(font2);
					content4.getChildren().add(productLabel);
				}
			}
			scrollPane4.setContent(content4);
			
			primaryStage.setScene(SceneDiscontinueProduct);
			primaryStage.setTitle("Discontinue Product");
			
		});
		
		btExit.setOnAction(e-> {

			
			userInfo.setName(username);
			userInfo.setUserID();
			
			
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);

			
			alert.setTitle("User Info");
			alert.setHeaderText("User ID: "+userInfo.getUserID()+"\n"+"User Name: "+userInfo.getName());
			alert.setContentText("Thank You For Using");
			alert.showAndWait();
			Platform.exit();
		});
		
		
		
		
		//Scene of View Products
		
		Button btBack1 = new Button("Back");
		btBack1.setFont(font3);
		
		BorderPane viewProd = new BorderPane();
		viewProd.setStyle("-fx-background:rgb(173,216,230);\n -fx-background-color:rgb(173,216,230)");
		Pane viewPane = new Pane();
		scrollPane1.setLayoutX(100);
		scrollPane1.setLayoutY(50);
		viewPane.getChildren().add(scrollPane1);
		
		viewProd.setCenter(viewPane);
		viewProd.setBottom(btBack1);
		viewProd.setAlignment(btBack1,Pos.BOTTOM_CENTER);
		
		
		btBack1.setOnAction(e-> {
	
			content1.getChildren().clear();
			
			primaryStage.setScene(menuScene);
			primaryStage.setTitle("Menu");
		
		});
		SceneViewProduct = new Scene(viewProd, 800, 800);

		
		
		//Scene of Add Products
		Button btBack2 = new Button("Back");
		btBack2.setFont(font3);
		
		Label addItemNum = new Label("Select Item Number To Add Stock :");
		addItemNum.setFont(font1);
		TextField tfAddItem = new TextField();
		
		Label addQuantity = new Label("Enter Quantity to Add :");
		addQuantity.setFont(font1);
		TextField tfQuantityToAdd = new TextField();
		
		Pane addPane = new Pane();
		scrollPane2.setLayoutX(50);
		scrollPane2.setLayoutY(50);
		addPane.getChildren().add(scrollPane2);
		
		Label addSuccess = new Label();
		addSuccess.setFont(font2);
		Label notFound1 = new Label();
        notFound1.setFont(font2);
		
		HBox HBaddItem = new HBox(15);
		HBaddItem.getChildren().addAll(addItemNum,tfAddItem);
		
		HBox HBAddQuantityItem = new HBox(15);
		HBAddQuantityItem.getChildren().addAll(addQuantity,tfQuantityToAdd);
		
		VBox VBaddItem = new VBox();
		VBaddItem.getChildren().addAll(addPane,HBaddItem,notFound1,HBAddQuantityItem,addSuccess);
		
		BorderPane addStock = new BorderPane();
		addStock.setStyle("-fx-background:rgb(173,216,230);\n -fx-background-color:rgb(173,216,230)");
		addStock.setCenter(VBaddItem);
		addStock.setBottom(btBack2);
		addStock.setAlignment(btBack2, Pos.BOTTOM_CENTER);
		
		
		
		
		
		tfAddItem.setOnAction(add->{
			
			selectItemNum = Integer.parseInt(tfAddItem.getText());
			
			
			

			tfQuantityToAdd.requestFocus();

			
			tfQuantityToAdd.setOnAction(success->{
				
				quantityToAdd = Integer.parseInt(tfQuantityToAdd.getText());
				
	    	    for (Product product : Products) {
	    	        if (product != null && product.getItemNumber() == selectItemNum) {
	    	            selectedProduct = product;
	    	            break;
	    	        }
	    	    }

	    	    if (selectedProduct == null) {
	    	        notFound1.setText("Product with item number " + selectItemNum  + " not found.");
	    	        
	    	        return;
	    	    }
	    	    
	    	    else {
	    	    	selectedProduct.addQuantity(quantityToAdd);
	    	    	addSuccess.setText("Stock Added Successfully!");
	    	    }
				
				
				
				
				
				content2.getChildren().clear();
				for (Product product : Products) {
					if (product != null) {
						Label productLabel = new Label(product+"\n");
						productLabel.setFont(font2);
						content2.getChildren().add(productLabel);
				    }
				}
				scrollPane2.setContent(content2);
			});
		});
		btBack2.setOnAction(e-> {
			
			content2.getChildren().clear();
			tfAddItem.clear();
			tfQuantityToAdd.clear();
			addSuccess.setText("");
			notFound1.setText(" ");
			
			primaryStage.setScene(menuScene);
			primaryStage.setTitle("Menu");
		});

		
		SceneAddStock = new Scene(addStock, 800, 800);
		
		
		
		
		
		//Scene of Deduct Products
		Button btBack3 = new Button("Back");
		btBack3.setFont(font3);
		
	
				
		Label deductItemNum = new Label("Select Item Number To Deduct Stock :");
		deductItemNum.setFont(font1);
		TextField tfDeductItem = new TextField();
		
		Label deductQuantity = new Label("Enter Quantity to Deduct :");
		deductQuantity.setFont(font1);
		TextField tfQuantityToDeduct = new TextField();
		
		Pane deductPane = new Pane();
		scrollPane3.setLayoutX(50);
		scrollPane3.setLayoutY(50);
		deductPane.getChildren().add(scrollPane3);
		
		HBox HBdeductItem = new HBox(15);
		HBdeductItem.getChildren().addAll(deductItemNum,tfDeductItem);
		
		HBox HBDeductQuantityItem = new HBox(15);
		HBDeductQuantityItem.getChildren().addAll(deductQuantity,tfQuantityToDeduct);
		
		Label availQuantity = new Label();
		Label notFound2 = new Label();
		notFound2.setFont(font2);
		Label error = new Label();
        error.setFont(font2);
        Label deductSuccess = new Label();
		deductSuccess.setFont(font2);
		
		VBox VBdeductItem = new VBox();
		VBdeductItem.getChildren().addAll(deductPane,HBdeductItem,notFound2,availQuantity,
				HBDeductQuantityItem,error,deductSuccess);
		
		
		BorderPane deductStock = new BorderPane();
		deductStock.setStyle("-fx-background:rgb(173,216,230);\n -fx-background-color:rgb(173,216,230)");
		deductStock.setCenter(VBdeductItem);
		deductStock.setBottom(btBack3);
		deductStock.setAlignment(btBack3,Pos.BOTTOM_CENTER);
		
		
		
		
		
		
		tfDeductItem.setOnAction(add->{
			
			selectItemNum = Integer.parseInt(tfDeductItem.getText());
			
    	    for (Product product : Products) {
    	        if (product != null && product.getItemNumber() == selectItemNum) {
    	            selectedProduct = product;
    	            break;
    	        }
    	    }

    	    if (selectedProduct == null) {
    	        notFound2.setText("Product with item number " + selectItemNum  + " not found.");
    	        
    	        
    	        return;
    	    }
    	    
    	    availQuantity.setText("Available Quantity for "+selectedProduct.getName()+
    	    		": "+selectedProduct.getQuantity());
    	    availQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC,20));
			
			
			String quantityToDeductText = tfQuantityToDeduct.getText();
			
			if (!quantityToDeductText.isEmpty()) {
			    quantityToDeduct = Integer.parseInt(quantityToDeductText);
			    
			} else {
			    // Handle the case where the text field is empty
			    // You might display an error message or prompt the user to enter a value
			}
			
			
			//VBdeductItem.getChildren().addAll(HBquantityItem);
			tfQuantityToDeduct.requestFocus();
		
			tfQuantityToDeduct.setOnAction(success->{
				
				int quantityToDeduct = Integer.parseInt(tfQuantityToDeduct.getText());
			    if (quantityToDeduct <= 0) {
			    	Alert alert = new Alert(Alert.AlertType.ERROR);
			        alert.setTitle("Input Error");
			        alert.setHeaderText("Invalid Value");
			        alert.setContentText("Please enter a positive number.");
			        alert.showAndWait();
			        tfQuantityToDeduct.clear();
			    }
				else {
			        int availableQuantity = 0;
			        Product selectedDeductProduct = null;
			        for (Product product : Products) {
			            if (product != null && product.getItemNumber() == selectItemNum) {
			                
			            	selectedDeductProduct = product;
			            	availableQuantity = product.getQuantity();
			                break;
			            }
			        }
			        
			        if (quantityToDeduct > availableQuantity) {
			            error.setText("Insufficient Stock.");
			            
			            
			        }
			        else {
			        	selectedDeductProduct.deductQuantity(quantityToDeduct);
			        	deductSuccess.setText("Stock Deducted Successfully!");
			        	
			        	
			        }
			    }
			    content3.getChildren().clear();
				for (Product product : Products) {
					if (product != null) {
						Label productLabel = new Label(product+"\n");
						productLabel.setFont(font2);
						content3.getChildren().add(productLabel);
				    }
				}
				scrollPane3.setContent(content3);
			});
		});

				
				
			
		btBack3.setOnAction(e-> {
			
			content3.getChildren().clear();
			tfDeductItem.clear();
			tfQuantityToDeduct.clear();
			deductSuccess.setText(" ");
			availQuantity.setText(" ");
			notFound2.setText(" ");
			error.setText(" ");
			deductSuccess.setText(" ");
			
			
			primaryStage.setScene(menuScene);
		});

		deductStock.setAlignment(btBack3, Pos.BOTTOM_CENTER);
		SceneDeductStock = new Scene(deductStock, 800, 800);
		
		
		
		
		
		//Scene of Discontinue Products
		Button btBack4 = new Button("Back");
		btBack4.setFont(font3);
		
		btBack4.setOnAction(e-> primaryStage.setScene(menuScene));
				
		Label discontinueItemNum = new Label("Select Item Number To Discontinue :");
		discontinueItemNum.setFont(font1);
		TextField tfDiscontinueItem = new TextField();
		
		
		Pane discontinuePane = new Pane();
		scrollPane4.setLayoutX(100);
		scrollPane4.setLayoutY(50);
		discontinuePane.getChildren().add(scrollPane4);
	
		Label notFound3 = new Label();
        notFound3.setFont(font2);
        Label discontinueSuccess = new Label();
    	discontinueSuccess.setFont(font2);
		
		HBox HBdiscontinueItem = new HBox(15);
		HBdiscontinueItem.getChildren().addAll(discontinueItemNum,tfDiscontinueItem);
		
		VBox VBdiscontinueItem = new VBox();
		VBdiscontinueItem.getChildren().addAll(discontinuePane,HBdiscontinueItem,notFound3,discontinueSuccess);
		
		BorderPane discontinueProd = new BorderPane();
		discontinueProd.setStyle("-fx-background:rgb(173,216,230);\n -fx-background-color:rgb(173,216,230)");
		discontinueProd.setCenter(VBdiscontinueItem);
		discontinueProd.setBottom(btBack4);
		discontinueProd.setAlignment(btBack4,Pos.BOTTOM_CENTER);
		
		tfDiscontinueItem.setOnAction(add->{
			
			selectItemNum = Integer.parseInt(tfDiscontinueItem.getText());
			
			
			for (Product product : Products) {
    	        if (product != null && product.getItemNumber() == selectItemNum) {
    	            selectedProduct = product;
    	            selectedProduct.setStatus(false);
    	            break;
    	        }
    	    }

    	    if (selectedProduct == null) {
    	        notFound3.setText("Product with item number " + selectItemNum  + " not found.");
    	        
    	        return;
    	    }
    	    
    	    else {
    	    
    	    	discontinueSuccess.setText("Stock Discontinued Successfully!");
    	    	
    	    }
			
			
			content4.getChildren().clear();
			for (Product product : Products) {
				if (product != null) {
					Label productLabel = new Label(product+"\n");
					productLabel.setFont(font2);
					content4.getChildren().add(productLabel);
			    }
			}
			scrollPane4.setContent(content4);
		});
		
	
		btBack4.setOnAction(e-> {
		
			content4.getChildren().clear();
			tfDiscontinueItem.clear();
			notFound3.setText(" ");
			discontinueSuccess.setText("");
		
			primaryStage.setScene(menuScene);
		});
		
		discontinueProd.setAlignment(btBack4, Pos.BOTTOM_CENTER);
		SceneDiscontinueProduct = new Scene(discontinueProd, 800, 800);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(15));
		vb.setCenterShape(true);
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(btViewProduct, btAddStock, 
				btDeductStock, btDiscontinueProduct, btExit);
		
		menuBP.setCenter(vb);
		
		menuScene = new Scene(menuBP, 800, 800);
		
		primaryStage.setScene(startScene);
		primaryStage.setTitle("SMS");
		primaryStage.show();
		
		
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}