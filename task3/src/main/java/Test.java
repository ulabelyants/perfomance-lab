import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Test{
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("title")
  private String title;
  @JsonProperty("value")
  private String value;
  @JsonProperty("values")
  private List<Test> values;

  public List<Test> getValues() {
    return values;
  }

  public void setValues(List<Test> values) {
    this.values = values;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}