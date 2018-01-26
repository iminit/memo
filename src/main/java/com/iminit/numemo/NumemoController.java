package com.iminit.numemo;

import com.iminit.common.model.WordSentence;
import com.iminit.word.WordService;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * NumemoController
 */
public class NumemoController extends Controller {

    private static final Log log = Log.getLog(NumemoController.class);

    static WordService wordService = WordService.me;

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
            renderJson(WordSentence.dao.find());
        } else {
            String[] ids = wordService.getIdByWord(word);
            if(ids.length > 0){
                renderJson(WordSentence.dao.wordsSentenceList(ids[0]));
            } else {
                renderJson("[]");
            }
        }
    }
}



