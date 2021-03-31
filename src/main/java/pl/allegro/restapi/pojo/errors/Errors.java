package pl.allegro.restapi.pojo.errors;

import java.util.List;

public class Errors {

    private List<Error> errors = null;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}