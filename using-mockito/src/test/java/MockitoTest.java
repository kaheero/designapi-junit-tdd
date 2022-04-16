import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@SuppressWarnings("all")
@ExtendWith(MockitoExtension.class)
public class MockitoTest {

  @Mock
  List<String> names;

  @Test
  @DisplayName("Primeiro teste com mockito.")
  public void primeiroTestMockito(){
    Mockito.when(names.size()).thenReturn(20);
    int size = names.size();
    names.add("John");

    InOrder inOrder = Mockito.inOrder(names);
    inOrder.verify(names).size();
    inOrder.verify(names).add("John");
    Assertions.assertThat(size).isEqualTo(20);
  }

}
