package com.tan.javaweb.service.impl;

import com.tan.javaweb.dao.FilmDao;
import com.tan.javaweb.dao.impl.FilmDaoImpl;
import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.service.FilmService;

import java.util.List;

public class FilmServiceImpl implements FilmService {

    private final FilmDao filmDao = new FilmDaoImpl();

    @Override
    public List<Film> getFilmList() {
        return filmDao.getFilmList();
    }
}
