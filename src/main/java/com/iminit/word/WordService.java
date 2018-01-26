package com.iminit.word;

import com.iminit.common.model.Word;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Word 管理
 * 描述：
 */
public class WordService {

    private static final Log log = Log.getLog(WordService.class);

    public static final WordService me = new WordService();
    private final Word dao = new Word().dao();


    /**
     * 列表-分页
     */
    public Page<Word> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "SELECT * ", "FROM word  ORDER BY create_time DESC");
    }

    /**
     * 保存
     */
    public void save(Word word) {
        word.save();
    }

    /**
     * 更新
     */
    public void update(Word word) {
        word.update();
    }

    /**
     * 查询
     */
    public Word findById(int wordId) {
        return dao.findFirst("select * from word where id=?", wordId);
    }

    /**
     * 删除
     */
    public void delete(int wordId) {
        Db.update("delete from word where id=?", wordId);
    }


    public List<Word> findNByRandom(Integer n) {
        List<Word> words = dao.find("select DISTINCT id,content FROM word " +
                "WHERE id >= (( SELECT MAX(id) FROM word ) - ( SELECT MIN(id) FROM word )) * RAND() + ( SELECT MIN(id) FROM word ) LIMIT ?", n);
        return words;
    }

    public int[] wordsSave(String words) {
        words = words.replace(" ", ",");
        words = words.replace("，", ",");
        words = words.replace("、", ",");
        words = words.replace("\n", ",");
        String[] split = words.split(",");
        List<Record> wordList = new ArrayList<Record>(split.length);
        for (int i = 0; i < split.length; i++) {
            Record w = new Record();
            w.set("content", split[i]);
            wordList.add(w);
        }
        checkRepetition(wordList);
        return Db.batchSave("word", wordList, wordList.size());
    }

    private void checkRepetition(List<Record> wordList) {
        int size = wordList.size();
        List<Record> records = Db.find("SELECT content FROM `word`");
        boolean b = wordList.removeAll(records);
        String s = "【词语去重】:" + b + ",输入个数:" + size + ",输出个数:" + wordList.size();
        System.out.println(s);
    }
}