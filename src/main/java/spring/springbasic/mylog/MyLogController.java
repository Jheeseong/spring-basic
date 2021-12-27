package spring.springbasic.mylog;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyLogController {

    private final MyLogService myLogService;
    private final ObjectProvider<MyLog> myLogObjectProvider;

    @Autowired
    public MyLogController(MyLogService myLogService, ObjectProvider<MyLog> myLogObjectProvider) {
        this.myLogService = myLogService;
        this.myLogObjectProvider = myLogObjectProvider;
    }


    @RequestMapping("log")
    @ResponseBody
    public String log(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        MyLog myLog = myLogObjectProvider.getObject();
        myLog.setUrl(url);

        myLog.log("controller test");
        myLogService.logic("testId");
        return "ok";
    }
}
