package vn.vissoft.portal.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = CustomOauthExceptionSerializer.class)

public class CustomOauthException extends OAuth2Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int httpErrorCode;

    public CustomOauthException(String msg) {
        super(msg);
    }

    public CustomOauthException(String msg, int httpErrorCode) {
        super(msg);
        this.httpErrorCode = httpErrorCode;
    }

    public int getHttpErrorCode() {
        return httpErrorCode;
    }

    public void setHttpErrorCode(int httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }


}
