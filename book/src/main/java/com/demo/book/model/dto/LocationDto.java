package com.demo.book.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
public class LocationDto {

  private Long id;

  private String address;

  private Integer seatOne;
  private Integer seatTwo;
  private Integer seatThree;
  private Integer seatFour;
  private Integer seatFive;
  private Integer seatSix;
  private Integer seatSeven;
  private Integer seatEight;
  private Integer seatNine;
  private Integer seatTen;

  public void subSeat(Integer type) {
    if (type == 1) {
      seatOne -= 1;
    } else if (type == 2) {
      seatTwo -= 1;
    } else if (type == 3) {
      seatThree -= 1;
    } else if (type == 4) {
      seatFour -= 1;
    } else if (type == 5) {
      seatFive -= 1;
    } else if (type == 6) {
      seatSix -= 1;
    } else if (type == 7) {
      seatSeven -= 1;
    } else if (type == 8) {
      seatEight -= 1;
    } else if (type == 9) {
      seatNine -= 1;
    } else if (type == 10) {
      seatTen -= 1;
    }
  }
}
