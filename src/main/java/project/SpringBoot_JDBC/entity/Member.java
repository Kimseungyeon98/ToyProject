package project.SpringBoot_JDBC.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String logInId;
    private String password;

    @Builder
    public Member(String logInId, String password) {
        this.logInId = logInId;
        this.password = password;
    }
}
