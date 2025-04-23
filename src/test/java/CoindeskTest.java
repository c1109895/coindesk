import com.app.dto.CoindeskDto;
import com.app.service.CoinService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class CoindeskTest {

    @InjectMocks
    private CoinService coinService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testCallCoindeskAPI_success() {
        // Arrange: 模擬 Coindesk 回應的資料
        Map<String, Object> data = new HashMap<>();
        data.put("code", "USD");
        data.put("rate", "34,000.0000");
        data.put("description", "United States Dollar");

        Map<String, Object> bpi = new HashMap<>();
        bpi.put("USD", data);

        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("bpi", bpi);

        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Map.class))).thenReturn(mockResponse);

        // Act
        CoindeskDto response = coinService.callCoindeskAPI();

        // Assert
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.getBpi().size());
        Assertions.assertEquals("USD", response.getBpi().get(0).getCode());
        Assertions.assertEquals("34,000.0000", response.getBpi().get(0).getRate());
        Assertions.assertEquals("United States Dollar", response.getBpi().get(0).getDescription());
    }
}
