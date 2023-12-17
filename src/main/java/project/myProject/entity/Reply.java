package project.myProject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String writer;
    private String comment;
    // 날짜?
}
