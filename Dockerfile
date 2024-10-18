FROM ringcentral/jdk:21
# WORKDIR ./var
LABEL author="Demin DS" learning_group=6380
COPY ./src ./src
RUN mkdir ./out
RUN mkdir ./docs
RUN javac -d out -sourcepath ./src ./src/ru/gb/homework/Programm.java
RUN javadoc -d docs -sourcepath ./src -subpackages ru ./src/ru/gb/homework/Programm.java
RUN ln -sf /bin/sh /bin/bash
# COPY ./docs d://docs
# RUN javac -d out -sourcepath ./src ./src/ru/gb/homework/Programm.java
# RUN java -classpath .var/out ru.gb.homework.Programm
CMD java -classpath ./out ru.gb.homework.Programm


