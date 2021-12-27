package spring.springbasic.mylog;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyLogService {

    private final ObjectProvider<MyLog> myLogObjectProvider;

    @Autowired
    public MyLogService(ObjectProvider<MyLog> myLogObjectProvider) {
        this.myLogObjectProvider = myLogObjectProvider;
    }


    public void logic(String id) {
        MyLog myLog = myLogObjectProvider.getObject();
        myLog.log("service id = " + id);
    }

}
