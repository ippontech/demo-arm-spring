package tech.ippon.armdemo.model.vm

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import tech.ippon.armdemo.model.dto.CPUInfo

data class CPUInfoVm(
    val architecture: String
) {
    companion object {
        fun from(cpu: CPUInfo): CPUInfoVm {
            return CPUInfoVm(cpu.architecture)
        }
    }
}