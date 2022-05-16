package com.demo.book.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.annotation.Unique;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.mblog.auth.model.Role;
import com.mblog.auth.model.UserInfo;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
@Table(name = "user", comment = "用户")
public class User implements UserInfo {

  @TableId(type = IdType.AUTO)
  @Column(name = "id", type = MySqlTypeConstant.BIGINT, length = 20, isKey = true, isNull = false, isAutoIncrement = true, comment = "自增Id")
  private Long id;

  @Unique
  @TableField("username")
  @Column(name = "username", type = MySqlTypeConstant.VARCHAR, length = 20, comment = "登陆用户名")
  private String username;

  @Column(name = "password", type = MySqlTypeConstant.CHAR, length = 100, comment = "密码")
  @TableField("password")
  private String password;

  @TableField(exist = false)
  private String rePassword;

  @Override
  public ArrayList<Role> getAuthorities() {
    return null;
  }
}
