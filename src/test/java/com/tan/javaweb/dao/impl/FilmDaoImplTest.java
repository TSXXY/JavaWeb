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
    void queryForPageTotalCount() {
        Integer integer = filmDao.queryForPageTotalCount();
        System.out.println(integer);
    }

    @Test
    void queryForPageItems() {
        List<Film> films = filmDao.queryForPageItems(1, 100);
        for (Film film : films) {
            System.out.println(film);
        }
    }
}