package mvc.project.handler.exception;

import org.springframework.http.HttpStatus;

public class NotFoundApiException extends BaseApiException {
    private NotFoundApiException(String code, String message, String description) {
        super(code, message, description);
    }

    @Override
    public String toString() {
        return "NotFoundApiException()";
    }

    public static class Builder {
        private String code = "not_found";
        private String message;
        private String description;

        public static Builder notFoundApiException() {
            return new Builder();
        }

        private Builder() {
            this.message = HttpStatus.NOT_FOUND.getReasonPhrase();
            this.description = "Ресурс не найден";
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

        public NotFoundApiException build() {
            return new NotFoundApiException(this.code, this.message, this.description);
        }
    }
}
