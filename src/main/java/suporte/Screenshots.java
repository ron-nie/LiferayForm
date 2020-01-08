package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshots {

    public static void shot (WebDriver browser, String file){
        File screenshot = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(file));

        } catch (Exception e){
            System.out.println("Unable to copy file" + e.getMessage());
        }


    }
}
