package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testSetup.SetupClass;

import java.io.File;
import java.io.IOException;

public class TestUtil extends SetupClass {

    public static void takeScreenShot() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String workDir = System.getProperty("user.dir");
        FileUtils.copyFile(srcFile, new File(workDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
    }

    public static String conculateBalance(String initAmount, String depositAmount) {
        int amount1 = Integer.parseInt(initAmount);
        int amount2 = Integer.parseInt(depositAmount);
        int total = amount1 + amount2;
        return Integer.toString(total);
    }
}
