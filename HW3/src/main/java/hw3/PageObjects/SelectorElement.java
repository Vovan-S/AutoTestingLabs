package hw3.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SelectorElement implements SelectableElement, PageComponent {
    @FindBy(xpath = "//main//select")
    WebElement selector;

    @Override
    public void select(int what) {
        selector.click();
        List<WebElement> list = selector.findElements(By.tagName("option"));
        list.get(what).click();
    }

    @Override
    public boolean isSelected() {
        return true;
    }

    @Override
    public boolean isVisible() {
        return selector.isDisplayed();
    }

    @Override
    public String getText() {
        return selector.getText();
    }

    public List<String> optionTexts() {
        List<WebElement> options = selector.findElements(By.tagName("option"));
        List<String> res = new ArrayList<>(options.size());
        for(WebElement option: options) {
            res.add(option.getText());
        }
        return res;
    }

    @Override
    public void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
