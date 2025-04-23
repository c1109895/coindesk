package com.app.service;

import com.app.dto.CoindeskDto;
import com.app.dto.CurrencyRateDto;
import com.app.entity.Coin;
import com.app.enums.CurrencyEnum;
import com.app.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CoinService {

    @Autowired
    private CoinRepository coinRepository;

    private static final String COINDESK_URL = "https://kengp3.github.io/blog/coindesk.json";

    private final RestTemplate restTemplate;

    @Autowired
    public CoinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 取得所有幣別
     * @return list
     */
    public List<Coin> getAllCoins() {
        return coinRepository.findAll();
    }

    /**
     * 新增幣別
     * @param coin 幣別資訊
     * @return Coin
     */
    public Coin createCoin(Coin coin) {
        // 檢查 coin 是否已存在
        if (coinRepository.findById(coin.getCode()).isPresent()) {
            throw new EntityExistsException(coin.getCode() + " already exists.");
        }
        return coinRepository.save(coin);
    }

    /**
     * 修改幣別資料
     * @param coin 幣別資訊
     * @return Coin
     */
    public Coin update(Coin coin) {
        return coinRepository.findById(coin.getCode()).map(existingCoin -> {
            existingCoin.setCodeNameZh(coin.getCodeNameZh());
            existingCoin.setSymbol(coin.getSymbol());
            existingCoin.setRateFloat(coin.getRateFloat());
            existingCoin.setDescription(coin.getDescription());
            return coinRepository.save(existingCoin);
        }).orElseThrow(() -> new EntityNotFoundException("Coin not found with code: " + coin.getCode()));
    }

    /**
     * 刪除幣別
     * @param coin 幣別資訊
     */
    public void deleteCoin(Coin coin) {
        // 檢查 coin 是否存在
        if (!coinRepository.findById(coin.getCode()).isPresent()) {
            throw new EntityNotFoundException("Coin not found with code: " + coin.getCode());
        }
        coinRepository.deleteById(coin.getCode());
    }

    /**
     * 串接 Coindesk API 取得即時匯率
     * @return CoindeskResponse
     */
    public CoindeskDto callCoindeskAPI() {
        Map<String, Object> response = restTemplate.getForObject(COINDESK_URL, Map.class);
        Map<String, Object> bpi = (Map<String, Object>) response.get("bpi");

        List<CurrencyRateDto> rates = new ArrayList<>();
        for (CurrencyEnum coin : CurrencyEnum.values()) {
            String code = coin.getCode();
            if (bpi.containsKey(code)) {
                Map<String, Object> currencyInfo = (Map<String, Object>) bpi.get(code);
                String rate = (String) currencyInfo.get("rate");
                String description = (String) currencyInfo.get("description");
                String chineseName = CurrencyEnum.getChineseName(code);
                rates.add(new CurrencyRateDto(code, chineseName, rate, description));
            }
        }
        return new CoindeskDto(LocalDateTime.now(), rates);
    }

}
