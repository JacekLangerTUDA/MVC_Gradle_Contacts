package etit.temp.contacts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class ContactsApplicationTests {

	@Container
	public static DockerComposeContainer<?> ENV = new DockerComposeContainer<>(ComposeUtils.getComposeFile());
	@Test
	void contextLoads() {
	}

}
