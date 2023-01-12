package com.pnj.crud.entity;

import lombok.*;
import org.apache.tomcat.util.modeler.BaseNotificationBroadcaster;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@ToString
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@Builder
@Table(name = "board")
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_no")
    private Long bNo;

    @Column(nullable = false)
    private String bTitle;

    @Column(nullable = false, length = 1000)
    private String bContent;

    @Column(nullable = false)
    private String bWriter;

    private String bRegDate;

    @ColumnDefault("0")
    private int bReadCount;

    private Long bRef;

    private int bDepth;

    private int bStep;

    private String delYn;

    private String bPasswd;

    private String bModifyDate;


}
