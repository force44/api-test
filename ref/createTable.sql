create table if not exists subscriber
(
    id                      int                    AUTO_INCREMENT PRIMARY KEY comment 'ID',
    naverId                 varchar(100)                            not null comment '네이버 ID ',
    paymentDatetime         varchar(100)                            not null comment '구매 일시',
    paymentStatus           int                                     null comment '지불 상태 ',
    purchasableType         varchar(500)                            null comment '상품 종류',
    purchaseNo              varchar(500)                            null comment '상품 NO',
    purchasePrice           varchar(10)                             null comment '상품 가격',
    purchaseProductId       varchar(10)                             not null comment '상품 Id',
    purchaseProductName     varchar(10)                             not null comment '상품 이름',
    realPaymentPrice        int                                     null comment '구매 금액',
    saleType                varchar(20)                             null comment '할인 종류',
    usedCouponDiscountPrice int                                     null comment '할인 금액',
    regDt               timestamp default current_timestamp()       null comment '등록 일시'
)
comment '구독자' charset = utf8mb3;


