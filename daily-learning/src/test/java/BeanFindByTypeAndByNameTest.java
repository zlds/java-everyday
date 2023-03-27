import org.example.beanlearn.AppConfig;
import org.example.beanlearn.service.BeanFindByTypeAndByName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */

public class BeanFindByTypeAndByNameTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("------------------------- BeanFindByTypeAndByName 测试 --------------------------");
		// 通过beanName获取对象。
		BeanFindByTypeAndByName byTypeAndByName = (BeanFindByTypeAndByName) applicationContext.getBean("beanFindByTypeAndByName");

		// 同一个对象
//		System.out.println(applicationContext.getBean("userInfoService"));
//		System.out.println(applicationContext.getBean("userInfoService"));
//		System.out.println(applicationContext.getBean("userInfoService"));

		// 不同对象
		System.out.println(applicationContext.getBean("userInfoService"));
		System.out.println(applicationContext.getBean("userInfoService1"));
		System.out.println(applicationContext.getBean("userInfoService2"));
	}
}
