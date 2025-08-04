package koita.hyundaiezwelsso.service

import koita.hyundaiezwelsso.property.SsoProperties
import koita.hyundaiezwelsso.util.AES256Crypto
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class SsoService(
    private val aes256Crypto: AES256Crypto,
    private val ssoProperties: SsoProperties,
) {
    companion object {
        const val ENCRY = "encry"
        private val timeStampFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
    }

    /**
     * SSO URL을 생성합니다.
     *
     * @param userId 사용자 ID
     * @param userNm 사용자 이름
     * @return SSO URL
     */
    fun getSsoUrl(userId: String, userNm: String): String {
        val timeStamp = LocalDateTime.now().format(timeStampFormatter)
        val encryptedData = getEncryptedData(userId, userNm, timeStamp)

        return "${ssoProperties.baseUrl}?data=$encryptedData&clientInfo=${ssoProperties.clientInfo}"
    }

    /**
     * 사용자 ID, 이름, 타임스탬프를 사용하여 암호화된 데이터를 생성합니다.
     *
     * @param userId 사용자 ID
     * @param userNm 사용자 이름
     * @param timeStamp 현재 시간의 타임스탬프
     * @return 암호화된 데이터 문자열
     */
    private fun getEncryptedData(userId: String, userNm: String, timeStamp: String): String {
        val data = "$userId|$timeStamp|$ENCRY|$userNm"
        val encryptedData = aes256Crypto.encrypt(data)
        return encryptedData.toString(Charsets.UTF_8)
    }
}