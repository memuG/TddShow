package test.com.przemo.tddshow;

import com.przemo.tddshow.SummaryTransformer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        target.transform("MyOrder");
    }
}