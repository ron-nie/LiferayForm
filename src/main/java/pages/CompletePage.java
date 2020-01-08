package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CompletePage {

    private WebDriver browser;

    public CompletePage(WebDriver browser){
        this.browser= browser;
    }

    public CompletePage confirmForm(){
        String textconfirm =
                browser.findElement(By.xpath("//*[contains (text(), 'sucesso')]"))
                .getText();

        return this;
    }
}
