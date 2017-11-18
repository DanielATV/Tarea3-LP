import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class test {
    public static void main(String[] args) {
    	List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		String random = list.get(new Random().nextInt(list.size()));
		System.out.println(random);
    }
}