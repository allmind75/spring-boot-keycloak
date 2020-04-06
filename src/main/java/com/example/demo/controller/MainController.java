package com.example.demo.controller;

import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * JavaDoc용 클래스의 용도를 설명합니다
 *
 * @author 서비스INFRA팀 TA파트 장환호
 * @version 1.0
 * <pre>
 * 2020.04.02 : 최초 작성
 * </pre>
 * @since 2020-04-02
 */
@Controller
@Slf4j
public class MainController {

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    @PreAuthorize("hasAuthority('user')")
    public String customers(Principal principal, Model model) {
//        log.info(principal.toString());
//        log.info(model.toString());
        log.info("customers");
        String str = "";
        return "customers";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "external";
    }

}
