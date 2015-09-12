# csv2xls

## Usage

```
Usage: csv2xls [options] <file>

     -o <value> | --out <value>
           output file
     -s <value> | --sheet <value>
           sheet name
     -e <value> | --encoding <value>
           encoding of csv file (default: utf-8)
     <file>
           input file
```

```
$ csv2xls -e shift-jis -o sample.xls sample.csv
```

## How to build

```
$ sbt universal:packageBin
```

## LICENSE

Apache 2.0