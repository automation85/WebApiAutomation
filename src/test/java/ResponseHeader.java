import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResponseHeader extends BaseClass{



    CloseableHttpClient client;
    CloseableHttpResponse response;


    @BeforeMethod
    public void setup(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();

    }


    @Test
    public void contentTypeIsJSON() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        Header contentType =response.getEntity().getContentType();

        System.out.println(contentType);
        assertEquals(contentType.getValue(),"application/json; charset=utf-8");


        ContentType contentType1 = ContentType.getOrDefault(response.getEntity());

        assertEquals(contentType1.getMimeType(),"application/json");


    }

    @Test
    public void serverIsGitHub() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);


        String headerValue = ResponseUtils.getHeader(response,"Server");

        assertEquals(headerValue,"GitHub.com");

    }


    @Test
    public void xRateLimitIsSixty() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);


        String limitValue = ResponseUtils.getHeaderUsingStream(response,"X-RateLimit-Limit");

        assertEquals(limitValue,"60");

    }

    @Test
    public void eTagIsPresent() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);


        boolean eTagIsPresent = ResponseUtils.headerIsPresent(response,"ETag");

        assertTrue(eTagIsPresent);

    }



}
