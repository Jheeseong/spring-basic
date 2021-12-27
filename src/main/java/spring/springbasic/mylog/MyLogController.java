package spring.springbasic.mylog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyLogController {

    private final MyLogService myLogService;
    private final MyLog myLog;

    @Autowired
    public MyLogController(MyLogService myLogService, MyLog myLog) {
        this.myLogService = myLogService;
        this.myLog = myLog;
    }

    @RequestMapping("log")
    @ResponseBody
    public String log(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        System.out.println("myLog = " + myLog.getClass());
        myLog.setUrl(url);

        myLog.log("controller test");
        myLogService.logic("testId");
        return "ok";
    }
}
