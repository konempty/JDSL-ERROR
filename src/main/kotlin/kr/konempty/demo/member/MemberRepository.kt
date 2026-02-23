package kr.konempty.demo.member

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository :
    JpaRepository<Member, Long>,
    KotlinJdslJpqlExecutor
