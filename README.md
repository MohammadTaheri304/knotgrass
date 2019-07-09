
```
██╗  ██╗███╗   ██╗ ██████╗ ████████╗ ██████╗ ██████╗  █████╗ ███████╗███████╗ 
██║ ██╔╝████╗  ██║██╔═══██╗╚══██╔══╝██╔════╝ ██╔══██╗██╔══██╗██╔════╝██╔════╝ 
█████╔╝ ██╔██╗ ██║██║   ██║   ██║   ██║  ███╗██████╔╝███████║███████╗███████╗ 
██╔═██╗ ██║╚██╗██║██║   ██║   ██║   ██║   ██║██╔══██╗██╔══██║╚════██║╚════██║ 
██║  ██╗██║ ╚████║╚██████╔╝   ██║   ╚██████╔╝██║  ██║██║  ██║███████║███████║ 
╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝    ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝ 
```

## Knotgrass
Knotgrass is a distributed decentralized database that based on a block chain.

### Prerequisites to develop and test project
- JDK 11 (JavaSE 11)
- Maven 3.6+

### How to build?
Check prerequisites, then run:
```
mvn package
```

### How to test?
```
mvn clean test
```

### Javadoc
To generate javadoc, run:
```
mvn javadoc:javadoc
```

### Contributing
To contribute on project please see [CONTRIBUTING](CONTRIBUTING.md).

```aidl
+------------------------------------------------+
|                  Event Bus                     |
+-----+-+-------------+-+--------------+-+-------+
      ^ |             ^ |              ^ |
      | v             | v              | v
 +----+-+-----+  +----+-+------+  +----+-+------+
 |            |  |             |  |             |
 |    Miner   |  |    Chain    |  |   Network   |
 |            |  |             |  |             |
 +------------+  +-------------+  +-------------+
```

### Contributors
List of Contributors on [CONTRIBUTORS](CONTRIBUTORS.md).
