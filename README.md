![](https://api.travis-ci.com/MohammadTaheri304/knotgrass.svg?branch=develop)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/MohammadTaheri304/knotgrass.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/MohammadTaheri304/knotgrass/alerts/)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/MohammadTaheri304/knotgrass.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/MohammadTaheri304/knotgrass/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/MohammadTaheri304/knotgrass.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/MohammadTaheri304/knotgrass/context:java)
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
!
### Contributors
List of Contributors on [CONTRIBUTORS](CONTRIBUTORS.md).
