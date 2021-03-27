package hw3;

import hw3.PageObjects.HomePage;
import hw3.Util.PropertiesHandler;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class StepDefinitions {
    WebDriver driver;
    HomePage page;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", "I:/distr/chromedriver89/chromedriver.exe");
                //PropertiesHandler.getProperty("driver.path"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Given("I'm opened homepage")
    public void openHomepage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        page = new HomePage(driver);
    }

    @Given("I'm logged as {word} - {word}")
    public void login(String username, String password) {
        page.login(username, password);
    }

    @Then("Browser title is {string}")
    public void assertTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Then("Username is {string}")
    public void assertUsername(String username) {
        Assert.assertEquals(page.getText(HomePage.Element.Username),
                username);
    }

    @Then("I see {int} {}")
    public void assertVisible(int number, String what) {
        HomePage.ElementList list;
        if (what.equals("images")) list =  HomePage.ElementList.BenefitIcons;
        else if (what.equals("texts")) list = HomePage.ElementList.BenefitTexts;
        else if (what.equals("header items")) list = HomePage.ElementList.Header;
        else {
            System.out.println("Wrong item: " + what);
            return;
        }
        /*HomePage.ElementList list = switch (what) {
            case "images" -> HomePage.ElementList.BenefitIcons;
            case "texts"  -> HomePage.ElementList.BenefitTexts;
            case "header items" -> HomePage.ElementList.Header;
            default -> null;
        };*/
        Assert.assertEquals(page.elementListSize(list),
                number);
        Assert.assertTrue(page.isDisplayed(list));
    }

    @Then("Header labels are proper")
    public void assertHeaderLabels() {
        SoftAssert softAssert = new SoftAssert();
        List<String> labels = page.getText(HomePage.ElementList.Header);
        String[] expected = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int i = 0; i < 4; i++) {
            softAssert.assertEquals(labels.get(i), expected[i]);
        }
        softAssert.assertAll();
    }

    @Then("Text blocks have proper text")
    public void assertBlockText() {
        SoftAssert softAssert = new SoftAssert();
        String[] expected = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        };
        List<String> labels = page.getText(HomePage.ElementList.BenefitTexts);
        for (int i = 0; i < 4; i++) {
            softAssert.assertEquals(labels.get(i), expected[i]);
        }
        softAssert.assertAll();
    }

    @Then("I see {string} as main header")
    public void assertHeader(String text) {
        Assert.assertEquals(page.getText(HomePage.Element.Title), text);
    }

    @Then("I see {string} as text below")
    public void assertText(String text) {
        if (text.equals("Lorem ipsum"))
            text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        Assert.assertEquals(page.getText(HomePage.Element.Text), text.toUpperCase());
    }

    @When("I switch to iFrame")
    public void switchToIFrame() {
        page = page.openIFrame(driver);
    }

    @Then("I see the {}")
    public void assertVisible(String what) {
        HomePage.Element element;
        if (what.equals("EPAM logo")) element =  HomePage.Element.Logo;
        else if (what.equals("left section")) element = HomePage.Element.LeftPanel;
        else if (what.equals("footer")) element = HomePage.Element.Footer;
        else {
            System.out.println("Wrong item: " + what);
            return;
        }
        Assert.assertTrue(page.isDisplayed(element));
    }

    @Then("I see {string} as sub header")
    public void assertSubHeader(String text) {
        Assert.assertEquals(page.getText(HomePage.Element.SubTitle), text);
    }

    @Then("The hyperref is proper")
    public void assertHref() {
        Assert.assertEquals(page.getHRef(HomePage.Element.SubTitle),
                "https://github.com/epam/JDI");
    }

}
