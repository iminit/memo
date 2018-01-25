package com.iminit.numemo;

import com.iminit.word.WordService;
import com.jfinal.core.Controller;

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
}



