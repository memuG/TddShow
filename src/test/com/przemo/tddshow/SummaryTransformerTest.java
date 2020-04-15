package test.com.przemo.tddshow;

import com.przemo.tddshow.CustomService;
import com.przemo.tddshow.SummaryTransformer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SummaryTransformerTest {
    private final static int ID_INT_PARAM = 4;

    private @Mock CustomService mockCustomService;
    private @Mock SummaryTransformer mockSummaryTransformer;
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

    @Test
    public void testArgumentCaptorUseCase() {
        Mockito.when(mockSummaryTransformer.argumentCaptorUseCase(ID_INT_PARAM))
                .thenReturn(ID_INT_PARAM);

        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(mockSummaryTransformer).argumentCaptorUseCase(argumentCaptor.capture());
        Integer capturedInt = argumentCaptor.getValue();
        mockSummaryTransformer.argumentCaptorUseCase(3);

        assertEquals(2, capturedInt);
    }
}