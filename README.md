## Compile a native library

Generate a header file

```
cd <PROJECT_ROOT>/src/main/java

javac -h ../../../native/ dev/nhayashida/liberty/jni/sample/JNISample.java
```

Compile C code

```
cd <PROJECT_ROOT>/native

- Mac
gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin/" -o libjnisample.jnilib -shared JNISample.c

- Linux
gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux/" -o libjnisample.so -shared JNISample.c

```

## Configure a server

```
cd <PROJECT_ROOT>

mvn install
```

Set the path to the native library as a JVM option

```
echo "-Djava.library.path=<PROJECT_ROOT>/native" > \
target/liberty/wlp/usr/servers/nfnavi-api/jvm.options
```

## Run the server

```
mvn liberty:run-server
```

Open http://localhost:9080/sample/message with your browser, then a message from C code is shown.
