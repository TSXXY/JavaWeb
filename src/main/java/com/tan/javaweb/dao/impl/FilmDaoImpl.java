package com.tan.javaweb.dao.impl;

import com.tan.javaweb.dao.FilmDao;
import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.pojo.Page;
import com.tan.javaweb.utils.BaseDao;

import java.util.List;

public class FilmDaoImpl extends BaseDao implements FilmDao {
    @Override
    public List<Film> getFilmList() {
        String sql = "SELECT id,name,episode,type FROM film limit 20";
        return queryForList(Film.class, sql);
    }

    @Override
    public int addFilm(Film film) {
        String sql = "INSERT INTO film(name,episode,type,Introduction,cover,release_time) VALUES (?,?,?,?,?,?)";
        return update(sql, film.getName(), film.getEpisode(), film.getType());
    }

    @Override
    public int delFilmById(int id) {
        String sql = "DELETE FROM film WHERE id = ?";
        return update(sql, id);
    }

    @Override
    public int updateFilm(Film film) {
        String sql = "UPDATE film SET `name`=?,episode=?,type=?,Introduction=?,cover=?,release_time=? WHERE id =?";
        return update(sql, film.getName(), film.getEpisode(), film.getType(),film.getIntroduction(),film.getCover(),film.getRelease_time(), film.getId());
    }

    @Override
    public Film getFilmById(int id) {
        String sql = "SELECT * FROM film WHERE id=?";
        return queryForOne(Film.class, sql, id);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "SELECT count(*) FROM film";
        Number count =(Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Film> queryForPageItems(int begin, int pageSize) {
        String sql = "SELECT * FROM film limit ?,?";
        return queryForList(Film.class,sql,begin,pageSize);
    }

}
