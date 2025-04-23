-- 建立預設幣別
INSERT INTO `COIN` (code, code_name_zh, symbol, rate_float, description, update_time, create_time)
VALUES ('USD', '美元', '&#36;', 20176.4049, 'United State Dollar', now(), now()),
       ('GBP', '英鎊', '&pound;', 16859.2425, 'British Pound Sterling', now(), now()),
       ('EUR', '歐元', '&euro;', 19654.7641, 'Euro', now(), now());