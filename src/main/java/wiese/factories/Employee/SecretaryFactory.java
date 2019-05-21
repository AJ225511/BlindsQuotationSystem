package wiese.factories.Employee;

import wiese.domains.Employeee.Secretary;

public class SecretaryFactory {

    public static  Secretary getSecretary(String type){
        return(Secretary) new Secretary.Builder()
                .type(type)
                .build();
    }
}
