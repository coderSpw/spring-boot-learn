package com.spw.learn.gen;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * mybatisPlus 代码生成器
 * 执行 main自动生成对应项目目录中
 * @author spw
 * @date 2020/06/07
 */
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
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig.Builder(
                "jdbc:mysql://123.57.86.182:3306/examdb?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root", "123456"
        ).build();

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dsc);

        // 全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig.Builder()
                .outputDir(projectPath + "/src/main/java")
                .author("spw")
                .dateType(DateType.SQL_PACK)
                .enableSwagger()
                .openDir(false)
                .commentDate("y/M/d")
                .build();
        mpg.global(gc);

        // 包配置
        PackageConfig pc = new PackageConfig.Builder(scanner("父包全限定名"), scanner("模块名")).build();
        mpg.packageInfo(pc);

        // 策略配置
        List<IFill> fillList = new ArrayList<>();
        IFill crtTime = new Property("crtTime", FieldFill.INSERT);
        IFill mdfTime = new Property("mdfTime", FieldFill.INSERT_UPDATE);
        fillList.add(crtTime);
        fillList.add(mdfTime);
        StrategyConfig strategy = new StrategyConfig.Builder()
                    .addInclude(scanner("表名，多个英文逗号分割").split(","))
                    .addTablePrefix(scanner("表前缀(带下滑线,没有直接回车)"))
                    .entityBuilder().enableLombok()
                                    .columnNaming(NamingStrategy.underline_to_camel)
                                    .naming(NamingStrategy.underline_to_camel)
                                    .enableSerialVersionUID()
                                    .logicDeleteColumnName(scanner("逻辑删除列名："))
                                    .versionColumnName(scanner("乐观锁(版本号)列名："))
                                    .addTableFills(fillList)
                                    .enableRemoveIsPrefix()
                                    .build()
                    .controllerBuilder().enableRestStyle().build()
                    .serviceBuilder().formatServiceFileName("%sService").build();
        mpg.strategy(strategy);
        mpg.execute();
    }

}
