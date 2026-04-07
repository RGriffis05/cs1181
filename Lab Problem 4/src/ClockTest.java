import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClockTest {

    @Test 
    void minutesValueTest(){
        Clock clock = new Clock(3, 80, "a.m.");
        assertTrue(clock.getMinutes() >= 0 && clock.getMinutes() <= 60, "Minutes should be between 0 and 60 inclusive");
    }
}
