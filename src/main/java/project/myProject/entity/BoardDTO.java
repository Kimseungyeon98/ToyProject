package project.myProject.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String fileName;
    private String filePath;
    private List<Reply> replies = new ArrayList<>();

    public Board toEntity() {
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .fileName(this.fileName)
                .filePath(this.filePath)
                .replies(this.replies)
                .build();
    }
}
