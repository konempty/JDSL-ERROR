package kr.konempty.demo.member

data class MemberResponseDto(
    val id: Long,
    val name: String,
    val email: String,
    val age: Int?,
    val zipcode: Long?,
)
