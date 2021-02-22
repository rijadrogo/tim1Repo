package com.web.restourant.service;

import com.web.restourant.entity.BaseEntity;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Base crud service as a template to perform CRUD operations on entity.
 *
 * @param <E> Entity which extends BaseEntity
 * @param <R> Repository implementation for managing entity
 */
@Getter
public abstract class CrudService<E extends BaseEntity, R extends JpaRepository<E, String>> {

    private final R repository;

    public CrudService(R repository) {
        this.repository = repository;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public List<E> saveAll(Iterable<E> entities) {
        return repository.saveAll(entities);
    }

    public E saveAndFlush(E entity) {
        return repository.saveAndFlush(entity);
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public void deleteAll(Iterable<E> entities) {
        repository.deleteAll(entities);
    }

    public Optional<E> findById(String key) {
        return getRepository().findById(key);
    }
}
