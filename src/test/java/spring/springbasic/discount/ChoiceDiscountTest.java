package spring.springbasic.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springbasic.AutoAppConfig;
import spring.springbasic.member.Grade;
import spring.springbasic.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ChoiceDiscountTest {

    @Test
    void DiscountChoice() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountMap.class);

        DiscountMap discountMap = ac.getBean(DiscountMap.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountMap.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountMap).isInstanceOf(DiscountMap.class);
        assertThat(discountPrice).isEqualTo(1000);
    }

    static class DiscountMap {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountMap(Map<String, DiscountPolicy> policyMap,
                           List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {

            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            System.out.println("discountPolicy = " + discountPolicy);
            System.out.println("discountCode = " + discountCode);

            return discountPolicy.discount(member,price);
        }
    }
}
