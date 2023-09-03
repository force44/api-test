package com.apitest

import com.batch.Subscriber
import com.google.gson.Gson
import org.modelmapper.ModelMapper

fun main(){

    val modelMapper=  ModelMapper()

    val jjson = "{\"data\":{\"purchaseListWithPageInfo\":{\"purchases\":[{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-08-20T09:21:16\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2906907854,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-07-20T09:22:44\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2817900509,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-06-20T09:23:24\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2723269200,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-05-20T09:24:26\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2646183318,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-04-20T09:28:16\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2571854555,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-03-20T09:28:19\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2493611535,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-02-20T09:28:51\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2425134274,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2023-01-20T09:30:56\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2351560376,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2022-12-20T09:33:20\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2275587689,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"},{\"naverId\":\"si****\",\"paymentDatetime\":\"2022-11-20T09:36:16\",\"paymentStatus\":\"COMPLETE\",\"purchasableType\":\"TICKET_MONTHLY\",\"purchaseNo\":2207033090,\"purchasePrice\":1487500,\"purchaseProductId\":\"sps-tck-1000001587\",\"purchaseProductName\":\"5인 구독\",\"realPaymentPrice\":0,\"saleType\":\"TICKET\",\"usedCouponDiscountPrice\":1487500,\"__typename\":\"Purchase\"}],\"pageInfo\":{\"totalCount\":12,\"pageNo\":0,\"pageSize\":10,\"__typename\":\"PageInfo\"},\"__typename\":\"PurchaseListWithPageInfo\"}},\"errors\":[]}"
    val map = purchaseList( Gson().fromJson(jjson, Map::class.java))

    val list = map["purchases"] as List<*>

    for( str in list){
        val tt = modelMapper.map(str, Subscriber::class.java)
        print(tt.naverId)
        //Gson().from(str, Subscriber::class.java)
    }

//   list.forEach { it ->  Gson().fromJson(it.toString(), Subscriber::class.java) }
//    print(">")
}


fun purchaseList(map : Map<*,*>): Map<*, *>{
//    val map = Gson().fromJson(str, Map::class.java)
// purchaseListWithPageInfo -> {LinkedTreeMap@994}  size = 3

    return if(map.contains("purchases")){
        map
    }else{
        purchaseList(map.values.iterator().next() as Map<*, *>)
        // return purchaseList(map.forEach( it ->))
    }
}