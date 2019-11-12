package foobarqix;

public class FooBar {
    public static String fooBarQix(int input) {
        String result="";
        Boolean diviseurTrouve = false;
        if (!(input > 0)) {
            throw new IllegalArgumentException("Les nombres négatifs ne sont pas acceptés");
        }

        if (input % 3 == 0){
            result = result+"Foo";
            diviseurTrouve = true;
        }

        if (input % 5 ==0) {
            result = result + "Bar";
            diviseurTrouve = true;
        }

        if (input % 7 == 0) {
            result = result + "Qix";
            diviseurTrouve = true;
        }

        if (! diviseurTrouve) {
            result = "" + input;
        }
        return result;
    }
}
