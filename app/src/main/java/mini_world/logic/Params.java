package mini_world.logic;

public class Params {

  static boolean isGUI = true;
  static boolean logsEnabled = false;
  static int trainedPlayer = 0;

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
              trainedPlayer = 1;
              break;
            } else if ("player2".equals(elemArr[1])) {
              trainedPlayer = 2;
              break;
            }
          }
        }
      }
      if (trainedPlayer != 0) {
        System.out.println("AI training mode, gui disabled.");
        System.out.println("Training player " + trainedPlayer);
        isGUI = false;
      } else if (logsEnabled) {
        System.out.println("Logging enabled.");
      }
    }
  }
}
