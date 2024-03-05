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
public class Register {
    @Builder.Default
    private String email= new Faker().internet().emailAddress();
    @Builder.Default
    private String password= new Faker().internet().password();
}
