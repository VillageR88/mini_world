package mini_world.logic;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import mini_world.logic.Helpers.OperatingSystem;
import org.json.JSONObject;

public class PipeClient { //TODO: Ultimately hidding dll setup for simple attachment would be cleaner

  static DLL dll;

  public interface DLL extends Library {
    int message_to_pipe(String message);
    int message_from_pipe();
    String get_received_message();
  }

  private static int getDllPath() {
    try {
      String text = Files.readString(Path.of("..", "config.json"));
      JSONObject json = new JSONObject(text);
      String TRAIN_PIPE_CLIENT_DLL_PATH = json
        .get("TRAIN_PIPE_CLIENT_DLL_PATH")
        .toString();
      dll = Native.load(TRAIN_PIPE_CLIENT_DLL_PATH, DLL.class);
      return 0;
    } catch (IOException ex) {
      System.err.println("Error reading config.json: " + ex.getMessage());
      return 1;
    }
  }

  public static void sendMessage(JSONObject message) {
    if (dll.message_to_pipe(message.toString()) != 0) System.out.println(
      "Error sending message."
    );
  }

  public static JSONObject getMessage() {
    if (dll.message_from_pipe() == 0) {
      return new JSONObject(dll.get_received_message());
    } else {
      System.out.println("Error receiving message.");
      JSONObject json = new JSONObject();
      json.put("name", "error");
      return json;
    }
  }

  public static int initialize(OperatingSystem operatingSystem) {
    if (operatingSystem != OperatingSystem.WINDOWS) {
      System.out.println("OS not supported yet.");
      return 1;
    }
    if (getDllPath() == 0) {
      return 0;
    }
    return 1;
  }
}
