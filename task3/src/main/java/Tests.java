import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class Tests {
  @JsonProperty("tests")
  List<Test> tests;


  public Tests() {
  }

  public Tests(List<Test> tests) {
    this.tests = tests;
  }

  public List<Test> getTests() {
    return tests;
  }
}
