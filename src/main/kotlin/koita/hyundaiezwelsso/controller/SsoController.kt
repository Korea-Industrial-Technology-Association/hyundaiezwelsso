package koita.hyundaiezwelsso.controller

import koita.hyundaiezwelsso.ApiPath
import koita.hyundaiezwelsso.service.SsoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
class SsoController(
    private val ssoService: SsoService
){
    /**
     * SSO URL을 생성하여 리다이렉트합니다.
     *
     * @param userId 사용자 ID
     * @param userNm 사용자 이름
     * @return 리다이렉트할 URL
     */
    @GetMapping(ApiPath.SSO)
    fun sso(
        @RequestParam(required = true) userId : String,
        @RequestParam(required = true) userNm : String,
    ): RedirectView {
        val redirectUrl = ssoService.getSsoUrl(userId, userNm)
        return RedirectView(redirectUrl)
    }
}