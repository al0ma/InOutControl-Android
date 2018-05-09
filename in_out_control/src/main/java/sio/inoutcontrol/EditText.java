package sio.inoutcontrol;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by marek on 05/05/18.
 */

public class EditText extends android.support.v7.widget.AppCompatEditText {

    public EditText(Context context) {
        super(context);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    String TAG = "EditText Error:";

    private boolean validity = false;
    //private static String validSQL = new String();


    public static final int DEFAULT = 0;
    public static final int PASSWORD_INPUT = 1;
    public static final int SQL_INPUT = 2;
    public static final int EMAIL_INPUT = 3;
    public static final int URL_INPUT = 4;
    private int flag = 0;

    private int numberOfCharacters = 8;
    private boolean numbers = false;
    private boolean letters = false;
    private boolean capitals = false;
    private boolean specialCharacters = false;

    private boolean emailHost = false;
    private boolean emailDomain = false;


    private boolean urlProtocol = false;
    private boolean urlDomain = false;
    private boolean urlFileType = false;


    public boolean getValidity(){
        return validity;
    }

    MailStringValidity mails = null;
    UrlStringValidity urls = null;
    public void setFunctionality(int flag){
        this.flag = flag;
        if(flag == EMAIL_INPUT){
            mails = new MailStringValidity();
        }
        if(flag == URL_INPUT){
            urls = new UrlStringValidity();
        }
    }

    public void setPasswordParameters(int numberOfCharacters){
        this.numberOfCharacters = numberOfCharacters;
    }

    public void setPasswordParameters(int numberOfCharacters, boolean numbers, boolean letters, boolean capitals, boolean specialCharacters){
        this.numberOfCharacters = numberOfCharacters;
        this.numbers = numbers;
        this.letters = letters;
        this.capitals = capitals;
        this.specialCharacters = specialCharacters;
    }

    public void setEmailParameters(boolean emailDomain, boolean emailHost){
        this.emailDomain = emailDomain;
        this.emailHost = emailHost;
    }

    public void setUrlParameters(boolean urlProtocol, boolean urlDomain) {
        this.urlProtocol = urlProtocol;
        this.urlDomain = urlDomain;
    }

    public void setUrlParameters(boolean urlProtocol, boolean urlDomain, boolean urlFileType) {
        this.urlProtocol = urlProtocol;
        this.urlDomain = urlDomain;
        this.urlFileType = urlFileType;
    }


    public void addUrlProtocolAllowed(String protocol){
        urls.addProtocolAllowed(protocol);
    }

    public void addUrlProtocolDisabled(String protocol){
        urls.addProtocolDisabled(protocol);
    }

    public void addUrlDomainAllowed(String domain){
        urls.addDomainAllowed(domain);
    }

    public void addUrlDomainDisabled(String domain){
        urls.addDomainDisabled(domain);
    }

    public void addUrlFileTypeAllowed(String filetype){
        urls.addFileTypeAllowed(filetype);
    }

    public void addUrlFileTypeDisabled(String filetype){
        urls.addFileTypeDisabled(filetype);
    }

    public void addEmailHostAllowed(String host){
        mails.addEmailHostAllowed(host);
    }

    public void addEmailHostDisabled(String host){
        mails.addEmailHostDisabled(host);
    }

    public void addEmailDomainAllowed(String domain){
        mails.addEmailDomainAllowed(domain);
    }

    public void addEmailDomainDisabled(String domain){
        mails.addEmailDomainDisabled(domain);
    }


    @Override
    public Editable getText(){


        switch (flag){
            case DEFAULT:{
                validity = true;
            }break;
            case PASSWORD_INPUT:{
                PasswordStringValidity passs = new PasswordStringValidity(numberOfCharacters, numbers, letters, capitals, specialCharacters);
                if (passs.checkPassword(super.getText().toString())) {

                    validity = true;
                }
                else {
                    validity = false;
                }
            }break;
            case SQL_INPUT:{
                SqlStringValidity sqls = new SqlStringValidity();
                if (sqls.checkSQL(super.getText().toString())) {
                    validity = true;
                }
                else{
                    validity = false;
                }
            }
            break;
            case EMAIL_INPUT:{
                mails.setParameters(emailDomain, emailHost);
                if(mails.checkEmail(super.getText().toString())){
                    validity = true;
                }
                else{
                    validity = false;
                }
            }
            break;
            case URL_INPUT:{
                urls.setParameters(urlProtocol, urlDomain, urlFileType);
                if(urls.checkUrl(super.getText().toString())){
                    validity = true;
                }
                else{
                    validity = false;
                }
            }
            break;
            default:
            {
                Log.v(TAG, "Invalid flag. Use method \"setFunctionality()\" with valid argument (such as EditText.PASSWORD_INPUT), or use default EditText");
            }
            break;

        }

        IllegalCharacterCheck ills = new IllegalCharacterCheck();
        if(ills.containsIllegalCharacter(super.getText().toString()))
            validity = false;

        return super.getText();

    }
}
