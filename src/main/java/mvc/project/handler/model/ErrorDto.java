package mvc.project.handler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class ErrorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    private String id;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("description")
    private String description;

    public ErrorDto() {
    }

    public ErrorDto id(String id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Уникальный UUID для логов и отладки"
    )
    public @NotNull String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ErrorDto code(String code) {
        this.code = code;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Код ошибки текстом"
    )
    public @NotNull String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorDto message(String message) {
        this.message = message;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "Описание ошибки для разработчиков"
    )
    public @NotNull String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDto description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty("Описание ошибки для пользователей")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ErrorDto errorDto = (ErrorDto) o;
            return Objects.equals(this.id, errorDto.id)
                    && Objects.equals(this.code, errorDto.code)
                    && Objects.equals(this.message, errorDto.message)
                    && Objects.equals(this.description, errorDto.description);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.id, this.code, this.message, this.description);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorDto {\n");
        sb.append("    id: ").append(this.toIndentedString(this.id)).append("\n");
        sb.append("    code: ").append(this.toIndentedString(this.code)).append("\n");
        sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
        sb.append("    description: ").append(this.toIndentedString(this.description)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
