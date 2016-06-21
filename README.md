####"# jmonitor" 
1. 修改cn.yandz.monitor.SizeOfObjectUtils.premain(String, Instrumentation)方法，添加需要计算内存占用情况的代码
2. 打jar
mvn package
3. 执行jar
run2.bat