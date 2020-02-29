package com.ienroll.tests;

public class DCBPOJO {
	private String EmpID;
	private String Password;
	private String EmailID;
	private String BSI;
	private String Bpremium;
	private String TopSI1Lac;
	private String TopPrem1Lac;
	
	private String Totaltop1Prem;
	private String TopSI2Lac;
	private String TopPrem2Lac;
	private String Totaltop2Prem;
	private String TopSI3Lac;
	
	private String TopPrem3Lac;
	private String Totaltop3Prem;
	private String TopSI4Lac;
	private String TopPrem4Lac;
	private String Totaltop4Prem;
	private String PilPremium;
	private String TotPILPremium;


	
	

	public String get3LacSumInsured() {
		return TopSI3Lac;
	}

	public void set3LacSumInsured(String topSI3Lac) 
	{
		TopSI3Lac = topSI3Lac;
	}

	public String get3LacPremium() {
		return TopPrem3Lac;
	}

	public void set3LacPremium(String topPrem3Lac) {
		TopPrem3Lac = topPrem3Lac;
	}

	
	
	public String get4LacSumInsured() {
		
		return TopSI4Lac ;
	}

	public void set4LacPremium(String topPrem4Lac) {
	
		TopPrem4Lac = topPrem4Lac;
	}

	public String get4LacPremium() {
		return TopPrem4Lac;
	}
	
	

	public void setEmpID(String empID) {
		// TODO Auto-generated method stub
		EmpID = empID;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		Password = password;
	}

	public void setSumInsured(String bSI) {
		// TODO Auto-generated method stub
		BSI = bSI;
	}

	
	public String getEmpID() {
		// TODO Auto-generated method stub
		return EmpID;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return Password;
	}

	public String getSumInsured() {
		// TODO Auto-generated method stub
		return BSI;
	}

	public String getPremium() {
		// TODO Auto-generated method stub
		return Bpremium;
	}

	public String get1LacSumInsured() {
		// TODO Auto-generated method stub
		return TopSI1Lac;
	}

	public String get1LacPremium() {
		// TODO Auto-generated method stub
		return TopPrem1Lac;
	}

	public String getTotalTop1LacPremium() {
		// TODO Auto-generated method stub
		return Totaltop1Prem;
	}

	public String get2LacSumInsured() {
		// TODO Auto-generated method stub
		return TopSI2Lac;
	}

	public String get2LacPremium() {
		// TODO Auto-generated method stub
		return TopPrem2Lac;
	}

	public String getTotalTop2LacPremium() {
		// TODO Auto-generated method stub
		return Totaltop2Prem;
	}

	public void setPremium(String bpremium) {
		// TODO Auto-generated method stub
		Bpremium = bpremium;
	}

	public void set1LacSumInsured(String topSI1Lac) {
		// TODO Auto-generated method stub
		TopSI1Lac = topSI1Lac;
	}

	public void set1LacPremium(String topPrem1Lac) {
		// TODO Auto-generated method stub
		TopPrem1Lac = topPrem1Lac;
	}

	public void set2LacSumInsured(String topSI2Lac) {
		// TODO Auto-generated method stub
		TopSI2Lac = topSI2Lac;
	}

	public void set2LacPremium(String topPrem2Lac) {
		// TODO Auto-generated method stub
		TopPrem2Lac = topPrem2Lac;
	}

	public void set4LacSumInsured(String topSI4Lac) {
		// TODO Auto-generated method stub
		TopSI4Lac = topSI4Lac;
	}

	public void setTotalTop1LacPremium(String totaltop1Prem) {
		// TODO Auto-generated method stub
		Totaltop1Prem = totaltop1Prem;
	}

	

	public void setTotalTop2LacPremium(String totaltop2Prem) {
		// TODO Auto-generated method stub
		Totaltop2Prem = totaltop2Prem;
	}

	public void setTotalTop3LacPremium(String totaltop3Prem) {
		// TODO Auto-generated method stub
		Totaltop3Prem = totaltop3Prem;
	}

	public void setTotalTop4LacPremium(String totaltop4Prem) {
		// TODO Auto-generated method stub
		Totaltop4Prem	 = totaltop4Prem;
	}

	public String getTotalTop3LacPremium() {
		// TODO Auto-generated method stub
		return Totaltop3Prem ;
	}

	public String getTotalTop4LacPremium() {
		// TODO Auto-generated method stub
		return Totaltop4Prem;
	}

	public String getPILPremium() {
		// TODO Auto-generated method stub
		return PilPremium;
	}

	public String getTotalPILPremium() {
		// TODO Auto-generated method stub
		return TotPILPremium;
	}

	public String getTopUpPILPremium() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPILPremium(String pilPremium) {
		// TODO Auto-generated method stub
		PilPremium = pilPremium;
	}

	public void setTotalPILPremium(String totPILPremium) {
		// TODO Auto-generated method stub
		TotPILPremium = totPILPremium;
	}

	public void setTopUpPILPremium(String cellData) {
		// TODO Auto-generated method stub
		
	}

	public String getTotalTopUpPILPremium() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTotalTopUpPILPremium(String cellData) {
		// TODO Auto-generated method stub
		
	}
}