package spring.springbasic.mylog;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = "request")
public class MyLog {

    private String uuid;
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "],[" + url + "]" + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}
