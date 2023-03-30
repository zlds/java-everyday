import org.example.beanlearn.bean.MyUserServiceQualifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: hanchaowei
 * @date 2023/3/30
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceQualifierTest.class)
@ComponentScan("org.example.beanlearn.bean")
public class UserServiceQualifierTest {

	@Autowired
	private MyUserServiceQualifier myUserServiceQualifier;


	@Test
	public void testGetMessage1() {
		myUserServiceQualifier.getMessage1();
	}

	@Test
	public void testGetMessage2() {
		myUserServiceQualifier.getMessage2();
	}
}
