package com.pnj.crud.repository.board;

import com.pnj.crud.entity.Board;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    @Query(value = "select * from board where del_yn='n' order by b_ref desc, b_step asc" , nativeQuery = true)
    List<Board> findAll();

//    @Query(value = "select * from board where del_yn='n' order by b_ref desc, b_step asc" , nativeQuery = true)
    Page<Board> findAll(Specification<Board> specification, Pageable pageable);
//    Optional<Board> findByBNo(Long bNO);

    @Transactional
    @Modifying
//    @Query(value = "update Board set bStep = bStep + 1 where bRef=:#{#ref} and bStep >= :#{#step} ")
    @Query(value = "update board set b_step = b_step + 1 where b_ref = :#{#ref} and b_step >= :#{#step} + 1", nativeQuery = true)
    List<Board> updateStep(@Param("ref") Long ref, @Param("step") int step);

    //    Page<Board> findByBTitleContaining(String keyword, Pageable pageable);

    //    BoardFindResponseDto findById(String bno);
}
