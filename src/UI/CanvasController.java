/***
 * @Author	 : Jaya Madhav, Sajith Kumar,Shiva Dhanush
 * File name : CanvasController
 * File Type : Java
 * 
 * This file is the controller for the UI module
 * The UI Package is imported into the controller
 * The functions in classes of UI package can now be used here.
 * Add all your created classes in UI package and use the functions in them here.
 * Do not make changes to the already existing code.
 * Import all the necessary javafx packages, if required.
 ***/
package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class CanvasController implements Initializable {
	
	/***
	 * Declare and use all the javafx components and events here.
	 * sendButton is the id of 'SEND' button in Chatbox
	 * sendMessage is the id of text entered in the text area of Chatbox
	 * chatDisplayBox is the id of the component which displays the Chatbox
	 ***/
	/**
	    * ComboBox below has a list of values for dropdown in brushSize.
	    */
	@FXML
	public ComboBox<Integer> brushSize;
	ObservableList<Integer> list = FXCollections.observableArrayList(2,4,6,8);
	@FXML
	private Button eraser;
	@FXML
	private Button brush;
	@FXML
	private Button cursor;
	@FXML
	private Button undo;
	@FXML
	private Button redo;
	
	@FXML
	private Button sendButton;
	
	@FXML
	private TextArea sendMessage;
	
	@FXML
	private VBox chatDisplayBox;
	
	@FXML
	private ScrollPane chatScroll;
	
    @FXML
    private Button line,rect,square,triangle,circle,oval;
    
	@FXML
	private Canvas canvasF,canvasB;
	
    @FXML
    private ColorPicker colorpicker;
	
    GraphicsContext gcF,gcB;
    double x1,y1,x2,y2,x3,y3;
    Color color;
    /***
	 * Javafx event handling the changes after clicking the brush,cursor, eraser ,undo and redo buttons.
	 * function for handling brushSize dropdown
	 ***/
    @FXML
	public void eraserClicked(ActionEvent e ) {
		
	}
    @FXML
   	public void cursorClicked(ActionEvent e ) {
   		
   	}
    @FXML
   	public void undoClicked(ActionEvent e ) {
   		
   	}
    @FXML
   	public void redoClicked(ActionEvent e ) {
   		
   	}
    
    @FXML
   	public void brushClicked(ActionEvent e ) {
   		
   	}
    @FXML
   	public void brushSizeChanged(ActionEvent e ) {
   		
   	}
    
	
	/***
	 * Javafx event handling the changes after clicking the 'SEND' button in the ChatBox.
	 ***/
	
	@FXML
	public void sendButtonClicked(ActionEvent e ) {
		
		String message = sendMessage.getText();
		Chatbox.buttonClick(e,message,chatDisplayBox,chatScroll);
		sendMessage.setText(null);
	}
	
	public void setStartPoint(double d, double e) {
        x1 = (d);
        y1 = (e);	
    }

    public void setEndPoint(double d, double e) {
        x2 = (d);
        y2 = (e);
    }
	
    @FXML
    void circleSelected(ActionEvent event) {
    	Shapes.defaultSelected(); 
    	Shapes.circleselected = true;
    }

    @FXML
    void lineSelected(ActionEvent event) {
    	Shapes.defaultSelected(); 
    	Shapes.lineselected = true;
    }

    @FXML
    void ovalSelected(ActionEvent event) {
    	Shapes.defaultSelected(); 
    	Shapes.ovalselected = true;
    }

    @FXML
    void rectSelected(ActionEvent event) {
    	Shapes.defaultSelected(); 
    	Shapes.rectselected = true;
    }

    @FXML
    void squareSelected(ActionEvent event) {
    	Shapes.defaultSelected(); 
    	Shapes.squareselected = true;
    }

    @FXML
    void triangleSelected(ActionEvent event) {
    	Shapes.defaultSelected(); 
    	Shapes.triangleselected = true;
    }
    
    @FXML
    void mousePressed(MouseEvent e) {
    	setStartPoint(e.getX(), e.getY());
    }

    @FXML
    void mouseReleased(MouseEvent e) {
    	gcF = canvasF.getGraphicsContext2D();
    	setEndPoint(e.getX(), e.getY());
    	color = colorpicker.getValue();
		if(Shapes.rectselected) {
			Shapes.drawPerfectRect(color,gcF,x1, y1, x2, y2);
		}
		if(Shapes.circleselected) {
			Shapes.drawPerfectCircle(color,gcF,x1, y1, x2, y2);
		}
		if(Shapes.lineselected) {
			Shapes.drawPerfectLine(color,gcF,x1, y1, x2, y2);
		}
		if(Shapes.ovalselected) {
			Shapes.drawPerfectOval(color,gcF,x1, y1, x2, y2);
		}
		if(Shapes.triangleselected) {
			Shapes.drawPerfectTriangle(color,gcF,x1, y1, x2, y2);
		}
		if(Shapes.squareselected) {
			Shapes.drawPerfectSquare(color,gcF,x1, y1, x2, y2);
		}
    }
    
    @FXML
    void mouseDragged(MouseEvent e) {
    	gcB = canvasB.getGraphicsContext2D();
    	double x3=e.getX();
    	double y3=e.getY();
    	color = colorpicker.getValue();
		if(Shapes.rectselected) {
			Shapes.drawPerfectRectEffect(canvasB,color,gcB,x1, y1, x3, y3);
		}
		if(Shapes.circleselected) {
			Shapes.drawPerfectCircleEffect(canvasB,color,gcB,x1, y1, x3, y3);
		}
		if(Shapes.lineselected) {
			Shapes.drawPerfectLineEffect(canvasB,color,gcB,x1, y1, x3, y3);
		}
		if(Shapes.ovalselected) {
			Shapes.drawPerfectOvalEffect(canvasB,color,gcB,x1, y1, x3, y3);
		}
		if(Shapes.triangleselected) {
			Shapes.drawPerfectTriangleEffect(canvasB,color,gcB,x1, y1, x3, y3);
		}
		if(Shapes.squareselected) {
			Shapes.drawPerfectSquareEffect(canvasB,color,gcB,x1, y1, x3, y3);
		}
    }
    /***
	 * The following code initializes the dropdown of brushSize.
	 ***/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		brushSize.setItems(list);
		// TODO Auto-generated method stub
		
	}
	
	/***
	 * This is the method to load the javafx file and display it.
	 ***/
/*	@Override
	public void start(Stage primaryStage){
		try {
			
				Parent root = FXMLLoader.load(getClass().getResource("canvas.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setTitle("Whiteboard Application"); //setting the title of the application
				primaryStage.setScene(scene);
				primaryStage.show(); //displaying the user page to draw on the canvas and message using Chatbox

			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}          */
		

}
