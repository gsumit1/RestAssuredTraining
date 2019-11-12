package JParsar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class readJson {

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        Reader reader = new FileReader("c:\\Learning\\test.json"); 

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            
            for(Object a:msg.toArray()) {
            	System.out.println(a.toString());
            }
            
            
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

    }


}