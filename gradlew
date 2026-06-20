#!/bin/sh
##############################################################################
# Gradle startup script for UN*X
##############################################################################

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    JAVACMD="$JAVA_HOME/bin/java"
else
    JAVACMD="java"
fi

APP_HOME="$(dirname "$0")"

exec "$JAVACMD" -jar "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" "$@" || exec "$JAVACMD" \
    -classpath "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" \
    org.gradle.wrapper.GradleWrapperMain "$@"
