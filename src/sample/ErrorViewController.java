package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorViewController {
  @FXML
  private Label errorView;
  
  @FXML
  private Button closeButton;
  
  @FXML
  void handleCloseButton(ActionEvent event) {
    Stage currentStage = (Stage) this.closeButton.getScene().getWindow();
    currentStage.close();
  }
  
  public void setErrorView(String errorMessage){
    this.errorView.setText(errorMessage);
  }
}
