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
        final int[] CALC_RESULT = {0};
        Signature<Integer> signature = new Signature<>(x -> 
        CALC_RESULT[0] = x * 2);

        signature.apply(INPUT_VALUE);
        Assertions.assertEquals(EXPECTED_RESULT, CALC_RESULT[0]);
    }
}
