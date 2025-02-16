@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem
@rem SPDX-License-Identifier: Apache-2.0
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  product-service startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and PRODUCT_SERVICE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\product-service-0.1.jar;%APP_HOME%\lib\micronaut-data-hibernate-jpa-4.10.5.jar;%APP_HOME%\lib\micronaut-grpc-runtime-4.8.0.jar;%APP_HOME%\lib\micronaut-kotlin-runtime-4.5.0.jar;%APP_HOME%\lib\micronaut-serde-jackson-2.12.1.jar;%APP_HOME%\lib\micronaut-jdbc-hikari-6.0.2.jar;%APP_HOME%\lib\micronaut-data-jpa-4.10.5.jar;%APP_HOME%\lib\micronaut-data-runtime-4.10.5.jar;%APP_HOME%\lib\micronaut-data-model-4.10.5.jar;%APP_HOME%\lib\micronaut-data-tx-hibernate-4.10.5.jar;%APP_HOME%\lib\micronaut-hibernate-jpa-6.0.2.jar;%APP_HOME%\lib\micronaut-grpc-client-runtime-4.8.0.jar;%APP_HOME%\lib\micronaut-grpc-server-runtime-4.8.0.jar;%APP_HOME%\lib\micronaut-validation-4.8.0.jar;%APP_HOME%\lib\micronaut-reactor-3.6.0.jar;%APP_HOME%\lib\micronaut-serde-support-2.12.1.jar;%APP_HOME%\lib\micronaut-serde-api-2.12.1.jar;%APP_HOME%\lib\micronaut-data-tx-jdbc-4.10.5.jar;%APP_HOME%\lib\micronaut-data-connection-jdbc-4.10.5.jar;%APP_HOME%\lib\micronaut-jdbc-6.0.2.jar;%APP_HOME%\lib\micronaut-data-tx-4.10.5.jar;%APP_HOME%\lib\micronaut-data-connection-hibernate-4.10.5.jar;%APP_HOME%\lib\micronaut-grpc-opentracing-4.8.0.jar;%APP_HOME%\lib\micronaut-grpc-health-4.8.0.jar;%APP_HOME%\lib\micronaut-grpc-annotation-4.8.0.jar;%APP_HOME%\lib\micronaut-data-connection-4.10.5.jar;%APP_HOME%\lib\micronaut-discovery-core-4.7.11.jar;%APP_HOME%\lib\micronaut-jackson-core-4.7.11.jar;%APP_HOME%\lib\micronaut-json-core-4.7.11.jar;%APP_HOME%\lib\micronaut-http-4.7.11.jar;%APP_HOME%\lib\micronaut-context-propagation-4.7.11.jar;%APP_HOME%\lib\micronaut-context-4.7.11.jar;%APP_HOME%\lib\micronaut-aop-4.7.11.jar;%APP_HOME%\lib\micronaut-buffer-netty-4.7.11.jar;%APP_HOME%\lib\micronaut-inject-4.7.11.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\jackson-databind-2.17.2.jar;%APP_HOME%\lib\jackson-annotations-2.17.2.jar;%APP_HOME%\lib\jackson-core-2.17.2.jar;%APP_HOME%\lib\jackson-module-kotlin-2.17.2.jar;%APP_HOME%\lib\kotlin-reflect-1.9.25.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.9.25.jar;%APP_HOME%\lib\kotlin-stdlib-1.9.25.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.9.25.jar;%APP_HOME%\lib\logback-classic-1.5.15.jar;%APP_HOME%\lib\h2-2.3.232.jar;%APP_HOME%\lib\snakeyaml-2.2.jar;%APP_HOME%\lib\grpc-protobuf-1.68.1.jar;%APP_HOME%\lib\grpc-netty-1.68.1.jar;%APP_HOME%\lib\grpc-util-1.68.1.jar;%APP_HOME%\lib\grpc-core-1.68.1.jar;%APP_HOME%\lib\grpc-stub-1.68.1.jar;%APP_HOME%\lib\grpc-context-1.68.1.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.68.1.jar;%APP_HOME%\lib\grpc-api-1.68.1.jar;%APP_HOME%\lib\guava-33.3.1-jre.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\netty-codec-http2-4.1.116.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.116.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.116.Final.jar;%APP_HOME%\lib\netty-handler-4.1.116.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.116.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.116.Final.jar;%APP_HOME%\lib\netty-codec-4.1.116.Final.jar;%APP_HOME%\lib\netty-transport-4.1.116.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.116.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.116.Final.jar;%APP_HOME%\lib\netty-common-4.1.116.Final.jar;%APP_HOME%\lib\reactor-core-3.6.10.jar;%APP_HOME%\lib\micronaut-core-reactive-4.7.11.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\micronaut-core-4.7.11.jar;%APP_HOME%\lib\proto-google-common-protos-2.41.0.jar;%APP_HOME%\lib\protobuf-java-3.25.5.jar;%APP_HOME%\lib\logback-core-1.5.15.jar;%APP_HOME%\lib\HikariCP-6.0.0.jar;%APP_HOME%\lib\slf4j-api-2.0.16.jar;%APP_HOME%\lib\hibernate-core-6.6.2.Final.jar;%APP_HOME%\lib\jakarta.persistence-api-3.1.0.jar;%APP_HOME%\lib\jakarta.transaction-api-2.0.1.jar;%APP_HOME%\lib\byte-buddy-1.15.10.jar;%APP_HOME%\lib\jakarta.validation-api-3.1.0.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.1.jar;%APP_HOME%\lib\config-1.4.3.jar;%APP_HOME%\lib\gson-2.11.0.jar;%APP_HOME%\lib\jboss-logging-3.5.0.Final.jar;%APP_HOME%\lib\hibernate-commons-annotations-7.0.3.Final.jar;%APP_HOME%\lib\jandex-3.2.0.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\jaxb-runtime-4.0.2.jar;%APP_HOME%\lib\jaxb-core-4.0.2.jar;%APP_HOME%\lib\jakarta.xml.bind-api-4.0.0.jar;%APP_HOME%\lib\antlr4-runtime-4.13.0.jar;%APP_HOME%\lib\angus-activation-2.0.0.jar;%APP_HOME%\lib\jakarta.activation-api-2.1.1.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.24.jar;%APP_HOME%\lib\error_prone_annotations-2.28.0.jar;%APP_HOME%\lib\perfmark-api-0.27.0.jar;%APP_HOME%\lib\txw2-4.0.2.jar;%APP_HOME%\lib\istack-commons-runtime-4.1.1.jar;%APP_HOME%\lib\failureaccess-1.0.2.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\checker-qual-3.43.0.jar;%APP_HOME%\lib\j2objc-annotations-3.0.0.jar


@rem Execute product-service
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %PRODUCT_SERVICE_OPTS%  -classpath "%CLASSPATH%" br.com.study.ApplicationKt %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable PRODUCT_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%PRODUCT_SERVICE_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
