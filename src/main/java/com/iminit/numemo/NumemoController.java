package com.iminit.numemo;

import com.iminit.common.model.WordSentence;
import com.iminit.word.WordService;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;

/**
 * NumemoController
 */
public class NumemoController extends Controller {

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
     * 组词保存到数据库
     */
    public void wordsSentenceSave() {
        try {
            WordSentence model = getModel(WordSentence.class,"");
            boolean save = model.save();
            renderJson(Kv.by("c",save));
        } catch (Exception e){
            renderJson(Kv.by("c","no").set("error", e.getMessage()));
        }
    }
    /**
     * 历史组词记录
     */
    public void wordsSentenceList() {
        String wordIds = getPara();
        if(StrKit.isBlank(wordIds)){
            renderJson("[]");
        }
        renderJson(WordSentence.dao.wordsSentenceList(wordIds));
    }
}



