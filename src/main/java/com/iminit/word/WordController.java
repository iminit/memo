package com.iminit.word;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.iminit.common.model.Word;

/**
 * Word 管理	
 * 描述：
 * 
 */
public class WordController extends Controller {

	//private static final Log log = Log.getLog(WordController.class);
	
	static WordService srv = WordService.me;
	
	/**
	 * 列表
	 * /iminit/word/list
	 */
	public void list() {
		setAttr("page", srv.paginate(getParaToInt("p", 1), 40));
		render("wordList.html");
	}
	
	/**
	 * 准备添加
	 * /iminit/word/add
	 */
	public void add() {
		render("wordAdd.html");
	}
	
	/**
	 * 保存
	 * /iminit/word/save
	 */
	@Before({WordValidator.class})
	public void save() {
		srv.save(getModel(Word.class));
		renderJson("isOk", true);
	}

	/**
	 * 准备更新
	 * /iminit/word/edit
	 */
	public void edit() {
		Word word = srv.findById(getParaToInt("id"));
		setAttr("word", word);
		render("wordEdit.html");
	}

	/**
	 * 更新
	 * /iminit/word/update
	 */
	@Before(WordValidator.class)
	public void update() {
		srv.update(getModel(Word.class));
		renderJson("isOk", true);
	}

	/**
	 * 查看
	 * /iminit/word/view
	 */
	public void view() {
		Word word = srv.findById(getParaToInt("id"));
		setAttr("word", word);
		render("wordView.html");
	}
	 
	/**
	 * 删除
	 * /iminit/word/delete
	 */
	public void delete() {
		srv.delete(getParaToInt("id"));
		renderJson("isOk", true);
	}
	
}