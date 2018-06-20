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
		/*Properties property = new Properties();
		property.load(new FileReader("src/main/resources/application.properties"));
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(TransactionsDetails.class);
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(TransactionImage.class);
		SessionFactory sf = cfg.buildSessionFactory();
		sf.close();*/
		int[][] matrix = {{1,0,0,1},{0,0,1,0},{0,0,0,0}};
		System.out.println(matrix.length);
		System.out.println(((int [])matrix[0]).length);
		System.out.println(squaresCount(matrix));
		
	}
	static int squaresCount(int[][] mat) {
        /*
         * Write your code here.
         */
        if(mat == null)
            return 0;
        int row = mat.length;
        int column = ((int [])mat[0]).length;
        int count = 0;
        int arr[] = new int[column];
        for(int i = 0 ;i < column;i++){
            arr[i] = -1;
        }
        for(int i = 0;i<row;i++){
            int[] columnMat = mat[i];
            for(int j=0;j<column;j++){
                if(columnMat[j] == 0){
                    count++;
                    if(arr[j] < 0){
                        arr[j] = 0;
                    }else{
                        arr[j]+=1;
                    }
                }else{
                    arr[j]=-1;
                }
            }
            for(int j = column - 1; j>=0; j--){
                if(arr[j]<=0)
                    continue;
                int value = arr[j];
                boolean found = true;
                int k = j-1;
                if(j - value + 1 < 0 || k < j-value+1)
                    continue;
                for(;k >= j-value+1;k--){
                    if(arr[k] == value)
                        continue;
                    found = false;
                    break;
                }
                if(found)
                    count++;
            }
        }
        return count;
    }
}
