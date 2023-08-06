import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Values {
  @JsonProperty("values")
  List<Value> values;

  public Values(List<Value> values) {
    this.values = values;
  }

  public Values() {
  }

  public List<Value> getValues() {
    return values;
  }

  public void setValues(List<Value> values) {
    this.values = values;
  }


}
