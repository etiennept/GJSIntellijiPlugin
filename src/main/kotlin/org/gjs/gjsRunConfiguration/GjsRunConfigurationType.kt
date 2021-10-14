package org.gjs.gjsRunConfiguration

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.icons.AllIcons
import org.gjs.gjsRunConfiguration.GjsConfigurationFactory
import javax.swing.Icon

class GjsRunConfigurationType : ConfigurationType {
    override fun getDisplayName(): String {
        return "Gjs"
    }

    override fun getConfigurationTypeDescription(): String {
        return "GJS run configuration type"
    }

    override fun getIcon(): Icon {
        return AllIcons.RunConfigurations.Application
    }

    override fun getId(): String {
        return "GjsRunConfiguration"
    }
    override fun getConfigurationFactories(): Array<ConfigurationFactory>{
        return arrayOf(GjsConfigurationFactory(this))
    }

}
