import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("value")
  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
