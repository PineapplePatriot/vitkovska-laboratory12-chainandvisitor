import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.tasktwo.Signature;

public class SignatureTest {
    @Test
    public void testSignatureFreeze() {
        Signature<Integer> signature = new Signature<>(System.out::println);
        signature.freeze();

        Assertions.assertNotNull(signature.getId());
    }

    @Test
    public void testSignatureApply() {
        final int[] result = {0};
        Signature<Integer> signature = new Signature<>(x -> result[0] = x * 2);

        signature.apply(5);
        Assertions.assertEquals(10, result[0]);
    }
}
