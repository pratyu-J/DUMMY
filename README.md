[![](https://jitpack.io/v/pratyu-J/DUMMY.svg)](https://jitpack.io/#pratyu-J/DUMMY)
# Virtualization Environment Detect

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency
  
  	dependencies {
	        implementation 'com.github.pratyu-J:DUMMY:1.0.1'
	}

 ## Implementation
 
 	String pkg = getPackageName();
	CheckEnv check = new CheckEnv(pkg, this);
	check.options(); //If in a virtual environment, it opens a dialog box where you can choose to continue or close the app.
	//Or 
	check.selfDecide(); // returns a boolean value, true if the environment is virtual false otherwise. Developers can use the value to tackel it however they want.
	//Or
	check.shutDown(); // will close the app automatically if it is running in a virtualized environment.
