import org.example.beanlearn.AppConfig;
import org.example.beanlearn.service.ConstructDemo;
import org.example.beanlearn.service.InitializingBeanDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */

public class InitializingBeanTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 通过beanName获取对象。
		InitializingBeanDemo initializingBeanDemo = (InitializingBeanDemo) applicationContext.getBean("initializingBeanDemo");
	}
}
