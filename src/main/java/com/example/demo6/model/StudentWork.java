package com.example.demo6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/9/15 20:15
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentWork {
    @Id
    private String id;
    private String name;
}
