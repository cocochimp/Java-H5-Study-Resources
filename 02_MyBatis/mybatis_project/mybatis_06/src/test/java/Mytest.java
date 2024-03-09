import com.koko.dao.BlogMapper;
import com.koko.pojo.Blog;
import com.koko.utils.IDutils;
import com.koko.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mytest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("1");
        blog.setAuthor("张三");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("2");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("3");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("4");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

       HashMap map=new HashMap();
       map.put("title","1");

        List<Blog> blogs = mapper.queryBlogIF(map);

        for(Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map=new HashMap();
        map.put("title","1");

        List<Blog> blogs = mapper.queryBlogChoose(map);

        for(Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map=new HashMap();
        map.put("id","aad349619f7043538c9f27077c11db87");
        map.put("title","1");

        mapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map=new HashMap();

        ArrayList<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
