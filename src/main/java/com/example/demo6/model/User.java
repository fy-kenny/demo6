package com.example.demo6.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/8/21 20:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class User {
    @Id
    private String id;
    private long userId;
    private String userName;
    private String exclude;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && this.getUserId() == ((User)obj).getUserId();
    }

    @JsonIgnore
//    @JSONField(serialize = false, deserialize = false)
    public boolean isRemoved()  {
        return true;
    }
}
