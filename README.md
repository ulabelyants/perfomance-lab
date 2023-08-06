#### Первое задание запускаем с двумя параметрами, первый параметр n, второй параметр m

`java -jar <absolut path>\task1.jar "5" "4"`

#### Второе задание запускается с двумя параметрами, где каждый является абсолютным путём до фалов с данными

В первом, начальная точка центра и длина радиуса, пример:

```text 
11 1
5  
```

второй файл содержит моссив точек формата `x y`, пример:

```text 
1 1
1 2
1 3
```

Запуск второго задания:  
`java -jar <absolut path>\task2.jar "<absolut path>\tast1.txt" "<absolut path>\tast2.txt"`

#### Третье задание запускается с двумя параметрами, где каждый является абсолютным путём до фалов с данными

В результате получим 3 файл (report.json), в том же каталоге, где располагается файл "<absolut path>
\tests.json"

Запуск третьего задания:  
`java -jar <absolut path>\task3.jar "<absolut path>\tests.json" "<absolut path>\values.json"`


#### Четвёртое задание запускается с одним параметром, где параметром является абсолютным путём до фала с данными
Пример файла
```text
1
10
2
9
```

Запуск третьего задания:  
`java -jar <absolut path>\task4.jar "<absolut path>\data.txt"`
