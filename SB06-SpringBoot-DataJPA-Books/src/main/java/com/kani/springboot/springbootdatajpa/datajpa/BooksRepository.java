package com.kani.springboot.springbootdatajpa.datajpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Books,Integer> {

}
