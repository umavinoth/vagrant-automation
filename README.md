vagrant-automation
==================
Vagrant Setup:
1.	Install Vagrant 1.5.3 and make sure vagrant executable path is set in environment path variable
2.	Set following environment variable to azure. This is to override the default provider of Vagrant i.e., virtualbox 
	“VAGRANT_DEFAULT_PROVIDER” = azure 
3.	Create a box file and add the box to the vagrant.

Gradle Setup:
1.	Install Java JDK  and set following environment variable
	JAVA_HOME = C:\Program Files\Java\jdk1.6.0_45\

Include “C:\Program Files\Java\jdk1.6.0_45\bin” in environment path variable.

2.	Install Gradle and set following environment variable
	GRADLE_HOME = “C:\gradle-1.12\bin”

Include “C:\gradle-1.12\bin” in environment path variable as well.


Vagrant-Gradle Acceptance Test:

1.	Attached zip is the Vagrant-Gradle code for acceptance testing.

2.	Unzip the folder and Include Vagrant executable path in vagrant.groovy file which is located inside
	buildSrc/src/…/vm/vagrant.groovy
	@Input
	static final String VAGRANT_EXECUTABLE = 'C:\\Hashicorp\\Vagrant\\bin\\vagrant.exe'

3.	Include the path where vagrantfile resides in build.gradle file.
	ext.targetedVagrantProjectDir = file('../vagrant-azure')

4.	Cd to the path where build.gradle file is located.
	Execute following Commands
	graldew wrapper : This will build all the required files
	gradlew vagrantWindowsTest : This command will start the vagrant automation by executing various vagrant commands in a sequential order.





