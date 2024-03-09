import com.koko.dao.UserMapper;
import com.koko.pojo.User;
import com.koko.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Mytest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user01 = mapper.queryUserById(1);
        System.out.println(user01);

        System.out.println("================");
        sqlSession.clearCache();

        User user02 = mapper.queryUserById(1);
        System.out.println(user02);

        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession01 = MybatisUtils.getSqlSession();
        UserMapper mapper01 = sqlSession01.getMapper(UserMapper.class);
        SqlSession sqlSession02 = MybatisUtils.getSqlSession();
        UserMapper mapper02 = sqlSession02.getMapper(UserMapper.class);

        User user01 = mapper01.queryUserById(1);
        System.out.println(user01);
        sqlSession01.close();

        System.out.println("================");

        User user02 = mapper02.queryUserById(1);
        System.out.println(user02);
        System.out.println(user01==user02);
        sqlSession02.close();
    }
}
