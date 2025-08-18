package mini_world.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import mini_world.logic.Main;

public class FXMLController {

  @FXML
  private Label label;

  @FXML
  private Button buttonSimulation;

  @FXML
  private Button buttonQuit;

  @FXML
  private Canvas canvas;

  double canvasSectorSpace;

  private void drawWorld(GraphicsContext canvasGc) {
    int y = 0;
    int x = 0;
    int canvasX = 0;
    int canvasY = 0;
    canvasGc.setFill(Color.LIGHTGRAY);
    canvasGc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    for (int v = 0; v < 10; v++) {
      if (v % 2 == 0) canvasX += canvasSectorSpace;
      for (int h = 0; h < 5; h++) {
        canvasGc.setFill(Color.GRAY);
        canvasGc.fillRect(
          canvasX,
          canvasY,
          canvasSectorSpace,
          canvasSectorSpace
        );
        canvasX += canvasSectorSpace * 2;
      }
      canvasX = 0;
      canvasY += canvasSectorSpace;
    }
    for (int eY = 0; eY < 10; eY++) {
      for (int eX = 0; eX < 10; eX++) {
        if (Main.getEntityNotNull(eX, eY)) {
          if (Main.getEntitySide(eX, eY) == 1) canvasGc.setFill(
            Color.BLUE
          ); else if (Main.getEntitySide(eX, eY) == 2) canvasGc.setFill(
            Color.RED
          );
          if (Main.getEntityCanSpawnEntity(eX, eY)) canvasGc.fillOval(
            x + (0.5 * canvasSectorSpace) - 10,
            y + (0.5 * canvasSectorSpace) - 10,
            20,
            20
          ); else canvasGc.fillOval(
            x + (0.5 * canvasSectorSpace) - 7.5,
            y + (0.5 * canvasSectorSpace) - 7.5,
            15,
            15
          );
        }
        x += 40;
      }
      x = 0;
      y += 40;
    }
  }

  public void initialize() {
    canvasSectorSpace = canvas.getWidth() / 10;
    canvasSectorSpace = canvas.getHeight() / 10;
    GraphicsContext canvasGc = canvas.getGraphicsContext2D();
    label.setText(
      "Day " +
      Main.getTime() +
      (Main.isProductionDay() ? " (production day)" : "") +
      "\n"
    );
    buttonSimulation.setOnAction(e -> {
      Main.simulateNextDay();
      label.setText(
        "Day " +
        Main.getTime() +
        (Main.isProductionDay() ? " (production day)" : "") +
        "\n"
      );
      drawWorld(canvasGc);
    });
    buttonQuit.setOnAction(e -> {
      Platform.exit();
    });
    drawWorld(canvasGc);
  }
}
