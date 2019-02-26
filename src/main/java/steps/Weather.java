package steps;


import com.jayway.jsonpath.JsonPath;

public class Weather {

    public Object JsonRead(String obj, String path) {

        return JsonPath.parse(obj).read(path);

    }
}
