import org.example.beanlearn.bean.AppConfig;
import org.example.beanlearn.bean.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/3/27
 * @description:
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testFindByType() {
		// 获取容器中所有的UserService实现类
		Map<String, UserService> userServiceMap = applicationContext.getBeansOfType(UserService.class);
		for (Map.Entry<String, UserService> entry : userServiceMap.entrySet()) {
			System.out.println("Bean name: "+entry.getKey() + ", Bean type:  " + entry.getValue().getClass());
		}

	}







}
