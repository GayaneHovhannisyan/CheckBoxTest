package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Helper {

    public void ctrlClick(WebDriver driver, WebElement element) {
        final Actions action = new Actions(driver);
        action.keyDown(Keys.LEFT_CONTROL).click(element)
                .build()
                .perform();
    }


    public Object[][] index(int bound) {
        Object[][] indexes = new Object[bound][1];
        for (int i = 0; i < bound; i++) {
            indexes[i][0] = i;
        }
        return indexes;
    }


    public static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor)MyWebDriver.getDriver())
                .executeScript("arguments[0].scrollIntoView(true)", element);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        }


    public void screenShot(WebDriver driver, String filePath) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File des = new File(filePath);
        try {
            FileUtils.copyFile(screenShot, des);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void screenShotAshot(WebDriver driver, String path) {
        Screenshot screenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
        File file = new File(path);
        try {
            ImageIO.write(screenShot.getImage(), "jpg",file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
