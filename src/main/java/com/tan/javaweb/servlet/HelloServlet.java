package com.tan.javaweb.servlet;

import java.io.IOException;

import java.lang.reflect.Method;
import java.util.List;


import com.tan.javaweb.pojo.Film;
import com.tan.javaweb.service.FilmService;
import com.tan.javaweb.service.impl.FilmServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * 可以利用反射进一步优化代码
 */
@WebServlet(value = "/getList")
public class HelloServlet extends HttpServlet {
    private FilmService filmService = new FilmServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Film> filmList = filmService.getFilmList();
        request.setAttribute("list", filmList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);


    }
}