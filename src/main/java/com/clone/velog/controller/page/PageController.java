package com.clone.velog.controller.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clone.velog.models.network.response.UserRes;
import com.clone.velog.service.user.UserService;

// PageController : UI에서 사용자가 요청하는 페이지를 띄움
@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private UserService userService;

    /*
     *
     * api
     * 
     */

    // login Success API - /{id}
    @RequestMapping("{id}")
    public String login_ok(HttpServletRequest request, HttpServletResponse response,
            @PathVariable(name = "id") String id, Model model) throws Exception {
        HttpSession session = request.getSession();
        UserRes userRes = userService.login(id).getData();
        session.setAttribute("userRes", userRes);
        model.addAttribute("userRes", session.getAttribute("userRes"));
        model.addAttribute("loginURL", "fragment/header_login");

        return "redirect:/";
    }

    // logout Success API - /logout
    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        session.invalidate();
        ; // session delete
        model.addAttribute("loginURL", "fragment/header");
        return "redirect:/";
    }

    /*
     * 
     * page list
     * 
     */

    // index page - /
    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            model.addAttribute("loginURL", "fragment/header");
        }
        return new ModelAndView("index")
                .addObject("code", "index");
    }

    // login page - /login
    @RequestMapping("login")
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return new ModelAndView("user/login")
                .addObject("code", "login");
    }

    // search page - /search
    @RequestMapping("search")
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            model.addAttribute("loginURL", "fragment/header");
        }
        return new ModelAndView("post/search")
                .addObject("code", "search");
    }

    // postDetail page
    @RequestMapping("post/{postTitle}")
    public ModelAndView postDetail(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            model.addAttribute("loginURL", "fragment/header");
        }
        return new ModelAndView("post/postDetail")
                .addObject("code", "postDetial");
    }

    // post write
    @RequestMapping("write")
    public ModelAndView postWrite(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            return new ModelAndView("user/login")
                    .addObject("code", "login");
        }

        return new ModelAndView("post/postwrite")
                .addObject("code", "postwirte");
    }

    /*
     * 
     * mypage list
     * 
     */

    // myVelog
    @RequestMapping("my")
    public ModelAndView myVelog(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            return new ModelAndView("user/login")
                    .addObject("code", "login");
        }

        return new ModelAndView("user/myVelog")
                .addObject("code", "myVelog");
    }

    // readList
    @RequestMapping("read")
    public ModelAndView readList(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            return new ModelAndView("user/login")
                    .addObject("code", "login");
        }
        return new ModelAndView("user/readList")
                .addObject("code", "readList");
    }

    // settting
    @RequestMapping("setting")
    public ModelAndView setting(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            return new ModelAndView("user/login")
                    .addObject("code", "login");
        }
        return new ModelAndView("user/setting")
                .addObject("code", "setting");
    }

    // temporary post
    @RequestMapping("temp")
    public ModelAndView temp(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userRes") != null) {
            model.addAttribute("loginURL", "fragment/header_login");
        } else {
            return new ModelAndView("user/login")
                    .addObject("code", "login");
        }

        return new ModelAndView("user/temporaryPost")
                .addObject("code", "temporaryPost");
    }

}
