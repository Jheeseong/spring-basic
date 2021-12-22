package spring.springbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springbasic.discount.DiscountPolicy;
import spring.springbasic.discount.FixDiscountPolicy;
import spring.springbasic.member.MemberRepository;
import spring.springbasic.member.MemberService;
import spring.springbasic.member.MemberServiceImpl;
import spring.springbasic.member.MemoryMemberRepository;
import spring.springbasic.order.OrderService;
import spring.springbasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}