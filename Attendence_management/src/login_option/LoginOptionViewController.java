package login_option;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginOptionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label txtlabel;


    @FXML
    void doS_login(ActionEvent event) {
    	
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/student_login/S_loginView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
			Scene scene1=(Scene)txtlabel.getScene();
			scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	
    	

    }

    @FXML
    void doT_login(ActionEvent event) {
    	
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/teacher_login/T_loginView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
			Scene scene1=(Scene)txtlabel.getScene();
			scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	

    }

    @FXML
    void initialize() {

    }

}
