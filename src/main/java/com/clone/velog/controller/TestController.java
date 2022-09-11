package com.clone.velog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clone.velog.models.TestModels;
import com.clone.velog.repository.CrudInterface;
import com.clone.velog.service.TestService;

import lombok.RequiredArgsConstructor;

// 임시 생성 파일, Controller 관련 폴더
// Post, Get, Put, Delete
// MVC 모델의 Controller 부분
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class TestController implements CrudInterface{
    
    @Autowired
    private TestService serviceTest;
    
    @Override
    @PostMapping("")
    public int create(TestModels testEntity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    @DeleteMapping("")
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    @PutMapping("")
    public int update(TestModels testDTO) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TestModels read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<TestModels> test = serviceTest.getAll();
        model.addAttribute("tests", test);
        return "home";
    }


}
