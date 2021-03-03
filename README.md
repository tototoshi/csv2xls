# csv2xls

```
$ cs bootstrap com.github.tototoshi::csv2xls:latest.stable -o /path/to/csv2xls
```

## Usage

```
Usage: csv2xls [options] <file>

  -v, --version           Print the version
  -h, --help              Print a help
  -o, --out <value>       Specify an output file
  -s, --sheet <value>     Specify the sheet name
  -e, --encoding <value>  Specify the encoding of csv file (default: utf-8)
  <file>                  Specify an input file
```

```
$ csv2xls -e shift-jis -o sample.xls sample.csv
```

## LICENSE

Apache 2.0
