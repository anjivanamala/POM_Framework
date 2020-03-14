package runners;

import java.util.HashMap;
import java.util.Map;

public class SyntaxChecker {

    public static void main(String[] args) {
        Map<String, String> activitiesAndInvoices = new HashMap<>();
        String CBR = "0|Task|No";
        String CBC = "0|Task|Yes|";
        String BCTC = "2|Dashboard|Yes|";
        System.out.println(CBR.split("\\|")[0]);
    }
}
