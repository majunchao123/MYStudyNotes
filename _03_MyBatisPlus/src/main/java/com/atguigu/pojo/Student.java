package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**                       @author:majunchao
						* @date:2022/10/19 23:51
						*/
@ApiModel(value="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "email")
    @ApiModelProperty(value="")
    private String email;

    @TableField(value = "age")
    @ApiModelProperty(value="")
    private Integer age;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_EMAIL = "email";

    public static final String COL_AGE = "age";
}