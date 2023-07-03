package pe.todotic.bookstoreapi_s2.web.dto.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApplicationContext {
  @JsonProperty("brand_name")
  private String brandName;
  @JsonProperty("return_Url")
  private String returnUrl;
  @JsonProperty("cancel_url")
  private String cancelUrl;



}
