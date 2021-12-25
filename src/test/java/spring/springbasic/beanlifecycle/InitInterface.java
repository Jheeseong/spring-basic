package spring.springbasic.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InitInterface implements InitializingBean, DisposableBean {

    private String network;

    public InitInterface() {
        System.out.println("생성자 호출, url = " + network);
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void connect() {
        System.out.println("connect: " + network);
    }
    public void call(String message) {
        System.out.println("call: " + network + " message = " + message);
    } //서비스 종료시 호출
    public void disConnect() {
        System.out.println("close = " + network);
    }

    @Override
    public void destroy() throws Exception {
        disConnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }
}
