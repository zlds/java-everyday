import org.example.beanlearn.bean.FindByBeanName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: hanchaowei
 * @date 2023/3/28
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FindByBeanNameTest.class)
@ComponentScan("org.example.beanlearn.bean")
public class FindByBeanNameTest {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testBeanName() {
		FindByBeanName findByBeanName = (FindByBeanName) applicationContext.getBean("myBeanName");
		System.out.println("--------------");
		findByBeanName.getMessage();
	}
}
