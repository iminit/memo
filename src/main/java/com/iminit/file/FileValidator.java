package com.iminit.file;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;


public class FileValidator extends Validator {

	//private static final Log log = Log.getLog(FileValidator.class);
	
	protected void validate(Controller c) {
		//if ("save".equals(getActionMethod().getName())) {
			
		//} else if ("update".equals(getActionMethod().getName())) {
			
		//}else {
			//addError("msg", "只能用于xxx方法");
		//}
	}
	
	protected void handleError(Controller c) {
		c.renderJson();
	}
	
}