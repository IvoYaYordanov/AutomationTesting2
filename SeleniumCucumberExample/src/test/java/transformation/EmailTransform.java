package transformation;

import cucumber.api.Transform;
import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String> {

    @Override
    public String transform(String email){
        return email.concat("The email is ea.com");
    }

}
