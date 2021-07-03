package sample;

import dataClass.Faculty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DataViewController {
  
  @FXML
  private ImageView imageView;
  
  
  @FXML // fx:id="facultyInitialLabel"
  private Label facultyInitialLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="emailLabel"
  private Label emailLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="facultyIDLabel"
  private Label facultyIDLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="departmentLabel"
  private Label departmentLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="currentSemesterLabel"
  private Label currentSemesterLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="totalStudentLabel"
  private Label totalStudentLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="purposeLabel"
  private Label purposeLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="classRoomLabel"
  private Label classRoomLabel; // Value injected by FXMLLoader
  
  @FXML
  private Label courseCodeLabel;
  
  @FXML // fx:id="bookingDateLabel"
  private Label bookingDateLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="closeButtonLabel"
  private Button closeButtonLabel; // Value injected by FXMLLoader
  private void resetUI(){
    this.facultyInitialLabel.setText("");
    this.emailLabel.setText("");
    this.facultyIDLabel.setText("");
    this.departmentLabel.setText("");
    this.currentSemesterLabel.setText("");
    this.totalStudentLabel.setText("");
    this.purposeLabel.setText("");
    this.classRoomLabel.setText("");
    this.courseCodeLabel.setText("");
    this.bookingDateLabel.setText(String.valueOf(""));
    this.imageView.setImage(null);
  }
  @FXML
  void handleCloseButtonClicked(ActionEvent event) {
    this.resetUI();
    this.switchToDataEntry();
  }
  
  private void switchToDataEntry(){
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataEntry.fxml"));
      Pane pane = (Pane) fxmlLoader.load();
      
      Scene detailViewScene = new Scene(pane);
      Stage primaryStage = (Stage) this.closeButtonLabel.getScene().getWindow();
      primaryStage.setScene(detailViewScene);
      primaryStage.setTitle("Data Entry App");
      primaryStage.show();
    } catch (Exception exception){
      System.out.println(exception.getMessage());
    }
  }
  
  public void transferFacultyObject(Faculty faculty){
    String facultyInitial = faculty.getFacultyInitial();
    String email1 = faculty.getEmail();
    String facultyID = faculty.getID();
    String department = faculty.getDepartment();
    String currentSemester = faculty.getSemester();
    String studentList = String.valueOf(faculty.getStudentList());
    String purpose = faculty.getPurpose();
    String classRoomName = faculty.getClassroomName();
    LocalDate bookingDate = faculty.getLocalDate();
    String courseCode = faculty.getCourseCode();
    String pathToProfile = "file://" + faculty.getProfilePath();
  
    this.facultyInitialLabel.setText(facultyInitial);
    this.emailLabel.setText(email1);
    this.facultyIDLabel.setText(facultyID);
    this.departmentLabel.setText(department);
    this.currentSemesterLabel.setText(currentSemester);
    this.totalStudentLabel.setText(studentList);
    this.purposeLabel.setText(purpose);
    this.classRoomLabel.setText(classRoomName);
    this.courseCodeLabel.setText(courseCode);
    this.bookingDateLabel.setText(String.valueOf(bookingDate));
    this.imageView.setImage(new Image(pathToProfile));
  }
  
}

