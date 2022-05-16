package com.demo.location.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("location")
@Table(name = "location", comment = "位置")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, length = 20, isKey = true, isNull = false, isAutoIncrement = true, comment = "自增Id")
    private Long id;

    @TableField("open_hour_mon")
    @Column(name = "open_hour_mon", type = MySqlTypeConstant.INT, isNull = false, comment = "周一")
    private Integer openHourMon;

    @TableField("open_hour_tue")
    @Column(name = "open_hour_tue", type = MySqlTypeConstant.INT, isNull = false, comment = "周二")
    private Integer openHourTue;

    @TableField("open_hour_wed")
    @Column(name = "open_hour_wed", type = MySqlTypeConstant.INT, isNull = false, comment = "周三")
    private Integer openHourWed;

    @TableField("open_hour_thur")
    @Column(name = "open_hour_thur", type = MySqlTypeConstant.INT, isNull = false, comment = "周四")
    private Integer openHourThur;

    @TableField("open_hour_fri")
    @Column(name = "open_hour_fri", type = MySqlTypeConstant.INT, isNull = false, comment = "周五")
    private Integer openHourFri;

    @TableField("open_hour_sat")
    @Column(name = "open_hour_sat", type = MySqlTypeConstant.INT, isNull = false, comment = "周六")
    private Integer openHourSat;

    @TableField("open_hour_sun")
    @Column(name = "open_hour_sun", type = MySqlTypeConstant.INT, isNull = false, comment = "周日")
    private Integer openHourSun;

    @TableField("address")
    private String address;

    @TableField("seat_one")
    @Column(name = "seat_one", type = MySqlTypeConstant.INT, isNull = false, comment = "1人座")
    private Integer seatOne;

    @TableField("seat_two")
    @Column(name = "seat_two", type = MySqlTypeConstant.INT, isNull = false, comment = "2人座")
    private Integer seatTwo;

    @TableField("seat_three")
    @Column(name = "seat_three", type = MySqlTypeConstant.INT, isNull = false, comment = "3人座")
    private Integer seatThree;

    @TableField("seat_four")
    @Column(name = "seat_four", type = MySqlTypeConstant.INT, isNull = false, comment = "4人座")
    private Integer seatFour;

    @TableField("seat_five")
    @Column(name = "seat_five", type = MySqlTypeConstant.INT, isNull = false, comment = "5人座")
    private Integer seatFive;

    @TableField("seat_six")
    @Column(name = "seat_six", type = MySqlTypeConstant.INT, isNull = false, comment = "6人座")
    private Integer seatSix;

    @TableField("seat_seven")
    @Column(name = "seat_seven", type = MySqlTypeConstant.INT, isNull = false, comment = "7人座")
    private Integer seatSeven;

    @TableField("seat_eight")
    @Column(name = "seat_eight", type = MySqlTypeConstant.INT, isNull = false, comment = "8人座")
    private Integer seatEight;

    @TableField("seat_nine")
    @Column(name = "seat_nine", type = MySqlTypeConstant.INT, isNull = false, comment = "9人座")
    private Integer seatNine;

    @TableField("seat_ten")
    @Column(name = "seat_ten", type = MySqlTypeConstant.INT, isNull = false, comment = "10人座")
    private Integer seatTen;

    @TableField(exist = false)
    private List<Integer> seat = new ArrayList<>();

    @TableField(exist = false)
    private List<Integer> openHours = new ArrayList<>();

    @TableField(exist = false)
    private List<Dish> dish = new ArrayList<>();

}
