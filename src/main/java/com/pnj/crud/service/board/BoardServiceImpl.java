package com.pnj.crud.service.board;

import com.pnj.crud.dto.board.BoardFindResponseDto;
import com.pnj.crud.dto.board.BoardSaveRequestDto;
import com.pnj.crud.dto.board.BoardsFindAllResponseDto;
import com.pnj.crud.entity.Board;
import com.pnj.crud.repository.board.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Function;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public List<Board> findAllPost() {
        System.out.println(boardRepository.findAll());
        return boardRepository.findAll();
    }


    @Override
    @Transactional
    public Long saveWrite(BoardSaveRequestDto boardDto) {

        System.out.println("boardDto : "+boardDto);
        Board board = boardRepository.save(boardDto.toEntity());
        System.out.println("board : "+board);
        board.setBRef(board.getBNo());
        boardRepository.save(board);


        return board.getBNo();
    }

    @Override
    @Transactional
    public BoardFindResponseDto findById(Long bno) {
        ModelMapper modelMapper = new ModelMapper();

        Board board = boardRepository.findById(bno).get();

        BoardFindResponseDto boardFindResponseDto = modelMapper.map(board, BoardFindResponseDto.class);

        return boardFindResponseDto;
    }

    @Override
    public Page<Board> findAllPost(Pageable pageable) {

        Page<Board> videoPage = boardRepository.findAll(pageable);

        return videoPage;
    }
}
