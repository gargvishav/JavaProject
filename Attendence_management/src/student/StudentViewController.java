package student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class StudentViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker datePickk;

    @FXML
    private TextField txtAttend;

    @FXML
    private TextField txtRoll;

    @FXML
    private ComboBox<String> txtSec;

    @FXML
    private ComboBox<String> txtSub;

    @FXML
    private TextField txtnameee;
    
    @FXML
    private ImageView vieww;
    
    Connection con;
    PreparedStatement pst;
    File file;
    ResultSet table;
    
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Title");
    	alert.setContentText(msg);
    	alert.show();
    }
    
    void doSetValues()
    {
    	
    	ArrayList<String> section = new ArrayList<String>(Arrays.asList("Select","CSE-1","CSE-2","CSE-3","CSE-4"));
    	txtSec.getItems().setAll(section);
    	
    	ArrayList<String> subject = new ArrayList<String>(Arrays.asList("Select","JAVA","OS","DAA","OOPS","ECS"));
    	txtSub.getItems().setAll(subject);

    }
    
    boolean chkMobile(String mobile)
    {
    	boolean jasoos=false;
    	try {
        	pst=con.prepareStatement("select * from student where mobileno=?");
        	pst.setString(1, txtRoll.getText());
        	
        	table=pst.executeQuery();
        	      	
        	
        	while(table.next())
        	{
        		jasoos=true;
        	}
        	}
        	catch(Exception exp)
        	{ 		
        	}
    	return jasoos;
    }
    
    

    @FXML
    void doFind(ActionEvent event) {
    	
//  	String mb=txtRoll.getText();
//   	if(chkMobile(mb)==false)
//   	{
//    		showMsg("not found...");
//    		return;
//   	}
    	
    	try {
			pst=con.prepareStatement("select * from student1 where roll_no=?");
			pst.setString(1, txtRoll.getText());
			table=pst.executeQuery();
			while(table.next())
			{
				txtnameee.setText(table.getString("name"));
				txtAttend.setText(table.getString("attendance_count"));
				txtSub.setValue(table.getString("subject"));
				txtSec.setValue(table.getString("section"));
				Date date=table.getDate("date");
				
				LocalDate date1=date.toLocalDate();
    			datePickk.setValue(date1);
				
				Image img;
				try {
					img = new Image(new FileInputStream(table.getString("image")));
					vieww.setImage(img);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


    }
    

    @FXML
    void initialize() {
    	con =	DatabaseConnection15.doconnect();
    	doSetValues();
    }

}
