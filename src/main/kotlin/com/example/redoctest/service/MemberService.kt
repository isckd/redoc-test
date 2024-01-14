package com.example.redoctest.service

import com.example.redoctest.domain.Member
import com.example.redoctest.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun getMember(id: Long): Member {
        return memberRepository.getById(id)
    }

    fun getMembers(): List<Member> {
        return memberRepository.findAll()
    }
    fun createMember(name: String) {
        memberRepository.save(Member(name = name))
    }

    fun deleteMember(id: Long) {
        memberRepository.deleteById(id)
    }
}