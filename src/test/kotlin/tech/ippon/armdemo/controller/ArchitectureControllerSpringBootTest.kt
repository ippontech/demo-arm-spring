package tech.ippon.armdemo.controller

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.math.exp

@SpringBootTest
class ArchitectureControllerSpringBootTest {

    @Autowired
    private lateinit var controller: ArchitectureController

    //@Autowired
    private lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun setUp() {
        webTestClient = WebTestClient.bindToController(controller).build()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `returns a JSON with CPU info`() {
        val expected = System.getProperty("os.arch")

        webTestClient.get()
            .uri("/api/v1/cpu")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.architecture").isEqualTo(expected)
    }
}