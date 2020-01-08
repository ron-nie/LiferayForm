package testing;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import suporte.Generator;
import suporte.Screenshots;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths= "UserInfoComplete.csv")

public class UserInfo {

    private WebDriver browser;
    private String xPathError="//*[contains (text(), 'This field is required.')]";

    @Rule
    public TestName test = new TestName();
    private String screens = "C:\\Users\\ronni\\IdeaProjects\\test-report\\"+ Generator.datetimefile()+test.getMethodName()+".png";

    @Before
    public void setUp(){
        browser = Web.createChrome();
    }

    @Test
    public void verifyText(){
        new FormPage(browser);

        String textconfirm =
                browser.findElement(By.xpath("//*[contains (text(), 'party rock')]"))
                        .getText();

        Screenshots.shot(browser,screens);
    }

    @Test
    public void addUserInfoComplete(){
        new FormPage(browser)
                .completeForm("R", "12/12/2012", "Olá");

        String textconfirm =
                browser.findElement(By.xpath("//*[contains (text(), 'sucesso')]"))
                        .getText();

        Screenshots.shot(browser,screens);
        assertEquals("Informações enviadas com sucesso!", textconfirm);
    }

    @Test
    public void addMultipleUserInfoComplete
            (@Param(name="name")String name, @Param(name="date")String date, @Param(name="text")String text){

        new FormPage(browser)
                .completeForm(name, date, text);

        String textconfirm =
                browser.findElement(By.xpath("//*[contains (text(), 'sucesso')]"))
                        .getText();

        assertEquals("Informações enviadas com sucesso!", textconfirm);
        Screenshots.shot(browser,screens);
    }

    @Test
    public void addUserInfoMissingName(){
        new FormPage(browser)
                .noNameForm("12/12/2012", "Olá");

        String textconfirm =
                browser.findElement(By.xpath(xPathError))
                        .getText();

        assertEquals("This field is required.", textconfirm);
        Screenshots.shot(browser,screens);

    }

    @Test
    public void addUserInfoMissingDate(){
        new FormPage(browser)
                .noDateForm("R", "Olá");

        String textconfirm =
                browser.findElement(By.xpath(xPathError))
                        .getText();

        assertEquals("This field is required.", textconfirm);
        Screenshots.shot(browser,screens);

    }

    @Test
    public void addUserInfoMissingText(){
        new FormPage(browser)
                .noTextForm("R", "12/12/2012");

        String textconfirm =
                browser.findElement(By.xpath(xPathError))
                        .getText();

        assertEquals("This field is required.", textconfirm);
        Screenshots.shot(browser,screens);

    }

    @After
    public void tearDown(){
        //navegador.quit();
    }
}
