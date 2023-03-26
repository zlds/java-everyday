import org.example.beanlearn.AppConfig;
import org.example.beanlearn.service.ConstructDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */

public class ConstructTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 通过beanName获取对象。
		 ConstructDemo constructDemo = (ConstructDemo) applicationContext.getBean("constructDemo");
	}
}
