Vagrant-automation
==================
Vagrant Setup:

        Install Vagrant 1.5.3 msi. 
        Install Ruby 2.0.0 and corresponding devkit. Make sure Environment variable is set for the same.
        Override the default provider of Vagrant i.e virtualbox  by  adding below 
        environment variable.
                VAGRANT_DEFAULT_PROVIDER= azure 
        Download  Vagrant-azure gemspec from following link
        https://github.com/MSOpenTech/vagrant-azure
        Execute gem build vagrant-azure.gemspec in the source directory.
        This will place a vagrant-azure.gem.
        Execute vagrant plugin install vagrant-azure.gem. 
        This will install vagrant-azure plugin.
        
Gradle Setup:

        Install Java JDK  and set following environment variable.
             JAVA_HOME = C:\Program Files\Java\jdk1.6.0_45\
        Install Gradle and set following environment variable.
             GRADLE_HOME = C:\gradle-1.12\bin

Steps to Run Vagrant-Gradle Acceptance Test:

        Download Vagrant-Automation code for acceptance testing.
        Unzip the folder and modify the  vagrant.groovy file as below
        @Input
        static final String VAGRANT_EXECUTABLE = 'vagrant executable path' /* Ex:C:\\Hashicorp\\Vagrant\\bin\\vagrant.exe'
        Make appropriate changes to the vagrantfile to fit in your changes.
        Include the path where vagrantfile resides in build.gradle file.
             ext.targetedVagrantProjectDir = file('../vagrant-azure')
        Create a box file for azure provider and add the box to the vagrant.

             
File Dependencies:

        Include gradle directory, gradlew.bat and gradlew files from following link
        https://github.com/bmuschko/gradle-in-action-source
        to vagrant-gradle-wrapper directory in the source.
        Cd to the path where build.gradle file is located.
        Execute following Commands    
             gradlew wrapper : This will build all the required files.
             gradlew vagrantWindowsTest : This command will start the vagrant automation by executing various vagrant         commands in a sequential order.

        
Note:

        SSL Certificate has to be added manually for provision to work as expected.   
        
Steps  to create SSL Certificate:

	Once the vm is up in azure and the endpoints are configured as expected. 
        Open the cloud service in the browser as below
        Ex: https://vagtest.cloudapp.net:5986 
        it will download a certificate which should to be included in host machine in trusted host Certificates. 
        This is a SSL Certificate which is required for basic file transfer, provisioning and rsync which also works based on file transfer mechanism.







