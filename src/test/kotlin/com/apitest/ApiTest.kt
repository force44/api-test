package com.apitest

import com.github.kevinsawicki.http.HttpRequest
import org.json.JSONObject


fun main(){
    val request = HttpRequest.post("https://studio.premium.naver.com/premium/graphql")
    // !!! 쿠키값 셋팅
    request.header("Cookie" , "NNB=PL7CKUYGW3YWI; nid_inf=-1520300371; NID_AUT=s/OeZhhhavF6qi9dSUcfJphyVCNKgpsiDhzSsYyJm3DIu2c+JjyPrxc4uE5E4XSx; NID_JKL=KPfQv47V+a6aKGAkWchDMQMtix71a9+Ftp2bhiSntBU=; _pk_id.1.2b3c=dfdcf695c3bd5bd4.1693563299.; _pk_ses.1.2b3c=1; NID_SES=AAABz4eDGk+EVq6ELe+Bh1YTtS98jrjGqmJ+xOIVIhK9aAPHvVVCW8U7qNdYQ3b7Ui74gBLr7ynrrtJ89E5wbckqRj0exr7BkqaB51sKiHQUv4tkgnpCUIjRiLBmILPhQ3KM/O2LzEvEnDxiIYVMlwLZkJyVbS0fFrExevV55ZbDFmfWNQGW2qVk733IGbasALk+boi1EyMxG6IUQ/7f5cWUq0xamCjQQKhLCL1+kHUqoGjB/9+ncrbg/4KSwxUKFku0h7Vbw459q6u/sBh8kRoB3Y34dh0SO8EkzrgsQnVD3X6J5W9rDwyvpuftsMkD68bqMidYVqgZMdGxJV/dGm1gmnXP64cQXbc1QItO4XqSE7tSJcj4bfussMMIQm3908Ee5JBx8cGQF7Auurpni/AhlyfnEmQJNQ2G2j4r7pDNVJnfRzDCcoysS5KGBSfUHmoaPzMATGWz8IYRCxYH8XVUb0YV03ZUlRXmXYR+qZHKXIosT4L4dapZRRsK/vGgHfDVZ1eqSWSydox2HD8724vMFKoAhcMd7Re+v8GubIj2P+LPOzv6+UE2MSf+eIbNQM6PtjPapTEvrQnWMybStG0cNX67+JX7h3krR1tk3IOxhA/D")
    request.header( "Authid", "3090")
    request.header( "Content-Type", "application/json")
    // 없어도 되나... 혹시 몰라서
    request.header( "Origin", "https://studio.premium.naver.com")
    request.header( "Referer", "https://studio.premium.naver.com/sales/subscribe")

    val variables = JSONObject()

    // 고정 값
    variables.put("cpType", "Premium")
    variables.put("cpName", "nomadand")
    variables.put("cpId", "FqPnomadand")
    variables.put("subId", "nomad")

    // 변경해서 스삭!!
    variables.put("startYmdt", "20220902235959")   // 날짜
    variables.put("endYmdt", "20230901235959")
    variables.put("pageNo", 0)
    variables.put("pageSize", 10)
    variables.put("naverId", "signalreport")      // 네이버 ID 변경

    val param = JSONObject()
    param.put( "variables", variables)
    param.put( "query", getQuery())

    //println(param.toString())
    request.send(param.toString())

    if(request.ok()){
        println(">>>>>>>>..go")
        println(request.body())
    }
}

fun getQuery():String{
    return "query (\$cpType: CpType!, \$cpName: String!, \$subId: String!, \$startYmdt: String, \$endYmdt: String, \$pageNo: Int, \$pageSize: Int, \$naverId: String, \$purchaseNo: String, \$searchType: PaymentStatus, \$ticketIds: [String]) {\n" +
            "  purchaseListWithPageInfo: getTicketSales(\n" +
            "    cpType: \$cpType\n" +
            "    cpName: \$cpName\n" +
            "    subId: \$subId\n" +
            "    startYmdt: \$startYmdt\n" +
            "    endYmdt: \$endYmdt\n" +
            "    pageNo: \$pageNo\n" +
            "    pageSize: \$pageSize\n" +
            "    naverId: \$naverId\n" +
            "    purchaseNo: \$purchaseNo\n" +
            "    searchType: \$searchType\n" +
            "    ticketIds: \$ticketIds\n" +
            "  ) {\n" +
            "    purchases {\n" +
            "      ...PurchaseFragment\n" +
            "      __typename\n" +
            "    }\n" +
            "    pageInfo {\n" +
            "      ...PageInfoFragment\n" +
            "      __typename\n" +
            "    }\n" +
            "    __typename\n" +
            "  }\n" +
            "}\n" +
            "\n" +
            "fragment PurchaseFragment on Purchase {\n" +
            "  naverId\n" +
            "  paymentDatetime\n" +
            "  paymentStatus\n" +
            "  purchasableType\n" +
            "  purchaseNo\n" +
            "  purchasePrice\n" +
            "  purchaseProductId\n" +
            "  purchaseProductName\n" +
            "  realPaymentPrice\n" +
            "  saleType\n" +
            "  usedCouponDiscountPrice\n" +
            "  __typename\n" +
            "}\n" +
            "\n" +
            "fragment PageInfoFragment on PageInfo {\n" +
            "  totalCount\n" +
            "  pageNo\n" +
            "  pageSize\n" +
            "  __typename\n" +
            "}\n"
}
