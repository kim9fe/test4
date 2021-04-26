package com.kim9fe.test4.controller;

import com.kim9fe.test4.domain.BoardDTO;
import com.kim9fe.test4.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    
    @Autowired
    public BoardService boardService;

    @GetMapping(value="/test")
    public String testHello(){
        return "TEST..";
    }

    @PostMapping(value="/board") 
    public String insertBoard(final BoardDTO params) {

        int result = 0;

        try{
            result = boardService.registBoard(params);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if(result > 0) {
            return boardService.getBoardList();
        }

        return "";
    }

    @PutMapping(value="/board") 
    public String updateBoard(final BoardDTO params) {
        int result = 0;

        try{
            result = boardService.registBoard(params);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        

        if(result > 0) {
            return boardService.getBoardList();
        }

        return "";
    }

    @DeleteMapping(value="/board/{id}") 
    public String deleteBoard(@PathVariable("id") long id, @ModelAttribute("params") BoardDTO params) {
        int result = 0;

        try{
            result = boardService.deleteBoard(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if(result > 0) {
            return boardService.getBoardList();
        }

        return "";
    }
}
