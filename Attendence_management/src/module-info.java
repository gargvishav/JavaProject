module attendence {
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;
	
	opens login_page to javafx.graphics, javafx.fxml;
	opens attendence to javafx.graphics, javafx.fxml;
	opens login_option to javafx.graphics, javafx.fxml;
	opens student_login to javafx.graphics, javafx.fxml;
	opens teacher_login to javafx.graphics, javafx.fxml;
	opens student to javafx.graphics, javafx.fxml;	
	
}