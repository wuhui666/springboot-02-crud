package zbh.springboot.springboot02crud.crud.component;

import org.apache.tomcat.jni.Local;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author: wuhui
 * @time: 2019/6/22 12:04
 * @desc:
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lang=httpServletRequest.getParameter("l");
        Locale locale =Locale.getDefault();//没有就默认
        if (lang!=null){
            String[] infos=lang.split("_");
            locale=new Locale(infos[0], infos[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
