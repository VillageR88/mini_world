package mini_world.logic;

public class Helpers {

  public enum OperatingSystem {
    WINDOWS,
    LINUX,
    MACINTOSH,
    OTHER,
  }

  public static OperatingSystem checkOS() {
    String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
      return OperatingSystem.WINDOWS;
    }
    if (os.contains("mac")) {
      return OperatingSystem.MACINTOSH;
    }
    if (os.contains("nux") || os.contains("nix")) {
      return OperatingSystem.LINUX;
    }
    return OperatingSystem.OTHER;
  }
}
