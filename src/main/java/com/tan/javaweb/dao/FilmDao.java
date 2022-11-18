package com.tan.javaweb.dao;


import com.tan.javaweb.pojo.Film;

import java.util.List;

public interface FilmDao {

    /**
     * 返回全部数据
     *
     * @return
     */
    public List<Film> getFilmList();
}
