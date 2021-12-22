# spring-basic

v1.02 12/22
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


v1.01 12/22
주문 및 할인 도메인 개발, 실행, 테스트


v1.00 12/22
회원 도메인 개발 ,회원 저장소 개발, 회원 서비스 개발, 회원 도메인 테스트

MemoryMemberRepository에 HashMap은 동시성 이슈가 있으나 테스트를 위해 진행

MemberDomain,OrderDomain 설게의 문제점
-의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존
-> 추후 수정 예정
- OCP 원칙 DIP 원칙 무시 중
