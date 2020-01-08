package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

    private WebDriver browser;
    private WebDriverWait wait;
    private Actions actions;

    private String xPathName=".//*[contains(@id, '_com_liferay_dynamic_data_mapping_form_web_portlet') and contains(@id, 'Nome')]";
    private String xPathDate="//div[@class='input-group input-group-container']/input";
    private String xPathText= ".//*[contains(@id, '_com_liferay_dynamic_data_mapping_form_web_portlet') and contains(@id, 'Porque')]";
    private String xPathButton="//button[@type='submit']";

    public FormPage(WebDriver browser){
        this.browser= browser;
    }

    public CompletePage completeForm(String name, String date, String text){

        browser.findElement(By.xpath(xPathName))
                .sendKeys(name);

        browser.findElement(By.xpath(xPathDate))
                .sendKeys(date);

        browser.findElement(By.xpath(xPathText))
                .sendKeys(text);

        //-------------Following commands to be used in low speed connections to wait for the Submit button to be enable---------
        //wait = new WebDriverWait(browser, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(browser.findElement(By.xpath("//button[@type='submit']"))));

        //---------- One Clicking--------------
        //browser.findElement(By.xpath(xPathButton))
          //      .click();

        //-------- Alternative Double Clicking ------------
        actions = new Actions (browser);
        actions.doubleClick(browser.findElement(By.xpath(xPathButton))).perform();

        return new CompletePage (browser);
    }

    public FormPage noNameForm(String date, String text){
        browser.findElement(By.xpath(xPathName))
                .click();

        browser.findElement(By.xpath(xPathDate))
                .sendKeys(date);

        browser.findElement(By.xpath(xPathText))
                .sendKeys(text);

        browser.findElement(By.xpath(xPathButton))
                .click();

        //-------------Following commands to be used in low speed connections to wait for the Submit button to be enable---------
        //wait = new WebDriverWait(browser, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(browser.findElement(By.xpath("//button[@type='submit']"))));

        //---------- One Clicking--------------
        //browser.findElement(By.xpath(xPathButton))
        //      .click();

        //-------- Alternative Double Clicking ------------
        actions = new Actions (browser);
        actions.doubleClick(browser.findElement(By.xpath(xPathButton))).perform();

        return this;
    }

    public FormPage noDateForm(String name, String text){


        browser.findElement(By.xpath(xPathName))
                .sendKeys(name);

        browser.findElement(By.xpath(xPathDate))
                .click();

        browser.findElement(By.xpath(xPathText))
                .sendKeys(text);

        //-------------Following commands to be used in low speed connections to wait for the Submit button to be enable---------
        //wait = new WebDriverWait(browser, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(browser.findElement(By.xpath("//button[@type='submit']"))));

        //---------- One Clicking--------------
        //browser.findElement(By.xpath(xPathButton))
        //      .click();

        //-------- Alternative Double Clicking ------------
        actions = new Actions (browser);
        actions.doubleClick(browser.findElement(By.xpath(xPathButton))).perform();

        return this;
    }

    public FormPage noTextForm(String name, String date){

        browser.findElement(By.xpath(xPathName))
                .sendKeys(name);

        browser.findElement(By.xpath(xPathDate))
                .sendKeys(date);

        browser.findElement(By.xpath(xPathText))
               .click();

        //-------------Following commands to be used in low speed connections to wait for the Submit button to be enable---------
        //wait = new WebDriverWait(browser, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(browser.findElement(By.xpath("//button[@type='submit']"))));

        //---------- One Clicking--------------
        //browser.findElement(By.xpath(xPathButton))
        //      .click();

        //-------- Alternative Double Clicking ------------
        actions = new Actions (browser);
        actions.doubleClick(browser.findElement(By.xpath(xPathButton))).perform();

        return this;
    }


}
