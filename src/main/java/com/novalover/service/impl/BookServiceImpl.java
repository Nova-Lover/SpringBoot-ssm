package com.novalover.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novalover.dao.BookDao;
import com.novalover.domain.Book;
import com.novalover.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean modify(Book book){
        return bookDao.updateById(book) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getUsername()),Book::getUsername,book.getUsername());
        lqw.like(Strings.isNotEmpty(book.getPassword()),Book::getPassword,book.getPassword());
        lqw.like(Strings.isNotEmpty(book.getEmail()),Book::getEmail,book.getEmail());

        IPage page = new Page<>(currentPage,pageSize);
        bookDao.selectPage(page,lqw);
        return page;
    }


}
