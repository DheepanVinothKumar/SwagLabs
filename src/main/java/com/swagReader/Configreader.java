package com.swagReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {

	FileInputStream fis;

	public Properties ConfigFile() {
		File f = new File(
				"C:\\Users\\mvion\\eclipse-workspace\\SwagLabs\\src\\main\\java\\com\\swagProperties\\Login.Properties");
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	public String getbrowser() {
		String browser = ConfigFile().getProperty("browser");
		return browser;
	}

	public String geturl() {
		String url = ConfigFile().getProperty("url");
		return url;
	}

	public String getusername() {
		String username = ConfigFile().getProperty("username");
		return username;
	}

	public String getusername2() {
		String username2 = ConfigFile().getProperty("username2");
		return username2;
	}

	public String getpassword() {
		String password = ConfigFile().getProperty("password");
		return password;
	}

	public String getpassword2() {
		String password2 = ConfigFile().getProperty("password2");
		return password2;
	}

	public String gethome() {
		String home = ConfigFile().getProperty("home");
		return home;
	}

	public String geterror() {
		String error = ConfigFile().getProperty("error");
		return error;
	}

	public String getfirstname1() {
		String firstname1 = ConfigFile().getProperty("firstname1");
		return firstname1;
	}

	public String getlastname1() {
		String lastname1 = ConfigFile().getProperty("lastname1");
		return lastname1;
	}

	public String getpostalcode1() {
		String postalcode1 = ConfigFile().getProperty("postalcode1");
		return postalcode1;
	}

	public String getfirstname2() {
		String firstname2 = ConfigFile().getProperty("firstname2");
		return firstname2;
	}

	public String getlastname2() {
		String lastname2 = ConfigFile().getProperty("lastname2");
		return lastname2;
	}

	public String getpostalcode2() {
		String postalcode2 = ConfigFile().getProperty("postalcode2");
		return postalcode2;
	}

	public String getfirstname3() {
		String firstname3 = ConfigFile().getProperty("firstname3");
		return firstname3;
	}

	public String getlastname3() {
		String lastname3 = ConfigFile().getProperty("lastname3");
		return lastname3;
	}

	public String getpostalcode3() {
		String postalcode3 = ConfigFile().getProperty("postalcode3");
		return postalcode3;
	}

	public String getfirstname4() {
		String firstname4 = ConfigFile().getProperty("firstname4");
		return firstname4;
	}

	public String getlastname4() {
		String lastname4 = ConfigFile().getProperty("lastname4");
		return lastname4;
	}

	public String getpostalcode4() {
		String postalcode4 = ConfigFile().getProperty("postalcode4");
		return postalcode4;
	}

	public String getfirstname5() {
		String firstname5 = ConfigFile().getProperty("firstname5");
		return firstname5;
	}

	public String getlastname5() {
		String lastname5 = ConfigFile().getProperty("lastname5");
		return lastname5;
	}

	public String getpostalcode5() {
		String postalcode5 = ConfigFile().getProperty("postalcode5");
		return postalcode5;
	}

}
