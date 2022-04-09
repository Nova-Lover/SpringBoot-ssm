package com.novalover.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.novalover.controller.utils.R;
import com.novalover.domain.Book;
import com.novalover.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Books")
@CrossOrigin
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        boolean flat = bookService.save(book);
        return new R(flat,flat ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        boolean flat = bookService.modify(book);
        return new R(flat,flat ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        boolean flat = bookService.removeById(id);
        return new R(flat,flat ? "删除成功^_^" : "删除失败-_-!");
    }

    @GetMapping("{id}")
    @Cacheable(value="cacheSpace",key="#id")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，则以总页码值重新查询一次
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }

}
