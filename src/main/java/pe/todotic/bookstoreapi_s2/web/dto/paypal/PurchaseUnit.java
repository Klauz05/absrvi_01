package pe.todotic.bookstoreapi_s2.web.dto.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PurchaseUnit {
@JsonProperty("reference_id")
  private String referenceId;
private Amount amount;
//private List<OrderItem> items;
}
