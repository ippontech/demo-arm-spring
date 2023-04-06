package tech.ippon.armdemo.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tech.ippon.armdemo.model.vm.CPUInfoVm
import tech.ippon.armdemo.service.ArchitectureService

@RestController
@RequestMapping("/api/v1/")
class ArchitectureController(
   private val architectureService: ArchitectureService
) {

    /**
     * Return a view-model containing CPU info.
     */
    @GetMapping( "/cpu", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    suspend fun getCPUInfo(): CPUInfoVm {
        val cpu = architectureService.getCPUInfo()
        return CPUInfoVm.from(cpu)
    }
}
