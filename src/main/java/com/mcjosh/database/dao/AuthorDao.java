package com.mcjosh.database.dao;

import com.mcjosh.database.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long authorId);

    List<Author> find();

    void update(long id, Author author);

    void delete(Long id);
}
