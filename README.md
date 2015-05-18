# gradle-jni-example
A sample application that shows how to use gradle to compile C/C++ JNI code

This project require gradle 2.3 to match the native compilation DSL.  

Native compilation currently support two toolchains: gcc and clang.  The gradle native plugin scans the path and chooses the "best" tool available, although how that determination is made is currently opaque.  Gradle clearly prefers clang to gcc, and will always use that toolchain if it is available.

The Java subset of the code base is a Spring-boot application.  

