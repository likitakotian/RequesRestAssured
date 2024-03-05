package reques.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import reques.utils.TestUtil;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateUserData {
    @Builder.Default
    private String name = new Faker().name().firstName();
    @Builder.Default
    private String job = new Faker().job().title();
}