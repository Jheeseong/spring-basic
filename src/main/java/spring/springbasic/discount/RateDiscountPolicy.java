package spring.springbasic.discount;

import spring.springbasic.member.Grade;
import spring.springbasic.member.Member;

public class RateDiscountPolicy implements  DiscountPolicy{

    private  int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
