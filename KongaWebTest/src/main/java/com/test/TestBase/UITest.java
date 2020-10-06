package com.test.TestBase;

import java.util.Date;
import java.util.List;

/**
*
* @author Shashi
*/

public class UITest {
    String Description;
    Date time;
    List<Result> resultList ;

    public void printResultToScreen()
    {
        for (Result rslt:resultList) {
            System.out.println(rslt.title+" "+rslt.status);
        }
    }
}
