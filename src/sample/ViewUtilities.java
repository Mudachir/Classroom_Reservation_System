package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtilities {
  public static void showError(String errorMessage, Stage parentStage)  {
    FXMLLoader fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource("ErrorView.fxml"));
    try {
    Pane  pane = (Pane) fxmlLoader.load();
      ErrorViewController errorView = fxmlLoader.getController();
      errorView.setErrorView(errorMessage);
      Scene errorViewScene = new Scene(pane);
      Stage errorStage = new Stage();
      errorStage.setScene(errorViewScene);
      errorStage.initOwner(parentStage);
      errorStage.initModality(Modality.APPLICATION_MODAL);
      errorStage.setTitle("Error");
      errorStage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
