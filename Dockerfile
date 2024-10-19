FROM ringcentral/jdk:21
LABEL author="Demin DS" learning_group=6380
COPY ./src ./src
RUN mkdir ./out
RUN mkdir ./docs
RUN javac -d out -sourcepath ./src ./src/ru/gb/homework1/Programm.java
RUN javadoc -d docs -sourcepath ./src -subpackages ru ./src/ru/gb/homework1/Programm.java
CMD java -classpath ./out ru.gb.homework1.Programm


