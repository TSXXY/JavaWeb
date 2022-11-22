package com.tan.javaweb.dao.impl;

import com.tan.javaweb.dao.FilmDao;
import com.tan.javaweb.pojo.Film;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.VariableElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmDaoImplTest {
    FilmDao filmDao = new FilmDaoImpl();

    @Test
    void  test(){
        Film filmById = filmDao.getFilmById(23276);
        System.out.println(filmById);
    }

    @Test
    void queryForPageTotalCount() {
        List<Film> films = filmDao.queryFilmByName("%游戏王%", 1, 20);
        System.out.println(films.size());
    }

    @Test
    void queryForPageItems() {
        List<Film> films = filmDao.queryForPageItems(2, 100);
        for (Film film : films) {
            System.out.println(film);
        }
    }
}