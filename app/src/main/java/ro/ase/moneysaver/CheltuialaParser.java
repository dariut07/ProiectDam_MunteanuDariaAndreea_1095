package ro.ase.moneysaver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheltuialaParser {
    public static List<Cheltuiala> parseJson(String json) throws JSONException {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parserCheltuieli(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException();
        }

    }
    private static List<Cheltuiala> parserCheltuieli(JSONArray jsonArray) throws JSONException {
        List<Cheltuiala> cheltuieli = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            cheltuieli.add(parserCheltuiala(jsonArray.getJSONObject(i)));
        }
        return cheltuieli;
    }
    private static Cheltuiala parserCheltuiala(JSONObject jsonObject) throws JSONException {
        double suma = jsonObject.getDouble("suma");
        String dataString = jsonObject.getString("data");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date data = null;
        try {
            data = dateFormat.parse(dataString);
        } catch (ParseException e) {
            throw new JSONException("Data este invalidă");
        }
        String descriere = jsonObject.getString("descriere");
        String val = jsonObject.getString("valuta");
        Valuta valuta = Valuta.valueOf(val);
        String cat = jsonObject.getString("categorie");
        Categorie categorie = Categorie.valueOf(cat);
        String metoda = jsonObject.getString("metodaPlata");
        MetodaPlata metodaPlata = MetodaPlata.valueOf(metoda);
        boolean esteUrgenta = jsonObject.getBoolean("esteUrgenta");
        return new Cheltuiala(suma, data, descriere, valuta, categorie, metodaPlata, esteUrgenta);

    }
}
