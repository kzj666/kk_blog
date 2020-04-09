# Bug

- ## OTS parsing error: incorrect entrySelector for table directory报错解决

```
<resource>
    <directory>${project.basedir}/src/main/resources</directory>
    <filtering>true</filtering>
    <excludes>
        <exclude>static/fonts/**</exclude>
    </excludes>
</resource>

<resource>
    <directory>${project.basedir}/src/main/resources</directory>
    <filtering>false</filtering>
    <includes>
        <include>static/fonts/**</include>
    </includes>
</resource>
```

如果上面的无效，可以试试改成这个

```
<resources>
    <resource>
        <directory>${project.sources}</directory>
        <filtering>true</filtering>
        <excludes>
            <exclude>**/*.woff</exclude>
            <exclude>**/*.ttf</exclude>
        </excludes>
    </resource>
    <resource>
        <directory>${project.sources}</directory>
        <filtering>false</filtering>
        <includes>
            <include>**/*.woff</include>
            <include>**/*.ttf</include>
        </includes>
    </resource>
</resources>
```



- ## 打jar包时无法跳过测试

> 直接运行命令：mvn clean package -Dmaven.test.skip=true



- ## th:href的坑

![1·](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200406131407541.png)

该路径如果开头加’`/`'为该项目的根目录，此时根路径为http://localhost:8080，否则以URL请求路径为根目录



- ## shiro静态资源放行

  ![image-20200406142004776](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200406142004776.png)

资源目录路径如下，在shiro过滤链中配置放行，因为springboot默认把所有的静态资源都映射到static目录下，所以我们要配置static下的admin和blog目录下的资源全部放行，" / "表示springboot默认的静态资源访问路径

![image-20200406142401515](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200406142401515.png)

```java
//定义拦截链
LinkedHashMap<String, String> filtermap = new LinkedHashMap<>();
// 配置拦截链 顺序判断
filtermap.put("/admin/**", "anon");
filtermap.put("/blog/**", "anon");
```



- ## ajax中使用RestFul风格报405

```xml
#在yml配置文件中开启SpringBoot的HiddenHttpMethodFilter自动配置
spring:  
  mvc:
    hiddenmethod:
      filter:
        enabled: true
```



- ## 带动态参数的th:href表达式

```html
<a class="prev" th:href="@{/blog/blogList(pn=${page.getCurrent()+1})}">&lt;</a>
```



![image-20200407221015944](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200407221015944.png)



- ## 设置disabled属性

![image-20200407222421233](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200407222421233.png)



- ## 终止进程

```bash
终止进程
netstat -ano
taskkill/pid pid号 -f
```

## 设置input框不自动提示

```html
<input autocomplete="off"></input>
```

- ## 前端格式化显示时间

```html
<td th:text="${#dates.format(blog.gmtCreate,'yyyy-MM-dd HH:mm:ss')}"></td>
```

- ## 配置图片-上传的适配地址后，记得去shiro放行，否则不会显示

![image-20200408180213450](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200408180213450.png)

- ## 输入文章标题进行搜索，涉及未学习知识，解决不了，停用搜索功能

![image-20200409143531842](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200409143531842.png)

































































