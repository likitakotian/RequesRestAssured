package reques.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserData {
    @Builder.Default
    private String name = new Faker().name().firstName();
    @Builder.Default
    private String job = new Faker().job().title();
}