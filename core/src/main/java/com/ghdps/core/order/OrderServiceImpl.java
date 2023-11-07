package com.ghdps.core.order;

import com.ghdps.core.discount.DiscountPolicy;
import com.ghdps.core.discount.FixDiscountPolicy;
import com.ghdps.core.member.Member;
import com.ghdps.core.member.MemberRepository;
import com.ghdps.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
