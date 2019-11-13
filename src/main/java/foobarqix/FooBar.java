package foobarqix;

public class FooBar {
    public String fooBarQix(int input) {

        if (!(input > 0)) {
            throw new IllegalArgumentException("Les nombres négatifs ne sont pas acceptés");
        }

        return divisible(input)+concat(input);
}

    String divisible(int input){
        String result = "";

        if (input % 3 == 0) {
            result = result + "Foo";
        }

        if (input % 5 == 0) {
            result = result + "Bar";
        }

        if (input % 7 == 0) {
            result = result + "Qix";
        }

        if (result =="") {
            result = "" + input;
        }
        return result;
    }

    String concat (int input){
        String chaine = ""+input;
        String result = "";
        for (int i=0 ; i<chaine.length(); i++){
            if (chaine.charAt(i) == '3'){
                result = result + "Foo";
            }
            if (chaine.charAt(i) == '5'){
                result = result + "Bar";
            }
            if (chaine.charAt(i) == '7'){
                result = result + "Qix";
            }
        }
        return result;
    }
}
