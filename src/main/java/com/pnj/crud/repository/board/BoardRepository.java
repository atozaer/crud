package com.pnj.crud.repository.board;

import com.pnj.crud.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    @Query(value = "select * from board where del_yn='n' order by b_ref desc, b_step asc" , nativeQuery = true)
    List<Board> findAll();

//    @Query(value = "select * from board where del_yn='n' order by b_ref desc, b_step asc" , nativeQuery = true)
    Page<Board> findAll(Pageable pageable);

//    BoardFindResponseDto findById(String bno);
}
