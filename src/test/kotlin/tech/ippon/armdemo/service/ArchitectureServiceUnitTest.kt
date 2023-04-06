package tech.ippon.armdemo.service

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ArchitectureServiceUnitTest {
    private lateinit var archSvc: ArchitectureService

    @BeforeEach
    fun setUp() {
        archSvc = ArchitectureService()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `arch service returns something`() {
        val expectedArch = System.getProperty("os.arch")
        val res = runBlocking {
            archSvc.getCPUInfo()
        }
        Assertions.assertEquals(expectedArch, res.architecture)
    }
}