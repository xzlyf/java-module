# 子模块创建教程

1. File——New——Module——Maven
2. 包名统一com.xz.module.模块名
   ![image-20220607174843743](D:\Typora_img\readme\image-20220607174843743.png)
3. 开始写功能了

# common——通用模块

**模块功能**：

1. 全局异常处理
2. 统一JSON返回实体

**当前版本：**0.0.1

**引入模块方式：**

1. 打开 Project Structure

2. import 外部module
   ![image-20220607172146291](D:\Typora_img\readme\image-20220607172146291.png)

3. ppj-net为当前例子项目，exception为子模块
   ![image-20220607174122515](D:\Typora_img\readme\image-20220607174122515.png)

4. 在当前例子项目（主项目）加入exception的依赖

   ```xml
   <dependencies>
       <dependency>
           <groupId>com.xz.module</groupId>
           <artifactId>exception</artifactId>
           <version>0.0.1</version>
       </dependency>
   </dependencies>
   ```

   **使用方式：**

   1. 在主项目启动类开启包扫描，扫描子模块包名。
      否则子模块的珠江将不生效。
      同时扫描当前项目的包名，否则当前包下的注解不生效
      com.xz.ppjnet——主项目
      com.xz.module.exception——子模块

      ```java
      package com.xz.ppjnet;
      
      import org.springframework.boot.SpringApplication;
      import org.springframework.boot.autoconfigure.SpringBootApplication;
      import org.springframework.context.annotation.ComponentScan;
      import org.springframework.context.annotation.ComponentScans;
      
      @SpringBootApplication
      @ComponentScan({"com.xz.ppjnet","com.xz.module.exception"})
      public class PpjNetApplication {
      
          public static void main(String[] args) {
              SpringApplication.run(PpjNetApplication.class, args);
          }
      }
      ```

   2. 通过抛出不同异常传输不同状态码
      DefinitionException该类为自定义异常主类，需要二次调整的异常类可以继承该类，便会被全局异常所捕获。
      BusinessException该类为一般业务异常类，也是通过继承DefinitionException类实现。

   3. 统一返回JSON格式

      ```json
      {
          "code": 1,
          "msg": "success",
          "data": null
      }
      ```

   4. 状态码查看ResultStatus类，继承该类可以实现自定义状态码。