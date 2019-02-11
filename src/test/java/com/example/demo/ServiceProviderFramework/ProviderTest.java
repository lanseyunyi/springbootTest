package com.example.demo.ServiceProviderFramework;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:12 2019/1/25/025
 * @Modify By:
 **/
public class ProviderTest implements Provider {
    private Service serviceS;
    @Override
    public Service newService() {
        if(serviceS==null){
            synchronized (ProviderTest.this){
                if(serviceS==null){
                    serviceS=new ServiceTest();
                }
            }
        }
        return serviceS;
    }
}
