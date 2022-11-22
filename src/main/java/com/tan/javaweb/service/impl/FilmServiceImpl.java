package com.tan.javaweb.service.impl;

import com.tan.javaweb.dao.FilmDao;
import com.tan.javaweb.dao.impl.FilmDaoImpl;
import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.pojo.Page;
import com.tan.javaweb.service.FilmService;

import java.util.List;

public class FilmServiceImpl implements FilmService {

    private final FilmDao filmDao = new FilmDaoImpl();

    @Override
    public List<Film> getFilmList() {
        return filmDao.getFilmList();
    }

    @Override
    public int addFilm(Film film) {
        return filmDao.addFilm(film);
    }

    @Override
    public int delFilmById(int id) {
        return filmDao.delFilmById(id);
    }

    @Override
    public int updateFilm(Film film) {
        return filmDao.updateFilm(film);
    }

    @Override
    public Film getFilmById(int id) {
        return filmDao.getFilmById(id);
    }

    @Override
    public Page<Film> getFilmListByPage(int pageNo, int pageSize) {
        Page<Film> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        Integer PageTotalCount = filmDao.queryForPageTotalCount();
        page.setPageTotalCount(PageTotalCount);

        Integer pageTotal = PageTotalCount/pageSize;
        if (PageTotalCount%pageSize>0) pageTotal+=1;
        page.setPageTotal(pageTotal);


        int begin = (page.getPageNo() -1) * pageSize;
        List<Film> films = filmDao.queryForPageItems(begin,pageSize);
        page.setItems(films);

        return page;
    }

    @Override
    public List<Film> queryFilmByName(String name,int pageNo,int pageSize) {
        name = "%"+name+"%";

        int begin = (pageNo-1) * pageSize;
        return filmDao.queryFilmByName(name,begin,pageSize);
    }

    @Override
    public int count(String name) {
        name = "%"+name+"%";
        return filmDao.count(name);
    }
}
