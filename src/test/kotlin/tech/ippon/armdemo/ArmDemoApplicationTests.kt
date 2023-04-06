package tech.ippon.armdemo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ArmDemoApplicationTests {

    @Test
    fun contextLoads() {
        // app starts
        Assertions.assertTrue(true)
    }

}
