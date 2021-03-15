package com.star.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class User {
    //    @TableId(type = IdType.AUTO) // 主键自动增长
    private Long id;
    private String name;
    private Integer age;
    private String email;
    // 自动填充 insert 的时候触发
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    // 自动填充 insert和update的时候触发
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic  // 逻辑删除注解 默认不删除是0 删除是1
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
