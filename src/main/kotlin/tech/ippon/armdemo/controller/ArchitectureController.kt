package tech.ippon.armdemo.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tech.ippon.armdemo.model.vm.CPUInfoVm
import tech.ippon.armdemo.service.ArchitectureService

@RestController
class ArchitectureController(
   private val architectureService: ArchitectureService
) {

    /**
     * Return a view-model containing CPU info.
     */
    @GetMapping(
        path = ["/cpu"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
        )
    suspend fun getCPUInfo(): Mono<CPUInfoVm> {
        TODO("ROFL implement me")
    }
}