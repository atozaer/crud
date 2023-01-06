package com.pnj.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Path;

@Controller
@RequestMapping(path = "/board")
public class BoardController {

    @GetMapping("/list")
    public String getBoardList() {
        return "views/board/list";
    }
}
