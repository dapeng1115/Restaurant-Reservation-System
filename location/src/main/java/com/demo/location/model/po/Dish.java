package com.demo.location.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author zrgj
 * @since 2022-05-10
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("dish")
@Table(name = "dish", comment = "菜单")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, length = 20, isKey = true, isNull = false, isAutoIncrement = true, comment = "自增Id")
    private Integer id;

    @TableField("name")
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, isNull = false, comment = "菜名")
    private String name;

    @TableField("price")
    @Column(name = "price", type = MySqlTypeConstant.DOUBLE, isNull = false, comment = "价格")
    private Double price;

    @TableField("location_id")
    @Column(name = "location_id", type = MySqlTypeConstant.BIGINT, isNull = false, comment = "城市id")
    private Long locationId;

}
