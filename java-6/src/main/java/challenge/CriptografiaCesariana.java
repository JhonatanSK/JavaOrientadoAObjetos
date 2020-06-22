package challenge;

public class  CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String text) {
        if(text.length() == 0) throw new IllegalArgumentException("must be an text");

        String crypto = "";
        char characters[] = text.toCharArray();

        for(char x: characters){
            if(Character.isSpaceChar(x)) crypto += " ";
            else if(Character.isDigit(x)) crypto += String.valueOf(x);
            else if (Character.isLetter(x)) {
                if(Character.toLowerCase(x) > 119)
                    crypto += String.valueOf((char) (((x - 122) + 93) + 3)).toLowerCase();

                else crypto += String.valueOf((char)(x + 3)).toLowerCase();
            }
        }
        return crypto;
    }

    @Override
    public String descriptografar(String text) {
        if(text.length() == 0) throw new IllegalArgumentException("must be an text");

        String crypto = "";
        char characters[] = text.toCharArray();

        for(char x: characters){
            if(String.valueOf(x).equals(" ")) crypto += " ";
            else if(Character.isDigit(x)) crypto += String.valueOf(x).toLowerCase();
            else if (Character.isLetter(x)) {
                if(Character.toLowerCase(x) < 100)
                    crypto += String.valueOf((char) (((122 - x) + 93) - 3)).toLowerCase();

                else crypto += String.valueOf((char)(x - 3)).toLowerCase();
            }
        }
        return crypto;
    }
}
