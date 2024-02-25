package practice.project.controller.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResponseDto<T> implements Serializable {
    private boolean success = false;
    private T content;

    public static <T> ResponseDto<T> ofSuccess(T content) {
        ResponseDto<T> response = new ResponseDto<>();
        response.success = true;
        response.content = content;
        return response;
    }

    public static ResponseDto<String> ofFailure(String message) {
        ResponseDto<String> response = new ResponseDto<>();
        response.content = message;
        return response;
    }
}
