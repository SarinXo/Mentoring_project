package mvc.project.handler.exception;

import org.springframework.http.HttpStatus;

public class IncorrectLoginInformationException extends BaseApiException{

    public IncorrectLoginInformationException(String code, String message, String description) {
        super(code, message, description);
    }

    @Override
    public String toString() {
        return "IncorrectLoginInformationException()";
    }

    public static class Builder {
        private String code = "forbidden";
        private String message;
        private String description;

        public static Builder incorrectLoginInformationException() {
            return new Builder();
        }

        private Builder() {
            this.message = HttpStatus.FORBIDDEN.getReasonPhrase();
            this.description = "Неверный логин или пароль";
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public IncorrectLoginInformationException build() {
            return new IncorrectLoginInformationException(this.code, this.message, this.description);
        }
    }

}
