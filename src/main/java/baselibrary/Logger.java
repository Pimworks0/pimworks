package baselibrary;

import org.testng.Reporter;

public class Logger {

	public void info(String message) {
		Reporter.log("<b style=\"color:blue\"> INFO : </b>" + message);
		System.out.println("INFO: " + message);
	}

	public void pass(String message) {
		Reporter.log("<b style=\"color:green\"> PASS : </b>" + message);
		System.out.println("PASS: " + message);
	}

	public void fail(String message) {
		Reporter.log("<b style=\"color:red\"> FAIL : </b>" + message);
		System.out.println("FAIL: " + message);
	}

	public void warn(String message) {
		Reporter.log("<b style=\"color:yellow\"> WARN : </b>" + message);
		System.out.println("WARNING: " + message);
	}

}
