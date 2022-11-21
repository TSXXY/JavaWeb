package com.tan.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    //动漫id
    private String id;
    //动漫名字
    private String name;
    //总集数
    private String episode;
    //类型
    private String type;
    //简介
    private String Introduction;
    //封面
    private String cover;
    //放送日期
    private String release_time;
}
