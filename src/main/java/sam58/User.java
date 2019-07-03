package sam58;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Slf4j
@ToString
public class User {
    private String name;
    private Integer age;
    private LocalDate date;

    private Address address;
    private List<String> roles;
    private Cv cv;

    public String outLog(){

        log.error("Something else is wrong here");
        return "Something else is wrong here";
    }
}

@Setter
@Getter
@ToString
class Address{
    private String  line1;
    private String line2;
    private String city;
    private String zip;

}

@Getter
@Setter
@ToString
class Cv{
    private List<CvLine> cvLines;
}

@Getter
@Setter
@ToString
class CvLine {
    private String line;
    LocalDate dateBegin;
    LocalDate dateEnd;
    private String position;
}