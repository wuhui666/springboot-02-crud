package zbh.springboot.springboot02crud.crud.exception;

/**
 * @author: wuhui
 * @time: 2019/6/22 23:05
 * @desc:
 */
public class MyException extends RuntimeException {
    public MyException() {
        super("My exception");
    }
}
