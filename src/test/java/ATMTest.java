import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.taskone.ATM;
import ucu.edu.ua.taskone.Sectionhundred;

class ATMTest {
    @Test
    void testATMProcessValidAmount() {
        ATM atm = new ATM();
        Assertions.assertDoesNotThrow(() -> atm.process(756)); 
    }

    @Test
    void testATMProcessInvalidAmount() {
        ATM atm = new ATM();
        Assertions.assertThrows(IllegalArgumentException.class, () -> atm.process(3));
    }

    @Test
    void testATMSectionSetup() {
        ATM atm = new ATM();
        Assertions.assertNotNull(atm.getFirstSection());
        Assertions.assertTrue(atm.getFirstSection() instanceof Sectionhundred);
    }
}
