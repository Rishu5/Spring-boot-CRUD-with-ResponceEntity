package com.example.demo.crud.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.crud.BookService;
import com.example.demo.crud.entity.Book;

//@RestController ke dwata hame @ResponseBody nahi lagana padta hai (or ye clear ho jata h ke yah Rest type ka Controller hai)
@RestController
public class fileController {

	// yaha service class ka object bana h jisme ke book pe sare operation perform
	// karne ke methord declear kiya gya h
	// and @autowired ke dwara controller ye samjhe gaa ke ushe is class ka refrence
	// Bookservice se automatic le lena h
	@Autowired
	private BookService service;

	// get all books handler
	// @getMapping ke dwara ye clear hoo ga ke ye get type ka methord ke liye hai
	// jo ke pahale @requestmapping(type="",methord =requestmapping.get) hota tha
	@GetMapping("/Books")
	public ResponseEntity<List<Book>> getbooks() {
		List<Book> list = service.getallBook();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	// get single book handler by id
	@GetMapping("/Book/{id}")
	public ResponseEntity<Book> getbook(@PathVariable("id") int id) {

		Book bk = null;
		try {
			bk = service.getBookById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		if (bk == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(bk));

	}

	// add new book handler
	// @postMapping ke dwara ye clear hoo ga ke ye post type ka methord ke liye hai
	// jo ke pahale @requestmapping(type="",methord =requestmapping.post) hota tha
	@PostMapping("/Book")

	// @RequeatBody ke dwara jason ke value ko hm noraml book ke object me dal sakte
	// h or book ka object hame mil jya gaa
	public ResponseEntity<Book> addBoook(@RequestBody Book book) {

		Book bk = this.service.addbook(book);
		System.out.println(bk);
		return ResponseEntity.of(Optional.of(bk));
	}

	@DeleteMapping("/book/{id}")
	public List<Book> removebook(@PathVariable("id") int id) {

		List<Book> list = this.service.removedBOok_byid(id);
		return list;

	}

	// yaha pe new wala updated book mile gaa jo ke updatebook wale methord me ja
	// kar update ho jya gaa
	// or fir wahi book retrn ho jya gaa
	@PutMapping("/book/{id}")
	public Book update(@RequestBody Book book, @PathVariable("id") int id) {
		this.service.updatebook(book, id);

		// or
//		book.setId(id);
//		this.service.addbook(book);

		return book;
	}

}
