package tech.ippon.armdemo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ArmDemoApplicationTests {

    @Test
    fun contextLoads() {
        // fail to check github actions
        Assertions.assertFalse(true)
    }

}
