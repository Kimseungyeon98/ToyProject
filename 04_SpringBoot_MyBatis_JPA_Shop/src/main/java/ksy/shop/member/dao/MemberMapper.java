package ksy.shop.member.dao;

import ksy.shop.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberVO member);
}
