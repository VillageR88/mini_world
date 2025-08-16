package mini_world;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

    Scene scene = new Scene(root);
    scene
      .getStylesheets()
      .add(getClass().getResource("styles.css").toExternalForm());

    stage.setTitle("Mini World");
    stage.setScene(scene);
    stage.show();
  }

  public static void seedGrid(Grid grid) {
    Base player1Base = new Base('A', 1);
    Base player2Base = new Base('B', 2);
    grid.setGrid(0, 0, player1Base);
    grid.setGrid(9, 9, player2Base);
  }

  public static void simulateOneDay(Grid grid) {
    if (grid.isProductionDay()) grid.produceUnits();
    grid.doFight();
    grid.moveUnits();
    grid.eraseSkipLegDayCoordinates();
    grid.proceedTime();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
