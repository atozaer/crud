package com.pnj.crud.service.board;

import com.pnj.crud.Utils.GenericSpecification;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public Page<Board> findAllPost(Pageable pageable, String searchType, String searchValue) {
        GenericSpecification<Board> boardSpecs = new GenericSpecification<>();
        Specification<Board> spec;
        if (searchType.equals("bTitleAndbContent")) {
            spec = boardSpecs.like("bTitle", searchValue).and(
              boardSpecs.like("bContent", searchValue)
            );
        }
        else {
            spec = boardSpecs.like(searchType, searchValue);
        }

        Page<Board> videoPage = boardRepository.findAll(spec,pageable);

        return videoPage;
    }

    @Override
//    @Transactional
    public Long saveReWrite(BoardSaveRequestDto boardDto, Long bNo) {
        Board parentBoard =  boardRepository.findById(bNo).get();

        if (parentBoard.getBRef() != null) {
            boardDto.setBRef(parentBoard.getBNo());
        }
        boardDto.setBStep(parentBoard.getBStep() + 1);
        boardDto.setBDepth(parentBoard.getBDepth() + 1);
        boardDto.setBTitle(" ∟ "+boardDto.getBTitle());
        long ref = parentBoard.getBRef();
        int step = parentBoard.getBStep();
        boardRepository.updateStep(ref, step);
        Board board = boardRepository.save(boardDto.toEntity());

        return board.getBNo();
    }
}
