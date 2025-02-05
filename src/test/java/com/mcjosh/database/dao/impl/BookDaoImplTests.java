package com.mcjosh.database.dao.impl;

import com.mcjosh.database.TestDataUtil;
import com.mcjosh.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("978-1-2345-6789-0"), eq("The Shadow in the Attic"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql() {
        underTest.findOne("978-1-2345-6789-0");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books where isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(), eq("978-1-2345-6789-0")
        );
    }

    @Test
    public void testThatFindGeneratesCorrectSql() {
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        book.setIsbn("978-1-2345-6789-5");
        underTest.update("978-1-2345-6789-1", book);
        verify(jdbcTemplate).update(
                eq("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?"),
                eq(book.getIsbn()), eq(book.getTitle()), eq(book.getAuthorId()), eq("978-1-2345-6789-1")
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.delete(book.getIsbn());
        verify(jdbcTemplate).update(
                eq("DELETE FROM books WHERE isbn = ?"),
                eq(book.getIsbn())
        );
    }

}
