package com.mcjosh.database.dao.impl;

import com.mcjosh.database.TestDataUtil;
import com.mcjosh.database.domain.Author;
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
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Abigail Rose"), eq(80)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql() {
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors where id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(), eq(1L)
        );
    }

    @Test
    public void testThatFindGeneratesCorrectSql() {
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql() {
        Author author = TestDataUtil.createTestAuthorA();
        author.setId(5L);
        underTest.update(1L, author);
        verify(jdbcTemplate).update(
                eq("UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?"),
                eq(author.getId()), eq(author.getName()), eq(author.getAge()), eq(1L)
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.delete(author.getId());
        verify(jdbcTemplate).update(
                eq("DELETE FROM authors WHERE id = ?"),
                eq(author.getId())
        );
    }
}
