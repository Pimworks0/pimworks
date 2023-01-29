package Testcase;

import java.io.IOException;

import static baselibrary.TestBase.getLocator;

public class testclass {

    public static void main(String[] args) throws IOException {
        System.out.println(getLocator().getProperty("Settings"));
    }
}
