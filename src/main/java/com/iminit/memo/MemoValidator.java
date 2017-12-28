package com.iminit.memo;

import com.iminit.common.model.Memo;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;


public class MemoValidator extends Validator {

	//private static final Log log = Log.getLog(MemoValidator.class);

	protected void validate(Controller controller) {
		validateRequiredString("memo.title", "titleMsg", "请输入标题!");
		validateRequiredString("memo.content", "contentMsg", "请输入内容!");
		validateRequiredString("memo.category", "categoryMsg", "请输入分类信息!");
	}

	protected void handleError(Controller controller) {
		controller.keepModel(Memo.class);

		String actionKey = getActionKey();
		if (actionKey.equals("/memo/save"))
			controller.render("memoAdd.html");
		else if (actionKey.equals("/memo/update"))
			controller.render("memoEdit.html");
	}
}