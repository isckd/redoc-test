package com.example.redoctest.domain

import javax.persistence.*

@Entity
@Table
class Member(
    name: String,
    age: Int = 0
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // 키 생성을 DB에 위임한다.
    var id: Long? = null

    @Column(nullable = false, length = 30)
    var name: String? = name

    @Column(nullable = true)
    var age: Int = age
}