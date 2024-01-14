package com.example.redoctest.repository

import com.example.redoctest.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}