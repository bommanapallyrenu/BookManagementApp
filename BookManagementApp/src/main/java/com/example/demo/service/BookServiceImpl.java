package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BookRepository;
import com.example.demo.model.Book;

@Service
public class BookServiceImpl implements BookService
{

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public List<Book> getAllBooks() {

		List<Book> bookList = bookRepo.findAll();
		if(bookList!=null && bookList.size()>0)
		{
			return bookList;
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public Book addBook(Book book) {

		if(book != null)
		{
			bookRepo.saveAndFlush(book);
			return book;
		}
		
		return null;

	}

	@Override
	public boolean deleteBook(int bid) {
		bookRepo.deleteById(bid);
		return true;
	}

	@Override
	public boolean updateBook(Book book) 
	{
		Book book1 = bookRepo.getById(book.getBookId());
		
		if(book1 !=null)
		{
			book1.setBookPrice(book.getBookPrice());
			bookRepo.saveAndFlush(book1);
			return true;
		}
		return false;
		
	}

}









