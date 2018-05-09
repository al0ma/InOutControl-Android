package sio.inoutcontrol;

/**
 * Created by marek on 05/05/18.
 */

public class PasswordStringValidity {

    private int numberOfCharacters = 8;
    private boolean numbers = false;
    private boolean letters = false;
    private boolean capitals = false;
    private boolean specialCharacters = false;


    public PasswordStringValidity(int numberOfCharacters){
        this.numberOfCharacters = numberOfCharacters;
    }

    public PasswordStringValidity(int numberOfCharacters, boolean numbers, boolean letters, boolean capitals, boolean specialCharacters){
        this.numberOfCharacters = numberOfCharacters;
        this.numbers = numbers;
        this.letters = letters;
        this.capitals = capitals;
        this.specialCharacters = specialCharacters;
    }

    public void setParameters(int numberOfCharacters){
        this.numberOfCharacters = numberOfCharacters;
    }

    public void setParameters(int numberOfCharacters, boolean numbers, boolean letters, boolean capitals, boolean specialCharacters){
        this.numberOfCharacters = numberOfCharacters;
        this.numbers = numbers;
        this.letters = letters;
        this.capitals = capitals;
        this.specialCharacters = specialCharacters;
    }

    public boolean checkPassword(String password){
        if (password.isEmpty() )
            return false;
        if (password.length() < this.numberOfCharacters)
            return false;

        boolean containsNumber = true;
        boolean containsLetter = true;
        boolean containsCapital = true;
        boolean containsSpecialCharacter = true;
        boolean containsIllegal = false;

        if(numbers == true){
            containsNumber = false;
            char c = '0';
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < password.length(); j++) {
                    if (password.toCharArray()[j] == c) {
                        containsNumber = true;
                        break;
                    }
                    if (containsNumber == true)
                        break;
                }
                c++;
            }
        }

        if(letters == true){
            containsLetter = false;
            char c = 'a';
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < password.length(); j++) {
                    if (password.toCharArray()[j] == c) {
                        containsLetter = true;
                        break;
                    }
                    if (containsLetter == true)
                        break;
                }
                c++;
            }
        }

        if(capitals == true){
            containsCapital = false;
            char c = 'A';
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < password.length(); j++) {
                    if (password.toCharArray()[j] == c) {
                        containsCapital = true;
                        break;
                    }
                    if (containsCapital == true)
                        break;
                }
                c++;
            }
        }

        if(specialCharacters == true){
            containsSpecialCharacter = false;
            int i = 33;
            while(true) {
                for (int j = 0; j < password.length(); j++) {
                    if (password.toCharArray()[j] == i) {
                        containsSpecialCharacter = true;
                        break;
                    }
                    if (containsSpecialCharacter == true)
                        break;
                }
                i++;
                if (i == 48)
                    i = 58;
                if (i == 65)
                    i = 91;
                if (i == 97)
                    i = 123;
                if (i > 127)
                    break;
            }
        }

        {
            int i = 0;
            while(true) {
                for (int j = 0; j < password.length(); j++) {
                    if (password.toCharArray()[j] == i) {
                        containsIllegal = true;
                        break;
                    }
                    if (containsIllegal == true)
                        break;
                }
                i++;
                if (i == 10)
                    i = 11;
                if (i == 13)
                    i = 14;
                if (i == 33)
                    i = 127;
                if (i > 127)
                    break;
            }

        }


        if(containsNumber == true && containsLetter == true && containsCapital == true && containsSpecialCharacter == true && containsIllegal == false)
            return true;
        else
            return false;
    }
}
