package camel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CamelCase {

    public static List<String> converterCamelCase(String original){
        List<String> list = new ArrayList<>();

        int contador = 0;

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\s]");
        boolean containsSpecialCharacters = pattern.matcher(original).find();
        if(containsSpecialCharacters){
            return List.of("Invalida");
        }

        for (String w : original.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])|(?<=[0-9])(?=[a-zA-Z])|(?<=[a-zA-Z])(?=[0-9])")) {
            char[] palavra = w.toCharArray();

            if (palavra[0] >= '0' && palavra[0] <= '9' && contador == 0) {
                return List.of("Invalida");
            }
            if (palavra[1] >= 'a' && palavra[1] <= 'z') {
                w = w.toLowerCase();
            }
            list.add(w);
            contador++;
        }
        return list;
    }
}
