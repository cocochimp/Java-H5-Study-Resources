import com.koko.config.kokoConfig;
import com.koko.service.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mytest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(kokoConfig.class);

        User getUser = annotationConfigApplicationContext.getBean("getUser", User.class);
        System.out.println(getUser.getName());

    }
}
