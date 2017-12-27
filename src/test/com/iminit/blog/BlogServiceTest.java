package com.iminit.blog;

import com.iminit.common.AppConfig;
import com.iminit.common.model.File;
import com.iminit.common.model._MappingKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * Created by Administrator on 2017/12/27 0027.
 */
public class BlogServiceTest {

    public static void main(String[] args) {
        init();
        File blog = new File();
        for (int i = 0; i < 100; i++) {
            blog.setName("标题" + i)
                    .setId(null)
                    .setUrl("内容" + i);
            blog.save();
        }
    }

    private static void init() {
        PropKit.use("config.properties");
        DruidPlugin dp = AppConfig.createDruidPlugin();
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        _MappingKit.mapping(arp);
        // 与web环境唯一的不同是要手动调用一次相关插件的start()方法
        dp.start();
        arp.start();
    }

}