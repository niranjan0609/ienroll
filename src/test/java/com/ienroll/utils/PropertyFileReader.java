package com.ienroll.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 

public class PropertyFileReader {
 
    private static PropertyFileReader instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\test\\java\\resources\\config.properties";
    private static String username;
    private static String password;
    private static String adminURL;
    private static String invalidusername;
    private static String usernameToSearch;
    private static String countryCode;
    private static String mobileNo;
    private static String changeEmailID;
    private static String usernameToReset;
    private static String companyName;
    private static String enrollFrom;
    private static String enrollTo;
    private static String companyNameDep;
    private static String lotNo;
    private static String companyNameBulk;
    private static String lotNoBulk;
    private static String emailType;
    private static String changeName;
    private static String changeDay;
    private static String changeMon;
    private static String changeYear;
    private static String changeRelationship;
    private static String enterRemarks;
    private static String xlFilePath;
    
 
    //Create a Singleton instance. We need only one instance.
    public static PropertyFileReader getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyFileReader();
                instance.loadData();
            }
        }
        return instance;
    }
 
    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        //Get properties from configuration.properties
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        adminURL = prop.getProperty("adminURL");
        invalidusername = prop.getProperty("invalidusername");
        usernameToSearch = prop.getProperty("usernameToSearch");
        countryCode = prop.getProperty("countryCode");
        mobileNo = prop.getProperty("mobileNo");
        changeEmailID = prop.getProperty("EmailID");
        usernameToReset = prop.getProperty("UsernameToReset");
        companyName = prop.getProperty("companyName");
        enrollFrom = prop.getProperty("enrollFrom");
        enrollTo = prop.getProperty("enrollTo");
        companyNameDep = prop.getProperty("companyNameDep");
        lotNo = prop.getProperty("lotNo");
        companyNameBulk = prop.getProperty("companyNameBulk");
        lotNoBulk = prop.getProperty("lotNoBulk");
        emailType = prop.getProperty("emailType");
        changeName = prop.getProperty("changeName");
        changeDay = prop.getProperty("changeDay");
        changeMon = prop.getProperty("changeMon");
        changeYear = prop.getProperty("changeYear");
        changeRelationship = prop.getProperty("chnageRelationship");
        enterRemarks = prop.getProperty("enterRemarks");
        xlFilePath = prop.getProperty("xlFilePath");
    }
 
    public String getUsername () {
        return username;
    }
    
    public String getInvalidUsername () {
        return invalidusername;
    }
    public String getPassword () {
        return password;
    }
    
    public String getUserNameToSearch () {
        return usernameToSearch;
    }
    
    public String getAdminURL () {
        return adminURL;
    }

	public String getCountryCode() {
		// TODO Auto-generated method stub
		return countryCode;
	}

	public String getMobileNo() {
		// TODO Auto-generated method stub
		return mobileNo;
	}

	/*public String getEmailID() {
		// TODO Auto-generated method stub
		return changeEmailID;
	}*/

	public String getUserNameToReset() {
		// TODO Auto-generated method stub
		return usernameToReset;
	}

	public String getEmailID() {
		// TODO Auto-generated method stub
		return changeEmailID;
	}

	public String getCompanyName() {
		// TODO Auto-generated method stub
		return companyName;
	}

	public String getenrollFromDate() {
		// TODO Auto-generated method stub
		return enrollFrom;
	}

	public String getenrollToDate() {
		// TODO Auto-generated method stub
		return enrollTo;
	}

	public String getCompanyNameDep() {
		// TODO Auto-generated method stub
		return companyNameDep;
	}

	public String getlotNo() {
		// TODO Auto-generated method stub
		return lotNo;
	}

	public String getCompanyNameBulk() {
		// TODO Auto-generated method stub
		return companyNameBulk;
	}

	public String getlotNoBulk() {
		// TODO Auto-generated method stub
		return lotNoBulk;
	}

	public String getEmailType() {
		// TODO Auto-generated method stub
		return emailType;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return changeName;
	}

	public String getDayDOB() {
		// TODO Auto-generated method stub
		return changeDay;
	}

	public String getMOnDOB() {
		// TODO Auto-generated method stub
		return changeMon;
	}

	public String getYearDOB() {
		// TODO Auto-generated method stub
		return changeYear;
	}

	public String getRelationship() {
		// TODO Auto-generated method stub
		return changeRelationship;
	}

	public String getRemarks() {
		// TODO Auto-generated method stub
		return enterRemarks;
	}

	public String getExcelFile() {
		// TODO Auto-generated method stub
		return xlFilePath;
	}
}