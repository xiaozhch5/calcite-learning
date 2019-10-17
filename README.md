# Apache Calcite入门
假如我们有个文件data.csv，现在要用sql查询的方法从文件中查询所有数据。

在这个项目中使用的是Apache Calcite模块。

创建model.json，指明文件数据和映射之间的关系。

首先我们要做的是对数据进行映射。

创建数据表映射类CustomTable.java，继承AbstractTable类和实现ScannableTable接口。

在CustomtTable中还需要指明数据输出，所以还要创建CustomEnumerator.java用于数据输出。

创建数据库映射类CustomSchema.java，读取data.csv文件，并生成一个数据库（Schema）的映射类，实例化表。

创建工厂类CustomSchemaFactory.java实例化Schema类。