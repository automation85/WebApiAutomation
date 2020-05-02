import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Arrays;
import java.util.List;

public class ResponseUtils {



    public static String getHeader(CloseableHttpResponse response, String headerName) {

        Header[] headers = response.getAllHeaders();

        List<Header> httpHeaders = Arrays.asList(headers);

        String returnHeader = "";

        for (Header header : httpHeaders){
            if(headerName.equalsIgnoreCase(header.getName())){
                returnHeader=header.getValue();
            }
        }

/*        if(returnHeader.isEmpty()){
            throw new RuntimeException("Did not find the header"+headerName);
        }*/


        return returnHeader;
    }


    public static String getHeaderUsingStream(CloseableHttpResponse response,  String headerName){

        Header[] headers = response.getAllHeaders();

        List<Header> httpHeaders = Arrays.asList(headers);


        Header matchHeader = httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(()->new RuntimeException("Did not find header"));

        return matchHeader.getValue();


    }

    public static boolean headerIsPresent(CloseableHttpResponse response, String headerName){

        Header[] headers = response.getAllHeaders();

        List<Header> httpHeaders = Arrays.asList(headers);


        boolean headerIsPresent = httpHeaders.stream()
               .anyMatch(aa->aa.getName().equalsIgnoreCase(headerName));


        return headerIsPresent;


    }
}
