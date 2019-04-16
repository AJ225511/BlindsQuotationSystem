package factories.Employee;

import domains.Employeee.Secretary;

public class SecretaryFactory {

    public static  Secretary getSecretary(String type){
        return(Secretary) new Secretary.Builder()
                .type(type)
                .build();
    }
}
