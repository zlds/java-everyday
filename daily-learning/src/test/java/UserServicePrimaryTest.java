import org.example.beanlearn.bean.UserServicePrimary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: hanchaowei
 * @date 2023/3/29
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServicePrimaryTest.class)
@ComponentScan("org.example.beanlearn.bean")
public class UserServicePrimaryTest {
	@Autowired
	private UserServicePrimary userServicePrimary;


	@Test
	public void testPrimary() {
		
		/**
		 * spring容器中存在多个同一类型的bean时，会抛出异常,如下：
		 * NoUniqueBeanDefinitionException: No qualifying bean of type 'org.example.beanlearn.bean.UserServicePrimary' available: expected single matching bean but found 2: userServicePrimaryImpl1,userServicePrimaryImpl2
		 * 表示有多个Bean可以选择，但不知道选择哪一个。
		 * 问题原因: 容器中存在多个同一类型的bean(userServicePrimary)，当根据类型查找时却没有明确指明使用哪个Bean
		 * 解决方法: 通过@Primary注解指定优先级(在实现类中添加@Primary注解)
		 *
		 */
		userServicePrimary.getMessage();
	}
}
