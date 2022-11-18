package com.tan.javaweb.dao.impl;

import com.tan.javaweb.dao.FilmDao;
import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.utils.BaseDao;

import java.util.List;

public class FilmDaoImpl extends BaseDao implements FilmDao {
    @Override
    public List<Film> getFilmList() {
        String sql = "SELECT id,name,episode,type FROM film limit 20";
        return queryForList(Film.class, sql);
    }
}
