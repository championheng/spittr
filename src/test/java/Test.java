import java.util.ArrayList;
import java.util.List;

/**
 * Created by hg_yi on 17-11-14.
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            System.out.println(item);
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
    }
}
