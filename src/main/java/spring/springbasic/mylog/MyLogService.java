package spring.springbasic.mylog;

import org.springframework.stereotype.Service;

@Service
public class MyLogService {

    private final MyLog myLog;

    public MyLogService(MyLog myLog) {
        this.myLog = myLog;
    }

    public void logic(String id) {
        myLog.log("service id = " + id);
    }

}
