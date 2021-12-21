package com.xihua.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Author:   lxs
 * Date:     2021/9/30 12:19
 * Description: 日志记录切面
 */
@Component
@Aspect
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(* com.xihua.controller.*.*(..))")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String type = request.getMethod();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, type, classMethod, args);
        log.info("Request : {}", requestLog);
    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        log.info("方法{}执行完毕,返回参数为:{}", method, result.toString());
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String method = joinPoint.getSignature().getName();
        log.error("执行方法{}出错，异常为:{}", method, e.getMessage());
    }

    private static class RequestLog {
        private String url;
        private String ip;
        private String type;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String type, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.type = type;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", type='" + type + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
