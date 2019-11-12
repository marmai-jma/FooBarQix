package foobarqix;

public class FooBar {
    public String fooBarQix(int input) {

        if (!(input > 0)) {
            throw new IllegalArgumentException("Les nombres négatifs ne sont pas acceptés");
        }

        return divisible(input);
    }

    String divisible(int input){
        String result = "";
        Boolean diviseurTrouve = false;

        if (input % 3 == 0) {
            result = result + "Foo";
            diviseurTrouve = true;
        }

        if (input % 5 == 0) {
            result = result + "Bar";
            diviseurTrouve = true;
        }

        if (input % 7 == 0) {
            result = result + "Qix";
            diviseurTrouve = true;
        }

        if (!diviseurTrouve) {
            result = "" + input;
        }
        return result;
    }
}
