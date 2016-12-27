package com.shupro.oa.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shupro.core.utils.SystemUtil;
import com.shupro.core.utils.io.FileUtil;
import com.shupro.core.utils.io.ZipUtil;
import com.shupro.core.utils.lang.DateUtil;
import com.shupro.core.vo.Result;
import com.shupro.oa.util.ServeConstant;


@Controller
@RequestMapping("/file")
public class FileController {
	
	/**
	 * 单个文件上传(按天区分)
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Result upload(HttpServletRequest request, HttpServletResponse response){
		int code = 500;
		String message = "发生错误";
		String path = "";
		try {
			String uploadType = request.getParameter("uploadType");
			if (SystemUtil.isEmpty(uploadType)) {
				uploadType = "other";
			}
			String savePathPrefix = "upload" + DateUtil.dateToStr(new Date(), "/yyyy/MM/dd");

			String typePath = ServeConstant.uploadTypeMap.get(uploadType);
			String savePath = savePathPrefix + "/" + typePath;
			String newFileName = FileUtil.upload(request, response, savePath);
			path = savePath + "/" + newFileName;

			code = 200;
			message = "上传成功";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Result(code, message, path);
	}
	
	/**
	 * 文件下载
	 * 方式一： 如果是多文件则在上传图片的位置就生成zip文件放在download/zip目录下，下载时参数是zip路径
	 * 方式二： 传文件路径用逗号隔开，然后工具类生成zip文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/download")
	@ResponseBody
	public String download(HttpServletRequest request, HttpServletResponse response){
		try {
			String path = request.getParameter("path");
			
			String url = "";
			String basePath = "";
			if(path.startsWith("http")){//存在图片服务器
				url = path;
			}else{//存在本地
				basePath = request.getSession().getServletContext().getRealPath("/");
				url = basePath + path.replace(",", ","+basePath);
			}
			String[] pathArr = url.split(",");
			int length = pathArr.length;
//			if(path.contains(",")){
			if(length > 1){
				String zipName = SystemUtil.getRandomId3(5) + ".zip";
				List<File> fileList = new ArrayList<>();
				File file = null;
				
				for (String str : pathArr) {
					file = new File(str);
					fileList.add(file);
				}
				//zip打包下载
				ZipUtil.downLoadZipFile(fileList, response, zipName);
				
			}else{
				FileUtil.download(url, request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
}
