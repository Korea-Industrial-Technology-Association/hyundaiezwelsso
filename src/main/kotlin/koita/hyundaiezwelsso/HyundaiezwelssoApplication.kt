package koita.hyundaiezwelsso

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class HyundaiezwelssoApplication

fun main(args: Array<String>) {
    runApplication<HyundaiezwelssoApplication>(*args)
}
