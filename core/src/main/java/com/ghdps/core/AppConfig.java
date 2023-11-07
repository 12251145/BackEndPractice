package com.ghdps.core;

import com.ghdps.core.discount.DiscountPolicy;
import com.ghdps.core.discount.FixDiscountPolicy;
import com.ghdps.core.discount.RateDiscountPolicy;
import com.ghdps.core.member.MemberService;
import com.ghdps.core.member.MemberServiceImpl;
import com.ghdps.core.member.MemoryMemberRepository;
import com.ghdps.core.order.OrderService;
import com.ghdps.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}