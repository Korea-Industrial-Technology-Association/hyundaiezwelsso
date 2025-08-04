package koita.hyundaiezwelsso.util

import koita.hyundaiezwelsso.property.SsoProperties
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import javax.crypto.spec.IvParameterSpec

@Component
class AES256Crypto(
    private val ssoProperties: SsoProperties,
) {

    /**
     * AES256 CBC 모드로 암호화
     * @param key: 32바이트 길이의 키
     * @param iv: 16바이트 길이의 IV
     * @param data: 암호화할 데이터
     * @return 암호화된 바이트 배열
     */
    fun encrypt(data: String): ByteArray {
        val secretKey: SecretKey = SecretKeySpec(ssoProperties.KEY.toByteArray(StandardCharsets.UTF_8), "AES")
        val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(
            Cipher.ENCRYPT_MODE,
            secretKey,
            IvParameterSpec(ssoProperties.IV.toByteArray(StandardCharsets.UTF_8))
        )
        val encryptedData = cipher.doFinal(data.toByteArray(StandardCharsets.UTF_8))

        return encryptedData
    }

    /**
     * AES256 CBC 모드로 복호화
     * @param key: 32바이트 길이의 키
     * @param iv: 16바이트 길이의 IV
     * @param data: 복호화할 데이터 (암호화된 바이트 배열)
     * @return 복호화된 바이트 배열
     */
    fun decrypt(data: ByteArray): ByteArray {
        val secretKey: SecretKey = SecretKeySpec(ssoProperties.KEY.toByteArray(StandardCharsets.UTF_8), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(
            Cipher.DECRYPT_MODE,
            secretKey,
            IvParameterSpec(ssoProperties.IV.toByteArray(StandardCharsets.UTF_8))
        )
        val decryptedData = cipher.doFinal(data)

        return decryptedData
    }
}