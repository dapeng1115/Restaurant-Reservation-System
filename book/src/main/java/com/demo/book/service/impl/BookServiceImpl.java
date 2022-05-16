package com.demo.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.book.feignService.LocationFeignService;
import com.demo.book.mapper.BookMapper;
import com.demo.book.model.dto.LocationDto;
import com.demo.book.model.po.Book;
import com.demo.book.service.BookService;
import com.demo.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

  @Autowired
  private LocationFeignService locationFeignService;
  @Autowired
  private UserService userService;

  @Override
  public List<Book> getBookList() {
    List<Book> books = this.baseMapper.selectList(new LambdaQueryWrapper<>());
    books.forEach(each -> {
      each.setUser(userService.getById(each.getUserId()));
      // HttpUtils.doGet("localhost:10001", "")
      each.setLocation(locationFeignService.getLocationById(each.getLocationId()));
    });
    return books;
  }

  private List<Book> getBookListAfter(Date date) {
    LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.ge(Book::getBookTime, date);
    return this.baseMapper.selectList(queryWrapper);
  }

  @Override
  public Map<Date, List<LocationDto>> getLocationList() {
    Calendar today = Calendar.getInstance();
    today.setTime(new Date());
    today.set(Calendar.HOUR, 0);
    today.set(Calendar.MINUTE, 0);
    today.set(Calendar.SECOND, 0);

    Date time = today.getTime();
    TreeMap<Date, List<LocationDto>> temp = new TreeMap<>();

    Calendar curr = today;
    for (int i = 0; i < 3; i++) {
      List<Book> bookList = getBookListByDate(curr.getTime());
      // 通过以上数据修改下面的数据
      Map<Long, LocationDto> locationMap = locationFeignService.getAllLocations().stream()
              .collect(Collectors.toMap(LocationDto::getId, v -> v));

      bookList.forEach(book -> {
        Long locationId = book.getLocationId();
        Integer type = book.getType();
        LocationDto locationDto = locationMap.get(locationId);
        locationDto.subSeat(type);
      });

      ArrayList<LocationDto> res = new ArrayList<>();
      locationMap.forEach((k, v) -> {
        res.add(v);
      });

      temp.put(curr.getTime(), res);
      curr.add(Calendar.DATE, 1);
    }

    return temp;
  }

  @Override
  public List<Book> getTodayBooking(Date today) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(today);
    cal.set(Calendar.HOUR, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.ge(Book::getBookTime, cal.getTime());
    cal.add(Calendar.DATE, 1);
    queryWrapper.lt(Book::getBookTime, cal.getTime());
    return this.baseMapper.selectList(queryWrapper);
  }

    @Override
    public void deleteByLocationId(Long id) {
      LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
      queryWrapper.eq(Book::getLocationId, id);
      baseMapper.delete(queryWrapper);
    }

  @Override
  public void add(Book book) throws Exception {
    LocationDto locationById = locationFeignService.getLocationById(book.getLocationId());
    if (locationById == null) {
      throw new Exception("Location is null!");
    }
    baseMapper.insert(book);
  }

  private List<Book> getBookListByDate(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, -1);
    Date today = cal.getTime();
    LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.ge(Book::getBookTime, today);
    queryWrapper.lt(Book::getBookTime, date);
    return this.baseMapper.selectList(queryWrapper);
  }

}
