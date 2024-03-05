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
public class Resources {
    private  Number id;
    private Number per_page;
    private Number total;
    private Number total_pages;
    private Data data;
    private Support support;
}
