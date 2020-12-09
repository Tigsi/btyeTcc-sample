package com.java4all.controller;

import com.java4all.service.CompanyService;
import java.math.BigDecimal;
//import lombok.extern.slf4j.Slf4j;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhongxiang
 * @date 2019/2/14 14:38
 */
@Compensable(
        interfaceClass = CompanyService.class,
        confirmableKey = "companyServiceConfirm",
        cancellableKey = "companyServiceCancel")
//@Slf4j
@RestController
@RequestMapping("company")
public class CompanyController {

    /**
     * 在调用此接口时，首先执行的是tcc中的try,
     * 因此，我们需要明确指定引入的究竟是此接口的哪一个实现类，
     * 首先执行try，try逻辑写在companyServiceImpl类中，我们就需要明确指定，
     * @Autowired private CompanyService companyService
     * 上述这种写法是不可以的，无法识别究竟是哪一个实现类，因此实现类，需要明确指定bean名称
     * @Compensable注解扫描时，在哪一种状态执行哪个实现类方法，是
     * */
    @Autowired
    private CompanyService companyServiceImpl;

    @PostMapping("increaseMoney")
    @Transactional
    public void increaseMoney(Integer id,BigDecimal money) throws InterruptedException {
        int line = companyServiceImpl.increaseMoney(id, money);
        System.out.println(line);
        Thread.sleep(10000);
        int i = 1/0;
//        log.info("修改行数为："+line);
    }
}