package com.linkedbear.spring.environment;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * 获取如下属性源：
 * 1. JVM 系统属性属性源（JVM system properties property source ）
 * System.getProperties()
 * 2. 系统环境属性源（System environment property source ）
 * System.getenv()
 *
 * @author heqin
 */
public class TestPropertySource {
    public static void main(String[] args) {
        doGetJvmSystemProperites();
        doGetSystemEnviroment();
    }

    private static void doGetJvmSystemProperites() {
        Map<String, Object> map = (Map) System.getProperties();
        System.out.println("JVM 系统属性: \n" + JSONUtils.toJSONString(map));
        String springProfilesActive = (String) map.get("spring.profiles.active");
        String springProfilesDefault = (String) map.get("spring.profiles.default");
        System.out.println("springProfilesActive: " + springProfilesActive);
        System.out.println("springProfilesDefault: " + springProfilesDefault);
    }

    private static void doGetSystemEnviroment() {
        Map<String, Object> map = (Map) System.getenv();
        System.out.println("系统环境属性: \n" + JSONUtils.toJSONString(map));
    }
}
