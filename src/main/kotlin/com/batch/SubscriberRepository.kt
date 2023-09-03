package com.batch

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.JpaRepository


interface SubscriberJpaRepository : JpaRepository<Subscriber, String>

class SubscriberRepository(
    private val subscriberJpaRepository : SubscriberJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : SubscriberJpaRepository by subscriberJpaRepository{

    fun create(){

    }
}