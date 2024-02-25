package practice.project.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
    private static ObjectMapper objectMapper;

    private ObjectMapperUtil() {

    }

    public static ObjectMapper getInstance() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            return objectMapper;
        }
        return objectMapper;
    }
}
