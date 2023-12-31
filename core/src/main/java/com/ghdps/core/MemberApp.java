package com.ghdps.core;

import com.ghdps.core.member.Grade;
import com.ghdps.core.member.Member;
import com.ghdps.core.member.MemberService;
import com.ghdps.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("found member = " + foundMember.getName());
    }
}
