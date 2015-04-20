package com.gr.sloader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Processor {

    public static void main(String[] args) {

        if (args.length != 1)
            throw new IllegalArgumentException("wrong input arguments!");
        WebDriver webDriver = new FirefoxDriver();

        webDriver.get("http://www.google.com");

        WebElement element1 = webDriver.findElement(By.name("q"));
        element1.sendKeys(args[0]);
        element1.submit();

        // wait until the google page shows the result
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        List<WebElement> findElements = webDriver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        String[] hrefs = new String[findElements.size()];
        int i = 0;
        for(WebElement resPage: findElements){
//            System.out.println(resPage.getAttribute("href"));
            hrefs[i++] = resPage.getAttribute("href");
        }

        i = 0;
        for (String href : hrefs) {
            webDriver.get(href);
            System.out.println("title [" + ++i + "] :" + webDriver.getTitle());
        }
        webDriver.quit();
    }
}
