CREATE TABLE exchange_rate (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    money_origin VARCHAR(10),
    money_destiny VARCHAR(10),
    code DECIMAL(10, 2)
);
