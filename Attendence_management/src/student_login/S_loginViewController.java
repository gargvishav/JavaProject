package student_login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class S_loginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNamee;

    @FXML
    private TextField txtPasswordd;
    
    @FXML
    private Label wLogin;

    @FXML
    void doLogin(ActionEvent event) {
    	
    	if(txtNamee.getText().toString().equals("student") && txtPasswordd.getText().toString().equals("123")) 
    	{
    		
    		wLogin.setText("Success!");

    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/student/StudentView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
			Scene scene1=(Scene)txtNamee.getScene();
			scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	
    	}
    	
    	 else if(txtNamee.getText().isEmpty() && txtPasswordd.getText().isEmpty()) {
    		 wLogin.setText("Please enter your data..");
         }

    	
    	else
    	{
    		wLogin.setText("Wrong username or password!");
    	}

    }

    

    @FXML
    void initialize() {
        
    }

}
