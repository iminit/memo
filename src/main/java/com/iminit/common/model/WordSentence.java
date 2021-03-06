package com.iminit.common.model;

import com.iminit.common.model.base.BaseWordSentence;
import com.iminit.word.WordService;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class WordSentence extends BaseWordSentence<WordSentence> {
    public static final WordSentence dao = new WordSentence().dao();
    WordService wordService = WordService.me;

    public List<Record> wordsSentenceList(String id, String content) {
        List<Record> records;
        if(StrKit.isBlank(id)){
            records = Db.find("SELECT id,content,wordIds FROM word_sentence WHERE content LIKE CONCAT('%',?,'%') ORDER BY create_time DESC", content);
        } else {
            records = Db.find("SELECT id,content,wordIds FROM word_sentence WHERE wordIds LIKE CONCAT('%',?,'%') ORDER BY create_time DESC", id);
        }
        formatWordsId(records);
        return records;
    }

    public List<Record> find() {
        List<Record> records = Db.find("select id,content,wordIds from word_sentence ORDER BY create_time DESC");
        formatWordsId(records);
        return records;
    }

    /**
     * 将取出的数据把其id格式化成名称
     * @param records
     */
    private void formatWordsId(List<Record> records) {
        List<Record> wordList = wordService.find();
        Map<String, Record> wordMap = new HashMap();
        for (int i = 0; i < wordList.size(); i++) {
            Record record = wordList.get(i);
            wordMap.put(String.valueOf(record.get("id")), record);
        }

        Iterator<Record> iterator = records.iterator();
        while (iterator.hasNext()) {
            Record next = iterator.next();
            String ids = next.get("wordIds");
            String[] split = ids.split("-");
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                String id = split[i];
                if(wordMap.containsKey(id)){
                    s.append(wordMap.get(id).get("content")).append(" ");
                } else {
                    s.append("-").append(" ");
                }
            }
            next.set("wordIds", s.toString());
        }
    }

}
