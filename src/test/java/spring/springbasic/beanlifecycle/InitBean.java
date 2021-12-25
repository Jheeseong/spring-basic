package spring.springbasic.beanlifecycle;

public class InitBean {

    private String network;

    public InitBean() {
        System.out.println("생성자 호출, url = " + network);
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void connect(){
        System.out.println("connect : " + network);
    }

    public void call(String message) {
        System.out.println("call : " + network +"message = " + message);
    }

    public void disconnect() {
        System.out.println("close : " + network);
    }

    public void init() {
        System.out.println("BeanLifeCycle.init");
        connect();
        call("초기화 연결 메세지");
    }

    public void close() {
        System.out.println("BeanLifeCycle.close");
        disconnect();
    }
}
