package org.gjs.gjsRunConfiguration

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.openapi.components.StoredProperty


class GjsRunConfigurationOptions : RunConfigurationOptions() {

    private val _scriptName = string("").provideDelegate(this, "scriptName")
    private val _workingFile = string("").provideDelegate(this, "workingFile")
    var scriptName
        get() = _scriptName.getValue(this) ?: ""
        set(value) {
            _scriptName.setValue(this, value)
        }
    var workingFile
        get() = _workingFile.getValue(this)
        set(value) {
            _workingFile.setValue(this, value)
        }


}