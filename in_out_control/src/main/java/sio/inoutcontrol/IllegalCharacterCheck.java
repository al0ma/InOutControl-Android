package sio.inoutcontrol;

/**
 * Created by marek on 05/05/18.
 */

public class IllegalCharacterCheck {

    public boolean containsIllegalCharacter(String string){
        {
            int i = 0;
            while(true) {
                for (int j = 0; j < string.length(); j++) {
                    if (string.toCharArray()[j] == i) {
                        return true;
                    }

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
        return false;
    }
}
