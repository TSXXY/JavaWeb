package com.tan.javaweb.test;

import com.tan.javaweb.dao.FilmDao;
import com.tan.javaweb.dao.impl.FilmDaoImpl;
import com.tan.javaweb.pojo.Film;
import org.junit.jupiter.api.Test;


class FilmDaoImplTest {
    FilmDao filmDao = new FilmDaoImpl();
    @Test
    void getFilmList() {

    }

    @Test
    void addFilm() {
        int i = filmDao.addFilm(new Film(null,"test","test","test","test","test","test"));
        if (i > 0) System.out.println("ok");
    }

    @Test
    void delFilmById() {
        int i = filmDao.delFilmById(23349);
        System.out.println(i);
    }

    @Test
    void updateFilm() {
        Film filmById = filmDao.getFilmById(23349);
        filmById.setCover("11111111111");
        filmById.setIntroduction("22222222222222");
        filmById.setRelease_time("11111111234");
        int i = filmDao.updateFilm(filmById);

    }

    @Test
    void getFilmById() {
        Film filmById = filmDao.getFilmById(1094);
        System.out.println(filmById);
    }
}