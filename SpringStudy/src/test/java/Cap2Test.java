import com.sf.cap2.config.Cap2MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Cap2Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap2MainConfig.class);

		String[] names = app.getBeanDefinitionNames();
		
		for(String name:names){
			System.out.println(name);
		}

		app.close();
	}

}
