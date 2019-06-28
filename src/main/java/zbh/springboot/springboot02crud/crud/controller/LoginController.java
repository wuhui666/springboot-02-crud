package zbh.springboot.springboot02crud.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import zbh.springboot.springboot02crud.crud.exception.MyException;

import javax.servlet.http.HttpSession;

/**
 * @author: wuhui
 * @time: 2019/6/22 11:18
 * @desc:
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/","/index.html"})
    public String home(){
        return "index";
    }
    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";

    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String pwd,
                        Model model, HttpSession session){
        if (!StringUtils.isEmpty(name) &&"123".equals(pwd)){
            session.setAttribute("user", name);
            return "redirect:/dashboard";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }

    }
    @GetMapping("/testError")
    public String test(){
        throw new MyException();
    }
}
