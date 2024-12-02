import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.taskone.ATM;
import ucu.edu.ua.taskone.Sectionhundred;

class ATMTest {
    private static final int TEST_MONEY = 752;
    private static final int TEST_MONEY_INVALID = 3;

    @Test
    void testATMProcessValidAmount() {
        ATM atm = new ATM();
        Assertions.assertDoesNotThrow(() -> atm.process(TEST_MONEY)); 
    }

    @Test
    void testATMProcessInvalidAmount() {
        ATM atm = new ATM();
        Assertions.assertThrows(IllegalArgumentException.class, 
        () -> atm.process(TEST_MONEY_INVALID));
    }

    @Test
    void testATMSectionSetup() {
        ATM atm = new ATM();
        Assertions.assertNotNull(atm.getFirstSection());
        Assertions.assertTrue(atm.getFirstSection() instanceof Sectionhundred);
    }
}
