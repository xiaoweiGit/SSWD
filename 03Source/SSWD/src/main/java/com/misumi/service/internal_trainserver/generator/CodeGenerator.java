package com.misumi.service.internal_trainserver.generator;

import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.toolkit.StringUtils;

import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        GeneratorServiceEntity entity=new GeneratorServiceEntity();

        String packageName = "com.misumi.service.internal_trainserver";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        entity.generateByTables(serviceNameStartWithI, packageName,
                scanner(("表名")));
    }
}

