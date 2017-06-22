package model;

public class ReturnResult {
	//·µ»ØÊý¾Ýmodel
	public String judge;
	public Object[][] result;
	public String errorReport;
	
	public ReturnResult(String judge, Object[][] res, String errorReport)
	{
		this.judge = judge;
		this.result = res;
		this.errorReport = errorReport;
	}
	
}
