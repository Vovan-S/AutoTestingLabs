package hw2;

import hw2.ex1.Exercise1;
import hw2.ex2.Exercise2;

public class Temp {
    public static void main(String[] args) throws InterruptedException {
        Exercise2 e = new Exercise2();
        try {
            e.initDriver();
            e.openPage();
            e.login();
            //e.headerTest();
            //e.iconsTest();
            //e.textTest();
            //e.iFrameTest();
            e.elementsPage();
            //e.elementsExist();
            e.clickElements();
            Thread.sleep(5000);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            e.closeDriver();
        }
    }
}
