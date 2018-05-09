package sio.inoutcontrol;

/**
 * Created by marek on 05/05/18.
 */

public class SqlStringValidity {

    public boolean checkSQL(String sql){
        if(sql.contains("\'") || sql.contains("\"") || sql.contains("\\")
                || sql.contains("/") || sql.contains("%") || sql.contains("*")
                || sql.contains("&") || sql.contains("#") || sql.contains("!"))
            return false;
        else
            return true;
    }
}
