package sio.inoutcontrol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marek on 05/05/18.
 */

public class MailStringValidity {

    private boolean emailHost = false;
    private boolean emailDomain = false;

    private List<String> emailHostAllowed = new ArrayList<>();
    private List<String> emailHostDisabled = new ArrayList<>();
    private List<String> emailDomainAllowed = new ArrayList<>();
    private List<String> emailDomainDisabled = new ArrayList<>();

    public void addEmailHostAllowed(String host){
        emailHostAllowed.add(host);
    }

    public void addEmailHostDisabled(String host){
        emailHostDisabled.add(host);
    }

    public void addEmailDomainAllowed(String domain){
        emailDomainAllowed.add(domain);
    }

    public void addEmailDomainDisabled(String domain){
        emailDomainDisabled.add(domain);
    }

    public void setParameters(boolean emailDomain, boolean emailHost){
        this.emailDomain = emailDomain;
        this.emailHost = emailHost;
    }

    public boolean checkEmail(String email){
        boolean validHost = false;
        boolean validDomain = false;

        if(emailHost){
            for(int i = 0; i<emailHostAllowed.size();i++){
                if (email.contains('@' + emailHostAllowed.get(i) + '.')){
                    validHost = true;
                    break;
                }
            }
        }
        else{
            validHost = true;
            for(int i = 0; i<emailHostDisabled.size();i++){
                if (email.contains('@' + emailHostDisabled.get(i) + '.')){
                    validHost = false;
                    break;
                }
            }
        }

        if(emailDomain){
            for(int i = 0; i<emailDomainAllowed.size();i++){
                if (email.contains('.' + emailDomainAllowed.get(i))){
                    validDomain = true;
                    break;
                }
            }
        }
        else{
            validDomain = true;
            for(int i = 0; i<emailDomainDisabled.size();i++){
                if (email.contains('.' + emailDomainDisabled.get(i))){
                    validDomain = false;
                    break;
                }
            }
        }

        if(validHost && validDomain && email.contains("@"))
            return true;
        else
            return false;
    }
}
