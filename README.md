vagrant-automation
==================
Vagrant Setup:

	Install Vagrant 1.5.3 and make sure vagrant executable path is set in environment path variable.
	Set following environment variable to azure. This is to override the default provider of Vagrant i.e., virtualbox 
		“VAGRANT_DEFAULT_PROVIDER” = azure 
	Create a box file and add the box to the vagrant.

Gradle Setup:

	Install Java JDK  and set following environment variable.
		JAVA_HOME = C:\Program Files\Java\jdk1.6.0_45\

	Include “C:\Program Files\Java\jdk1.6.0_45\bin” in environment path variable.

	Install Gradle and set following environment variable.
		GRADLE_HOME = “C:\gradle-1.12\bin”

	Include “C:\gradle-1.12\bin” in environment path variable as well.


Vagrant-Gradle Acceptance Test:

	Attached zip is the Vagrant-Gradle code for acceptance testing.

	Unzip the folder and Include Vagrant executable path in vagrant.groovy file which is located inside
			buildSrc/src/…/vm/vagrant.groovy
			@Input
			static final String VAGRANT_EXECUTABLE = 'vagrant executable path' /* Ex: "C:\\Hashicorp\\Vagrant\\bin\\vagrant.exe" */

	Include the path where vagrantfile resides in build.gradle file.
			ext.targetedVagrantProjectDir = file('../vagrant-azure')

	Cd to the path where build.gradle file is located.
	Execute following Commands
	
			gradlew wrapper : This will build all the required files
			gradlew vagrantWindowsTest : This command will start the vagrant automation by 
			executing various vagrant commands in a sequential order.
	
	
File Dependencies:

	Include gradle directory, gradlew.bat and gradlew files from following link
	https://github.com/bmuschko/gradle-in-action-source
	to vagrant-gradle-wrapper directory in the source

	
Note:

	SSL Certificate has to be added manually for provision to work as expected.

	Once the vm is up in azure and the endpoints are configured as expected. 
	Navigating to the cloud service as below
	Ex: https:\\vagtest.cloudapp.net:5986 
	will download a certificate which is should to be included in host machine in trusted host Certificates. 
	This is a SSL Certificate which is required for basic file tranfer, provisioning and 
	rsync which also works based on file transfer mechanism.







