package runners;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.apache.commons.lang.WordUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SyntaxChecker {

    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println(timeStamp);


    }
}
