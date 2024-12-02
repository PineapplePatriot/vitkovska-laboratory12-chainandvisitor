import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import ucu.edu.ua.tasktwo.Signature;
import ucu.edu.ua.tasktwo.Group;

public class GroupTest {
    private static final int INPUT_VALUE = 5;
    private static final int EXPECTED_RESULT_1 = 5;
    private static final int EXPECTED_RESULT_2 = 10;
    private static final int EXPECTED_RESULT_COUNT = 2;

    @Test
    public void testGroupFreeze() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(System.out::println));

        group.freeze();
        Assertions.assertNotNull(group.getGroupUuid());
        Assertions.assertThrows(UnsupportedOperationException.class,
        () -> group.getTasks().add(new Signature<>(System.out::println)));
    }

    @Test
    public void testGroupApply() {
        List<Integer> results = new ArrayList<>();
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(results::add))
             .addTask(new Signature<>(x -> results.add(x * 2)));

        group.apply(INPUT_VALUE);
        Assertions.assertEquals(EXPECTED_RESULT_COUNT, results.size());
        Assertions.assertEquals(List.of(EXPECTED_RESULT_1,
         EXPECTED_RESULT_2), results);
    }
}
