import com.koko.service.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest {
    @Test
    public void test01(){
        ApplicationContext contest = new ClassPathXmlApplicationContext("applicationContest.xml");

        User user =contest.getBean("p_test",User.class);
        System.out.println(user);
    }
}
