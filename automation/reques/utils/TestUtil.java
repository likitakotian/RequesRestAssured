package reques.utils;

import io.restassured.response.Response;
import javax.ws.rs.core.Response.Status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Supplier;

public class TestUtil {
    public static String getCurrentDate(){
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        return nowAsISO;
    }

    public static Response waitForExpectedStatusCode(Supplier<Response> supplier, javax.ws.rs.core.Response.StatusType status) {
        Response response = supplier.get();
        int count = 0;
        while( response.getStatusCode()!= status.getStatusCode() && count < 2) {
            try{
                Thread.sleep(10000);
                response = supplier.get();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 2) {
                throw new RuntimeException("Expected status code " + status.getStatusCode() + " but got " + response.getStatusCode());
            }
            response =supplier.get();
        }
        response.then().assertThat().statusCode(status.getStatusCode());
        return response;
    }
}