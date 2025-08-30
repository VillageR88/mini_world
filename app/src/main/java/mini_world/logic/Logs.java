package mini_world.logic;

import mini_world.model.Grid.ScanResult;
import mini_world.model.Grid.Stance;
import org.json.JSONArray;
import org.json.JSONObject;

public class Logs {

  public static JSONObject create(ScanResult scanResult, Stance stance) {
    if (Params.logsEnabled || Params.trainedPlayer != 0) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("name", stance);
      JSONArray options = new JSONArray();
      for (int i = 0; i < scanResult.possibilitiesLength; i++) {
        options.put(
          new JSONArray()
            .put(scanResult.possibleLocations[i][0])
            .put(scanResult.possibleLocations[i][1])
        );
      }
      jsonObject.put("options", options);
      System.out.println("Message length: " + jsonObject.toString().length());
      System.out.println("Message: " + jsonObject);
      return jsonObject;
    }
    return null;
  }
}
