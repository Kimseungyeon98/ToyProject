package project.myProject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReplyDTO {

    private Long id;
    private Long board;
    private String writer;
    private String comment;

    public Reply toEntity(Board board) {
        return Reply.builder()
                .board(board)
                .writer(this.writer)
                .comment(this.comment)
                .build();
    }
}
