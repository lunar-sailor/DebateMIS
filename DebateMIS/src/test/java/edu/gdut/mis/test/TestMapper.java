package edu.gdut.mis.test;

import edu.gdut.mis.entity.Debater;
import edu.gdut.mis.mappers.DebaterMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMapper {
//    @Test
//    public void TestMapper() throws IOException {
//        //加载核心配置文件
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取sqlSessionFactoryBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //获取SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        //获取SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //获取mapper接口对象
//        //底层使用了代理模式
//        DebaterMapper mapper = sqlSession.getMapper(DebaterMapper.class);
//        //测试功能
//        int result = mapper.insertDebater();
//        //提交
//        //sqlSession.commit();
//        System.out.println("result"+result);
//        sqlSession.close();
//    }

    @Test
    public void TestUpdate() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DebaterMapper mapper = sqlSession.getMapper(DebaterMapper.class);
        mapper.updateDebater();
        System.out.println("success");
        sqlSession.close();
    }

    @Test
    public void TestCRUD() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DebaterMapper mapper = sqlSession.getMapper(DebaterMapper.class);
        //mapper.deleteDebater();
        //Debater debater = mapper.getDebaterById();
        //String username = mapper.getUsernameById();
        //System.out.println(debater +" "+ "success");
        //List<Debater> list = mapper.getAllDebater();
        //list.forEach(debater -> System.out.println(debater));
        Debater debater = mapper.getDebaterById(2);
        System.out.println(debater);
        sqlSession.close();
    }
}
