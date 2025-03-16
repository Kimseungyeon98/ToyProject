package ksy.shop.member.service;

import ksy.shop.member.dao.MemberMapper;
import ksy.shop.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void insertMember(MemberVO member) {
        memberMapper.insertMember(member);
    }
}
