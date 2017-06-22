package util;

import java.util.ArrayList;

import model.Book;
import model.ReturnResult;
import model.User;

public class Parser {
	//把数据处理成特定的格式
	public String judge;
	public Object[][] result;
	public String errorReport;
	
	public ReturnResult getAddBookResult(String returnStr){
		
		//返回的returnStr形式：
		//success:id1,bookname1,author1,price1&id2,bookname2,author2,price2...
		//或者: error:why?
		judge = returnStr.split(":")[0];
		ReturnResult res = new ReturnResult(judge,result,errorReport);
		return res;
	}
	
	public ReturnResult getDeleteBookResult(String returnStr){
		judge = returnStr.split(":")[0];
		ReturnResult res = new ReturnResult(judge,result,errorReport);
		return res;
	}
	
	public ReturnResult getChangeBookResult(String returnStr){
		judge = returnStr.split(":")[0];
		ReturnResult res = new ReturnResult(judge,result,errorReport);
		return res;
	}
	
	public ReturnResult clearResult(String returnStr){
		judge = returnStr.split(":")[0];
		ReturnResult res = new ReturnResult(judge,result,errorReport);
		return res;
	}
	
	public ReturnResult getSelectBookResult(String returnStr){
		judge = returnStr.split(":")[0];
		if(judge.equals("success"))
		{
			errorReport = null;
			String[] temp = returnStr.split(":")[1].split("&");
			result = new Object[temp.length][4];
			for(int i = 0; i < temp.length; i++)
			{
				result[i][0] = temp[i].split(",")[0]; //id
				result[i][1] = temp[i].split(",")[1]; //bookname
				result[i][2] = temp[i].split(",")[2]; //author
				result[i][3] = temp[i].split(",")[3]; //price
			}
		}
		else if(judge.equals("error"))
		{
			errorReport = returnStr.split(":")[1];
			result = null;
		}
		else
		{
			System.out.println("发生未知错误！");
		}
		
		ReturnResult res = new ReturnResult(judge,result,errorReport);
		return res;
	}
	
	public ReturnResult findAllResult(String returnStr){
		judge = returnStr.split(":")[0];
		if(judge.equals("success"))
		{
			errorReport = null;
			String[] temp = returnStr.split(":")[1].split("&");
			result = new Object[temp.length][4];
			for(int i = 0; i < temp.length; i++)
			{
				result[i][0] = temp[i].split(",")[0]; //id
				result[i][1] = temp[i].split(",")[1]; //bookname
				result[i][2] = temp[i].split(",")[2]; //author
				result[i][3] = temp[i].split(",")[3]; //price
			}
		}
		else if(judge.equals("error"))
		{
			errorReport = returnStr.split(":")[1];
			result = null;
		}
		else
		{
			System.out.println("发生未知错误！");
		}
		
		ReturnResult res = new ReturnResult(judge,result,errorReport);
		return res;
	}
	
	public ArrayList<User> printUser(String returnStr){
		judge = returnStr.split(":")[0];
		ArrayList<User> user = new ArrayList<User>();
		if(judge.equals("success")){
			String[] temp = returnStr.split(":")[1].split("&");
			for(int i = 0; i < temp.length; i++){
				String id = temp[i].split(",")[0];
				String username = temp[i].split(",")[1];
				String password = temp[i].split(",")[2];
				String borrowtime = temp[i].split(",")[3];
				User person = new User(id,username,password,borrowtime);
				user.add(person);
			}
		}
		return user;
	}
	
	public ArrayList<Book> printBook(String returnStr){
		judge = returnStr.split(":")[0];
		ArrayList<Book> books = new ArrayList<Book>();
		if(judge.equals("success")){
			String[] temp = returnStr.split(":")[1].split("&");
			for(int i = 0; i < temp.length; i++){
				String id = temp[i].split(",")[0];
				String bookname = temp[i].split(",")[1];
				String author = temp[i].split(",")[2];
				String price = temp[i].split(",")[3];
				String isout = temp[i].split(",")[4];
				String readtime = temp[i].split(",")[5];
				Book book = new Book(id,bookname,author,price,isout,readtime);
				books.add(book);
			}
		}
		return books;
	}
}
