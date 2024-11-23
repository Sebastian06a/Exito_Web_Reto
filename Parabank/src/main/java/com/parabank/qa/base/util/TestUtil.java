package com.parabank.qa.base.util;

import org.openqa.selenium.By;
import com.parabank.qa.base.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT =20;
    public static long IMPLICIT_WAIT =10;

    public void switchToFrame(){
        //driver.switchTo().frame("no hay frame");
       String dd = (driver.findElement(By.className("smallText")).getText());
      // System.out.println("validando el nombre de usuario::"+dd);
    }

    public void switchToTableFrame(){
       String aa = (driver.findElement(By.className("accountTable")).getText());
      // System.out.println("validando el nombre de usuario::"+dd);
    }
}
