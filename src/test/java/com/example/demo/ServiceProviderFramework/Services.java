package com.example.demo.ServiceProviderFramework;

import java.lang.reflect.AccessibleObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 11:31 2019/1/25/025
 * @Modify By:
 **/
// Noninstantiable class for service registration and access
public class Services {
    private static final String DEFALUT_PROVIDER_NAME="";
    private Services(){} // Prevents instantiation(Item 4)

    // Map sevice names to services(Map)
    private static final Map<String,Provider> providers=new ConcurrentHashMap<>();

    // Provider registration API
    public static void registerDefaultProvider(Provider p){registerProvider(DEFALUT_PROVIDER_NAME,p);}

    public static void registerProvider(String name,Provider p){providers.put(name,p);}

    public static Service newInstance(String name){
        Provider p=providers.get(name);
        if(p==null)throw new IllegalArgumentException("No provider registered with name: "+name);
        return p.newService();
    }

    public static void main(String[] args) {
        Services.registerProvider("serviceTest",new ProviderTest());
        ServiceTest serviceImpl=(ServiceTest)Services.newInstance("serviceTest");
        System.out.println(serviceImpl.getName());

    }
}
