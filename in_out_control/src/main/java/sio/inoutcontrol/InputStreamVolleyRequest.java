package sio.inoutcontrol;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marek on 05/05/18.
 */

public class InputStreamVolleyRequest extends Request<byte[]> {
    private final Response.Listener<byte[]> mListener;
    private Map<String, String> mParams;

    //create a static map for directly accessing headers
    public Map<String, String> responseHeaders ;

    private String requestUrl;

    public InputStreamVolleyRequest(int method, String mUrl , Response.Listener<byte[]> listener,
                                    Response.ErrorListener errorListener, HashMap<String, String> params) {


        super(Method.GET, mUrl, errorListener);
        // this request would never use cache.
        setShouldCache(false);
        mListener = listener;
        mParams=params;
        requestUrl = mUrl;
    }



    private boolean validity = false;

    private boolean controlUrl = false;
    private boolean imageUrlProtocol = false;
    private boolean imageUrlFormat = false;
    private boolean imageUrlDomain = false;

    UrlStringValidity urls = new UrlStringValidity();


    public boolean getValidity(){
        return validity;
    }



    public void setParameters(boolean controlUrl,boolean imageUrlProtocol, boolean imageUrlFormat, boolean imageUrlDomain) {
        this.controlUrl = controlUrl;
        this.imageUrlProtocol = imageUrlProtocol;
        this.imageUrlFormat = imageUrlFormat;
        this.imageUrlDomain = imageUrlDomain;
        urls.setParameters(imageUrlProtocol,imageUrlDomain,imageUrlFormat);
    }

    public void addUrlProtocolAllowed(String protocol){
        urls.addProtocolAllowed(protocol);
    }

    public void addUrlProtocolDisabled(String protocol){
        urls.addProtocolDisabled(protocol);
    }

    public void addUrlFormatAllowed(String format){
        urls.addFileTypeAllowed(format);
    }

    public void addUrlFormatDisabled(String format){
        urls.addFileTypeDisabled(format);
    }

    public void addUrlDomainAllowed(String domain){
        urls.addDomainAllowed(domain);
    }

    public void addUrlDomainDisabled(String domain){
        urls.addDomainDisabled(domain);
    }

    public boolean checkUrl(String url){
        if(urls.checkUrl(url)){
            return true;
        }
        else{
            return false;
        }

    }


    @Override
    protected Map<String, String> getParams()
            throws com.android.volley.AuthFailureError {
        return mParams;
    };



    @Override
    protected void deliverResponse(byte[] response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {

        //Initialise local responseHeaders map with response headers received
        responseHeaders = response.headers;

        if(controlUrl) {
            validity = checkUrl(requestUrl);
        }

        //Pass the response data here
        return Response.success( response.data, HttpHeaderParser.parseCacheHeaders(response));
    }
}