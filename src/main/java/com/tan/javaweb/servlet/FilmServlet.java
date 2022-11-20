package com.tan.javaweb.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;


import com.alibaba.druid.support.json.JSONUtils;
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

@WebServlet(name = "FilmServlet",value = "/filmServlet")
public class FilmServlet extends BaseServlet {
    private final FilmService filmService = new FilmServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request,response);
    }

    public void pages(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("limit"), 100);
        Page<Film> page = filmService.getFilmListByPage(pageNo,pageSize);

        stringObjectHashMap.put("code",0);
        stringObjectHashMap.put("msg","ok");
        stringObjectHashMap.put("count",page.getPageTotal());
        stringObjectHashMap.put("data",page.getItems());
//        request.setAttribute("page",page);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(stringObjectHashMap);
//        request.setAttribute("data",s);
        response.getWriter().write(s);
//        request.getRequestDispatcher("/pages/test.jsp").forward(request,response);


    }


    public void getFilmList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Film> filmList = filmService.getFilmList();
        request.setAttribute("list", filmList);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }
}