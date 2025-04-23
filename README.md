# 國泰世華 Java Engineer 線上作業

## API 說明
所有 API 的 `Content-Type` 為 `application/json`

### 1. Coindesk 原始資料 API
#### 串接 Coindesk API 取得即時匯率 **GET** http://localhost:8080/coindesk/api/v1/coin/coindesk
### 2. 幣別資料 CRUD API
#### 取得所有幣別 **GET** http://localhost:8080/coindesk/api/v1/coin/search
#### 新增幣別資料 **POST** http://localhost:8080/coindesk/api/v1/coin/add
Request Body：
```json
  {
    "code": "USD",
    "codeNameZh": "美元",
    "symbol": "&#36;",
    "rateFloat": 20176.4049,
    "description": "United State Dollar"
  }
```
#### 修改幣別資料 **PUT** http://localhost:8080/coindesk/api/v1/coin/update
Request Body：
```json
  {
    "code": "USD",
    "codeNameZh": "美元",
    "symbol": "&#36;",
    "rateFloat": 20176.4049,
    "description": "United State Dollar"
  }
```
#### 刪除幣別資料 **DELETE** http://localhost:8080/coindesk/api/v1/coin/delete
Request Body：
```json
  {
  "code": "USD"
}
```

## H2 資料庫管理介面
URL: http://localhost:8080/coindesk/h2-console