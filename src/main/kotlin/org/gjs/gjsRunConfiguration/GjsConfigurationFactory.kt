package org.gjs.gjsRunConfiguration

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NotNull

class GjsConfigurationFactory(type : ConfigurationType) : ConfigurationFactory( type ) {
    init {

    }

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
       // println("createTemplateConfiguration")
        return GjsRunConfiguration(project, this, "Demo")
    }

    @NotNull
    override fun getId(): String {
        return type.id
    }
    override fun getOptionsClass(): Class<out BaseState?>? {
        //println("getOptionsClass")
        return GjsRunConfigurationOptions::class.java
    }


}