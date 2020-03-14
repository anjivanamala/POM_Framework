package runners;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class XTREAM {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("Name", "Tharun");
        map.put("Key2", "Value2");
        map.put("Key3", "Value3");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(map.get(key));
        }
    }


}