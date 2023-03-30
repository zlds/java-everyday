import org.example.beanlearn.bean.UserServiceResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: hanchaowei
 * @date 2023/3/30
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyUserServiceResourceTest.class)
@ComponentScan("org.example.beanlearn.bean")
public class MyUserServiceResourceTest {
	/**
	 * 通过Bean名称查找
	 */
	@Resource(name = "userServiceResourceImpl2")
	private UserServiceResource userServiceResource;

	@Test
	public void testDoSomething() {
		userServiceResource.getMessage();
	}

}
