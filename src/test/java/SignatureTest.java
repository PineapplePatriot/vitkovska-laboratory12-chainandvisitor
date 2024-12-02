import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.tasktwo.Signature;

public class SignatureTest {
    private static final int INPUT_VALUE = 5;
    private static final int EXPECTED_RESULT = 10;

    @Test
    public void testSignatureFreeze() {
        Signature<Integer> signature = new Signature<>(System.out::println);
        signature.freeze();

        Assertions.assertNotNull(signature.getId());
    }

    @Test
    public void testSignatureApply() {
        final int[] calcResult = {0};
        Signature<Integer> signature = new Signature<>(x -> 
        calcResult[0] = x * 2);

        signature.apply(INPUT_VALUE);
        Assertions.assertEquals(EXPECTED_RESULT, calcResult[0]);
    }
}
