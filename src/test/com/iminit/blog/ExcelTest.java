package com.iminit.blog;

import com.xiaoleilu.hutool.collection.CollUtil;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.poi.excel.ExcelReader;
import com.xiaoleilu.hutool.poi.excel.ExcelUtil;
import com.xiaoleilu.hutool.poi.excel.ExcelWriter;

import java.util.List;

/**
 * Created by Administrator on 2017/12/29 0029.
 */
public class ExcelTest {
    public static void main1(String[] args) {

    }

    public static void main2(String[] args) {
        TestBean bean1 = new TestBean();
        bean1.setName("张三");
        bean1.setAge(22);
        bean1.setPass(true);
        bean1.setScore(66.30);
        bean1.setExamDate(DateUtil.date());

        TestBean bean2 = new TestBean();
        bean2.setName("李四");
        bean2.setAge(28);
        bean2.setPass(false);
        bean2.setScore(38.50);
        bean2.setExamDate(DateUtil.date());

        List<TestBean> rows = CollUtil.newArrayList(bean1, bean2);

        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeBeanTest.xlsx");
// 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "一班成绩单");
// 一次性写出内容，使用默认样式
        writer.write(rows);
// 关闭writer，释放内存
        writer.close();
    }

    public static void main(String[] args) {
        // 读取和写入
        ExcelReader reader = ExcelUtil.getReader("d:/writeBeanTest.xlsx");
        List<TestBean> all = reader.readAll(TestBean.class);
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeBeanTest2.xlsx");
        writer.write(all);
        writer.close();
    }
}
