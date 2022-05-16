package com.demo.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.book.model.dto.LocationDto;
import com.demo.book.model.po.Book;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookService extends IService<Book> {

  List<Book> getBookList();

  Map<Date, List<LocationDto>> getLocationList();

    List<Book> getTodayBooking(Date today);

    void deleteByLocationId(Long id);

  void add(Book book) throws Exception;
}
