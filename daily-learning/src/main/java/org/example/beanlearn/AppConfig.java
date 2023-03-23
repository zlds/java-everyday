package org.example.beanlearn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/23
 * @description: 定义扫描路径
 */

@ComponentScan("org.example.beanlearn.service")
public class AppConfig {
}
