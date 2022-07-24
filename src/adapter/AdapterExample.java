package adapter;
interface IWebDriver {
    public void getElement();
    public void selectElement();
}

class ChromeDriver implements IWebDriver {

    @Override
    public void getElement() {
        System.out.println("Get element from Chrome Driver..");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from Chrome Driver..");
    }
}

class FireFoxDriver {

    public void findElement() {
        System.out.println("Get element from firefox driver..");
    }

    public void clickElement() {
        System.out.println("Select element from firefox driver..");
    }
}

class FireFoxDriverAdapter implements IWebDriver{
    FireFoxDriver fireFoxDriver;
    public FireFoxDriverAdapter(FireFoxDriver fireFoxDriver){
        this.fireFoxDriver = fireFoxDriver;
    }

    @Override
    public void getElement() {
        this.fireFoxDriver.findElement();
    }

    @Override
    public void selectElement() {
        this.fireFoxDriver.clickElement();
    }
}
public class AdapterExample {
    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();
        FireFoxDriver fireFoxDriver = new FireFoxDriver();
        FireFoxDriverAdapter fireFoxDriverAdapter = new FireFoxDriverAdapter(fireFoxDriver);
        fireFoxDriverAdapter.getElement();
        fireFoxDriverAdapter.selectElement();
    }
}
