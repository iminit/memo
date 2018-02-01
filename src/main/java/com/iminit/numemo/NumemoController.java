package com.iminit.numemo;

import com.iminit.common.model.Num;
import com.iminit.common.model.WordSentence;
import com.iminit.word.WordService;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NumemoController
 */
public class NumemoController extends Controller {

    private static final Log log = Log.getLog(NumemoController.class);

    static WordService wordService = WordService.me;
    static WordSentence wordSentenceDao = WordSentence.dao;

    public void index() {
    }

    /**
     * 阅读测试
     */
    public void read() {

    }

    /**
     * 组词游戏
     */
    public void word() {

    }

    /**
     * 组词数据
     */
    public void words() {
        Integer n = getParaToInt(0, 2);
        renderJson(wordService.findNByRandom(n));
    }

    /**
     * 数字关键词
     */
    public void nums() {
        List<Num> nums = Num.dao.find("select * from num");
        Map<String, Num> map = new HashMap<String, Num>();
        for (int i = 0; i < nums.size(); i++) {
            Num num = nums.get(i);
            String n = String.valueOf(num.get("num"));
            num.remove("num");
            map.put(n, num);
        }
        renderJson(map);
    }

    /**
     * 组词数据
     */
    public void wordsSave() {
        String words = getPara();
        if (StrKit.isBlank(words)) {
            renderJson();
        } else {
            try {
                words = URLDecoder.decode(words, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            int[] ints = wordService.wordsSave(words);
            renderJson(ints);
        }
    }

    /**
     * 组词保存到数据库
     */
    public void wordsSentenceSave() {
        try {
            WordSentence model = getModel(WordSentence.class, "");
            boolean save = model.save();
            renderJson(Kv.by("c", save));
        } catch (Exception e) {
            e.printStackTrace();
            renderJson(Kv.by("c", "no").set("error", e.getMessage()));
        }
    }

    /**
     * 历史组词记录
     */
    public void wordsSentenceList() {
        String word = getPara();
        if (StrKit.isBlank(word)) {
            renderJson(wordSentenceDao.find());
        } else {
            try {
                word = URLDecoder.decode(word, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String[] ids = wordService.getIdByWord(word);
            String id = "";
            if (ids.length > 0) {
                id = ids[0];
            }
            renderJson(wordSentenceDao.wordsSentenceList(id, word));
        }
    }
}



