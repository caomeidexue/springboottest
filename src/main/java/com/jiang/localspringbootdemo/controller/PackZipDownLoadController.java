package com.jiang.localspringbootdemo.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jiang.localspringbootdemo.model.DownInFo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author jiangqb  打包远程图片成压缩二维码zip文件
 * @Description
 * @Date 2020-01-19 10:25
 */

@Controller
public class PackZipDownLoadController {


    public static void getBarCodeImgByUrl(String url, OutputStream os) throws WriterException, IOException {
        //二维码参数
        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix;
        bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, format, os);
    }


    //入口
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response){

        //通过活动标识和商户id查询活动
        List<DownInFo> infoList = new ArrayList<>();

        DownInFo downInFo = new DownInFo();
        downInFo.setBarCode_name("aa");
        downInFo.setFileName(".png");
        downInFo.setUrl("https://j-image.missfresh.cn/1579157121105-870.png");

        DownInFo downInFo1 = new DownInFo();
        downInFo1.setBarCode_name("bb");
        downInFo1.setFileName(".png");
        downInFo1.setUrl("https://j-image.missfresh.cn/1578883646267-paint.png");

        infoList.add(downInFo);
        infoList.add(downInFo1);


        if(infoList != null && infoList.size()>0){
            ZipOutputStream zos = null;
            try {
                String downloadFilename = infoList.get(0).getFileName();//文件的名称
                downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");//转换中文否则可能会产生乱码
                response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
                response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename+".zip");// 设置在下载框默认显示的文件名
                zos = new ZipOutputStream(response.getOutputStream());
                for(DownInFo info:infoList ){
                    zos.putNextEntry(new ZipEntry((info.getBarCode_name())+".png"));//命名
                    getBarCodeImgByUrl(info.getUrl(), zos);//拼接了url
                }
                zos.flush();
                zos.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriterException e) {
                e.printStackTrace();
            } finally{
                if(zos != null){
                    try {
                        zos.flush();
                        zos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }


    }


    @RequestMapping("download1")
    public void downLoadPic1(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //Map<String, Object> params = getParameters(request);
        String[] pictureIDs = request.getParameterValues("pictureID");
       downLoadPic(request, response);
        return ;
    }



    public void downLoadPic(HttpServletRequest request,HttpServletResponse response) throws IOException {

        //压缩文件初始设置
        String path=System.getProperty("ics.webapp.root");//这个是服务器路径地址，request.getSession().getServletContext().getRealPath() 也一样能
        String fileZip =  "Pictures.zip";
        String filePath = path+"\\" + fileZip;//之后用来生成zip文件

        //filePathArr为根据前台传过来的信息，通过数据库查询所得出的pdf文件路径集合（具体到后缀）
        List<Map<String, Object>> fileNameArr = new ArrayList<Map<String,Object>>();
        //JSONArray jsons = JSONArray.fromObject(params.get("pictureList"));
        /*List<String> pictureIDs = new ArrayList<String>();
        for(Object obj:jsons){
        	pictureIDs.add(obj.toString());
        }
        */
        Map<String,Object> map = new HashMap<>();
        //map.put();

        //需要压缩的文件--包括文件地址和文件名
        //String[] pathtytytyt ={"D:\\13.jpg","D:\\1212.jpg"};
        // 要生成的压缩文件地址和文件名称
        //String desPath = "D:\\DOWNLOADS\\new.zip";
        File zipFile = new File(filePath);
        ZipOutputStream zipStream = null;
        FileInputStream zipSource = null;
        BufferedInputStream bufferStream = null;
        try {
            //构造最终压缩包的输出流
            zipStream = new ZipOutputStream(new FileOutputStream(zipFile));
            for(int i =0;i<fileNameArr.size();i++){
                File file = new File((String) fileNameArr.get(i).get("F_FILENAME"));
                //File file = new File(pathtytytyt[i]);
                //将需要压缩的文件格式化为输入流
                zipSource = new FileInputStream(file);
                //压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样
                //这里的name就是文件名，文件名和之前的重复就会导致文件被覆盖，在这用i加文件名进行单一文件识别
                ZipEntry zipEntry = new ZipEntry(i+file.getName());
                //定位该压缩条目位置，开始写入文件到压缩包中
                zipStream.putNextEntry(zipEntry);
                //输入缓冲流
                bufferStream = new BufferedInputStream(zipSource, 1024 * 10);
                int read = 0;
                //创建读写缓冲区
                byte[] buf = new byte[1024 * 10];
                while((read = bufferStream.read(buf, 0, 1024 * 10)) != -1)
                {
                    zipStream.write(buf, 0, read);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(null != bufferStream) bufferStream.close();
                if(null != zipStream) zipStream.close();
                if(null != zipSource) zipSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*// 写流文件到前端浏览器
		ServletOutputStream os = response.getOutputStream();
		response.setContentType("application/x-octet-stream");
		response.setContentLength((int) zipFile.length());
		response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileZip, "UTF-8"));
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(filePath));
			bos = new BufferedOutputStream(os);
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			os.flush();
			os.close();
		} catch (IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
			File obj = new File(filePath);
			if (obj.exists()) {
				obj.delete();//删除服务器本地产生的临时压缩文件
			}
		}*/


        //进行浏览器下载
        //获得浏览器代理信息
        final String userAgent = request.getHeader("USER-AGENT");
        //判断浏览器代理并分别设置响应给浏览器的编码格式
        String finalFileName = null;
        if(StringUtils.contains(userAgent, "MSIE")||StringUtils.contains(userAgent,"Trident")){//IE浏览器
            finalFileName = URLEncoder.encode(fileZip,"UTF-8");
            System.out.println("IE浏览器");
        }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
            finalFileName = URLEncoder.encode(fileZip,"UTF-8");
        }else{
            finalFileName = URLEncoder.encode(fileZip,"UTF-8");//其他浏览器
        }
        response.setContentType("application/x-octet-stream");//告知浏览器下载文件，而不是直接打开，浏览器默认为打开
        response.setHeader("Content-Disposition" ,"attachment;filename=" +finalFileName);//下载文件的名称

        ServletOutputStream servletOutputStream=response.getOutputStream();
        DataOutputStream temps = new DataOutputStream(servletOutputStream);

        DataInputStream in = new DataInputStream(new FileInputStream(filePath));//浏览器下载文件的路径
        byte[] b = new byte[2048];
        File reportZip=new File(filePath);//之后用来删除临时压缩文件
        try {
            while ((in.read(b)) != -1) {
                temps.write(b);
            }
            temps.flush();
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            if(temps!=null) temps.close();
            if(in!=null) in.close();
            if(reportZip!=null) reportZip.delete();//删除服务器本地产生的临时压缩文件
            servletOutputStream.close();
        }
		/*if (picInfolList.size() > 0) {
			rc.put("success", true);
			rc.put("picInfo", picInfolList);
			optLogsvc.saveLog(au.getUsername(), au.getAttribute("F_BRNO"), au.getAttribute("F_LSTIP"),
					TOptlogService.TYPE_MR, "", au.getUsername() + "查询批量下载"+params.get("f_svr_code")+"成功！");
		} else {
			rc.put("success", false);
			rc.put("errmsg", "test info");
			optLogsvc.saveLog(au.getUsername(), au.getAttribute("F_BRNO"), au.getAttribute("F_LSTIP"),
					TOptlogService.TYPE_MR, "", au.getUsername() + "查询批量下载"+params.get("f_svr_code")+"失败！");
		}*/

        return ;
    }




}
