package util;

import java.util.ArrayList;

import control.Operator;
import model.Book;

public class Parser {
	public String returnStr;
	
	public String Parse(String receiveStr){
		
		if(!receiveStr.equals("exit"))
		{
			String operate = receiveStr.split(":")[0];
			String information = receiveStr.split(":")[1];
			if(operate.equals("add"))
			{
				String bookname = information.split(",")[0];
				String author = information.split(",")[1];
				String pricestr = information.split(",")[2];
				float price = Float.parseFloat(pricestr);
				Operator operator = new Operator();
				boolean isSuccess = operator.addBook(bookname, author, price);
				if (isSuccess){
					returnStr = "success:" + "1" + "," + bookname + "," + author + "," + pricestr + "& \n";
				}
				else{
					returnStr = "error:&\n";
				}
				/*
				operate operate = new operate();
				boolean isSuccess = operate.addBook(bookname, author, price);
				if(isSuccess)
				{
					returnStr = "success";
				}
				else
				{
					returnStr = "faied";
				}
				*/
			}
			else if(operate.equals("returnbook")){
				String username = information.split("&")[0];
				String idStr = information.split("&")[1];
				Operator operator = new Operator();
				boolean isSuccess = operator.returnBook(username, idStr);
				if(isSuccess){
					returnStr = "success\n";
				}else{
					returnStr = "failed\n";
				}
			}
			else if(operate.equals("borrowbook")){
				String username = information.split("&")[0];
				String idStr = information.split("&")[1];
				Operator operator = new Operator();
				boolean isSuccess = operator.borrowBook(username, idStr);
				if(isSuccess){
					returnStr = "success\n";
				}else{
					returnStr = "failed\n";
				}
			}
			else if(operate.equals("changeuser")){
				String username = information.split(",")[0];
				String pwd = information.split(",")[1];
				Operator operator = new Operator();
				boolean isSuccess = operator.changeUser(username, pwd);
				if(isSuccess){
					returnStr = "success\n";
				}else{
					returnStr = "failed\n";
				}
			}
			else if(operate.equals("printbook")){
				String isout = information;
				Operator operator = new Operator();
				String books = operator.printBook(isout);
				returnStr = "success:" + books + "\n";
			}
			else if(operate.equals("deleteuser")){
				Operator operator = new Operator();
				String idStr = information.split("&")[0];
				String status = information.split("&")[1];
				boolean isSuccess = operator.deleteUser(idStr, status);
				if(isSuccess){
					returnStr = "success\n";
				}else{
					returnStr = "failed\n";
				}
			}
			else if(operate.equals("printuser")){
				Operator operator = new Operator();
				String user = operator.printUser(information);
				returnStr = "success:" + user + "\n";
			}
			
			//接下来往这里往下面写，接上后台....
			else if(operate.equals("adduser")){
				String username = information.split(",")[0];
				String password = information.split(",")[1];
				String status = information.split(",")[2];
				Operator operator = new Operator();
				boolean isSuccess = operator.addUser(username, password, status);
				if(isSuccess){
					returnStr = "success\n";
				}else{
					returnStr = "failed\n";
				}
			}
			else if(operate.equals("login")){
				String username = information.split(",")[0];
				String password = information.split(",")[1];
				String status = information.split(",")[2];
				Operator operator = new Operator();
				boolean isSuccess = operator.login(username, password, status);
				if(isSuccess){
					returnStr = "success\n";
				}else{
					returnStr = "failed\n";
				}
			}
			else if(operate.equals("delete"))
			{
				String choose = information.split(",")[0];
				int id = -1;
				String bookname = null;
				if(choose.equals("id"))
				{
					String idstr = information.split(",")[1];
					id = Integer.parseInt(idstr);
					Operator operator = new Operator();
					boolean isSuccess = operator.deleteBook(id,bookname);
					if(isSuccess){
						returnStr = "success:" + id + "&\n";
					}
					else{
						returnStr = "error:&\n";
					}
					
				}
				else if(choose.equals("bookname"))
				{
					bookname = information.split(",")[1];
					Operator operator = new Operator();
					boolean isSuccess = operator.deleteBook(id,bookname);
					if(isSuccess){
						returnStr = "success:" + bookname + "&\n";
					}
					else{
						returnStr = "error:&\n";
					}
				}
			}
			
			else if(operate.equals("change"))
			{
				String choose = information.split(",")[0];
				int id = -1;
				String name = "";
				Operator operator = new Operator();
				if(choose.equals("id"))
				{
					String idstr = information.split(",")[1];
					id = Integer.parseInt(idstr);
					String changename = information.split(",")[2];
					boolean isSuccess = operator.changeBoo(id,name,changename);
					if(isSuccess)
					{
						returnStr = "success:" + id + "," + changename + "&\n";
					}else{
						returnStr = "error:&\n";
					}
				}
				else if(choose.equals("bookname"))
				{
					name = information.split(",")[1];
					String changename = information.split(",")[2];
					boolean isSuccess = operator.changeBoo(id,name,changename);
					if(isSuccess)
					{
						returnStr = "success:" + name + "," + changename + "&\n";
					}else{
						returnStr = "error:&\n";
					}
				}
			}
			
			else if(operate.equals("select"))
			{
				String name = null;
				int id = -1;
				String author = null;
				String dimname = null;
				float minprice = 0;
				float maxprice = -1;
				String choose = information.split(",")[0];
				Operator operator = new Operator();
				String result = "";
				if(choose.equals("id"))
				{
					String idstr = information.split(",")[1];
					id = Integer.parseInt(idstr);
					ArrayList<Book> booklist = operator.findBoo(id,name,author,dimname,minprice,maxprice);
					for (int j = 0; j < booklist.size(); j++)  
			        {  
			            Book book = (Book)booklist.get(j);  
			            System.out.println("编号"+book.getBookid()+" 书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");
			            result = result + book.getBookid() + "," + book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "&";
			        }
					returnStr = "success:" + result + "\n";
				}
				else if(choose.equals("bookname"))
				{
					name = information.split(",")[1];
					ArrayList<Book> booklist = operator.findBoo(id,name,author,dimname,minprice,maxprice);
					for (int j = 0; j < booklist.size(); j++)  
			        {  
			            Book book = (Book)booklist.get(j);  
			            System.out.println("编号"+book.getBookid()+" 书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");
			            result = result + book.getBookid() + "," + book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "&";
			        }
					returnStr = "success:" + result + "\n";
				}
				else if(choose.equals("dimname"))
				{
					dimname = information.split(",")[1];
					ArrayList<Book> booklist = operator.findBoo(id,name,author,dimname,minprice,maxprice);
					for (int j = 0; j < booklist.size(); j++)  
			        {  
			            Book book = (Book)booklist.get(j);  
			            System.out.println("编号"+book.getBookid()+" 书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");
			            result = result + book.getBookid() + "," + book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "&";
			        }
					returnStr = "success:" + result + "\n";
				}
				else if(choose.equals("author"))
				{
					author = information.split(",")[1];
					ArrayList<Book> booklist = operator.findBoo(id,name,author,dimname,minprice,maxprice);
					for (int j = 0; j < booklist.size(); j++)  
			        {  
			            Book book = (Book)booklist.get(j);  
			            System.out.println("编号"+book.getBookid()+" 书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");
			            result = result + book.getBookid() + "," + book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "&";
			        }
					returnStr = "success:" + result + "\n";
				}
				else if(choose.equals("price"))
				{
					minprice = Float.parseFloat(information.split(",")[1]);
					maxprice = Float.parseFloat(information.split(",")[2]);
					ArrayList<Book> booklist = operator.findBoo(id,name,author,dimname,minprice,maxprice);
					for (int j = 0; j < booklist.size(); j++)  
			        {  
			            Book book = (Book)booklist.get(j);  
			            System.out.println("编号"+book.getBookid()+" 书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");
			            result = result + book.getBookid() + "," + book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "&";
			        }
					returnStr = "success:" + result + "\n";
				}
			}
			
			else if(operate.equals("findall")){
				String result = "";
				Operator operator = new Operator();
				ArrayList<Book> booklist = operator.printAllbook();
				for (int j = 0; j < booklist.size(); j++)  
		        {  
		            Book book = (Book)booklist.get(j);  
		            System.out.println("编号"+book.getBookid()+" 书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");
		            result = result + book.getBookid() + "," + book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "&";
		        }
				returnStr = "success:" + result + "\n";
				
			}
			
			else if(operate.equals("clearall")){
				Operator operator = new Operator();
				boolean isSuccess = operator.clearBook();
				if(isSuccess){
					returnStr = "success:\n";
				}else{
					returnStr = "error:\n";
				}
			}
		}
		
		return returnStr;
	}
}
