import java.util.List;

public class CalculatorService {

  public int calculateTotal(List<Integer> numbers) {

    int sum = 0;
    int length = numbers.size();
    for (int i = 0; i < length; i++) {
      sum += numbers.get(i);
    }
    return sum;
  }
}
