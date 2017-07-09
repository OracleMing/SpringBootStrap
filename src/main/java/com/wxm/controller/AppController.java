package com.wxm.controller;

import com.wxm.bean.Student;
import com.wxm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Created by OracleMing from IMSE of BUAA.
 * @Time 2017-06-06-14:57.
 * @Description Web应用根控制器
 */

@Controller
public class AppController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "")
    public String redirectIndex() {
        return "index";
    }

    @RequestMapping(value = "/index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/register")
    public String agreementPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute(value = "student") Student student) {

        model.addAttribute("result", studentService.registerService(student));
        return "registerResult";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute(value = "student") Student student, HttpServletRequest request) {

        String result = studentService.loginService(student);
        if (!result.equals(StudentService.CHECK_SUCCESS)) {
            request.getSession().setAttribute("studentName", student.getStudentName());
            model.addAttribute("result", result);
            model.addAttribute("session", request.getSession());
            model.addAttribute("studentName", student.getStudentName());
            return "index";
        }
        return "home";
    }

}
