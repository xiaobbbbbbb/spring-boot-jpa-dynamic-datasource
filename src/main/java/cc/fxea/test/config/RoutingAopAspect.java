package cc.fxea.test.config;

import cc.fxea.test.annotation.TargetDataSource;
import cc.fxea.test.enums.DataSourceType;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className RoutingAopAspect
 * @description
 * @date 7/5/2020 20:21
 **/
@Order(0)
@Aspect
@Component
public class RoutingAopAspect {
    private static final Logger LOG = LoggerFactory.getLogger(RoutingAopAspect.class);

//    @Around("@annotation(targetDataSource)")
//    public Object routingWithDataSource(ProceedingJoinPoint joinPoint, TargetDataSource targetDataSource) throws Throwable {
//        try {
//            DynamicRoutingDataSourceContext.setDataSource(targetDataSource.value());
//            return joinPoint.proceed();
//        } finally {
//            DynamicRoutingDataSourceContext.clearDataSource();
//        }
//    }

    @Before("@annotation(cc.fxea.test.annotation.TargetDataSource)")
    public void before(JoinPoint point) {
        Class<?> className = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceType.WRITE.getName();

        try {
            Method method = className.getMethod(methodName, argClass);
            if (method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource dataSourceChoice = method.getAnnotation(TargetDataSource.class);
                DataSourceType dataSourceType = dataSourceChoice.value();
                dataSource = dataSourceType.getName();
            }
        } catch (Exception var9) {
        }

        LOG.info("执行：{}，的 {} 方法，使用数据源：{}。", new Object[]{className, methodName, dataSource});
        DynamicRoutingDataSourceContext.setDataSource(dataSource);
    }

    @After("@annotation(cc.fxea.test.annotation.TargetDataSource)")
    public void after() {
        try {
            DynamicRoutingDataSourceContext.clearDataSource();
        } catch (Exception var2) {
        }

    }

}
