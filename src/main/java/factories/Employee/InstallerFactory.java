package factories.Employee;

import domains.Employeee.Installer;

public class InstallerFactory {

    public static Installer getInstaller(String installDate){
        return( Installer) new  Installer.Builder()
                .installDate(installDate)
                .build();
    }
}
