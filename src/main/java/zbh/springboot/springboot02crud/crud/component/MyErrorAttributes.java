package zbh.springboot.springboot02crud.crud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wuhui
 * @time: 2019/6/22 23:17
 * @desc:
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        HashMap<String, Object> map = (HashMap<String, Object>) super.getErrorAttributes(webRequest, includeStackTrace);
        /*新加自定义字段*/
        map.put("diy", "DIY");
        /*获取ExceptionHandler夹带的错误信息一起显示*/
        map.put("extra", webRequest.getAttribute("extra", 0));
        return map;
    }
}
