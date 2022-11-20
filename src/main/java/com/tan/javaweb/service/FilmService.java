package com.tan.javaweb.service;

import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.pojo.Page;

import java.util.List;

public interface FilmService {
    public List<Film> getFilmList();

    public int addFilm(Film film);

    public int delFilmById(int id);

    public int updateFilm(Film film);

    public Film getFilmById(int id);

    Page<Film> getFilmListByPage(int pageNo, int pageSize);
}
