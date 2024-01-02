package project.myProject.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    private String writer;
    private String comment;

    @Builder
    public Reply(Board board, String writer, String comment) {
        this.board = board;
        this.writer = writer;
        this.comment = comment;
    }
}
