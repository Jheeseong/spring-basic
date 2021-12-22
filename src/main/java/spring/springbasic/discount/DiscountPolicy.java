package spring.springbasic.discount;

import spring.springbasic.member.Member;

public interface DiscountPolicy {

    //할인 대상 금액
    int discount(Member member, int price);
}
