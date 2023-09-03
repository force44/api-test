package com.batch

import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

@Entity
data class Subscriber(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = null,
    @Id
    var naverId: String,
    var paymentDatetime: String,
    var paymentStatus: String,
    var purchasableType: String,
    var purchaseNo: Long,
    var purchasePrice: Long,
    var purchaseProductId: String,
    var purchaseProductName: String,
    var realPaymentPrice: Long,
    var saleType: String,
    var usedCouponDiscountPrice: Long,
) {
//    final override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other == null) return false
//        val oEffectiveClass =
//            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
//        val thisEffectiveClass =
//            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
//        if (thisEffectiveClass != oEffectiveClass) return false
//        other as Subscriber
//
//        return id != null && id == other.id
//    }
//
//    final override fun hashCode(): Int =
//        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
//
    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $naverId )"
    }

}
