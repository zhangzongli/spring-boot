package com.wang.miao.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 描述:
 *    LogAnnotation 注解实现类
 * @author zhangzl
 * @create 2018-12-24 9:30 AM
 */
@Aspect
@Component
public class LogAnnotationAnalytic {

    @Pointcut(value = "execution(* com.wang.miao.web.controller..*(..)) && @annotation(LogAnnotation)")
    public void log() {

    }

    @Around("log()")
    public Object logAround(ProceedingJoinPoint joinPoint) {

        //收到请求 记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("URL:");
        stringBuffer.append(request.getRequestURI() + "; ");
        stringBuffer.append("HTTP_METHOD:");
        stringBuffer.append(request.getMethod() + "; ");
        stringBuffer.append("IP:");
        stringBuffer.append(request.getRemoteAddr() + "; ");
        stringBuffer.append("CLASS_METHOD:");
        stringBuffer.append(joinPoint.getSignature().getDeclaringTypeName() + joinPoint.getSignature().getName() + ";");
        stringBuffer.append("ARGS:");
        stringBuffer.append(Arrays.toString(joinPoint.getArgs()));

        System.out.println(stringBuffer.toString());

        Object object = null;
        try {
            object = joinPoint.proceed();
            System.out.println("返回值是:" + object.toString());
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return object;

    }

}
