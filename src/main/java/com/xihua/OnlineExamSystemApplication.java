package com.xihua;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@MapperScan("com.xihua.dao")
public class OnlineExamSystemApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(OnlineExamSystemApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                "欢迎使用在线考试系统！访问地址:\n\t" +
                "本地链接: \t\thttp://localhost:" + port + "/\n\t" +
                "网络链接: \thttp://" + ip + ":" + port + "/\n\t" +
                "----------------------------------------------------------");
    }

}
