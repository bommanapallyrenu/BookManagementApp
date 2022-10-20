package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookServiceImpl;

@RestController
@RequestMapping("api/v1")
public class BookController 
{

	@Autowired
	private BookServiceImpl bookService;
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<?> getAllBooks()
	{
		List<Book> bookList = bookService.getAllBooks();
		if(bookList !=null)
		{
			return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("bookList is empty", HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<?> addBook(@RequestBody Book book)
	{
		if(bookService.addBook(book)!=null)
		{
			return new ResponseEntity<Book>(book, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("book object is empty", HttpStatus.CONFLICT);
	}
	
	
	@DeleteMapping("/deleteBook/{bid}")
	public ResponseEntity<?> deleteBook(@PathVariable("bid") int bid)
	{
		if(bookService.deleteBook(bid))
		{
			return new ResponseEntity<String>("book record is deleted!", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<String>("book record cannot be deleted!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateBook(@RequestBody Book book)
	{
		if(bookService.updateBook(book))
		{
			return new ResponseEntity<>(book, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("book record cannot be updated!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}












