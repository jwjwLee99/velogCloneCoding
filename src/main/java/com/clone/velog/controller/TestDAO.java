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

import com.clone.velog.dto.TestDTO;
import com.clone.velog.repository.CrudInterface;
import com.clone.velog.service.TestService;

import lombok.RequiredArgsConstructor;

// 임시 생성 파일, DAO 관련 폴더
// Data Access Object
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class TestDAO implements CrudInterface{
    
    @Autowired
    private final TestService serviceTest;
    
    @Override
    @PostMapping("")
    public int create(TestDTO testDTO) {
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
    public int update(TestDTO testDTO) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TestDTO read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<TestDTO> test = serviceTest.getAll();
        model.addAttribute("tests", test);
        return "index/home";
    }


}
