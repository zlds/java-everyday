import org.example.beanlearn.AppConfig;
import org.example.beanlearn.service.BeanFindByTypeAndByName;
import org.example.beanlearn.service.UserAopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */

public class UserAopTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("------------------------- BeanFindByTypeAndByName 测试 --------------------------");
		// 通过beanName获取对象。
		UserAopService userAopService = (UserAopService) applicationContext.getBean("userAopService");
		userAopService.test();
	}
}
