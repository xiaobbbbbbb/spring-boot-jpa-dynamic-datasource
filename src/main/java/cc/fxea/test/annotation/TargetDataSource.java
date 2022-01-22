package cc.fxea.test.annotation;

import cc.fxea.test.enums.DataSourceType;
import java.lang.annotation.*;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className TargetDataSource
 * @description
 * @date 7/5/2020 20:40
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    DataSourceType value() default DataSourceType.WRITE;
}
