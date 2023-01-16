package com.pnj.crud.controller.board;

import com.pnj.crud.dto.board.BoardSaveRequestDto;
import com.pnj.crud.dto.board.BoardsFindAllResponseDto;
import com.pnj.crud.service.board.BoardService;
import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {

        this.boardService = boardService;
    }

//    @GetMapping("/list")
//    public String getBoardList(
//            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
//            ModelMap model
//    ) {
//        Page<BoardsFindAllResponseDto> board = boardService.findAllPost(page);
//
//        Pageable pageAble = board.getPageable();
//
//        System.out.println(page);
//        System.out.println(pageAble);
//        System.out.println();
//
//        model.addAttribute("page", 1);
//        model.addAttribute("board", board);
//        model.addAttribute("msg", "success");
//
//        return "views/board/list";
//    }

    @GetMapping("/list")
    public ModelAndView getBoardList(
            ModelAndView mv,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "searchType", required = false, defaultValue = "bTitleAndbContent") String searchType,
            @RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
    ) {
        mv.setViewName("views/board/list");
        mv.addObject("page", page);
        mv.addObject("size", size);
        mv.addObject("searchType", searchType);
        mv.addObject("searchValue", searchValue);


        return mv;
    }

    @GetMapping("/write")
    public String getWrite() {

        return "views/board/write";
    }

    @PostMapping("/write")
    public String postWrite(BoardSaveRequestDto boardDto) {

        boardService.saveWrite(boardDto);

        return "views/board/list";
    }

    @GetMapping("/{bno}/detail")
    public String getBoardDetail(
            @PathVariable("bno") Long bNo,
            Model model
    ) {
        model.addAttribute("board", boardService.findById(bNo));

        return "views/board/detail";
    }

    @GetMapping("/{bNo}/modify")
    public String getBoardModify(
            @PathVariable("bNo") Long bNo,
            Model model
    ) {
        model.addAttribute("board", boardService.findById(bNo));

        return "views/board/modify";
    }

    @PostMapping("/modify")
    public String postBoardModify() {


        return "views/board/list";
    }

    @GetMapping("/{bNo}/reWrite")
    public String getReWrite() {

        return "views/board/reWrite";
    }

    @PostMapping("/{bno}/reWrite")
    public String postReWrite(
            BoardSaveRequestDto boardDto,
            @PathVariable("bno") Long bNo
    ) {

        boardService.saveReWrite(boardDto, bNo);

        return "views/board/list";
    }
}
