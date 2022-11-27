package login_page;

import java.io.IOException;
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

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    private Label wrongLogin;

    @FXML
    void doLogin(ActionEvent event)  throws IOException {
    	if(txtUser.getText().toString().equals("vishav") && txtPassword.getText().toString().equals("123")) 
    	{
    		
    		wrongLogin.setText("Success!");

    	
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/login_option/LoginOptionView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
			Scene scene1=(Scene)txtUser.getScene();
			scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	
    	}
    	
    	 else if(txtUser.getText().isEmpty() && txtPassword.getText().isEmpty()) {
         	wrongLogin.setText("Please enter your data..");
         }

    	
    	else
    	{
    		 wrongLogin.setText("Wrong username or password!");
    	}
		

    	

    }

    @FXML
    void initialize() {
       
    }

}
