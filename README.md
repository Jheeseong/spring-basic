# spring-basic

# v1.07 12/25

2개의 빈이 조회 될 시 NoUniqueBeanDefinitionException 오류가 발생(FixDiscountPolicy,RateDiscountPolicy)

@Autowired 필드명 매칭, @Qualifier 매칭, @Primary 매칭으로 해결

- @Autowired

타입 맻이을 시도하고 여러 빈이 있으면 필드 이름, 파라미터 이름으로 빈 추가 후 매칭

- @Qualifier

추가 구분자를 붙여주는 방법을 제공, 빈이름 변경은 아님

@Qualifier끼리 매칭

빈 이름 매칭

- @Primary

우선 순위를 정하는 방법

@Primary는 기본 값처럼 동작하고 @Qualifier은 상세하게 동작하며 @Qualifier가 우선권을 가짐

- 조회한 빈이 모두 필요할 떄 List,Map 사용

map키에 스프링 빈의 이름을 넣고 DiscountPolicy 타입으로 조회한 모든 스프링 빈을 담음

List에 DiscountPolicy 타입으로 조회한 모든 스프링을 담음

선택적으로 조회한 빈을 사용 가능

-> 자동 조회 기능을 기본으로 사용하지만 다형성을 활용하는 비지니스 로직은 수동 등록을 고민

   직접 등록하는 기술 지원 객체는 수동 등록

# v1.06 12/23

@ComponentScan을 통하여 컴포넌트 애노테이션이 붙은 클래스를 스캔 후 스프링 빈에 자동 등록

@Autowired를 통해 의존관게 주입

MemoryMemberRepository, RateDiscountPolicy, MemberServiceimpl에 컴포넌트 추가

MemberServiceimpl, OrderServiceimpl에 Autowired 추가 

클래스를 스프링 빈에 등록 시 클래스명 그대로 사용하되 맨 앞글자만 소문자를 사용(빈 이름 지정 가능)

@Contriller : 스프링 MVC 컨트롤러로 인식

@Repository : 스프링 데이터 접근 계층으로 인식하고 데이터 계층의 예외를 스프링 예외로 변환

@Configuration : 스프링 빈이 싱글톤을 유지하도록 처리

@Service : 개발자들이 핵심 비지니스 계층 인식 하도록 함

컴포넌트 스캔에서 이름이 같은 클래스가 스크린 빈에 등록 될 경우 
ConflictingBeanDefinitionException 예외 발생

수동 빈 등록과 자동 빈 등록이 충돌 될 경우 수동 빈 등록이 우선권을 가짐
(수동 빈이 자동 빈을 오버라이딩)

-> 스트링 부트에서 실행 시 CoreApplication 오류가 생성

다양한 의존관계 주입 방법
- 생성자 주입

생성자 호출 시점에 1번만 호출 보장

불편,필수 의존관계에 사용(final)

생성자 1개 있을 시 생략 가능
- 수정자 주입(setter 주입)

선택,변경 가능성이 있는 의존관계에 사용
- 필드 주입

외부에서 변경 불가능

스프링 설정을 목표로 하는 @Configuration에서만 특별한 용도로 사용 가능
- 일반 메서드 주입

한번에 여러 필드 주입 가능

일반적으로 사용 X

-> 생성자 주입 선택!!

대부분의 의존관계 주입은 일어날 시 거의 변경 X(불변)


# v1.05 12/23

스프링 없는 순수한 ID 컨테이너 테스트, 싱글톤 패턴 적용 테스트, 싱글톤 컨테이너 적용 테스트 작성

순수 ID 컨테이너 테스트 시 고객 트래픽 마다 객체가 생성되는 문제 존재

-> 싱클톤 패턴을 적용한 코드 사용

(private 생성자를 사용해 외부의 new 키워드로 객체 인스턴스 생성 막음)

싱글톤 패턴 문제점

- 의존관계상 클라이언트가 구체 클래스에 의존 -> DIP 위반
- 클라이언트가 구체 클래스에 의존해 OCP 위반 가능성이 높음
- 내부 속성을 변경하거나 초기화에 어려움 존재

--> 스프링 컨테이너는 싱글톤 패턴을 적용하지 않아도 객체 인스턴스를 싱글톤으로 관리!!


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
