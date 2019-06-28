package zbh.springboot.springboot02crud;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.LocaleResolver;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02CrudApplicationTests {

    @Autowired
    LocaleResolver localeResolver;
    @Test
    public void contextLoads() {
        System.out.println(localeResolver);
    }

}
