package debug;

import java.io.InputStream;

import bean.User;
/*
入门程序测试类
*/
public class MyBatisTest {

	//根据客尸编号查询客尸信息
	public static void findCustomerByldTest() throws Exception{
		//读取配置文件
		String resource = "mybatis-config.xml";
		//InputStream inputStream = Resources.getResourceAsStream(resource);
		//根据配置文件构建Sq1SessionFactory
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder() .build(inputStream);
		//通过Sq1SessionFactory 创建SqlSession
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession 执行映射文件中定义的SQL ，并返回映射结果
		//User user = sqlSession.selectOne("com.community.mapper" + ".UserMapper.findUserById","user20190226101036");
		//打印输出结果
		//System.out.println(user.toString());
		//关闭SqlSession
		//sqlSession.close();
	}
}

