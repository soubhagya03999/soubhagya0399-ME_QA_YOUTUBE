package demo;

import org.openqa.selenium.WebElement;

public class WrapperMethods {
    public static void advanceSearch(String keyword,WebElement seachbox,WebElement searchclick){
        seachbox.sendKeys(keyword);
        searchclick.click();
    }
}
