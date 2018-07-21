Objective:  This project is considered to develop a mini OS to hone my operating system, Java skills

Skills & Technologies used: Java, operating system concepts (specifically to implement page replacement, disk scheduling algorithms)
                            mysql
                            
                           Application is developed using eclipse IDE 
 
 
 Application (mini OS) on startup launches login screen and prompts the user to enter username, password. On successful authentication,
    miniDesktop is created. More than 3 unsuccessful attempts to login, exits the program.
 Authentication is as per credentials stored in mysql database of logins.
 Mini desktop  allows user to access mini applications like calculator, shell,calendar, simulated page replacement, disk scheduler algorithms,
   a puzzle game, Text editor,browser. Mini desk top shows icons to access each of these applications and exit the program.
 
 Page replacement algorithms simulation: This application accepts Random/Manual input for chosen number of frames and calculates 
  number of page faults for FIFO, LRU, Second Chance and Optimal page replacement algorithms implemented.
  
Disk Scheduler application : Disk scheduler UI number of input requests(using NRequests button) and allows user to either input
 Random/Manual I?O request information. Then it generates Disk scheduling graph for selected algorithm. FCFS,SSTF,Scan,CScan, Look, CLook
    disk scheduling algorithms are implemented. Draw Graph button seeks user input on starting position of head. 
  As per the user input and chosen algorithm, disk scheduling graph gets generated.
  
 miniShell: This application creates a command line interface and capable of executing simple unix shell commands.
 
 FileBrowser: This application starts with home directory and allows user to view the files in selected directory.
 
 Browser: This applet creates a browser and facilitates browsing provided the system is connected to internet.
 
 Along with above application a simple calculator, calendar applications and a puzzle game are also implemented.
 
 
 Setup Instructions: Install mysql (version 8.0), create osProject database and create oslogin table and create login. Example shown in DB.txt
 
                     Compile Java source code to create executable or use runnable jar shared with the source code.
                     
Note: Eclipse should be setup to create osProject package and copy the source files, images to compile the code. Referenced external libraries are places in resources folder for your reference. Required eclipse settings should be made as applicable.
                     
 
 
 
 
 
 
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             


