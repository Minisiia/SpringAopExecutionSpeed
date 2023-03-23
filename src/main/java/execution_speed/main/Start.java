package execution_speed.main;

import execution_speed.objects.Manager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import execution_speed.objects.FileManager;

/**
 * Вивести швидкість виконання лише тих методів, які позначені @ShowTime.
 * Вивести результати в консоль тільки для тих методів, які позначені @ShowResult.
 * Самостійно створити @ShowTime та @ShowResult.
 */
public class Start {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Manager fileManager = (Manager) context.getBean("fileManager");
		System.out.println("Method with annotation @ShowResult");
		fileManager.getExtensionCount("c:\\Windows\\");
		System.out.println("Method with annotations @ShowTime and @ShowResult");
		fileManager.getExtensionList("c:\\Windows\\");
	}
}
