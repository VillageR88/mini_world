package mini_world;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FXMLController {

  Grid grid = new Grid();

  @FXML
  private Label label;

  @FXML
  private Canvas canvas;

  @FXML
  private Button buttonSimulation;

  @FXML
  private void handleButtonQuitClick() {
    Platform.exit();
  }

  private void drawWorld(Grid grid, GraphicsContext canvasGc) {
    int y = 0;
    int x = 0;
    canvasGc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    canvasGc.setFill(Color.LIGHTGRAY);
    canvasGc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    for (Entity[] row : grid.getGrid()) {
      for (Entity element : row) {
        if (element != null) {
          if (element.side == 1) canvasGc.setFill(Color.BLUE); else if (
            element.side == 2
          ) canvasGc.setFill(Color.RED);
          if (element.canSpawnEntity) canvasGc.fillOval(
            x,
            y,
            20,
            20
          ); else canvasGc.fillOval(x, y, 15, 15);
        }
        x += 40;
      }
      x = 0;
      y += 40;
    }
  }

  public void initialize() {
    MainApp.seedGrid(grid);
    GraphicsContext canvasGc = canvas.getGraphicsContext2D();
    label.setText(
      "Day " +
      grid.getTime() +
      (grid.isProductionDay() ? " (production day)" : "") +
      "\n"
    );
    buttonSimulation.setOnAction(e -> {
      MainApp.simulateOneDay(grid);
      label.setText(
        "Day " +
        grid.getTime() +
        (grid.isProductionDay() ? " (production day)" : "") +
        "\n"
      );
      drawWorld(grid, canvasGc);
    });
    buttonSimulation.fire();
  }
}
