package Utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SharedDrivers {

        private static WebDriver webDriver;

        public enum Browsers {
            CHROME,
            FIREFOX,
            IE
        }

        protected static WebDriver getWebDriver(Browsers browsers) {

            switch (browsers) {
                case CHROME:

                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;


                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;

                case IE:
                    WebDriverManager.iedriver().setup();
                    webDriver = new InternetExplorerDriver();
                    break;

            }
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return webDriver;
        }

        protected static void closeDriver() {
            if (webDriver != null) {

                webDriver.close();
            }
        }


    }



