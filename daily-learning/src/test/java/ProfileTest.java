import org.example.beanlearn.bean.MyProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: hanchaowei
 * @date 2023/4/6
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProfileTest.class)
@ComponentScan("org.example.beanlearn.bean")
@ActiveProfiles("prod") // 激活环境
public class ProfileTest {
	@Autowired
	private MyProfileService myProfileService;

	@Test
	public void getMessage() {
		myProfileService.getMessage();
	}
}
