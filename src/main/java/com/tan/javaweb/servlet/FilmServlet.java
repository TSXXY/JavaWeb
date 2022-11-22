package com.tan.javaweb.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.pojo.Page;
import com.tan.javaweb.service.FilmService;
import com.tan.javaweb.service.impl.FilmServiceImpl;
import com.tan.javaweb.utils.BaseServlet;
import com.tan.javaweb.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FilmServlet", value = "/filmServlet")
public class FilmServlet extends BaseServlet {
    private final FilmService filmService = new FilmServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    public void pages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("limit"), 100);
        Page<Film> page = filmService.getFilmListByPage(pageNo, pageSize);

        stringObjectHashMap.put("code", 0);
        stringObjectHashMap.put("msg", "ok");
        stringObjectHashMap.put("count", page.getPageTotalCount());
        stringObjectHashMap.put("data", page.getItems());


        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(stringObjectHashMap);

        response.getWriter().write(s);


    }
    public void updateFilm(HttpServletRequest request,HttpServletResponse response){
        Film copy = WebUtils.copy(request.getParameterMap(), new Film());
        filmService.updateFilm(copy);

    }

    public void addFilm(HttpServletRequest request,HttpServletResponse response){
        Film copy = WebUtils.copy(request.getParameterMap(), new Film());
        filmService.addFilm(copy);
    }

    public void queryFilmByName(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HashMap<String,Object> objectObjectHashMap = new HashMap<>();
        String text = request.getParameter("text");
        int count = filmService.count(text);
        int pageSize = WebUtils.parseInt(request.getParameter("limit"), 100);
        int upperLimit =count / pageSize;
        if (count % pageSize != 0){
            upperLimit+=1;
        }
        int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
        if (pageNo > upperLimit){
            pageNo = upperLimit;
        }
        List<Film> films = filmService.queryFilmByName(text,pageNo,pageSize);
        objectObjectHashMap.put("data", films);
        objectObjectHashMap.put("code",0);
        objectObjectHashMap.put("count",count);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(objectObjectHashMap);
        response.getWriter().write(s);
    }

    public void delFilmById(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        filmService.delFilmById(WebUtils.parseInt(id,0));
    }

    public void getFilmList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Film> filmList = filmService.getFilmList();
        request.setAttribute("list", filmList);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }
}