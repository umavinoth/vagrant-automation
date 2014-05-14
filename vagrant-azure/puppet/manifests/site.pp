	file {'C:\Users\vagrant\my_puppet.txt':
    ensure  => present,
    content => "Puppet is working",
     }
	
	
  package { "notepad++":
  ensure  => installed,   
  source   => "C:/msi/npp.6.6.2.installer.exe",    
 install_options => [ '/S' ]
 }
 

	
