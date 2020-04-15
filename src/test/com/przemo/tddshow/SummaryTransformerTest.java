package test.com.przemo.tddshow;

import com.przemo.tddshow.CustomService;
import com.przemo.tddshow.SummaryTransformer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SummaryTransformerTest {
    private final static int ID_INT_PARAM = 4;

    private @Mock CustomService mockCustomService;
    private SummaryTransformer target = null;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new SummaryTransformer(mockCustomService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testTransformSuccess() {
        String result = target.transform("MyOrder");
        assertEquals("ResultString", result);
    }

    @Test
    public void testTransformRaises() {
        assertThrows(IllegalArgumentException.class, () -> target.transform(null));
    }

    @Test
    public void testCallCustomServiceMethod() {
        Mockito.when(mockCustomService.externalResourceQuery(ID_INT_PARAM))
                .thenReturn("Mockito returns CustomService.externalResourceQuery result");
        assertEquals("called customService and got: Mockito returns CustomService.externalResourceQuery result",
                      target.callCustomServiceMethod(ID_INT_PARAM));
        Mockito.verify(mockCustomService).externalResourceQuery(ID_INT_PARAM);
    }
}