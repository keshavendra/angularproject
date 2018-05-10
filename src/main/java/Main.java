import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kps.angularproject.application.dao.hibernatepojo.Category;
import com.kps.angularproject.application.dao.hibernatepojo.TransactionImage;
import com.kps.angularproject.application.dao.hibernatepojo.TransactionsDetails;
import com.kps.angularproject.application.dao.hibernatepojo.User;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileReader("src/main/resources/application.properties"));
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(TransactionsDetails.class);
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(TransactionImage.class);
		SessionFactory sf = cfg.buildSessionFactory();
		sf.close();
	}
}
