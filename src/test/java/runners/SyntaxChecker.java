package runners;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.apache.commons.lang.WordUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SyntaxChecker {

    public static void main(String[] args) {
        Map<String, Map<String, String>> activitiesAndInvoices = new HashMap<>();
        Map<String, String> testMap1 = new HashMap<>();
        testMap1.put("Key1", "Value1");
        testMap1.put("Key2", "Value2");
        Map<String, String> testMap2 = new HashMap<>();
        testMap2.put("Key1", "Value1");
        testMap2.put("Key2", "Value2");
        activitiesAndInvoices.put("TestMap1", testMap1);
        activitiesAndInvoices.put("TestMap2", testMap2);

        Map<String, Map<String, String>> activitiesAndInvoices2 = new HashMap<>();
        Map<String, String> testMap12 = new HashMap<>();
        testMap12.put("Key1", "Value1");
        testMap12.put("Key2", "Value2");
        Map<String, String> testMap22 = new HashMap<>();
        testMap22.put("Key1", "Value1");
        testMap22.put("Key2", "Value3");
        activitiesAndInvoices2.put("TestMap1", testMap12);
        activitiesAndInvoices2.put("TestMap2", testMap22);
        Set<String> set = activitiesAndInvoices.keySet();
        for (String key : set) {
            if (!activitiesAndInvoices.get(key).equals(activitiesAndInvoices2.get(key))) {
                SeleniumUtils.logInfo(key + " is not Matched\nExpected :\n" + activitiesAndInvoices.get(key) + "\nActual :\n" + activitiesAndInvoices2.get(key));
            }

        }
        System.out.println("Info Not Matched:\n" + SeleniumUtils.getMessageToPrint());
//        String CBR = "0|Task|No\n";
//        String CBC = "BESTWAY Transport\n";
//        String BCTC = "2|Dashboard|Yes|\n";
//        System.out.println(CBR.split("\\|")[0]);
//        System.out.println(WordUtils.capitalizeFully(CBC, new char[]{' '}));
//        String address = CBC + CBR + BCTC;
//        System.out.println(address);
//        if (address.charAt(address.length() - 1) == '\n') {
//            address = address.substring(0, address.length() - 2);
//        }
//        System.out.println(address);
//        System.out.println("hi");
    }
}
