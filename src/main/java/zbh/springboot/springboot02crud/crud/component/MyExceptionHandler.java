package zbh.springboot.springboot02crud.crud.component;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import zbh.springboot.springboot02crud.crud.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: wuhui
 * @time: 2019/6/22 23:03
 * @desc:
 */
@ControllerAdvice
public class MyExceptionHandler{

    @ExceptionHandler(MyException.class)
    public String handle(Exception e, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        map.put("tel", "1324234353");
        map.put("QQ", "45354637");
        request.setAttribute("extra", map);
        /*一定要改变状态码，否则会视为成功，因为是200*/
        request.setAttribute("javax.servlet.error.status_code", 500);
        return "forward:/error";

    }
}
