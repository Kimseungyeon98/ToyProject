package project.myProject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {
    private Long id;
    private String loginId;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .loginId(this.loginId)
                .password(this.password)
                .build();
    }
}
