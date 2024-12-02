import org.junit.jupiter.api.Test;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.tasktwo.StampingVisitor;
import ucu.edu.ua.tasktwo.Signature;
import ucu.edu.ua.tasktwo.Group;

class StampingVisitorTest {
    @Test
    void testOnGroupStartAndEnd() {
        StampingVisitor visitor = new StampingVisitor();
        Group<Integer> group = new Group<>();
        
        var headers = new HashMap<String, String>();
        var result = visitor.onGroupStart(group, headers);
        
        Assertions.assertTrue((boolean) 
        ((boolean[]) result.get("in_group"))[0]);
        visitor.onGroupEnd(group, headers);
    }

    @Test
    void testOnSignature() {
        StampingVisitor visitor = new StampingVisitor();
        Group<Integer> group = new Group<>();
        Signature<Integer> signature = new Signature<>(System.out::println);
        var headers = new HashMap<String, String>();
        visitor.onGroupStart(group, headers);
        
        var result = visitor.onSignature(signature, headers);
        Assertions.assertTrue((boolean) 
        ((boolean[]) result.get("in_group"))[0]);
    }
}