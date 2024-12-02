import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import ucu.edu.ua.tasktwo.Signature;
import ucu.edu.ua.tasktwo.Group;

public class GroupTest {
    @Test
    public void testGroupFreeze() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(System.out::println));

        group.freeze();
        Assertions.assertNotNull(group.getGroupUuid());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> group.getTasks().add(new Signature<>(System.out::println)));
    }

    @Test
    public void testGroupApply() {
        List<Integer> results = new ArrayList<>();
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(results::add))
             .addTask(new Signature<>(x -> results.add(x * 2)));

        group.apply(5);
        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals(List.of(5, 10), results);
    }
}
