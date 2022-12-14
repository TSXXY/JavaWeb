package com.tan.javaweb.service.impl;

import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.pojo.Page;
import com.tan.javaweb.service.FilmService;
import org.junit.jupiter.api.Test;

import java.util.List;

class FilmServiceImplTest {
    FilmService filmService = new FilmServiceImpl();
    @Test
    void getFilmListByPage() {
        long startTime = System.currentTimeMillis();
        Page<Film> filmListByPage = filmService.getFilmListByPage(1, 100);
        System.out.println(filmListByPage.getPageSize());
        System.out.println(filmListByPage.getPageTotal());
        System.out.println(filmListByPage.getPageNo());
        List<Film> items = filmListByPage.getItems();
        for (Film item : items) {
            System.out.println(item);
        }
        System.out.println(filmListByPage.getPageTotalCount());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime + "ms");
    }

    @Test
    void test(){
        List<Film> films = filmService.queryFilmByName("游戏王", 1, 20);
        int i = 0;
        for (Film film : films) {
            System.out.println((i++)+"::::::::::::"+film);

        }
    }
}