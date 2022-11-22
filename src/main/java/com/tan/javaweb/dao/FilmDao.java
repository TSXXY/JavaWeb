package com.tan.javaweb.dao;


import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.pojo.Page;

import java.util.List;

public interface FilmDao {

    /**
     * 返回全部数据
     *
     * @return
     */
    public List<Film> getFilmList();

    /**
     * 添加数据
     * @param film
     * @return
     */
    public int addFilm(Film film);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    public int delFilmById(int id);

    /**
     * 修改数据
     * @param film
     * @return
     */
    public int updateFilm(Film film);

    /**
     * 通过id查询一条数据
     * @param id
     * @return
     */
    public Film getFilmById(int id);


    /**
     * 查询总条数
     * @return
     */
    Integer queryForPageTotalCount();

    /**
     * 查询分页数据
     * @param begin
     * @param pageSize
     * @return
     */
    List<Film> queryForPageItems(int begin, int pageSize);

    /**
     * 根据作品名称进行模糊查询
     * @param name
     * @return
     */
    List<Film> queryFilmByName(String name,int begin,int pageSize);

    int count(String name);
}
