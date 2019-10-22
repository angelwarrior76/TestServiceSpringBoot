package com.homework.spring.service.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex on 24.04.2018.
 */
@RestController
@RequestMapping("/services")
public class RatesServiceController {

    @Autowired
    private RatesService service;
    private static final Logger log = LoggerFactory.getLogger(RatesServiceController.class);

    @GetMapping(value = "/rates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends Object> contacts(@RequestParam(name = "ccy", defaultValue = "*") String ccy) {
        ccy = ccy.replace('*', '%');
        Object response;
        try {
            response = service.listRates(ccy);
        } catch (Exception e) {
            response = new ErrorSimpleView(e);
        }
        return ResponseEntity.ok().body(response);
    }

    /**
     * Метод-обработчик неперехваченных исключений. Выводит соответствующее
     * сообщение в общий лог и на доступную консоль
     *
     * @param e экземпляр исключения
     */
    @ExceptionHandler(value = Exception.class)
    public void handleException(Exception e) {
        log.error("Ошибка при выполнении запроса", e);
    }

}
