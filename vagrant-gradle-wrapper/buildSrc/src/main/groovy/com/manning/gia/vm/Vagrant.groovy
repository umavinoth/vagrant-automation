package com.manning.gia.vm

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class Vagrant extends DefaultTask {
    static final String VAGRANT_EXECUTABLE = ''

    @Input
    List<String> commands

    @Input
    File dir	

	def message = ""
	def cmd = ""	

    @TaskAction
    void runCommand() {
		StringBuffer sbout = new StringBuffer()
        StringBuffer sberr = new StringBuffer()	
		cmd = commands[0]
		
		println cmd+" command is in progress"		
        commands.add(0, VAGRANT_EXECUTABLE)
        logger.info "Executing Vagrant command: '${commands.join(' ')}'"

        def process = commands.execute(null, dir)
		process.waitForProcessOutput (sbout, sberr)
        process.waitFor()
		
        if (process.exitValue() != 0) {
			println cmd+" command failed to execute."
            throw new GradleException()			
        }
		else
		{			
			println(sbout.toString())
			println cmd+" command executed successfully"
		}
    }
	
}