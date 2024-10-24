import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorServiceTest {

  private CalculatorService calc;
  private List<Integer> numbers;

  @BeforeEach
  public void setup() { // runs once before each test method
    calc = new CalculatorService();

    // Mock List
    numbers = mock(List.class);
  }

  @Test
  void calculateTotal_withMockedList_verifiesMethodCalls() {

    // Stub the get and size methods to return specific values
    when(numbers.get(anyInt())).thenReturn(1);
    when(numbers.size()).thenReturn(3);

    // Call the calculateTotal method
    calc.calculateTotal(numbers);

    // Verify behavior, that the method was called
    verify(numbers, times(3)).get(anyInt());
    verify(numbers).size();
  }

  @Test
  @DisplayName("calculateTotal with mocked List returns correct sum")
  void calculateTotal_withMockedList_returnsCorrectSum() {

    // Stub the get and size methods to return specific values
    when(numbers.get(anyInt())).thenReturn(1);
    when(numbers.size()).thenReturn(3);

    // Call the calculateTotal method
    int result = calc.calculateTotal(numbers);

    // Assert the result
    assertEquals(3, result);
  }
}