package com.example.bookTest.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookDto;

@Repository
public class BookDAO {
	
	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO( JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}
	
	public void insert(BookDto bookDto) {
		String sql = "insert into book(book_title, book_author, book_cost, book_page, publisher) values(?, ?, ?, ?, ?)";
		jt.update(sql , bookDto.getBookTitle() , bookDto.getBookAuthor(), bookDto.getBookCost(), bookDto.getBookPage(), bookDto.getPublisher());
	}
}
