package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

public class CommonMethods {
    public static byte[] takeScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverUtils.getDriver();
        byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenShot;
    }
    public static void takeScreenshot(Scenario scenario){
        try{
            if(scenario.isFailed()){
                File screenshot = ((TakesScreenshot)DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
