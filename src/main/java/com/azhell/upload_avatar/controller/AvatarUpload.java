package com.azhell.upload_avatar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azhell.upload_avatar.pojo.Avatar;
import com.azhell.upload_avatar.tool.Base64ToImage;

@Controller
public class AvatarUpload {
	protected static Logger logger = LoggerFactory.getLogger(AvatarUpload.class);

	@RequestMapping("/index.html")
	public String index() {
		logger.info("进入头像上传视图");
		return "index";
	}

	@RequestMapping("/upload.do")
	@ResponseBody
	public int upload(Avatar avatar) {
		int status = 1;
		String imgFilePath = "src/main/resources/static/img/" + avatar.getId() + ".jpg";
		// 去掉字符串的头部信息
		String imgStr = avatar.getImg().replaceAll("data:image/jpeg;base64,", "");
		logger.info(imgStr);
		boolean ok = Base64ToImage.GenerateImage(imgStr, imgFilePath);
		if (!ok) {
			// 失败
			status = 2;
		}
		return status;
	}
}
