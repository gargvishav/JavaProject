package attendence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application 
{
	
	
 public void start(Stage primaryStage) 
   {
		try {
				Parent root=(Parent)FXMLLoader.load(getClass().getResource("AttendenceView.fxml")); 
				
				Scene scene = new Scene(root,700,550);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				

		    } 
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}
 

 
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}




