package page;

import help.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DressesPage {
    private WebDriver driver;

    public DressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]")
    private WebElement sliderOne;

    @FindBy(xpath = "//label[@for='price']")
    private WebElement click;

    public void canRangOne() {
        NewHelper.waitUnEl();
        Actions moveSlider = new Actions(driver);
        Actions action = moveSlider.dragAndDropBy(sliderOne, 50, 0); //25.62
        action.perform();
    }

    @FindBy(xpath = "(//a[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]")
    private WebElement sliderTwo;


    public void canRangTwo() {
        Actions moveSlider = new Actions(driver);
        Actions action = moveSlider.dragAndDropBy(sliderTwo, -40, 0); //44.86
        action.perform();
    }

    public void canRang() {
        canRangOne();
        click.click();
        canRangTwo();
        click.click();
    }

    public void addOrder() {  //тех.долг, оптимизировать
        NewHelper.waitUnEl();
        NewHelper.waitUnEl();
        WebElement nameProductOne = driver.findElement(By.xpath("(//h5[@itemprop='name'])[1]"));
        WebElement nameProductTwo = driver.findElement(By.xpath("(//h5[@itemprop='name'])[2]"));
        WebElement nameProductThree = driver.findElement(By.xpath("(//h5[@itemprop='name'])[3]"));
        WebElement nameProductFour = driver.findElement(By.xpath("(//h5[@itemprop='name'])[4]"));
        WebElement nameProductFive = driver.findElement(By.xpath("(//h5[@itemprop='name'])[5]"));
        WebElement nameProductSix = driver.findElement(By.xpath("(//h5[@itemprop='name'])[6]"));
        WebElement nameProductSeven = driver.findElement(By.xpath("(//h5[@itemprop='name'])[7]"));
        WebElement nameSale = driver.findElement(By.xpath("(//span[@class='price-percent-reduction'])[3]"));

        if (nameProductThree.getText().contains("Dress") ) {
            driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[3]")).click();
            NewHelper.waitUnEl();
            driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        } else{
            driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[4]")).click();
            NewHelper.waitUnEl();
            driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

        }if (nameSale.getText().contains("-5") ) {
            driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[5]")).click();
            NewHelper.waitUnEl();
            driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        }

//            if (nameProductTwo.getText().contains("Dress") ) {
//                driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[2]")).click();
//                NewHelper.waitUnEl();
//                driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
//            }
//
//            if (nameProductThree.getText().contains("Dress") ) {
//
//                driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[3]")).click();
//                NewHelper.waitUnEl();
//                driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
//            }
//
//            if (nameProductFour.getText().contains("Dress") ) {
//                driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[4]")).click();
//                NewHelper.waitUnEl();
//                driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
//            }
//
//            if (nameProductFive.getText().contains("Dress") ) {
//                driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[5]")).click();
//                NewHelper.waitUnEl();
//                driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
//            }
//
//            if (nameProductSix.getText().contains("Dress") ) {
//                driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[6]")).click();
//                NewHelper.waitUnEl();
//                driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
//            }
//
//            if (nameProductSeven.getText().contains("Dress") ) {
//                driver.findElement(By.xpath("(//div[@class='product-container']//a[@title='Add to cart'])[7]")).click();
//                NewHelper.waitUnEl();
//                driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
//            }

    }

    @FindBy(xpath = "(//td[@class='cart_total'])[1]")
    private int priceOne;

    @FindBy(xpath = "(//td[@class='cart_total'])[1]")
    private int priceTwo;

    public void deleteOrder() {
        if (priceOne < priceTwo ) {
            driver.findElement(By.xpath("(//a[@title='Delete'])[1]")).click();
        } else {
            driver.findElement(By.xpath("(//a[@title='Delete'])[2]")).click();
        }
    }
    public String getPrise(){
        return driver.findElement(By.xpath("//td[@class='cart_total']")).getText();
    }
    public String getTotalProducts(){
        NewHelper.waitUnEl();
        return driver.findElement(By.xpath("//td[@id='total_product']")).getText();
    }

    public void endOrder(){
        canRang();
        addOrder();
        deleteOrder();
    }

}




