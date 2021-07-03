package sample;

import dataClass.Faculty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utilities.DataSaving;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DataEntryController implements Serializable {
  
  @FXML // fx:id="facultyInitialTextField"
  private TextField facultyInitialTextField; // Value injected by FXMLLoader
  
  @FXML // fx:id="emailTextField"
  private TextField emailTextField; // Value injected by FXMLLoader
  
  @FXML // fx:id="facultyIDTextField"
  private TextField facultyIDTextField; // Value injected by FXMLLoader
  
  @FXML
  private ComboBox<String> departmentCombo;
  
  @FXML
  private ComboBox<String> semesterCombo;
  
  @FXML // fx:id="totalStudentTextField"
  private TextField totalStudentTextField; // Value injected by FXMLLoader
  
  @FXML // fx:id="purposeSelectionField"
  private ComboBox<String> purposeSelectionField; // Value injected by FXMLLoader
  
  @FXML // fx:id="saveButton"
  private Button saveButton; // Value injected by FXMLLoader
  
  @FXML // fx:id="clearButton"
  private Button clearButton; // Value injected by FXMLLoader
  
  @FXML
  private ComboBox<String> classRoomCombo;
  
  @FXML // fx:id="bookingDatePicker"
  private DatePicker bookingDatePicker; // Value injected by FXMLLoader
  
  @FXML
  private ComboBox<String> courseCodeCombo;
  
  
  @FXML // fx:id="chooseProfilePhotoButton"
  private Button chooseProfilePhotoButton; // Value injected by FXMLLoader
  
  @FXML
  private ImageView chosenProfileImage;
  
  
  @FXML // fx:id="informationListView"
  private ListView<Faculty> informationListView; // Value injected by FXMLLoader
  
  @FXML // fx:id="editDetailsButton"
  private Button editDetailsButton; // Value injected by FXMLLoader
  
  @FXML // fx:id="viewDetailsButton"
  private Button viewDetailsButton; // Value injected by FXMLLoader
  
  @FXML
  private Button deleteButton;
  
  private String profilePath = null;
  
  private ArrayList<Faculty> facultyArrayList = null;
  
  private ObservableList<Faculty> facultyObservableList = null;
  
  private int indexOfSelectedPerson = -1;
  
  private void updateProfilePicture(){
    Image image = new Image("file://" + this.profilePath);
    this.chosenProfileImage.setImage(image);
  }
  
  @FXML
  void handleChooseProfileButtonClicked(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = (Stage) this.chooseProfilePhotoButton.getScene().getWindow();
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    if (selectedFile != null) {
      String selectedFilePath = selectedFile.toURI().getPath();
      this.profilePath = selectedFilePath;
      this.updateProfilePicture();
    }
  }
  
  @FXML
  void handleSaveButtonClicked(ActionEvent event) {
    String facultyInitial = this.facultyInitialTextField.getText();
    String email1 = this.emailTextField.getText();
    String facultyID = this.facultyIDTextField.getText();
    String department = this.departmentCombo.getSelectionModel().getSelectedItem();
    String currentSemester = this.semesterCombo.getSelectionModel().getSelectedItem();
    String studentList = this.totalStudentTextField.getText();
    String purpose = this.purposeSelectionField.getSelectionModel().getSelectedItem();
    String classRoomName = this.classRoomCombo.getSelectionModel().getSelectedItem();
    LocalDate bookingDate = this.bookingDatePicker.getValue();
    String course = this.courseCodeCombo.getSelectionModel().getSelectedItem();
    String pathToProfile = this.profilePath;
    try {
      Faculty faculty = new Faculty(facultyInitial, email1, facultyID, email1, department, currentSemester, Integer.parseInt(studentList),
        purpose, classRoomName, bookingDate,course, pathToProfile);
      if(this.indexOfSelectedPerson != -1){
        this.facultyObservableList.set(this.indexOfSelectedPerson, faculty);
        this.informationListView.refresh();
      } else{
        this.facultyObservableList.add(faculty);
        System.out.println(faculty);
      }
      boolean save = DataSaving.serialize(DataSaving.savingPath, this.facultyArrayList);
      if (!save) {
        throw new Exception("Invalid");
      }
    } catch (Exception exception) {
      Stage primaryStage = (Stage) this.saveButton.getScene().getWindow();
      ViewUtilities.showError(exception.getMessage(),primaryStage);
    }
  }
  
  @FXML
  void handleClearButtonClicked(ActionEvent event) {
    this.facultyInitialTextField.setText("");
    this.emailTextField.setText("");
    this.facultyIDTextField.setText("");
    this.departmentCombo.getSelectionModel().clearSelection();
    this.semesterCombo.getSelectionModel().clearSelection();
    this.totalStudentTextField.setText("");
    this.purposeSelectionField.getSelectionModel().clearSelection();
    this.classRoomCombo.getSelectionModel().clearSelection();
    this.bookingDatePicker.setValue(null);
    this.courseCodeCombo.getSelectionModel().clearSelection();
    this.profilePath = null;
    this.chosenProfileImage.setImage(null);
  }
  
  @FXML
  void handleEditButtonClicked(ActionEvent event) {
    this.indexOfSelectedPerson = this.informationListView.getSelectionModel().getSelectedIndex();
   if(this.indexOfSelectedPerson != -1){
     Faculty savedFaculty = this.informationListView.getItems().get(this.indexOfSelectedPerson);
     String facultyInitial = savedFaculty.getFacultyInitial();
     String email1 = savedFaculty.getEmail();
     String facultyID = savedFaculty.getID();
     String department = savedFaculty.getDepartment();
     String currentSemester = savedFaculty.getSemester();
     String studentList = String.valueOf(savedFaculty.getStudentList());
     String purpose = savedFaculty.getPurpose();
     String classRoomName = savedFaculty.getClassroomName();
     LocalDate bookingDate = savedFaculty.getLocalDate();
     String courseCode = savedFaculty.getCourseCode();
     String pathToProfile = savedFaculty.getProfilePath();
     
     this.updateUIWithSavedPerson(facultyInitial,email1,facultyID,department,currentSemester,studentList,purpose,classRoomName,bookingDate,courseCode, pathToProfile);
   }
  }
  
  private void updateUIWithSavedPerson(String facultyInitial,String email1,String facultyID,String department, String currentSemester,String studentList,
                                       String purpose,String classRoomName,LocalDate bookingDate,String course, String pathToProfile){
  
    this.facultyInitialTextField.setText(facultyInitial);
    this.emailTextField.setText(email1);
    this.facultyIDTextField.setText(facultyID);
    this.departmentCombo.setSelectionModel(departmentCombo.getSelectionModel());
    this.semesterCombo.setSelectionModel(semesterCombo.getSelectionModel());
    this.totalStudentTextField.setText(studentList);
    this.purposeSelectionField.setSelectionModel(purposeSelectionField.getSelectionModel());
    this.classRoomCombo.setSelectionModel(classRoomCombo.getSelectionModel());
    this.bookingDatePicker.setValue(bookingDate);
    this.courseCodeCombo.setSelectionModel(courseCodeCombo.getSelectionModel());
    this.updateProfilePicture();
  }
  @FXML
  void handleDeleteButton(ActionEvent event) {
    this.indexOfSelectedPerson = this.informationListView.getSelectionModel().getSelectedIndex();
    if(this.indexOfSelectedPerson != -1){
      Faculty savedFaculty = this.informationListView.getItems().remove(this.indexOfSelectedPerson);
      facultyObservableList.remove(savedFaculty);
      boolean save = DataSaving.serialize(DataSaving.savingPath, this.facultyArrayList);
      if (!save) {
        try {
          throw new Exception("Invalid");
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
      this.informationListView.refresh();
    }
  }
  private void updateUIWithSavedPerson1(String facultyInitial,String email1,String facultyID,String department, String currentSemester,String studentList,
                                       String purpose,String classRoomName,LocalDate bookingDate,String course, String pathToProfile){
    
    this.facultyInitialTextField.setText(facultyInitial);
    this.emailTextField.setText(email1);
    this.facultyIDTextField.setText(facultyID);
    this.departmentCombo.setSelectionModel(departmentCombo.getSelectionModel());
    this.semesterCombo.setSelectionModel(semesterCombo.getSelectionModel());
    this.totalStudentTextField.setText(studentList);
    this.purposeSelectionField.setSelectionModel(purposeSelectionField.getSelectionModel());
    this.classRoomCombo.setSelectionModel(classRoomCombo.getSelectionModel());
    this.bookingDatePicker.setValue(bookingDate);
    this.courseCodeCombo.setSelectionModel(courseCodeCombo.getSelectionModel());
    this.updateProfilePicture();
  }
  
  
  @FXML
  void handleViewButtonClicked(ActionEvent event) {
    this.indexOfSelectedPerson = this.informationListView.getSelectionModel().getSelectedIndex();
    if(this.indexOfSelectedPerson != -1){
      Faculty faculty = this.informationListView.getItems().get(this.indexOfSelectedPerson);
      try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataDetailView.fxml"));
        Pane pane = (Pane) fxmlLoader.load();
    
        DataViewController dataViewController = fxmlLoader.getController();
        dataViewController.transferFacultyObject(faculty);
        Scene detailViewScene = new Scene(pane);
        Stage primaryStage = (Stage) this.viewDetailsButton.getScene().getWindow();
        primaryStage.setScene(detailViewScene);
        primaryStage.setTitle("Classroom Reservation Detail Of: " + faculty.getFacultyInitial());
        primaryStage.show();
      } catch (Exception exception){
       Stage primaryStage = (Stage) this.viewDetailsButton.getScene().getWindow();
        ViewUtilities.showError(exception.getMessage(),primaryStage);
      }
    }
  }
  
  @FXML
  void handleTextView(MouseEvent event) {
  
  }
  
  
  
  public void initialize() {
    ArrayList<String> department = new ArrayList<>();
    department.add("Department of Electrical and Computer Engineering");
    department.add("Department of Civil and Environmental Engineering");
    department.add("Department of Architecture");
    department.add("Department of Mathematics & Physics");
    department.add("Department of Accounting & Finance");
    department.add("Department of Economics");
    department.add("Department of Management");
    department.add("Department of Marketing & International Business");
    department.add("Department of English & Modern Languages");
    department.add("Department of Political Science & Sociology");
    department.add("Department of Law");
    department.add("Department of History & Philosophy");
    department.add("Department of Biochemistry and Microbiology");
    department.add("Department of Environmental Science & Management");
    department.add("Department of Pharmaceutical Sciences");
    department.add("Department of Public Health");
  
  
    ObservableList<String> departmentObservableList = FXCollections.observableArrayList(department);
    this.departmentCombo.setItems(departmentObservableList);
  
    ArrayList<String> semesterList = new ArrayList<>();
    semesterList.add("Spring 2021");
    semesterList.add("Summer 2021");
    semesterList.add("Fall 2021");
    ObservableList<String> semesterObservableList = FXCollections.observableArrayList(semesterList);
    this.semesterCombo.setItems(semesterObservableList);
    
    
    ArrayList<String> purposeOption = new ArrayList<>();
    purposeOption.add("Exam");
    purposeOption.add("Makeup-Class");
    ObservableList<String> purposeObservableList = FXCollections.observableArrayList(purposeOption);
    this.purposeSelectionField.setItems(purposeObservableList);
  
    
    File fileToRead = new File("./Course.txt");
    ArrayList<String> course = new ArrayList<>();
    try (Scanner fileReader = new Scanner(fileToRead)) {
      while (fileReader.hasNext()) {
       course.add(fileReader.next());
        ObservableList<String> courseObservableList = FXCollections.observableArrayList(course);
        this.courseCodeCombo.setItems(courseObservableList);
      }
    } catch (FileNotFoundException fileNotFoundException) {
      System.err.println(fileNotFoundException.getMessage());
    }
  
    File fileToReadClassroom = new File("./Classroom.txt");
    ArrayList<String> classroom = new ArrayList<>();
    try (Scanner fileReader = new Scanner(fileToReadClassroom)) {
      while (fileReader.hasNext()) {
        classroom.add(fileReader.next());
        ObservableList<String> classroomObservableList = FXCollections.observableArrayList(classroom);
        this.classRoomCombo.setItems(classroomObservableList);
      }
    } catch (FileNotFoundException fileNotFoundException) {
      System.err.println(fileNotFoundException.getMessage());
    }
    
    try{
      this.facultyArrayList = DataSaving.deserialize(DataSaving.savingPath);
    } catch (Exception exception){
      System.out.println(exception.getMessage());
    }
    if (this.facultyArrayList == null) {
      this.facultyArrayList = new ArrayList<>();
    }
    this.facultyObservableList = FXCollections.observableList(facultyArrayList);
    this.informationListView.setItems(facultyObservableList);
  }
}
