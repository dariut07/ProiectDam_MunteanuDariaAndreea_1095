package ro.ase.moneysaver;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<ContUser> utilizatori = new ArrayList<>();


    public static void adaugaUtilizator(ContUser utilizator) {
        utilizatori.add(utilizator);
    }


    public static List<ContUser> getUtilizatori() {
        return utilizatori;
    }


    public static ContUser valideazaUtilizator(String email, String parola) {
        for (ContUser utilizator : utilizatori) {
            if (utilizator.getEmail().equals(email) && utilizator.getParola().equals(parola)) {
                return utilizator;
            }
        }
        return null;
}
}
