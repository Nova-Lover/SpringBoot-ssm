package com.novalover.service;

import com.novalover.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testBookService {
    @Autowired
    private IBookService bookService;

    @Test
    void testGetAll(){

    }

}
