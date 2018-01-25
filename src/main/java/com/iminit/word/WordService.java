package com.iminit.word;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.iminit.common.model.Word;

import java.util.List;

/**
 * Word 管理	
 * 描述：
 */
public class WordService {

	//private static final Log log = Log.getLog(WordService.class);
	
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
}