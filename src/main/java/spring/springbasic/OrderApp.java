package spring.springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springbasic.member.Grade;
import spring.springbasic.member.Member;
import spring.springbasic.member.MemberService;
import spring.springbasic.member.MemberServiceImpl;
import spring.springbasic.order.Order;
import spring.springbasic.order.OrderService;
import spring.springbasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        long memberId = 1L; Member member = new Member(memberId, "memberA", Grade.VIP);memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
