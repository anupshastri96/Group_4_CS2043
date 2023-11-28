import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
public class MainGUI extends Application {

    private TextField usernameField;
    private TextField passwordField;
    private Button loginButton;
    private Button logoutButton;
    private Text topText;
    private Text condText;

    private TextField FName;
    private TextField LName;
    private DatePicker datePicker;
    
    private Stage doctorStage;
	private Scene doctorScene;
	private VBox docVBox;
    
	private Stage nurStage;
	private Scene nurScene;
	private VBox nurVBox;
	
	private Stage admStage;
	private Scene admScene;
	private VBox admVBox;
	
	private Stage patStage;
	private Scene patScene;
	private VBox patVBox;
	
	private Button viewApp;
	private Button staffSch;
	private Button addAppointment;
	private Button resAppointment;
	private Button patRec;
	
	private Button crStaff;
	private Button delStaff;
	private Button staffRec;
	
	ArrayList<Patient> Patients = new ArrayList<>();
	
	private Stage doctorStage() {
		
		doctorStage = new Stage();
		doctorStage.setTitle("DOCTOR VIEW");
			
			viewApp = new Button();
			viewApp.setText("Appointments");
			staffSch = new Button();
			staffSch.setText("Staff Schedule");
		 	addAppointment = new Button();
	        addAppointment.setText("Create Appointment");     
	        addAppointment.setOnAction(this::createAppointment);
	        resAppointment = new Button();
	        resAppointment.setText("Edit/View Appointments");
	        patRec = new Button();
	        patRec.setText("View Patient Record");
	        patRec.setOnAction(this::patientRecordAccess);
	        logoutButton = new Button();
	        logoutButton.setText("Logout");
	        logoutButton.setOnAction(this::Logout);
	        
	        topText = new Text("Logged in as Doctor");
	        topText.setFont(Font.font("Arial", 16));
	        
	        docVBox = new VBox(topText,viewApp,staffSch,addAppointment,resAppointment,patRec,logoutButton);
	        docVBox.setAlignment(Pos.CENTER);
	        doctorScene = new Scene(docVBox,500,300);
		doctorStage.setScene(doctorScene);
		
		return doctorStage;
	}
	
private Stage adminStage() {
		
		admStage = new Stage();
		admStage.setTitle("ADMIN VIEW");
		
		 	crStaff = new Button();
	        crStaff.setText("Create Staff");     
	        delStaff = new Button();
	        delStaff.setText("Remove Staff");  
	        staffRec = new Button();
	        staffRec.setText("View Staff Record");
	        staffSch = new Button();
	        staffSch.setText("View Scheduling");
	        patRec = new Button();
	        patRec.setText("View Patient Record");
	        logoutButton = new Button();
	        logoutButton.setText("Logout");
	        logoutButton.setOnAction(this::Logout);
	        
	        topText = new Text("Logged in as Admin");
	        topText.setFont(Font.font("Arial", 16));
	        
	        admVBox = new VBox(topText,crStaff,delStaff,staffRec,staffSch,patRec,logoutButton);
	        admVBox.setAlignment(Pos.CENTER);
	        admScene = new Scene(admVBox,500,300);
		admStage.setScene(admScene);
		
		return admStage;
	}

private Stage nurseStage() {
	
	nurStage = new Stage();
	nurStage.setTitle("NURSE VIEW");
		
		Button viewApp = new Button();
		viewApp.setText("Appointments");
		Button staffSch = new Button();
		staffSch.setText("Staff Schedule");
        Button patRec = new Button();
        patRec.setText("View Patient Record");
        patRec.setOnAction(this::patientRecordAccess);
        logoutButton = new Button();
        logoutButton.setText("Logout");
        logoutButton.setOnAction(this::Logout);
        
        topText = new Text("Logged in as Nurse");
        topText.setFont(Font.font("Arial", 16));
        
        nurVBox = new VBox(topText,viewApp,staffSch,patRec,logoutButton);
        nurVBox.setAlignment(Pos.CENTER);
        nurScene = new Scene(nurVBox,500,300);
        nurStage.setScene(nurScene);
	
	return nurStage;
}

	private Stage patientRecord(){
		patStage = new Stage();
		patStage.setTitle("PATIENT RECORDS");
		
			
	        
	        topText = new Text("Patient Records");
	        topText.setFont(Font.font("Arial", 16));
	        
	        
	        
	        if(Patients.isEmpty()==true){
	        	condText = new Text("There are no records available.");
	        }
	        
	        patVBox = new VBox(topText,condText);
	        patVBox.setAlignment(Pos.CENTER);
	        patScene = new Scene(patVBox,500,300);
	        patStage.setScene(patScene);
		
		return patStage;
		
	}
	
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Doctors Office Management System");
        doctorStage = doctorStage();
        nurStage = nurseStage();
        admStage = adminStage();
        patStage = patientRecord();
        
        
        
        Label Username = new Label("Username:");
        usernameField = new TextField();
        usernameField.setOnAction(this::LoginAttempt);
        usernameField.setPrefWidth(150);

        Label Password = new Label("Password");
        passwordField = new PasswordField();
        passwordField.setOnAction(this::LoginAttempt);
        passwordField.setPrefWidth(150);

        loginButton = new Button("Login");
        loginButton.setOnAction(this::LoginAttempt);
        

        topText = new Text("Doctors Office Management System");
        topText.setFont(Font.font("Arial", 20));
    

        VBox topBox = new VBox(topText);
        topBox.setAlignment(Pos.CENTER);
        topBox.setMinHeight(150);

        FlowPane pane = new FlowPane(Username, usernameField, Password, passwordField, loginButton);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(25);
        pane.setVgap(10);

        VBox mainBox = new VBox(topBox, pane);
        mainBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainBox, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    public void LoginAttempt(ActionEvent event) {

        if (event.getSource() == loginButton) {
            
            String loginUser = usernameField.getText();
            String passUser = passwordField.getText();
            String d = "Doctor";
            String a = "Admin";
            String n = "Nurse";
            String pw = "TEST1";
            
            if(loginUser.equals(d)) {
            doctorStage.show();
            }else if(loginUser.equals(a) && passUser.equals(pw)){
            	admStage.show();
            }else if(loginUser.equals(n)){
            	nurStage.show();
            }
            passwordField.clear();
            usernameField.clear();
        }
    }
    public void Logout(ActionEvent event) {
    	
    	if (event.getSource() == logoutButton) {
    		
    		Stage stage = (Stage) logoutButton.getScene().getWindow();
    		stage.close();
    		
    		
    	}
    	
    }
    
    public void createAppointment(ActionEvent event) {
    	
    	Popup apptInfo = new Popup();
    	
    	apptInfo.setAutoFix(true);
    	
    	apptInfo.setWidth(300);
    	apptInfo.setHeight(400);
    	Label pLabel = new Label();
    	pLabel.setText("Create Appointment");
    	
    	pLabel.setMinWidth(300);
    	pLabel.setMinHeight(400);
    	
    	Label FirstName = new Label("First Name:");
        FName = new TextField();
        FName.setPrefWidth(150);
    	
        Label LastName = new Label("Last Name:");
        LName = new TextField();
        LName.setPrefWidth(150);
        
        Label Date = new Label("Selected Date:");
        //pLabel,FirstName,FName,LastName,LName,Date
        apptInfo.getContent().add(pLabel);
        apptInfo.getContent().add(FirstName);
        apptInfo.getContent().add(FName);
        apptInfo.getContent().add(LastName);
        apptInfo.getContent().add(LName);
        apptInfo.getContent().add(Date);
        
        apptInfo.show(doctorStage);
    }
    
    public void patientRecordAccess(ActionEvent event) {
    	
if (event.getSource() == patRec) {
    		
    		patStage.show();
    		
    		
    	}
    	
    }
	

    public static void main(String[] args) {
        launch(args);
    }
}
