package com.homework.spring.service.test.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class JsonSimpleView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.addHeader("Content-Type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (map.size() > 0) {
            ObjectMapper om = new ObjectMapper();
            om.writeValue(response.getWriter(), map.entrySet().iterator().next().getValue());
            response.getWriter().flush();
        }
    }

}
