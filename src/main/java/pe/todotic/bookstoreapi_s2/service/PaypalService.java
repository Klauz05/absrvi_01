package pe.todotic.bookstoreapi_s2.service;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pe.todotic.bookstoreapi_s2.model.SalesOrder;
import pe.todotic.bookstoreapi_s2.web.dto.paypal.*;

@Service
public class PaypalService {
  private final static String PAYPAL_API_BASE = "https://api-m.sandbox.paypal.com";
  private final static String PAYPAL_CLIENT_ID = "AU9-98cklA0UshY-cRIt8aqG_JdYOR79oPXd7rh8S3ba27gZwLWviz78jFPW5kK2uvl6x-3aHLKHqqEK";
  private final static String PAYPAL_CLIENT_SECRET = "ECYkfDW-T2v8lz9XInUlt_F4wrOoJ8vn7OyH6OALWPn0Ld9O0OM4g_oRic-T5VOtMRUuiI1e0EUBFPgT";

  private String getAccessToken() {
    String url = String.format("%s/v1/oauth2/token", PAYPAL_API_BASE);
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.setBasicAuth(PAYPAL_CLIENT_ID, PAYPAL_CLIENT_SECRET);

    MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
    form.add("grant_type", "client_credentials");

    HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);
    ResponseEntity<Token> response = restTemplate.postForEntity(url, entity, Token.class);

    return response.getBody().getAccessToken();
  }

  /*public OrderResponse createOrder(SalesOrder salesOrder, String returnUrl,String cancelUrl){
    String Url=String.format("%s/v1/oauth2/token", PAYPAL_API_BASE);
    OrderRequest orderRequest=new OrderRequest();
    orderRequest.setIntent(OrderRequest.Intent.CAPTURE);
    ApplicationContext applicationContext=new ApplicationContext();
    applicationContext.setBrandName("TodoTic");
    applicationContext.setReturnUrl(returnUrl);
    applicationContext.setCancelUrl(cancelUrl);
    orderRequest.setApplicationContext(applicationContext);
    PurchaseUnit purchaseUnit=new PurchaseUnit();
    purchaseUnit.setReferenceId(salesOrder.getId().toString());
    Amount amount=new Amount();
    amount.setcurrency

  }*/
}
