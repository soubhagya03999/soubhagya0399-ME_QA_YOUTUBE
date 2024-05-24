package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases {
    static ChromeDriver driver;

    @BeforeSuite(alwaysRun = true)
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    

    @Test(priority = 1,description = "Go to YouTube.com and Assert you are on the correct URL. Click on ABOUT at the bottom of the sidebar, and print the message on the screen.",enabled = true)
    public static void TestCase01(){
        try {
            //STEP-01:open you tube
            YouTubeMethods.openYouTube(driver);
            //STEP-02:using hard assert to check URL contains youtube or not 
            Assert.assertTrue(YouTubeMethods.verifyYouTubeURL(driver));
            //STEP-03:click on about
            YouTubeMethods.clickOnAbout(driver);
            //STEP-04:print message on the screen as per the given requirement in document
            YouTubeMethods.printMessageOnAboutPage(driver);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test(priority = 2,description = "Go to the Films tab and in the Top Selling section, scroll to the extreme right. Apply a Soft Assert on whether the movie is marked A for Mature or not. Apply a Soft assert on whether the movie is either Comedy or Animation.",enabled = true)
    public static void TestCase02(){
        try {
            //STEP-01:open you tube
            YouTubeMethods.openYouTube(driver);
            //STEP-02:click on movies tab
            YouTubeMethods.selectTheExploreTabs(driver, "Movies");
            //STEP-03:scroll to extreme right
            YouTubeMethods.scrollToTheExtremeRight(driver,"Movies");
            //STEP-04:create the instance of soft assert
            SoftAssert softAssert = new SoftAssert();
            //STEP-05:verify the movie marked as A or not
            softAssert.assertTrue(YouTubeMethods.verifyMovieMarkedForMature(driver, "A"));
            //STEP-06:verify the movie types
            softAssert.assertTrue(YouTubeMethods.verifyMovieTypesWithORCondition(driver, "Comedy", "Animation"));
            //STEP-07:final check with assert with all the conditions
            softAssert.assertAll();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    @Test(priority = 3,description = "Go to the Music tab and in the 1st section, scroll to the extreme right. Print the name of the playlist. Soft Assert on whether the number of tracks listed is less than or equal to 50.",enabled = true)
    public static void TestCase03(){
        try {
             //STEP-01:open you tube
             YouTubeMethods.openYouTube(driver);
             //STEP-02:go to music tab
             YouTubeMethods.selectTheExploreTabs(driver, "Music");
             //STEP-03:scroll to the extreme right
             YouTubeMethods.scrollToTheExtremeRight(driver,"Music");
             //STEP-04:print the name of the playlist
             YouTubeMethods.printPlaylistOfMusicFirstSectionExtreamRight(driver);
             //STEP-05:create the instance of soft assert
             SoftAssert softAssert = new SoftAssert();
             //STEP-06:Soft Assert on whether the number of tracks listed is less than or equal to 50
             softAssert.assertTrue(YouTubeMethods.verifyTracksListedIsLessThanOrEqualToTheSpecificNumberForMusicFirstSectionExtreamRight(driver, 50));
             //STEP-07:final check with assert with all the conditions
             softAssert.assertAll();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test(priority = 4,description = "\tGo to News tab and print the title and body of the 1st 3 Latest News Posts along with the sum of number of likes on all 3 of them. No likes given means 0.",enabled = true)
    public static void TestCase04(){
        try {
             //STEP-01:open you tube
            YouTubeMethods.openYouTube(driver);
             //STEP-02:click on news tab
            YouTubeMethods.selectTheExploreTabs(driver, "News");
             //STEP-03:print the latest 3 title and body of nes
            YouTubeMethods.printTheTitleAndBodyOfLatestNewsPostsOfFirstThree(driver, 3);
             //STEP-04:print sum of all likes of those 3 news having
            YouTubeMethods.sumOfNumberOfLikesOnNumberOfNewsOnLatestNewsPosts(driver, 3);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test(priority = 5,description = "Search for each of the items given in this excel sheet, and keep scrolling till the sum of each video views reach 10 Cr.",enabled = true,dataProvider = "search",dataProviderClass = ExcelUtils.class)
    public static void TestCase05(String keyword){
        try {
            //STEP-01:open you tube
            YouTubeMethods.openYouTube(driver);
            //STEP-02: Search for each of the items given in this excel sheet, and keep scrolling till the sum of each video views reach 10 Cr.
            YouTubeMethods.searchAndKeepScrollingTillTheSumOfEachVideoViewsReachTheLimit(driver, keyword, 100000000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @AfterSuite(alwaysRun = true)
    public static void closeBrowser(){
       driver.quit(); 
    }
}
