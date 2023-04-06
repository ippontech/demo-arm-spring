package tech.ippon.armdemo.service

import org.springframework.stereotype.Service
import tech.ippon.armdemo.model.dto.CPUInfo

@Service
class ArchitectureService {

    /**
     * Ask the JVM to introspect its `os` runtime properties to get `arch.
     */
    suspend fun getCPUInfo(): CPUInfo {
        val envOsInfoQuery = System.getProperty("os.arch")
        return CPUInfo(envOsInfoQuery)
    }

}