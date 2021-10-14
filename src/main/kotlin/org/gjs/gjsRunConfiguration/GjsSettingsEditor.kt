package org.gjs.gjsRunConfiguration

import com.intellij.ide.ui.laf.darcula.ui.TextFieldWithPopupHandlerUI
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.openapi.vcs.ui.TextFieldAction
import com.intellij.ui.*
import com.intellij.util.textCompletion.TextFieldWithCompletion
import java.awt.TextField

import javax.swing.JComponent

import javax.swing.JPanel




class GjsSettingsEditor(private val project: Project ) : SettingsEditor<GjsRunConfiguration>() {

    private lateinit var myPanel: JPanel
    private lateinit var myScriptName: LabeledComponent<TextFieldWithBrowseButton>
    private lateinit var workingDir : LabeledComponent<TextFieldWithBrowseButton>

    private fun TextFieldWithBrowseButton.addBrowseFolderListener(chooseFile : Boolean , chooseFolders : Boolean  ,project : Project?= null  ){
        addBrowseFolderListener(TextBrowseFolderListener(FileChooserDescriptor(
            chooseFile,
            chooseFolders,
            false,
            false,
            false,
            false), project ))
    }

    override fun resetEditorFrom(gjsRunConfiguration: GjsRunConfiguration) {
        myScriptName.component.text = gjsRunConfiguration.scriptName
        workingDir.component.text = gjsRunConfiguration.workingFile
    }

    override fun applyEditorTo(gjsRunConfiguration: GjsRunConfiguration) {
        gjsRunConfiguration.scriptName = myScriptName.component!!.text
        gjsRunConfiguration.workingFile = workingDir.component!!.text
    }

    override fun createEditor(): JComponent {
        return myPanel
    }

    private fun LabeledComponent(project : Project?) =LabeledComponent<TextFieldWithBrowseButton>().apply {
        component = TextFieldWithBrowseButton().apply {
            addBrowseFolderListener(true ,
                chooseFolders = false,
                project = project
            )
        }

    }
    private fun createUIComponents() {
        myScriptName = LabeledComponent(project)
        workingDir = LabeledComponent(null)




    }
}