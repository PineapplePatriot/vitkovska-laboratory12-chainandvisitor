import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.taskone.Sectionhundred;
import ucu.edu.ua.taskone.Sectionfifty;
import ucu.edu.ua.taskone.Sectiontwo;


class SectionTest {
    private static final int TEST_MONEY = 752;
    private static final int TEST_MONEY_INVALID = 3;

    @Test
    void testSectionProcessValidAmount() {
        Sectionhundred hundred = new Sectionhundred();
        Sectionfifty fifty = new Sectionfifty();
        Sectiontwo two = new Sectiontwo();

        hundred.setNext(fifty);
        fifty.setNext(two);

        Assertions.assertDoesNotThrow(() -> hundred.process(TEST_MONEY));
    }

    @Test
    void testSectionProcessInvalidAmount() {
        Sectionhundred hundred = new Sectionhundred();
        Sectionfifty fifty = new Sectionfifty();
        Sectiontwo two = new Sectiontwo();

        hundred.setNext(fifty);
        fifty.setNext(two);

        Assertions.assertThrows(IllegalArgumentException.class, 
        () -> hundred.process(TEST_MONEY_INVALID));
    }
}
