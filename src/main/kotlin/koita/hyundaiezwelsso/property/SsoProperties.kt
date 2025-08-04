package koita.hyundaiezwelsso.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "hyundaiezwel")
data class SsoProperties(
    val baseUrl: String,
    val clientInfo: String,
    val ssoKey: String,
    val KEY: String,
    val IV: String,
)