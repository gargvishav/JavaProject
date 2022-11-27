package attendence;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class AttendenceViewController {
	
	@FXML
    private ResourceBundle resources;

	@FXML
	private URL location;

    @FXML
    private ListView<String> Absentees;

    @FXML
    private ListView<String> StdLIST;

    @FXML
    private ComboBox<String> comboSec;

    @FXML
    private ComboBox<String> comboTime;

    @FXML
    private DatePicker pickDate;
    
    Connection con;
    PreparedStatement pst;
    File file;
    ResultSet table;
    
    String aryP[]={"Vishav","Priyansh","Ashi","Ridit","Anushka","Abid","Arin"};
    
    String aryB[]={"Runishka","hriday","prashant","Aman","Panda","manas","Ritik"};
    
    String aryC[]= {"Parth","Akhil","Akansha","Arjan","Vikas","Naina","Raina"};
   
   void showMsg(String msg)
   {
   	Alert alert=new Alert(AlertType.CONFIRMATION);
   	alert.setTitle("Title");
   	alert.setContentText(msg);
   	alert.show();
   }
    

    @FXML
    void doAddinCart(MouseEvent event) {
    	if(event.getClickCount()==2) {
    		Absentees.getItems().add(StdLIST.getSelectionModel().getSelectedItem());
    	}

    }
    
    @FXML
    void doFill(ActionEvent event) 
    {
    	StdLIST.getItems().clear();
    	
    	if(comboSec.getSelectionModel().getSelectedIndex()==1) 
    	{
    		StdLIST.getItems().addAll(Arrays.asList(aryB));
    	}
    	if(comboSec.getSelectionModel().getSelectedIndex()==2) 
    	{
    		StdLIST.getItems().addAll(Arrays.asList(aryP));
    	}
    	if(comboSec.getSelectionModel().getSelectedIndex()==3) 
    	{
    		StdLIST.getItems().addAll(Arrays.asList(aryC));
    	}


    }
    

    @FXML
    void doSubmit(ActionEvent event) {
    	
//    	String mb=txt.getText();
//    	if(chkMobile(mb)==true)
//    		{
//    		showMsg("Already registered......");
//    		return;
//    		}
    	
    	try {
			pst=con.prepareStatement("insert into subjectinfo1 values(?,?,current_date())");
			pst.setString(1, comboTime.getEditor().getText());
			pst.setString(2, comboSec.getEditor().getText());
			pst.executeUpdate();
			showMsg("Attendence Taken....");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

    }
    void doSetValues() 
    {
        	
     ArrayList<String> time = new ArrayList<String>(Arrays.asList("Select","9:15am-10am","10:15am-11am","1:15pm-2pm","2:15pm-3pm"));
    	comboTime.getItems().setAll(time);

     }
     
    
    @FXML
    void initialize() 
    {
    	comboSec.getItems().add("select");
        comboSec.getItems().add("CSE-1");
        comboSec.getItems().add("CSE-2");
        comboSec.getItems().add("CSE-3");
        doSetValues();
        
        con =	DatabaseConnection16.doconnect();
      
    }


}
