package org.gjs.gjsRunConfiguration

import com.intellij.execution.ExecutionException
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File


class GjsRunConfiguration(project : Project, factory : ConfigurationFactory, name :String ) : RunConfigurationBase<GjsRunConfigurationOptions>(project , factory , name) {
    override fun getOptions(): GjsRunConfigurationOptions {
        return super.getOptions( ) as GjsRunConfigurationOptions
    }

    var scriptName
        get() = options.scriptName
        set(value) { options.scriptName  = value}

    var workingFile
        get() = options.workingFile ?: project.basePath!!
        set(value) {
            options.workingFile = value
        }



    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?>{
        return GjsSettingsEditor(project)
    }

    override fun checkConfiguration() {

    }

    override fun getState(executor: Executor, executionEnvironment: ExecutionEnvironment): RunProfileState {

        return object : CommandLineState(executionEnvironment) {
            @Throws(ExecutionException::class)
            override fun startProcess(): ProcessHandler {
                val commandLine = GeneralCommandLine( "gjs" , options.scriptName).apply {
                    workDirectory = File(workingFile)
                }
                return ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine).apply {
                    ProcessTerminatedListener.attach(this )
                }
            }
        }
    }
}



