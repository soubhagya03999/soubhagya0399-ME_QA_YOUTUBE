package demo;

import java.time.Duration;
import java.util.*;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeMethods {
    static ChromeDriver driver;
    static String url="https://www.youtube.com/";
    
    public static void openYouTube(ChromeDriver driver){
        try {
            driver.get(url);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static boolean verifyYouTubeURL(ChromeDriver driver){
        try {
            boolean status;
            if (driver.getCurrentUrl().equals(url)) {
                status=true;
            } else {
                status=false;
            }
            return status;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static void clickOnAbout(ChromeDriver driver){
        try {
            WebElement aboutButton=driver.findElement(By.xpath("//a[text()='About']"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", aboutButton);
            aboutButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://about.youtube/"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void printMessageOnAboutPage(ChromeDriver driver){
        try {
            WebElement elem1 = driver.findElement(By.xpath("//h1[contains(text(),'About YouTube')]"));
            WebElement elem2 = driver.findElement(By.xpath("//p[contains(text(),'Our mission is to give everyone a voice and show them the world.')]"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", elem2);
            System.out.println(elem1.getText());
            System.out.println(elem2.getText());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void scrollToTheExtremeRight(ChromeDriver driver,String selection){
        try {
            if (selection.equalsIgnoreCase("Movies") || selection.equalsIgnoreCase("film")) {
                WebElement nextButton = driver.findElement(By.xpath("//button[@aria-label='Next']"));
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView();", nextButton);
                while (nextButton.isDisplayed()) {
                    nextButton.click();
                }
            }else if (selection.equalsIgnoreCase("Music")) {
                WebElement nextButton = driver.findElement(By.xpath("(//button[@aria-label='Next'])[1]"));
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,350)", "");
                Thread.sleep(6000);
                Thread.sleep(5000);
                while (nextButton.isDisplayed()) {
                    nextButton.click();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void selectTheExploreTabs(ChromeDriver driver,String tab){
    try {
        WebElement Exploretab = driver.findElement(By.xpath("//yt-formatted-string[text()='"+tab+"']"));
        Exploretab.click();
        
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
    }
    public static boolean verifyMovieMarkedForMature(ChromeDriver driver,String mark){
        try {
            boolean status;
            WebElement sign = driver.findElement(By.xpath("(//p[text()='"+mark+"'])[3]"));
            if (sign.getText().contains(mark)) {
                status=true;
            }else{
                status=false;
            }
            return status;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean verifyMovieTypesWithORCondition(ChromeDriver driver,String type1,String type2){
        try {
            boolean status;
            WebElement t1=driver.findElement(By.xpath("(//span[contains(text(),'"+type1+"')])[3]"));
            if (t1.getText().contains(type1)){
                status =true;
            }else{
                status=false;
            }
            return status;
        } catch (NoSuchElementException e) {
            try {
                boolean status;
                WebElement t2=driver.findElement(By.xpath("(//span[contains(text(),'"+type2+"')])[3]"));
                if (t2.getText().contains(type2)){
                    status=true;
                }else{
                    status=false;
                }
                return status;
            } catch (Exception f) {
                // TODO: handle exception
                f.printStackTrace();
                return false;
            }
        }
    }

    public static void printPlaylistOfMusicFirstSectionExtreamRight(ChromeDriver driver){
        try {
            WebElement playlist = driver.findElement(By.xpath("(//h3[contains(@class,'compact-station-renderer')])[11]"));
            System.out.println("1.Print the name of the playlist:"+playlist.getText());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static boolean verifyTracksListedIsLessThanOrEqualToTheSpecificNumberForMusicFirstSectionExtreamRight(ChromeDriver driver,int count){
        try {
            boolean status;
            WebElement music = driver.findElement(By.xpath("(//p[@id='video-count-text'])[11]"));
            String[] arr= music.getText().split(" ");
            if (Integer.parseInt(arr[0])<=count) {
                status=true;
            } else {
                status=false;
            }
            return status;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static void printTheTitleAndBodyOfLatestNewsPostsOfFirstThree(ChromeDriver driver,int count){
        try {
            WebElement elem = driver.findElement(By.xpath("//span[text()='Latest news posts']"));
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", elem);
            List<WebElement> elem1= driver.findElements(By.xpath("(//a[@id='author-text'])"));
            int size=1;
            for (WebElement webElement : elem1) {
                System.out.println("print the title of first "+count+" news:"+webElement.getText());
                System.out.println();
                if (size==count) {
                    break;
                }else{
                    size++;
                }
            }
            List<WebElement> elem2=driver.findElements(By.xpath("(//yt-formatted-string[@id='home-content-text'])"));
            int size1=1;
            for (WebElement webElement : elem2) {
                System.out.println("print the body of first "+count+" news:"+webElement.getText());
                System.out.println();
                if (size1==count) {
                    break;
                }else{
                    size1++;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void sumOfNumberOfLikesOnNumberOfNewsOnLatestNewsPosts(ChromeDriver driver,int count){
        try {
            List<WebElement> l1=driver.findElements(By.xpath("//span[@id='vote-count-middle']"));
            int size =1;
            int sum=0;
            for (WebElement webElement : l1) {
                if (!webElement.isDisplayed()) {
                    continue;
                 }else{
                    sum=sum+Integer.parseInt(webElement.getText().replaceAll("[^0-9]", ""));
                 }
                 if (size==count) {
                    break;
                 }
                size++;
            }
            System.out.println("print the sum of numbers of likes on "+count+" News:"+sum);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void searchAndKeepScrollingTillTheSumOfEachVideoViewsReachTheLimit(ChromeDriver driver,String searchKeyword,double limit){
        WebElement searchb = driver.findElement(By.xpath("//input[@id='search']"));
        WebElement searchc =driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]"));
        WrapperMethods.advanceSearch(searchKeyword, searchb, searchc);
        List<WebElement> list1 = driver.findElements(By.xpath("//ytd-video-renderer[1]/div[1]/div/div[1]/ytd-video-meta-block/div[1]/div[2]/span[1]"));
        double sum =0;
        for (WebElement webElement : list1) {
            String[] arr = webElement.getText().split(" ");
            if (arr[0].contains("M")) {
                String[] arr1= arr[0].split("M");
                double value = Double.parseDouble(arr1[0]) * 0.1;
                double crore = value * 10000000;
                sum = sum + crore;
                if (sum>=limit) {
                    break;
                }
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView();",webElement);
            }
            if (arr[0].contains("K")) {
                String[] arr1= arr[0].split("K");
                double value = Double.parseDouble(arr1[0]);
                double crore = value * 1000;
                sum = sum + crore;
                if (sum>=limit) {
                    break;
                }
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView();",webElement);
            }
        }
    }
}
