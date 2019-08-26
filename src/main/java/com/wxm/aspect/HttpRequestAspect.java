package com.wxm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class HttpRequestAspect {
//    private static final Logger log = (Logger) LoggerFactory.getLogger(HttpRequestAspect.class);

    private static long startTime;
    private static long endTime;

    /*@PointCut注解表示表示横切点，哪些方法需要被横切*/
    /*切点表达式*/
    @Pointcut("execution(public * com.wxm.controller.*.*(..))")
    /*切点签名*/
    public void print() {
    }

    /*@Before注解表示在具体的方法之前执行*/
    @Before("print()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置切面before……");
        startTime = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        String remoteAddr = request.getRemoteAddr();   //这个方法取客户端ip"不够好"
        String requestMethod = request.getMethod();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("有" + args.length + "个参数");
        for (Object a : args) {
            System.out.println(a);
        }
        System.out.println("请求url=" + requestURI + ",客户端ip=" + remoteAddr + ",请求方式=" + requestMethod + ",请求的类名=" + declaringTypeName + ",方法名=" + methodName + ",入参=" + Arrays.toString(args));
    }

    /*@After注解表示在方法执行之后执行*/
    @After("print()")
    public void after() {
        endTime = System.currentTimeMillis() - startTime;
        System.out.println("后置切面after……");
    }

    /*@AfterReturning注解用于获取方法的返回值*/
    @AfterReturning(pointcut = "print()", returning = "object")
    public void getAfterReturn(Object object) {
        System.out.println("本次接口耗时={}ms" + endTime);
        System.out.println("afterReturning={}" + object.toString());
    }


    /*@PointCut注解表示表示横切点，哪些方法需要被横切*/
    /*切点表达式*/
    @Pointcut("execution(public * com.wxm.controller.*.*(..))")
    public void afterPoincut() {
    }

    @Around("afterPoincut()")
    public String afterDemo(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕通知----before");
        String result = null;
        try {
            result = String.valueOf(joinPoint.proceed(joinPoint.getArgs()));
            System.out.println("环绕通知-----方法的返回值为 " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕通知----after");
        }
        return result;
    }
}
