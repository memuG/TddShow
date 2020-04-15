package test.com.przemo.tddshow;

import com.przemo.tddshow.SummaryTransformer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SummaryTransformerTest {

    private SummaryTransformer target = null;

    @BeforeEach
    void setUp() {
        target = new SummaryTransformer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testTransformSuccess() {
        String result = target.transform("MyOrder");
        assertEquals(result, "ResultString");
    }

    @Test
    public void testTransformRaises() {
        assertThrows(IllegalArgumentException.class, () -> target.transform(null));
    }
}