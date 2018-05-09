package sio.inoutcontrol;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;

/**
 * Created by marek on 05/05/18.
 */

public class ImageLoader extends com.android.volley.toolbox.ImageLoader{


    private final ImageCache mImageCache;
    private final Cache mDiskCache;

    /**
     * Constructs a new ImageLoader.
     *
     * @param queue      The RequestQueue to use for making image requests.
     * @param imageCache The cache to use as an L1 cache.
     */
    public ImageLoader(RequestQueue queue, ImageCache imageCache) {
        super(queue, imageCache);
        mImageCache = imageCache;
        mDiskCache = queue.getCache();
    }

    public ImageCache getImageCache() {
        return mImageCache;
    }
    public Cache getDiskCache() {
        return mDiskCache;
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
    }

    public void addImageProtocolAllowed(String protocol){
        urls.addProtocolAllowed(protocol);
    }

    public void addImageProtocolDisabled(String protocol){
        urls.addProtocolDisabled(protocol);
    }

    public void addImageFormatAllowed(String format){
        urls.addFileTypeAllowed(format);
    }

    public void addImageFormatDisabled(String format){
        urls.addFileTypeDisabled(format);
    }

    public void addImageDomainAllowed(String domain){
        urls.addDomainAllowed(domain);
    }

    public void addImageDomainDisabled(String domain){
        urls.addDomainDisabled(domain);
    }



    public boolean checkUrl(String url){
        urls.setParameters(imageUrlProtocol, imageUrlFormat, imageUrlDomain);
        if(urls.checkUrl(url)){
            return true;

        }
        else{
            return false;
        }

    }


    @Override
    public ImageContainer get(String RequestUrl,ImageListener listener){

        if(controlUrl) {
            validity = checkUrl(RequestUrl);
        }


        return super.get(RequestUrl, listener);
    }

    @Override
    public ImageContainer get(String RequestUrl,ImageListener listener, int maxWidth, int maxHeight){
        if(controlUrl) {
            validity = checkUrl(RequestUrl);
        }

        return super.get(RequestUrl, listener, maxWidth, maxHeight);
    }


}
