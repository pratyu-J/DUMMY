[![](https://jitpack.io/v/pratyu-J/DUMMY.svg)](https://jitpack.io/#pratyu-J/DUMMY)
# Virtualization Environment Detect

App-level virtualization is now a pretty common technique to execute multiple instances of a single application on a single device. Millions of users use applications like Parallel Space, Dual Apps, App Cloner and other virtualization enabling applications to use multiple instances of applications like WhatsApp, Google Pay, etc.

The Library here, gives the app developer an option to not allow the user to execute the application in a virtualized environment. This library can successfully detect and disable application execution under virtualization technologies like, In-App Virtualization, OEM based Virtualization, App-Id Modification* based Pseudo Vitualization.
The simple steps to implement the library are discussed below.

*[***Note: To stop the application from being cloned using the App-ID modification technique, an additional step is required, see optional section under Implementation.***]


## Setting up:

**Step 1. Add the JitPack repository to your build file**

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 **Step 2. Add the dependency**
  
  	dependencies {
	        implementation 'com.github.pratyu-J:DUMMY:1.0.2'
	}

 ## Implementation
 
 	String pkg = "com.xyz.appname";  //full package name //Look for optional section 
	CheckEnv check = new CheckEnv(pkg, this);
	check.options(); //If in a virtual environment, it opens a dialog box where you can choose to continue or close the app.
	//Or 
	check.selfDecide(); // returns a boolean value, true if the environment is virtual false otherwise. Developers can use the value to tackle it however they want.
	//Or
	check.shutDown(); // will close the app automatically if it is running in a virtualized environment.
	
<br>

---

<h3>Optional Step:</h3>

***This is an optional step; the library will work perfectly even if the steps given below are not followed***

To disable the application execution in App-ID modification technique, instead of providing the package name provide in clear text, the base64 encoded package name needs to be provided.

Base64 encoding can be done using, https://www.base64encode.org/ tool.

If the above specified tool doesn't work, use any tool that gives the following output to the input,

Input:
```
com.xyz.appname
```
Output: 
```
Y29tLnh5ei5hcHBuYW1l
```

The Implementation Step will now look like,

	String pkg = "Y29tLnh5ei5hcHBuYW1l";  //Base64 encoded package name
	CheckEnv check = new CheckEnv(pkg, this);
	check.options(); //If in a virtual environment, it opens a dialog box where you can choose to continue or close the app.
	//Or 
	check.selfDecide(); // returns a boolean value, true if the environment is virtual false otherwise. Developers can use the value to tackle it however they want.
	//Or
	check.shutDown(); // will close the app automatically if it is running in a virtualized environment.
	
[Note: Please donot remove "="(equals to) symbols from the Base64 encoded strings, if they appear in the output]
