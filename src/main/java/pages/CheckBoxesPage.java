package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class CheckBoxesPage {
    @FindBy(css = "[class='rct-icon rct-icon-expand-close']")
    private List<WebElement> chevronClosed;
    @FindBy(css = "[class='rct-icon rct-icon-expand-open']")
    private List<WebElement> chevronOpen;
    @FindBy(css = "[for='tree-node-home'] [class='rct-checkbox']")
    private WebElement home;
    @FindBy(css = "[title='Expand all']")
    private WebElement expandAll;
    @FindBy(css = "[title='Collapse all']")
    private WebElement collapseAll;
    @FindBy(css = "[class='rct-icon rct-icon-uncheck']")
    private List<WebElement> iconHome;

    @FindBy(css = "[class='rct-icon rct-icon-expand-open']")
    private List<WebElement> allExpandedChevrons;
    @FindBy(css = "[class='rct-icon rct-icon-expand-close']")
    private List<WebElement> allCollapsedChevrons;

    @FindBy(css = "[class='rct-icon rct-icon-check']")
    private List<WebElement> allIconsChecked;

    @FindBy(css = "[class='rct-checkbox'] svg")
    private List<WebElement> allCheckBoxes;


    public List<WebElement> getCloseChevrones() {
        return chevronClosed;
    }

    public void expandAll() {
        expandAll.click();
    }

    public void collapseAll() {
        collapseAll.click();
    }


    public void iconHome() {
        iconHome.get(0).click();
    }

    public boolean areAllCollapsed() {
        return allExpandedChevrons.size() == 0;
    }

    public boolean areAllExpanded() {
        return allCollapsedChevrons.size() == 0;
    }

    public boolean areAllChecked() {
        for (WebElement checkbox : allCheckBoxes) {
            if (checkbox.getAttribute("class").contains("uncheck")) {
                return false;
            }
        }
        return true;
    }

    public boolean isHomeHalfCheck() {
        for (int i = 1; i < allCheckBoxes.size(); i++) {
            WebElement checkBox = allCheckBoxes.get(i);
            if (checkBox.getAttribute("class").contains("uncheck") ||
                    checkBox.getAttribute("class").contains("half-check")) {
                return true;
            }
        }
        return false;
    }

    public void CheckOrHalfCheck() {
        Random random=new Random();
        int index = random.nextInt(9) + 1;
       allCheckBoxes.get(index).click();
            }
        }



