package com.novalover.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.novalover.domain.Book;

public interface IBookService extends IService<Book> {
    boolean modify(Book book);

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);

}
