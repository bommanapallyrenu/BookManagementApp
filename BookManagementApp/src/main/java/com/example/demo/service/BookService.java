package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService
{
	public List<Book> getAllBooks();
	
	public Book addBook(Book book) ;
	
	public boolean deleteBook(int bid);
	
	public boolean updateBook(Book book);
	

}
