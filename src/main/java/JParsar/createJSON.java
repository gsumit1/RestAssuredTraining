package JParsar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class createJSON {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "Sumit");
        obj.put("age", 49);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("c:\\Learning\\test.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}