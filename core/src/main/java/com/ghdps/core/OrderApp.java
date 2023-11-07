package com.ghdps.core;

import com.ghdps.core.member.Grade;
import com.ghdps.core.member.Member;
import com.ghdps.core.member.MemberService;
import com.ghdps.core.member.MemberServiceImpl;
import com.ghdps.core.order.Order;
import com.ghdps.core.order.OrderService;
import com.ghdps.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
    }
}
