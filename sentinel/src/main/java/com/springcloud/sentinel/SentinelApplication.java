package com.springcloud.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaomai
 * @date 2022/5/30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApplication {

    public static void main(String[] args) {
//        initFlowRules();
        SpringApplication.run(SentinelApplication.class);

    }

    /**
     * Java代码定义规则
     */
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>(); //定义规则列表
        FlowRule rule = new FlowRule(); //定义一个规则
        rule.setResource("/hello"); //什么资源应用此规则
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(2); //没秒只能2次请求
        rules.add(rule);//加入该规则
        FlowRuleManager.loadRules(rules); //载入规则列表



    }

}
