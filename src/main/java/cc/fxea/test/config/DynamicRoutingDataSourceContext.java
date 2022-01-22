package cc.fxea.test.config;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className DynamicRoutingDataSourceContext
 * @description
 * @date 7/5/2020 20:16
 **/
public class DynamicRoutingDataSourceContext {


    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    public DynamicRoutingDataSourceContext() {
    }

    public static void setDataSource(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSource() {
        return (String)contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
