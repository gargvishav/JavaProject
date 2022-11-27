package teacher_login;

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

public class T_loginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtUsername;

    @FXML
    private Label wrgLogin;

    @FXML
    void doLogin(ActionEvent event) {
    	
    	if(txtUsername.getText().toString().equals("nitin.varyani") && txtPass.getText().toString().equals("123")) 
    	{
    		
    		wrgLogin.setText("Success!");

    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/attendence/AttendenceView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
			Scene scene1=(Scene)txtUsername.getScene();
			scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	
    	}
    	
    	 else if(txtUsername.getText().isEmpty() && txtPass.getText().isEmpty()) {
    		 wrgLogin.setText("Please enter your data..");
         }

    	
    	else
    	{
    		wrgLogin.setText("Wrong username or password!");
    	}

    }

    @FXML
    void initialize() {
       

    }

}
