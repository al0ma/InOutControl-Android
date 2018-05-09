package sio.inoutcontrol;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

/**
 * Created by marek on 05/05/18.
 */

public class GsonRequest<T> extends Request<T> {

    /** JSON parsing engine */
    protected final Gson gson;

    /** class of type of response */
    protected final Class<T> clazz;

    /** result listener */
    private final Listener<T> listener;

    private final String url;

    UrlStringValidity urls = new UrlStringValidity();

    public GsonRequest(String url, Class<T> clazz, Listener<T> listener,
                       ErrorListener errorListener) {

        super(Method.GET, url, errorListener);
        this.url = url;
        this.clazz = clazz;
        this.listener = listener;
        this.gson = new Gson();

    }


    private boolean gsonUrlProtocol = false;
    private boolean gsonUrlDomain = false;


    public void setParameters(boolean gsonUrlProtocol, boolean gsonUrlDomain) {
        this.gsonUrlProtocol = gsonUrlProtocol;
        this.gsonUrlDomain = gsonUrlDomain;
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




    public boolean checkUrl(){
        if(urls.checkUrl(url)){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));

        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}