package stringcalculator;

public class StringCalculator {
    public static int add(String input) {
        String separators = ",|\n";
        int sum = 0;
        if (input =="") { return 0;}
        // si le chaine commence par //
        if(input.startsWith("//")){
            // => recuperer la chaine qui est avant le 1er \n
            String[] strWithDoubleSlash = input.split("\n");
            String delimiter=strWithDoubleSlash[0].substring(2);
            //System.out.println(delimiter);
            // l'ajouter avec un pipe à la fin du Separateur
            separators = separators+"|"+delimiter;
            //System.out.println(separators);
            //=> recupérer la chaine après qui devient la chaine à traiter
            input = input.substring(4+delimiter.length()-1); // commencer juste après le premier n
            System.out.println(input);
        }

        String[] strNumbers = input.split(separators);

        for (int i = 0; i < strNumbers.length; i++) {
            sum += Integer.valueOf(strNumbers[i]);
        }
        return sum;
    }
}
