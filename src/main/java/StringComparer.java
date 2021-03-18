import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringComparer {

    public static boolean compare(String s1, String s2) {

        String[] strArr1 = s1.toLowerCase().split("");
        List<String> strList1 = Arrays.asList(strArr1);
        strList1.sort(Comparator.naturalOrder());

        String[] strArr2 = s2.toLowerCase().split("");
        List<String> strList2 = Arrays.asList(strArr2);
        strList2.sort(Comparator.naturalOrder());

        return strList1.equals(strList2);
    }


}