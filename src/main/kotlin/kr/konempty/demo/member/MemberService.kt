package kr.konempty.demo.member

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor,
) {
    @Transactional(readOnly = true)
    fun getByEmailOK(email: String): MemberResponseDto =
        memberRepository
            .findAll {
                selectNew<MemberResponseDto>(
                    path(Member::id),
                    path(Member::name),
                    path(Member::email),
                    nullValue<Int>(),
                    nullValue<Long>(),
                ).from(entity(Member::class))
                    .where(path(Member::email).equal(email))
            }.firstOrNull()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found with email: $email")

    @Transactional(readOnly = true)
    fun getByEmailError1(email: String): MemberResponseDto =
        kotlinJdslJpqlExecutor
            .findPage(Pageable.ofSize(1)) {
                selectNew<MemberResponseDto>(
                    path(Member::id),
                    path(Member::name),
                    path(Member::email),
                    nullValue<Int>(),
                    nullValue<Long>(),
                ).from(entity(Member::class))
                    .where(path(Member::email).equal(email))
            }.firstOrNull()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found with email: $email")

    @Transactional(readOnly = true)
    fun getByEmailError2(email: String): MemberResponseDto =
        memberRepository
            .findPage(Pageable.ofSize(1)) {
                selectNew<MemberResponseDto>(
                    path(Member::id),
                    path(Member::name),
                    path(Member::email),
                    nullValue<Int>(),
                    nullValue<Long>(),
                ).from(entity(Member::class))
                    .where(path(Member::email).equal(email))
            }.firstOrNull()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found with email: $email")

    @Transactional(readOnly = true)
    fun getByEmailError3(email: String): MemberResponseDto =
        memberRepository
            .findAll(Pageable.ofSize(1)) {
                selectNew<MemberResponseDto>(
                    path(Member::id),
                    path(Member::name),
                    path(Member::email),
                    nullValue<Int>(),
                    nullValue<Long>(),
                ).from(entity(Member::class))
                    .where(path(Member::email).equal(email))
            }.firstOrNull()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found with email: $email")

    @Transactional(readOnly = true)
    fun getByEmailError4(email: String): MemberResponseDto =
        kotlinJdslJpqlExecutor
            .findAll {
                selectNew<MemberResponseDto>(
                    path(Member::id),
                    path(Member::name),
                    path(Member::email),
                    nullValue<Int>(),
                    nullValue<Long>(),
                ).from(entity(Member::class))
                    .where(path(Member::email).equal(email))
            }.firstOrNull()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found with email: $email")
}
