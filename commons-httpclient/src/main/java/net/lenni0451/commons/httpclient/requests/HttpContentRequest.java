package net.lenni0451.commons.httpclient.requests;

import net.lenni0451.commons.httpclient.content.HttpContent;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;

@ParametersAreNonnullByDefault
public class HttpContentRequest extends HttpRequest {

    private HttpContent content;

    public HttpContentRequest(final String method, final String url) throws MalformedURLException {
        super(method, url);
    }

    public HttpContentRequest(final String method, final URL url) {
        super(method, url);
    }

    /**
     * @return If this request has content
     */
    public boolean hasContent() {
        return this.content != null;
    }

    /**
     * @return The content of this request
     */
    @Nullable
    public HttpContent getContent() {
        return this.content;
    }

    /**
     * Set the content of this request.
     *
     * @param content The content to set
     * @return This instance for chaining
     */
    public HttpRequest setContent(@Nullable final HttpContent content) {
        this.content = content;
        return this;
    }

}