package di;

import org.springframework.context.support.
ClassPathXmlApplicationContext;
public class KnightMain {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context =
				//Load Spring context
				//Get knight bean
				new ClassPathXmlApplicationContext(
						"beans.xml");
		Knight knight = context.getBean(Knight.class);

		knight.embarkOnQuest();
		context.close();
	}
}