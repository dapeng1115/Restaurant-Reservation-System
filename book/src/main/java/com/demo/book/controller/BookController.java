package com.demo.book.controller;

import com.demo.book.model.dto.LocationDto;
import com.demo.book.model.po.Book;
import com.demo.book.service.BookService;
import com.mblog.auth.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping("/list")
  public String getList(Model model) {
    List<Book> data = bookService.getBookList();
    model.addAttribute("reservations", data);
    return "reservationlist";
  }

  @GetMapping("/create")
  public String toAdd(Model model) {
    Map<Date, List<LocationDto>> locationList = bookService.getLocationList();
    model.addAttribute("locationMap", locationList);
    model.addAttribute("book", new Book());
    return "reservationEdit";
  }

  @PostMapping("/create")
  public String add(Book book, Model model, HttpSession session) throws Exception {
    String token = (String) session.getAttribute("token");
    if (token == null) {
      // 未登录
      return "fail";
    }
    long l = JwtUtils.parseIdFromToken(token);
    book.setUserId(l);
    if (new Date().after(book.getBookTime())) {
      return "fail";
    }
    bookService.add(book);
    return "success";
  }

  @DeleteMapping("/delete-by-location-id/{id}")
  @ResponseBody
  public void deleteByLocationId(@PathVariable("id") Long id) {
    bookService.deleteByLocationId(id);
  }
}
