# Database Config

1. 导入./database文件夹中的openBBS.sql。
2. 修改src/main/resources/application-example.yml为application.yml，并配置其中的如下三项。

```sql
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://ip:3306/database?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username:
    password:
```