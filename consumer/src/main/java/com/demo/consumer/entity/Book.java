package com.demo.consumer.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("consumer")
@Table(name = "consumer", comment = "consumer")
public class Book {

    @TableId(type = IdType.AUTO)
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, length = 20, isKey = true, isNull = false, isAutoIncrement = true, comment = "自增Id")
    private Long id;

    @TableField("user_id")
    @Column(name = "user_id", type = MySqlTypeConstant.BIGINT, length = 20, isNull = false, comment = "用户id")
    private Long userId;


    @TableField(exist = false)
    private String token;

    @TableField("location_id")
    @Column(name = "location_id", type = MySqlTypeConstant.BIGINT, length = 20, isNull = false, comment = "位置id")
    private Long locationId;



    @TableField("type")
    @Column(name = "type", type = MySqlTypeConstant.INT, isNull = false, comment = "几人桌")
    private Integer type;

    @Column(name = "book_time", type = MySqlTypeConstant.DATE, isNull = false, comment = "预约时间")
    @TableField(value = "book_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date bookTime;

    @Column(name = "create_time", type = MySqlTypeConstant.DATETIME, isNull = false, comment = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
