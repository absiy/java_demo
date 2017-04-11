package com.pro.xwt.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.xwt.common.utils.Common;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
@RequestMapping("/file")
public class FileController {
	
	/**
	 * 上传图片
	 */
	@RequestMapping(value = "/upload.html", method = RequestMethod.POST)
	@ResponseBody
	public String subPic(String subfile,String fileFormat, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String noce = RandomStringUtils.randomAlphanumeric(4);
			long timestamp = System.currentTimeMillis() / 1000;
			Date date= new Date();
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String d = format.format(date);

			String dd =d.substring(0, 10);
			String fileName =noce+timestamp+"."+fileFormat;
			/*String url1 = request.getSession().getServletContext().getRealPath("upload")+"\\"+dd;*/
			String url1 = Common.FILE_SAVE_BASEPATH+dd;
			File saveDir = new File(url1);
			if (!saveDir.isDirectory()){
				saveDir.mkdirs();
			}
				String url = url1+"/"+fileName;
			GenerateImage( subfile, url);
			String ur =  dd+"/"+ fileName;
			return ur;
		
	}
	
	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	/**
	 * 读取图片
	 * @param saveAddress
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getImg.html")  
    public void getimg(String saveAddress ,HttpServletRequest request, HttpServletResponse response) throws IOException{  
        try{
        	/*saveAddress = URLEncoder.encode(saveAddress, "utf-8");*/
        	/*saveAddress = URLDecoder.decode(saveAddress, "utf-8");*/
        	saveAddress = Common.FILE_SAVE_BASEPATH+saveAddress;
            FileInputStream hFile = new FileInputStream(saveAddress); // 以byte流的方式打开文件 d:\1.gif  
            int i=hFile.available(); //得到文件大小  
            byte data[]=new byte[i];  
            hFile.read(data); //读数据  
            hFile.close();  
            response.setContentType("image/*"); //设置返回的文件类型  
            OutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象  
            toClient.write(data); //输出数据  
            toClient.close();  
        }  
        catch(IOException e) //错误处理  
        {  
            PrintWriter toClient = response.getWriter(); //得到向客户端输出文本的对象  
            response.setContentType("text/html;charset=gb2312");  
            toClient.write("无法打开图片!");  
            toClient.close();  
        }   
    } 
}
