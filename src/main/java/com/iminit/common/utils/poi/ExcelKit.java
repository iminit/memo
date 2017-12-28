package com.iminit.common.utils.poi;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.upload.UploadFile;
import org.apache.xmlbeans.impl.common.ConcurrentReaderHashMap;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/28 0028.
 */
public class ExcelKit {

    public static Map<String, Object> importData(UploadFile upload, String insertSql) {
        return importData(upload, insertSql, false, null);
    }

    public static Map<String, Object> importData(UploadFile uplad, String insertSql, boolean isDrop, String deleteSql) {
        String filename = PathKit.getWebRootPath() + "/upload/" + uplad.getFileName();
        filename = filename.replaceAll("\\\\", "/");
        if (isDrop) {
            Db.update(deleteSql);
        }
        Map<String, Object> map = new ConcurrentReaderHashMap();
        try {
            map = PoiExt.ReadExcel(filename, insertSql, 4);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("err", e.getMessage());
        }
        return map;
    }
}
