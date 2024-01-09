package project.myProject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {
    private Long id;
    private String logInId;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .logInId(this.logInId)
                .password(this.password)
                .build();
    }
}
