@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Gradle startup script for Windows
@rem
@echo off

set DIRNAME=%~dp0
set APP_HOME=%DIRNAME%

set JAVACMD=java
if defined JAVA_HOME set JAVACMD=%JAVA_HOME%\bin\java

"%JAVACMD%" -classpath "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
