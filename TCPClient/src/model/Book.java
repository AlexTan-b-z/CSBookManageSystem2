package model;

public class Book {
	public String id;
	public String bookname;
	public String author;
	public String price;
	public String readtime;
	public String isout;
	
	public Book(String id, String bookname, String author, String price, String isout, String readtime){
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.readtime = readtime;
		this.isout = isout;
	}
}
