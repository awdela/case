package com.test.groovy;

import java.util.HashMap;
import java.util.Map;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;

public class GroovyTest {

    public static void main(String[] args) {
        String str = "name    average current last 1minute 5minutes 15minutes\r\n" +
                "------- ------- ------- ------------ -------- ---------\r\n" +
                " cpu1/0    1.3%    1.5%         1.3%     1.2%     1.2%\r\n" +
                " cpu2/0    1.1%    1.0%         1.0%     0.9%     1.0%\r\n" +
                "cpu17/0    0.2%    0.5%         0.2%     0.2%     0.2%\r\n" +
                "cpu19/0    0.3%    0.5%         0.3%     0.3%     0.3%\r\n" +
                "cpu21/0    0.3%    0.0%         0.3%     0.3%     0.3%\r\n" +
                "cpu23/0    0.3%    0.0%         0.3%     0.3%     0.3%\r\n" +
                "\r\n" +
                "SG-6000(M)# ";
        String script = "int cpuCount=0, last1minute=0                 \r\n" +
                "for(String line:fetchResult.split('\\n')){                                  \r\n" +
                "    println line                                  \r\n" +
                "    def m = line =~ /\\s*cpu\\S+\\s+(\\d+\\.\\d+)%\\s+(\\d+\\.\\d+)%\\s+(\\d+\\.\\d+)%\\s+(\\d+\\.\\d+)%.*/  \r\n" +
                "    if ( m ){                                                               \r\n" +
                "        println m                                                               \r\n" +
                "        last1minute += m.group(3).toFloat().round();                             \r\n" +
                "        println \"hi\"                                                    \r\n"+
                "        cpuCount ++                                                         \r\n" +
                "    }                                                                       \r\n" +
                "}                                                                          \r\n"+
                "println last1minute/cpuCount                                             \r\n" ;
        ClassLoader parent = GroovyTest.class.getClassLoader();
        GroovyClassLoader loader = new GroovyClassLoader(parent);
        Class scriptClass =loader.parseClass(script, "test.groovy");
        Script script0;
        try {
            script0 = (Script) scriptClass.newInstance();
            Map<String, Object> map0 = new HashMap<String, Object>();
            map0.put("fetchResult", str);
            Binding binding = new Binding(map0);
            script0.setBinding(binding);
            script0.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
