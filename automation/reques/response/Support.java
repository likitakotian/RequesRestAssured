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
public class Support {
    private String url;
    private String text;
}
