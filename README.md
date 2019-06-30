## ss-solphire-echart-demo项目说明
```
项目功能：对接后台数据，动态展示e-chart图表
created by: junhong
date:    2017-02-21
```

### 步骤
- step1

```
新建一个<div id=main>
```

- step2

```
引入 js

```

- step3

```
设置 config
```

- step4

```
setOption:饼图，折线图，坐标显示等
```

- step5

```
结合JQuery加载动态数据(echart-test-3.html) 
```


### 使用说明
- 启动方式一： 打开IDE通过运行类 com.solphire.echart.demo.Application 启动服务
- 启动方式二： 命令行运行 $ java -jar target/ss-solphire-echart-demo-0.1.0.jar
- 1.访问接口
    ```
    http://localhost:8080/index?name=Jack
    http://localhost:8080/greeting?name=Mama
    ```
- 2.访问页面 
    ```
    http://localhost:8080/echart-test-1.html
    http://localhost:8080/echart-test-2.html
    http://localhost:8080/echart-test-3.html
    ```

### ！注意
- 后台传输的数据列表list可以是整形列表或者整型数组或者字符串列表，js自动填充

### 附
参考

百度 (中文) : http://echarts.baidu.com

在线视频教程：http://study.163.com/course/courseMain.htm?courseId=1016007

Why ECharts (中文) : http://echarts.baidu.com/doc/slide/whyEcharts.html

Github pages (English) : http://ecomfe.github.io/echarts/index-en.html

Why ECharts (English) : http://ecomfe.github.io/echarts/doc/slide/whyEcharts-en.html

基于Canvas，纯Javascript图表库，提供直观，生动，可交互，可个性化定制的数据可视化图表。创新的拖拽重计算、数据视图、值域漫游等特性大大增强了用户体验，赋予了用户对数据进行挖掘、整合的能力。

———— “大数据时代，重新定义数据图表的时候到了”





