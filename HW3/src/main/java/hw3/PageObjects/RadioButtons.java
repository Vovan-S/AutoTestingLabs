package hw3.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RadioButtons implements SelectableElement, PageComponent {
    @FindBy(xpath = "//main//input[@type='radio']")
    List<WebElement> radios;
    List<ClickableElement> radioElements;

    @Override
    public void select(int what) {
        radioElements.get(what).select(0);
    }

    @Override
    public boolean isSelected() {
        for (ClickableElement clickableElement : radioElements) {
            if (clickableElement.isSelected()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isVisible() {
        for (ClickableElement clickableElement : radioElements) {
            if (!clickableElement.isVisible()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getText() {
        StringBuilder builder = new StringBuilder();
        for (ClickableElement element : radioElements) {
            builder.append(element.getText()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
        radioElements = new ArrayList<>(radios.size());
        for(WebElement webElement: radios) {
            radioElements.add(new ClickableElement(webElement));
        }
    }
}
