import org.example.beanlearn.service.PostConstructDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: hanchaowei
 * @date 2023/3/24
 * @description:
 */

@SpringBootTest(classes = PostConstructDemo.class)
public class PostConstructTest {
	@Autowired
	private PostConstructDemo postConstructDemo;

	@Test
	public void test() {
		System.out.println(postConstructDemo.getMessage());
	}
}
