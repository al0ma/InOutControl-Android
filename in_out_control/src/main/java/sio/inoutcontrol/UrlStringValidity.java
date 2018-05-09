package sio.inoutcontrol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marek on 05/05/18.
 */

public class UrlStringValidity {
    private List<String> protocolAllowed = new ArrayList<>();
    private List<String> protocolDisabled = new ArrayList<>();
    private List<String> domainAllowed = new ArrayList<>();
    private List<String> domainDisabled = new ArrayList<>();
    private List<String> fileTypeAllowed = new ArrayList<>();
    private List<String> fileTypeDisabled = new ArrayList<>();

    private boolean urlProtocol = false;
    private boolean urlDomain = false;
    private boolean urlFileType = false;


    public void addProtocolAllowed(String protocol){
        protocolAllowed.add(protocol);
    }

    public void addProtocolDisabled(String protocol){
        protocolDisabled.add(protocol);
    }

    public void addDomainAllowed(String domain){
        domainAllowed.add(domain);
    }

    public void addDomainDisabled(String domain){
        domainDisabled.add(domain);
    }

    public void addFileTypeAllowed(String format){
        fileTypeAllowed.add(format);
    }

    public void addFileTypeDisabled(String format){
        fileTypeDisabled.add(format);
    }

    public void setParameters(boolean urlProtocol, boolean urlDomain) {

        this.urlProtocol = urlProtocol;
        this.urlDomain = urlDomain;
    }

    public void setParameters(boolean urlProtocol, boolean urlDomain, boolean urlFileType) {

        this.urlProtocol = urlProtocol;
        this.urlDomain = urlDomain;
        this.urlFileType = urlFileType;
    }

    public boolean checkUrl(String url){
        boolean validProtocol = false;
        boolean validFiletype = false;
        boolean validDomain = false;

        if(urlProtocol){
            for(int i = 0; i<protocolAllowed.size();i++){
                if (url.contains(protocolAllowed.get(i) + "://")){
                    validProtocol = true;
                    break;
                }
            }
        }
        else{
            validProtocol = true;
            for(int i = 0; i<protocolDisabled.size();i++){
                if (url.contains(protocolDisabled.get(i) + "://")){
                    validProtocol = false;
                    break;
                }
            }
        }

        if(urlDomain){
            for(int i = 0; i<domainAllowed.size();i++){
                if (url.contains('.' + domainAllowed.get(i))){
                    validDomain = true;
                    break;
                }
            }
        }
        else{
            validDomain = true;
            for(int i = 0; i<domainDisabled.size();i++){
                if (url.contains('.' + domainDisabled.get(i))){
                    validDomain = false;
                    break;
                }
            }
        }

        if(urlFileType){
            for(int i = 0; i<fileTypeAllowed.size();i++){
                if (url.contains('.' + fileTypeAllowed.get(i))){
                    validFiletype = true;
                    break;
                }
            }
        }
        else{
            validFiletype = true;
            for(int i = 0; i<fileTypeDisabled.size();i++){
                if (url.contains('.' + fileTypeDisabled.get(i))){
                    validFiletype = false;
                    break;
                }
            }
        }

        if(validFiletype && validDomain && validProtocol)
            return true;
        else
            return false;
    }
}
