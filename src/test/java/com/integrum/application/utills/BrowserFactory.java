package com.integrum.application.utills;

import static com.integrum.application.utills.ConfigFile.browserName;
import static com.integrum.application.utills.ConfigFile.headless;
import static com.integrum.application.utills.ConfigFile.projectDirectory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

  private static final ThreadLocal<BrowserFactory> browserFactoryThread = new ThreadLocal<BrowserFactory>();
  private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();

  private BrowserFactory() {

  }

  public static BrowserFactory initializeDriver() {
    if (browserFactoryThread.get() == null) {
      browserFactoryThread.set(new BrowserFactory());
      setChromeDriver(System.getProperty("os.name"));
      setDriver();
    }
    return browserFactoryThread.get();
  }

  private static void setDriver() {
    switch (browserName) {
      case "firefox":
        break;
      case "IE":
        break;
      default:
        System.out.println("Reached to set default driver based on OS " + System.getProperty("os.name"));
        setChromeDriver(System.getProperty("os.name"));
        driverThread.set(new ChromeDriver(setChromeOptions()));
    }
  }

  public static void setChromeDriver(String osName) {
    String driverName = null;
    String driverPath;
    System.out.println("Code ready to executing on " + osName);
    switch (osName) {
      case "Linux":
        driverName = "chromedriver";
        System.out.println("Linux machine " + osName);
        break;
      case "Mac OS X":
        driverName = "chromedriver_mac64";
        break;
      case "Windows 10":
        driverName = "chromedriver.exe";
        break;
      default:
        driverName = "chromedriver";
    }

    driverPath = projectDirectory + "/src/test/resources/Drivers/" + driverName;
    if (osName.equalsIgnoreCase("Linux")) {
      System.out.println("Linux headless configuration set as " + headless);
      try {
        File file = new File(driverPath);
        file.createNewFile();
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        Files.setPosixFilePermissions(file.toPath(), perms);
        System.out.println("As it is Linux OS, the driver path is : " + driverPath);
        System.out.println("Execute permission set for Driver");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.setProperty("webdriver.chrome.driver", driverPath);
    System.out.println("the driver path is " + driverPath);
  }

  public static ChromeOptions setChromeOptions() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("disable-infobars");
    chromeOptions.addArguments("--enable-automation");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--disable-dev-shm-usage");
    chromeOptions.addArguments("use-fake-device-for-media-stream");
    chromeOptions.addArguments("use-fake-ui-for-media-stream");
    chromeOptions.addArguments("--window-size=1936,1056");
    chromeOptions.addArguments("start-maximized");
    chromeOptions.addArguments("--remote-allow-origins=*");
    chromeOptions.setHeadless(Boolean.parseBoolean(headless));
    return chromeOptions;
  }

  public WebDriver getDriver() {
    return driverThread.get();
  }

  public void closeDriverSession() {
    driverThread.get().close();
    browserFactoryThread.remove();
    driverThread.remove();
  }
}
