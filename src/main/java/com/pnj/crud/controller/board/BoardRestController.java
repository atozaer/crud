package com.pnj.crud.controller.board;

import com.pnj.crud.entity.Board;
import com.pnj.crud.service.board.BoardService;
import javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/board")
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;

    }

    @GetMapping("/list")
    public Map<String, Object> getBoardList(
            @PageableDefault(size = 10, sort = "bRef", direction = Sort.Direction.DESC) Pageable pageable,

            @RequestParam(name="searchType") String searchType,
            @RequestParam(name="searchValue") String searchValue
//            @RequestParam(name="page", required=false, defaultValue = "1") int page
    ) {
        System.out.println(searchType);
        System.out.println(searchValue);
        Map<String, Object> result = new HashMap<>();
        pageable = pageable.withPage(pageable.getPageNumber() - 1);
        Page<Board> boardPage = boardService.findAllPost(pageable, searchType, searchValue);

        int pageNumber = pageable.getPageNumber() + 1;
        int startPage = ((pageNumber - 1)   / pageable.getPageSize()) * pageable.getPageSize();
        int endPage = startPage + pageable.getPageSize();

        if (endPage >= boardPage.getTotalPages()) {
            endPage = boardPage.getTotalPages();
        }

        List<Board> boardlist = new ArrayList<>();
        if(boardPage != null && boardPage.hasContent()) {

            boardlist = boardPage.getContent();
            result.put("result", true);
            result.put("boardList", boardlist);
            result.put("totalPages", boardPage.getTotalPages());
            result.put("totalElements", boardPage.getTotalElements());
            result.put("PageSize", pageable.getPageSize());
            result.put("currentPage", pageable.getPageNumber());
            result.put("endPage", endPage);
            result.put("searchType", searchType);
            result.put("searchValue", searchValue);
        }
        else {
            result.put("result", false);
        }

        return result;
    }


}
