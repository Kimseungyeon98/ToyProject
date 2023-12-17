package project.myProject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long id;

    private String title;
    private String content;

    private String fileName;
    private String filePath;

    @OneToMany(mappedBy = "board")
    private List<Reply> replies = new ArrayList<>();
}