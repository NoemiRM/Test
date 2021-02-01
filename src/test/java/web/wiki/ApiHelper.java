package web.wiki;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Created by PilarRM on 1/8/20.
 */
public class ApiHelper {

    public static Map<String,String> mapOfStringsFrom(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey,
                        entry -> entry.getValue().toString()));
    }
}
