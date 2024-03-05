package reques.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.javafaker.Faker;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class User {
    private Number id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

}
