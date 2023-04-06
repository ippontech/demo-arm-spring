package tech.ippon.armdemo.controller

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import tech.ippon.armdemo.model.dto.CPUInfo
import tech.ippon.armdemo.service.ArchitectureService

class ArchitectureControllerUnitTest {

    private lateinit var service: ArchitectureService
    private lateinit var controller: ArchitectureController

    @BeforeEach
    fun setUp() {
        service = mockk<ArchitectureService>()
        controller = ArchitectureController(service)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `sends out results of CPU lookup`() {
        val architecture = "POWER9"
        coEvery {
            service.getCPUInfo()
        } coAnswers {
            CPUInfo(architecture)
        }

        val vm = runBlocking { controller.getCPUInfo() }

        Assertions.assertEquals(architecture, vm.architecture)
    }
}