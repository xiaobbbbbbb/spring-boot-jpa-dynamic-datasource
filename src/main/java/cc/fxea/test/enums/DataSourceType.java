package cc.fxea.test.enums;

/**
 * DataSourceType
 *
 * @author: niko
 * @date: 2022/1/18 16:37
 */
public enum DataSourceType {
    WRITE {
        public String getName() {
            return "masterDataSource";
        }
    },
    READ {
        public String getName() {
            return "slaveDataSource";
        }
    };

    private DataSourceType() {
    }

    public abstract String getName();
}

