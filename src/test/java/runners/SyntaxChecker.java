package runners;

import com.agility.focis.CBR.CBREDI;
import org.apache.commons.lang.WordUtils;

import java.util.HashMap;
import java.util.Map;

public class SyntaxChecker {

    public static void main(String[] args) {
        Map<String, String> activitiesAndInvoices = new HashMap<>();
        String CBR = "0|Task|No\n";
        String CBC = "BESTWAY Transport\n";
        String BCTC = "2|Dashboard|Yes|\n";
        System.out.println(CBR.split("\\|")[0]);
        System.out.println(WordUtils.capitalizeFully(CBC, new char[]{' '}));
        String address = CBC + CBR + BCTC;
        System.out.println(address);
        if (address.charAt(address.length() - 1) == '\n') {
            address = address.substring(0, address.length() - 2);
        }
        System.out.println(address);
        System.out.println("hi");
    }
}
