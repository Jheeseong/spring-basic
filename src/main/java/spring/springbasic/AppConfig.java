package spring.springbasic;

import spring.springbasic.discount.DiscountPolicy;
import spring.springbasic.discount.FixDiscountPolicy;
import spring.springbasic.member.MemberRepository;
import spring.springbasic.member.MemberService;
import spring.springbasic.member.MemberServiceImpl;
import spring.springbasic.member.MemoryMemberRepository;
import spring.springbasic.order.OrderService;
import spring.springbasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}