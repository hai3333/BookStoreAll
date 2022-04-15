package com.example.bookstoreall.service.impl;

import com.example.bookstoreall.dao.BookDao;
import com.example.bookstoreall.dao.impl.BookDaoImpl;
import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.poje.Page;
import com.example.bookstoreall.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);

    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {

        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page=new Page<Book>();



    // 每页数量
    page.setPageSize(pageSize);
    // 每页显示的数量page.setPageTotal(pageTotalCount);
        //求总记录数
        Integer pageTotalCount=bookDao.queryForPageTotalCount();
      //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount % pageSize>0){
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
            if(pageNo<1){
                pageNo=1;
            }
            if(pageNo>pageTotal){
                pageNo=pageTotal;
            }

        //设置页码
        page.setPageNo(pageNo);

        //求开始索引
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItems( begin, pageSize);
        //设置当前页数据
        page.setItems(items);



        return page;
    }
}
