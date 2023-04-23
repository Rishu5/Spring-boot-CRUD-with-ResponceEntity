package com.example.demo.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.demo.crud.entity.Book;

@Configuration
public class BookService {

	@Autowired
	Bookcrud bookcrud;

	// public static List<Book> list = new ArrayList<>();
//	static {
//		list.add(new Book(12, "namak ka daroga", "b-tech", "Bettiah"));
//		list.add(new Book(15, "minu", "b-tech", "Bettiah"));
//		list.add(new Book(198, "Adi", "Agro", "Bettiah"));
//		list.add(new Book(1201, "namak ka daroga", "b-tech", "Bettiah"));
//	}

	// get all books
	public List<Book> getallBook() {

		List list = (List) this.bookcrud.findAll();
		return list;
	}

	// get bbook by id
	public Book getBookById(int id) {
		Book bk = null;
		// bk = list.stream().filter(e -> e.getId() == id).findFirst().get();
		bk = this.bookcrud.findById(id);

		return bk;
	}

	public Book addbook(Book bk) {
		this.bookcrud.save(bk);
//		list.add(bk);
		return bk;
	}

	public List<Book> removedBOok_byid(int id) {
//		list = list.stream().filter(list -> list.getId() != id).collect(Collectors.toList());
//		return list;
		bookcrud.deleteById(id);
		List<Book> list = (List<Book>) this.bookcrud.findAll();
//
		list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());

		return list;

	}

	public Book updatebook(Book bk, int id) {

//		list = list.stream().map(e -> {
//			if (e.getId() == id) {
//				e.setCity(bk.getCity());
//				e.setName(bk.getName());
//				e.setQualification(bk.getQualification());
//
//			}
//			return e;
//		}).collect(Collectors.toList());
//		return list;

		Book bk1 = null;
		// bk = list.stream().filter(e -> e.getId() == id).findFirst().get();
		bk1 = this.bookcrud.findById(id);
		bk1.setCity(bk.getCity());
		bk1.setName(bk.getName());
		bk1.setQualification(bk.getQualification());
		this.bookcrud.save(bk1);
		return bk1;

	}

}