package sam58;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Objects;

/**
 * Hello YAML!
 * https://www.baeldung.com/jackson-yaml
 */
@Slf4j
public class App 
{
    public static void main( String[] args )
    {

        try{
            //We’re going to use Jackson’s ObjectMapper to read our YAML file into an Order object, so let’s set that up now:
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory())
                    .registerModule(new JavaTimeModule());// new module, NOT JSR310Module

            //We need to use the findAndRegisterModules method so that Jackson will handle our Date properly:
            mapper.findAndRegisterModules();

            //Once we have our ObjectMapper configured, we simply use readValue
            User user = mapper.readValue(
                    new File(
                            Objects.requireNonNull(User.class.getClassLoader().getResource("test.yaml")).getFile()
                    ),
                    User.class
            );

            System.out.println("user - "+ user.toString());
        }catch(Exception e){
            log.error("!!!!!!!!!!!!!!!!!!! Error",e);
        }

    }
}
