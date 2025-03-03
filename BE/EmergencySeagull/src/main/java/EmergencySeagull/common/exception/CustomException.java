package EmergencySeagull.common.exception;

import EmergencySeagull.common.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private ExceptionCode exceptionCode;
    private String message;

    public CustomException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
        this.message = exceptionCode.getMessage();
    }

    public CustomException(ExceptionCode exceptionCode, String message) {
        this.exceptionCode = exceptionCode;
        this.message = message;
    }

    public ApiUtils.ApiFail body() {
        return ApiUtils.fail(message, exceptionCode.getHttpStatus());
    }

    public HttpStatus status() {
        return exceptionCode.getHttpStatus();
    }
}