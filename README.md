# spring-basic

# v1.04 12/22

스프링으로 전환, @Configuration, @Bean 추가

@Configuration을 통하여 Appconfig에 설정을 구성

@Bean을 통하여 스프링 컨케이너에 스프링 빈 등록

기존에는 AppConfig를 사용하여 직접 객체를 생성 및 DI하였지만 위 설정을 통해 스프링컨테이너를 통해 사용

이젠 AppConfig를 이용한 조회가 아닌 getBean()을 통해 스프링 빈(객체)를 검색

# v1.03 12/22

AppConfig 추가 및 도메인, 테스트 코드 수정

애플리케이션의 전체 동작 방식 구성하기 위해 구현 객체 생성,연결을 책임지는 클래스 생성(관심사의 분리)


MemberServiceImpl, MemoryMemberRepository, OrderServiceImpl, FixDiscountPolicy 구현 객체 생성

생성자를 통해서 레퍼런스를 연결

AppConfig을 통해 클라이언트 코드 코드 변경 필요없이 수정 가능, 애플리케이션을 크게 사용영역과
객체를 생성하고 구성하는 영역으로 분리

-> OCP,DIP 객체지향 설계 원칙을 준수

Appconfig 클래스를 통해 역할과 구현을 명확하게 확인 가능



# v1.02 12/22

RateDiscountPolicy(새로운 정책)추가 및 테스트

문제점

OCP,DIP 같은 객체지향 설계 원칙을 준수하지 못함

DIP

-OrderServiceImpl은 DiscountPolicy 인터페이스에 의존하면서 RateDiscountPolicy 혹은
 FixDiscountPolicy에 동시 의존

OCP

-기능을 확장해서 변경하면, OrderServiceImpl에 영향

해결법

인터페이스에만 의존하도록 설계 변경 계획


# v1.01 12/22

주문 및 할인 도메인 개발, 실행, 테스트


# v1.00 12/22

회원 도메인 개발 ,회원 저장소 개발, 회원 서비스 개발, 회원 도메인 테스트

MemoryMemberRepository에 HashMap은 동시성 이슈가 있으나 테스트를 위해 진행

MemberDomain,OrderDomain 설게의 문제점
-의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존
-> 추후 수정 예정
- OCP 원칙 DIP 원칙 무시 중
