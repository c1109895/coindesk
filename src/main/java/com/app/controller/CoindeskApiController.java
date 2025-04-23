package com.app.controller;

import com.app.dto.CoindeskDto;
import com.app.entity.Coin;
import com.app.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coin")
public class CoindeskApiController {

    @Autowired
    private CoinService service;

    /**
     * 取得所有幣別
     */
    @GetMapping("/search")
    public ResponseEntity<List<Coin>> getAllCoins() {
        List<Coin> coins = service.getAllCoins();
        return ResponseEntity.ok(coins);
    }

    /**
     * 新增幣別資料
     */
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Coin coin) {
        try {
            Coin createdCoin = service.createCoin(coin);
            return ResponseEntity.ok(createdCoin);
        } catch (EntityExistsException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    /**
     * 修改幣別資料
     */
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Coin coin) {
        try {
            Coin updatedCoin = service.update(coin);
            return ResponseEntity.ok(updatedCoin);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    /**
     * 刪除幣別
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Coin coin) {
        try {
            service.deleteCoin(coin);
            return ResponseEntity.ok("Successfully deleted");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    /**
     * 串接 Coindesk API 取得即時匯率
     */
    @GetMapping("/coindesk")
    public ResponseEntity<CoindeskDto> callCoindeskAPI() {
        CoindeskDto coindeskResponse = service.callCoindeskAPI();
        return ResponseEntity.ok(coindeskResponse);
    }
}
