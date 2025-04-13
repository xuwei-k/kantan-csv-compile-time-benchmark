# kantan.csv compile time benchmark

https://github.com/xuwei-k/kantan-csv-compile-time-benchmark/commit/0f0d68b641b3c51ee568e8ea5afc3cd454836587


|                                      | median | average | 
| ------------------------------------ | ------ | ------- | 
| custom implementation                | 10     | 10.3    | 
| wildcard import                      | 110    | 109.4   | 
| explicit import with LabelledGeneric | 93     | 92.8    | 
| explicit import                      | 19     | 19.2    | 


custom implementation

```
12
11
10
10
10
10
10
10
10
10
```

wildcard import

```scala
import kantan.csv.generic._
```

```
112
111
110
111
111
110
110
109
105
105
```


explicit import with LabelledGeneric


```scala
import kantan.csv.generic.hnilRowEncoder
import kantan.csv.generic.hlistRowEncoder
import kantan.csv.generic.caseClassEncoderFromLabelled
import kantan.csv.generic.caseClassEncoder
```

```
95
93
94
93
93
93
93
92
92
90
```

explicit import

```scala
import kantan.csv.generic.hnilRowEncoder
import kantan.csv.generic.hlistRowEncoder
import kantan.csv.generic.caseClassEncoder
```

```
21
20
19
19
19
19
19
19
19
18
```

