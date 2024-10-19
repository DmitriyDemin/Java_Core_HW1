# Java Core 
## Урок 1. Компиляция и интерпретация кода

Задача: Создать [docker](https://hub.docker.com/ "набор инструментов")-контейнер для формирования полной 
документации по проекту

````` 
D:.
│   HomeWork1.iml
│   README.md
│
└───src
    └───ru
        └───gb
            └───homework1
                │   Programm.java
                │
                ├───service
                │       MathAction.java
                │
                └───view
                        Decorator.java

`````
Перед созданием контейнера убеждаемся в работоспособности кода:

1. **javac -sourcepath .\src -d out .\src\ru\gb\homework1\Programm.java**
2. **java -classpath out ru.gb.homework1.Programm**
3. **javadoc -sourcepath .\src -d docs -subpackages ru .\src\ru\gb\homework1\Programm.java**

````
D:.
├───docs
│   ├───legal
│   ├───resources
│   ├───ru
│   │   └───gb
│   │       └───homework1
│   │           ├───service
│   │           └───view
│   └───script-dir
├───out
│   └───ru
│       └───gb
│           └───homework1
│               ├───service
│               └───view
└───src
    └───ru
        └───gb
            └───homework1
                ├───service
                └───view

````
Убедившись в работоспособности кода приступаем к созданию образа docker, создаем Dockerfile:

```commandline
# образ строится на основе образа JDK21
FROM ringcentral/jdk:21
# атрибут lable для дополнительной идентификации
LABEL author="Demin DS" learning_group=6380
# копирует исходные данные в образ
COPY ./src ./src
# создает в структуре образа директорию
RUN mkdir ./out
# создает в структуре образа директорию
RUN mkdir ./docs1
# компилирует исходный код
RUN javac -d out -sourcepath ./src ./src/ru/gb/homework1/Programm.java
# создает пакет документов по исходному коду
RUN javadoc -d docs -sourcepath ./src -subpackages ru ./src/ru/gb/homework1/Programm.java
# запускает Java-приложение
CMD java -classpath ./out ru.gb.homework1.Programm
# после выполнения программы контейнер останавливается
```

4. **docker build -t homework1 -f .\Dockerfile .** - создаем образ
5. **docker run homework1** - контейнер запущен, и после выполнения логики приложения остановлен, произведены вычисления
и сформирован пакет документов по коду
6. **docker cp  [container_name]:.\docs D:\......\docs2** - посмотреть содержимое остановленного контейнера напрямую нет 
возможности, поэтому кипируем содержимое директории docs контейнера в локальное расположение.
7. 2-й ввариент просмотра документации, вывод в консоль содержимого файла index-all.html

```commandline
CMD ["sh", "-c", "java -classpath ./out ru.gb.homework1.Programm && cat ./docs1/index-all.html"]
```

8. **docker login**
9. **docker tag homework1 dmitriydemin/homework1:ver3** - подготовка образа для передачи в репозиторий
10.**docker push dmitriydemin/homework1:ver3** - передача в [репозиторий](https://hub.docker.com/repository/docker/dmitriydemin/homework1/general)  

