package com.tan.javaweb.servlet;

import java.io.IOException;

import java.util.List;


import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.pojo.Page;
import com.tan.javaweb.service.FilmService;
import com.tan.javaweb.service.impl.FilmServiceImpl;
import com.tan.javaweb.utils.BaseServlet;
import com.tan.javaweb.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FilmServlet",value = "/filmServlet")
public class FilmServlet extends BaseServlet {
    private final FilmService filmService = new FilmServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request,response);
    }

    public void getFilmListByPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), 100);
        Page<Film> page = filmService.getFilmListByPage(pageNo,pageSize);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/test.jsp").forward(request,response);


    }


    public void getFilmList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Film> filmList = filmService.getFilmList();
        request.setAttribute("list", filmList);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }
}