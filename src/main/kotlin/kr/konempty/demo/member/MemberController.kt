package kr.konempty.demo.member

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService,
) {
    @GetMapping("/by-email/ok")
    fun getByEmailOK(
        @RequestParam email: String,
    ): MemberResponseDto = memberService.getByEmailOK(email)

    @GetMapping("/by-email/error1")
    fun getByEmailError1(
        @RequestParam email: String,
    ): MemberResponseDto = memberService.getByEmailError1(email)

    @GetMapping("/by-email/error2")
    fun getByEmailError2(
        @RequestParam email: String,
    ): MemberResponseDto = memberService.getByEmailError2(email)

    @GetMapping("/by-email/error3")
    fun getByEmailError3(
        @RequestParam email: String,
    ): MemberResponseDto = memberService.getByEmailError3(email)

    @GetMapping("/by-email/error4")
    fun getByEmailError4(
        @RequestParam email: String,
    ): MemberResponseDto = memberService.getByEmailError4(email)
}
