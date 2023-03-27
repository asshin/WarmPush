package com.cws.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author zsw
 * @create 2023-03-27 19:18
 */
public class TxtUtil {
    public static String readTxtFileByClassPath(String filePath){
        String fileString="";
        try {
            String encoding="GBK";
            File file = new ClassPathResource(filePath).getFile();

            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);

                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
//                    System.out.println(lineTxt);
                    fileString+=lineTxt;
                }

                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return  fileString;
    }
    public static String readTxtFileByFileSystem(String filePath){
        String fileString="";

            String encoding="GBK";

            try
            {
                //建立链接
                FileInputStream fileInputStream = new FileInputStream(filePath);

                int n=0;

                StringBuffer sBuffer=new StringBuffer();

                while (n!=-1) //当n不等于-1,则代表未到末尾
                {

                    n=fileInputStream.read();//读取文件的一个字节(8个二进制位),并将其由二进制转成十进制的整数返回

                    char by=(char) n; //转成字符

                    sBuffer.append(by);

                }
                fileString=sBuffer.toString();
               fileString= fileString.substring(0,fileString.length()-1);

            }
            catch (FileNotFoundException e)
            {

                System.out.println("文件不存在或者文件不可读或者文件是目录");
            }
            catch (IOException e)
            {
                System.out.println("读取过程存在异常");
            }

        return  fileString;
    }

    public  static  boolean writeTxtByClassPath(String filePath,int content,Boolean append){
        try {
            File f = new ClassPathResource(filePath).getFile();
            if (f.exists()) {
                System.out.print("文件存在");
            } else {
                System.out.print("文件不存在");
                f.createNewFile();// 不存在则创建
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(f,append));//true,则追加写入text文本

//            output.write(","+content);
              output.write(""+content);
//            output.write("\r\n");//换行
            output.flush();
            output.close();
        } catch (IOException e) {

            e.printStackTrace();
            return  false;
        }
        return  true;
    }
    public  static  boolean writeTxtByFileSystem(String filePath,int content,Boolean append){


        try {
            FileOutputStream fout = new FileOutputStream(filePath,append);//默认覆盖文件

            /******************(方法一)按字节数组写入**********************/
            //byte[] bytes = msg.getBytes();//msg.getBytes()将字符串转为字节数组

            //fout.write(bytes);//使用字节数组输出到文件
            /******************(方法一)逐字节写入**********************/
            byte[] bytes = String.valueOf(content).getBytes();
            for (int i = 0; i < bytes.length; i++) {
                fout.write(bytes[i]);//逐字节写文件
            }
            fout.flush();//强制刷新输出流
            fout.close();//关闭输出流
            System.out.println("写入完成！");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  true;
    }
    public static String readTxtFileOnJar(String filePath){
        String fileString="";
        try {
            String encoding="GBK";

            ClassPathResource resource = new ClassPathResource(filePath);

            InputStream inputStream = resource.getInputStream();
            List<String> strings = IOUtils.readLines(inputStream);
            for (int i = 0; i < strings.size(); i++) {
                fileString+=strings;
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return   fileString.substring(1, fileString.length() - 1);
    }
    public static int writeTxtFileOnJar(String filePath,int content){
        String fileString="";
        try {
            String encoding="GBK";

            Resource r1=new ClassPathResource(filePath);
            InputStream is = r1.getInputStream();
            int n;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while((n=is.read())!=-1){
                bos.write(n);
            }
            System.out.println(bos.toString());
            bos.close();is.close();




        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return   content;
    }

}
