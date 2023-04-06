package tech.ippon.armdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArmDemoApplication

fun main(args: Array<String>) {
    runApplication<ArmDemoApplication>(*args)
}
