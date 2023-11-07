package com.ghdps.core;

import com.ghdps.core.member.Grade;
import com.ghdps.core.member.Member;
import com.ghdps.core.member.MemberService;
import com.ghdps.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("found member = " + foundMember.getName());
    }
}
