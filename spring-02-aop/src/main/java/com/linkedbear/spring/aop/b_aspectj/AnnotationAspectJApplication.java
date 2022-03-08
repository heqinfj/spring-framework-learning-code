package com.linkedbear.spring.aop.b_aspectj;

import com.linkedbear.spring.aop.b_aspectj.config.AspectJAOPConfiguration;
import com.linkedbear.spring.aop.b_aspectj.service.FinanceService;
import net.sf.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAspectJApplication {

    public static void main(String[] args) throws Exception {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\code\\heq\\heqinfj_fork\\1-proxySource_temp");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                AspectJAOPConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
    }
}
