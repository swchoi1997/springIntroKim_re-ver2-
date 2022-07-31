package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    // 생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해서 주입해준다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(rateDiscountPolicy(), memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private RateDiscountPolicy rateDiscountPolicy(){
        return new RateDiscountPolicy();
    }

    private FixDiscountPolicy fixDiscountPolicy(){
        return new FixDiscountPolicy();
    }
}