package project.myProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long id;

    private String title;
    private String content;

    private String fileName;
    private String filePath;

    @OneToMany(mappedBy="board")
    private List<Reply> replies = new ArrayList<>();

    @Builder
    public Board(String title, String content, String fileName, String filePath, List<Reply> replies) {
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.filePath = filePath;
        this.replies = replies;
    }
}