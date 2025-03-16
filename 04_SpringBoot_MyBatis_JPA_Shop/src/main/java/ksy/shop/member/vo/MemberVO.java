package ksy.shop.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class MemberVO {
    private Long num;
    private String name;
    private String id;
    private String password;
}
