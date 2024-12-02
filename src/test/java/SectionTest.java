import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.taskone.Sectionhundred;
import ucu.edu.ua.taskone.Sectionfifty;
import ucu.edu.ua.taskone.Sectiontwo;


class SectionTest {
    @Test
    void testSectionProcessValidAmount() {
        Sectionhundred hundred = new Sectionhundred();
        Sectionfifty fifty = new Sectionfifty();
        Sectiontwo two = new Sectiontwo();

        hundred.setNext(fifty);
        fifty.setNext(two);

        Assertions.assertDoesNotThrow(() -> hundred.process(752));
    }

    @Test
    void testSectionProcessInvalidAmount() {
        Sectionhundred hundred = new Sectionhundred();
        Sectionfifty fifty = new Sectionfifty();
        Sectiontwo two = new Sectiontwo();

        hundred.setNext(fifty);
        fifty.setNext(two);

        Assertions.assertThrows(IllegalArgumentException.class, () -> hundred.process(3)); // Invalid case
    }
}
