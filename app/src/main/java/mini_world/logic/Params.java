package mini_world.logic;

import mini_world.logic.Helpers.OperatingSystem;

public class Params {

  static boolean isGUI = true;
  static boolean logsEnabled = false; // TODO
  static int trainedPlayer = 0;
  static OperatingSystem operatingSystem;

  public static int getTrainedPlayer() {
    return trainedPlayer;
  }

  public static void parametrize(String[] args) {
    if (args.length > 0) {
      for (String elem : args) {
        if ("logs".equals(elem)) {
          logsEnabled = true;
          break;
        }
        if (elem.contains("=")) {
          String[] elemArr = elem.split("=");
          if ("train".equals(elemArr[0])) {
            if ("player1".equals(elemArr[1])) {
              trainedPlayer = 1; // TODO
              break;
            } else if ("player2".equals(elemArr[1])) {
              trainedPlayer = 2; // TODO
              break;
            }
          }
        }
      }
      if (trainedPlayer != 0) {
        System.out.println("AI training mode, gui disabled.");
        System.out.println("Training player " + trainedPlayer);
        isGUI = false;
        operatingSystem = Helpers.checkOS();
        PipeClient.initialize(operatingSystem);
      } else if (logsEnabled) {
        System.out.println("Logging enabled."); // TODO
      }
    }
  }
}
