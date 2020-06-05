package com.example.cloudservice.common.helper;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.activation.MimetypesFileTypeMap;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import com.example.cloudservice.common.ObjectFilter;
import com.example.cloudservice.common.ObjectHandler;
import com.example.cloudservice.common.ObjectProcess;
import com.example.cloudservice.common.util.AssertUtil;
import com.example.cloudservice.common.util.ZIPUtil;
import com.example.cloudservice.common.util.algorithmImpl.FileImpl;
import com.example.cloudservice.common.util.encrypt.Base64;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;

/**
 * 一些操作文件的便捷方法
 */
@Slf4j
public final class FileHelper {

    /**
     * 定义GB的计算常量
     */
    private static final int GB = 1024 * 1024 * 1024;
    /**
     * 定义MB的计算常量
     */
    private static final int MB = 1024 * 1024;
    /**
     * 定义KB的计算常量
     */
    private static final int KB = 1024;

    /**
     * 格式化小数
     */
    private static final DecimalFormat DF = new DecimalFormat("0.00");


    /**
     * 获取文件扩展名，不带 .
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * Java文件操作 获取不带扩展名的文件名
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    /**
     * 文件大小转换
     */
    public static String getSize(long size){
        String resultSize;
        if (size / GB >= 1) {
            //如果当前Byte的值大于等于1GB
            resultSize = DF.format(size / (float) GB) + "GB   ";
        } else if (size / MB >= 1) {
            //如果当前Byte的值大于等于1MB
            resultSize = DF.format(size / (float) MB) + "MB   ";
        } else if (size / KB >= 1) {
            //如果当前Byte的值大于等于1KB
            resultSize = DF.format(size / (float) KB) + "KB   ";
        } else {
            resultSize = size + "B   ";
        }
        return resultSize;
    }

    /**
     * inputStream 转 File
     */
    static File inputStreamToFile(InputStream ins, String name) throws Exception{
        File file = new File(System.getProperty("java.io.tmpdir") + File.separator + name);
        if (file.exists()) {
            return file;
        }
        OutputStream os = new FileOutputStream(file);
        int bytesRead;
        int len = 8192;
        byte[] buffer = new byte[len];
        while ((bytesRead = ins.read(buffer, 0, len)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
        return file;
    }

    /**
     * 将文件名解析成文件的上传路径
     */
    public static File upload(MultipartFile file, String filePath) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssS");
        String name = getFileNameNoEx(file.getOriginalFilename());
        String suffix = getExtensionName(file.getOriginalFilename());
        String nowStr = "-" + format.format(date);
        try {
            String fileName = name + nowStr + "." + suffix;
            String path = filePath + fileName;
            // getCanonicalFile 可解析正确各种路径
            File dest = new File(path).getCanonicalFile();
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            // 文件写入
            file.transferTo(dest);
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 导出excel
     */
    public static void downloadExcel(List<Map<String, Object>> list, HttpServletResponse response) throws IOException {
        String tempPath =System.getProperty("java.io.tmpdir") + IdUtil.fastSimpleUUID() + ".xlsx";
        File file = new File(tempPath);
        BigExcelWriter writer= ExcelUtil.getBigWriter(file);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename=file.xlsx");
        ServletOutputStream out=response.getOutputStream();
        // 终止后删除临时文件
        file.deleteOnExit();
        writer.flush(out, true);
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    public static String getFileType(String type) {
        String documents = "txt doc pdf ppt pps xlsx xls docx";
        String music = "mp3 wav wma mpa ram ra aac aif m4a";
        String video = "avi mpg mpe mpeg asf wmv mov qt rm mp4 flv m4v webm ogv ogg";
        String image = "bmp dib pcp dif wmf gif jpg tif eps psd cdr iff tga pcd mpt png jpeg";
        if(image.contains(type)){
            return "图片";
        } else if(documents.contains(type)){
            return "文档";
        } else if(music.contains(type)){
            return "音乐";
        } else if(video.contains(type)){
            return "视频";
        } else {
            return "其他";
        }
    }

    public static String getFileTypeByMimeType(String type) {
        String mimeType = new MimetypesFileTypeMap().getContentType("." + type);
        return mimeType.split("/")[0];
    }

    /**
     * 判断两个文件是否相同
     */
    public static boolean check(File file1, File file2) {
        String img1Md5 = getMd5(file1);
        String img2Md5 = getMd5(file2);
        return img1Md5.equals(img2Md5);
    }

    /**
     * 判断两个文件是否相同
     */
    public static boolean check(String file1Md5, String file2Md5) {
        return file1Md5.equals(file2Md5);
    }

    private static byte[] getByte(File file) {
        // 得到文件长度
        byte[] b = new byte[(int) file.length()];
        try {
            InputStream in = new FileInputStream(file);
            try {
                in.read(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return b;
    }

    private static String getMd5(byte[] bytes) {
        // 16进制字符
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(bytes);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            // 移位 输出字符串
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载文件
     * @param request /
     * @param response /
     * @param file /
     */
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, File file, boolean deleteOnExit){
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
            IOUtils.copy(fis,response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if(deleteOnExit){
                        file.deleteOnExit();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getMd5(File file) {
        return getMd5(getByte(file));
    }


    /**
     * 逐行处理
     *
     * @param file     handler file
     * @param encoding file encoding
     * @param handler  handler
     */
    public static void handlerWithLine(File file, String encoding, ObjectHandler<String> handler) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                handler.handler(line);
            }
        } catch (IOException e) {
            log.error("handler error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 逐行处理
     *
     * @param file     需要处理的文件
     * @param encoding 文件编码
     * @param result   接受处理结果的集合
     * @param process  处理过程实现
     * @param <E>
     */
    public static <E> void processWithLine(File file, String encoding, Collection<E> result, ObjectProcess<String, E> process) {
        if (result == null) {
            log.info("receive collection is null");
            return;
        }
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                E tmpLine = process.process(line);
                if (tmpLine != null) {
                    result.add(tmpLine);
                }
            }
        } catch (IOException e) {
            log.error("process error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 获取文件content-type
     * @param file
     * @return
     */
    public static String contentType(String file) {
        String contentType = null;
        try {
            contentType = new MimetypesFileTypeMap().getContentType(new File(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentType;
    }
    ///////////////////////////////////////////////////////////////////////
    // 写文件的方法(如果写入的数据较多建议使用通道的方式)

    /**
     * 获取文件的行数
     *
     * @param file 统计的文件
     * @return 文件行数
     */
    public static int lineCounts(File file) {
        try (LineNumberReader rf = new LineNumberReader(new FileReader(file))) {
            long fileLength = file.length();
            rf.skip(fileLength);
            return rf.getLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 以列表的方式获取文件的所有行
     *
     * @param file 需要出来的文件
     * @return 包含所有行的list
     */
    public static List<String> readLines(File file) {
        List<String> list = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 以列表的方式获取文件的所有行
     *
     * @param file     需要处理的文件
     * @param encoding 指定读取文件的编码
     * @return 包含所有行的list
     */
    public static List<String> readLines(File file, String encoding) {
        List<String> list = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取文件内容
     *
     * @param file
     * @return
     */
    public static String readContents(File file) {
        try (FileInputStream in = new FileInputStream(file)) {
            Long filelength = file.length();
            byte[] filecontent = new byte[filelength.intValue()];
            if(in.read(filecontent)>0){
                return new String(filecontent);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建文件支持多级目录
     *
     * @param file 需要创建的文件
     * @return 是否成功, 如果存在则返回成功
     */
    public final static boolean createFiles(File file) {
        if (file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            if (!file.exists()) {
                return file.mkdirs();
            }
        } else {
            File dir = file.getParentFile();
            if (!dir.exists()) {
                if (dir.mkdirs()) {
                    try {
                        return file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    return file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 创建文件支持多级目录
     *
     * @param file 需要创建的文件
     * @return 是否成功, 如果存在则返回成功
     * @para isReNew 存在的时候是否重新创建
     */
    public final static boolean createFiles(File file, boolean isReNew) {
        if (file.exists()) {
            if (isReNew) {
                if (file.delete()) {
                    try {
                        return file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        }
        if (file.isDirectory()) {
            if (!file.exists()) {
                return file.mkdirs();
            }
        } else {
            File dir = file.getParentFile();
            if (!dir.exists()) {
                if (dir.mkdirs()) {
                    try {
                        return file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    return file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 写文件
     *
     * @param file 需要处理的函数
     * @param str  添加的子字符串
     * @return 是否成功
     */
    public static boolean write(File file, String str) {
        AssertUtil.notNull(file, "file is null");
        try (
                RandomAccessFile randomFile = new RandomAccessFile(file, "rw")
        ) {
            randomFile.writeBytes(str);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 写文件
     *
     * @param file     需要处理的文件
     * @param str      添加的字符串
     * @param encoding 指定写入的编码
     * @return 是否成功
     */
    public static boolean write(File file, String str, String encoding) {
        AssertUtil.notNull(file, "file is null");
        try (
                RandomAccessFile randomFile = new RandomAccessFile(file, "rw")
        ) {
            randomFile.write((str).getBytes(encoding));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 写文件
     *
     * @param file 需要处理的函数
     * @param str  添加的子字符串
     * @return 是否成功
     */
    public static boolean addWrite(File file, String str) {
        try (
                RandomAccessFile randomFile = new RandomAccessFile(file, "rw")
        ) {
            long fileLength = randomFile.length();
            randomFile.seek(fileLength);
            randomFile.writeBytes(str);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 写文件
     *
     * @param file     需要处理的文件
     * @param str      添加的字符串
     * @param encoding 指定写入的编码
     * @return 是否成功
     */
    public static boolean addWrite(File file, String str, String encoding) {
        try (
                RandomAccessFile randomFile = new RandomAccessFile(file, "rw")
        ) {
            long fileLength = randomFile.length();
            randomFile.seek(fileLength);
            randomFile.write((str).getBytes(encoding));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    ///////////////////////////////////////////////////////////////////////
    // 复制文件的方法

    /**
     * 复制文件
     *
     * @param resource 源文件
     * @param target   目标文件
     * @return 是否成功
     */
    public static boolean copy(File resource, File target) throws IOException {
        if (resource == null) {
            log.error("copy  resource is null");
            return false;
        }
        if (resource.isFile()) {
            return copyFile(resource, target);
        }
        File[] files = resource.listFiles();
        if (files == null || files.length == 0) {
            return target.mkdirs();
        }
        target.mkdirs();
        for (File file : files) {
            String targetFilePath = file.getAbsolutePath().substring(resource.getAbsolutePath().length());
            File targetFile = new File(target + "/" + targetFilePath);
            if (file.isDirectory()) {
                targetFile.mkdirs();
                copy(file, targetFile);
            } else {
                copyFile(file, targetFile);
            }
        }
        return true;

    }

    /**
     * 复制文件
     * 通过该方式复制文件文件越大速度越是明显
     *
     * @param file       需要处理的文件
     * @param targetFile 目标文件
     * @return 是否成功
     */
    public static boolean copyFile(File file, File targetFile) throws IOException {
        log.debug("copy file resource:{} ,target:{}", file.getAbsolutePath(), targetFile.getAbsolutePath());
        int BUFFER_SIZE = 1024 * 1024;
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        targetFile.createNewFile();
        try (
                FileInputStream fin = new FileInputStream(file);
                FileOutputStream fout = new FileOutputStream(targetFile)
        ) {
            FileChannel in = fin.getChannel();
            FileChannel out = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
            return true;
        } catch (IOException e) {
            throw e;
        }
    }


    ///////////////////////////////////////////////////////////////////////
    // 删除文件的方法

    /**
     * 快速清空一个超大的文件
     *
     * @param file 需要处理的文件
     * @return 是否成功
     */
    public static boolean cleanFile(File file) {
        try (
                FileWriter fw = new FileWriter(file)
        ) {
            fw.write("");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除一个目录
     *
     * @param file 需要处理的文件
     * @return 是否成功
     */
    public static boolean delete(File file) {
        if (file == null)
            return false;

        if (file.isFile())
            return file.delete();

        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return file.delete();
        }
        for (File ff : files) {
            if (file.isDirectory()) {
                delete(ff);
            } else {
                if (ff.length() > 1024 * 1024 * 1024) {
                    cleanFile(ff);
                }
                ff.delete();
            }
        }
        return file.delete();
    }


    ///////////////////////////////////////////////////////////////////////
    // 检索文件的方法

    /**
     * 罗列指定路径下的全部文件
     *
     * @param path 需要处理的文件
     * @return 返回文件列表
     */
    public static List<File> listFile(File path) {
        List<File> list = new ArrayList<>();
        if (path != null && path.exists() && path.isDirectory()) {
            File[] files = path.listFiles();
            if (files == null || files.length == 0) {
                return list;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    list.addAll(listFile(file));
                } else {
                    list.add(file);
                }
            }
        }
        return list;
    }


    /**
     * 获取指定目录下的特点文件,通过后缀名过滤
     *
     * @param dirPath  需要处理的文件
     * @param postfixs 文件后缀
     * @return 返回文件列表
     */
    public static List<File> listFileSuffix(File dirPath, String postfixs) {
        List<File> list = new ArrayList<>();
        if (dirPath != null && dirPath.exists() && dirPath.isDirectory()) {
            File[] files = dirPath.listFiles();
            if (files == null || files.length == 0) {
                return list;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    list.addAll(listFileSuffix(file, postfixs));
                } else {
                    String fileName = file.getName().toLowerCase();
                    if (fileName.endsWith(postfixs.toLowerCase())) {
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 在指定的目录下按照文件名查找文件
     *
     * @param dirPath  搜索的目录
     * @param fileName 搜索的文件名
     * @return 返回文件列表
     */
    public static List<File> listFileName(File dirPath, String fileName) {
        List<File> list = new ArrayList<>();
        if (dirPath != null && dirPath.exists() && dirPath.isDirectory()) {
            File[] files = dirPath.listFiles();
            if (files == null || files.length == 0) {
                return list;
            }

            for (File file : files) {
                if (file.isDirectory()) {
                    list.addAll(listFileName(file, fileName));
                } else {
                    String Name = file.getName();
                    if (Name.equals(fileName)) {
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 在指定的目录下按照文件名查找文件忽略文件带下
     *
     * @param dirPath  搜索的目录
     * @param fileName 搜索的文件名
     * @return 返回文件列表
     */
    public static List<File> listFileNameIgnoreCase(File dirPath, String fileName) {
        List<File> list = new ArrayList<>();
        if (dirPath != null && dirPath.exists() && dirPath.isDirectory()) {
            File[] files = dirPath.listFiles();
            if (files == null || files.length == 0) {
                return list;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    list.addAll(listFileName(file, fileName));
                } else {
                    String Name = file.getName();
                    if (Name.equalsIgnoreCase(fileName)) {
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 罗列指定路径下的全部文件包括文件夹
     *
     * @param path   需要处理的文件
     * @param filter 处理文件的filter
     * @return 返回文件列表
     */
    public static List<File> listFileFilter(File path, ObjectFilter filter) {
        List<File> list = new ArrayList<>();
        if (path != null && path.exists() && path.isDirectory()) {
            File[] files = path.listFiles();
            if (files == null || files.length == 0) {
                return list;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    list.addAll(listFileFilter(file, filter));
                } else {
                    if (filter.filter(file)) {
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }


    /**
     * 罗列指定目录下的文件名符合正则表达式的文件
     *
     * @param dirPath 搜索的目录
     * @param pattern 正则表达式
     * @return 返回文件列表
     */
    public static List<File> listFileNameReg(File dirPath, Pattern pattern) {
        List<File> list = new ArrayList<>();
        if (dirPath != null && dirPath.exists() && dirPath.isDirectory()) {
            File[] files = dirPath.listFiles();
            if (files == null || files.length == 0) {
                return list;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    list.addAll(listFileNameReg(file, pattern));
                } else {
                    if (pattern.matcher(file.getName()).matches()) {
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 处理并检索文件
     *
     * @param path
     * @param handler
     * @return
     */
    public static List<File> listFileWithHandler(File path, ObjectProcess<File, File> handler) {
        List<File> list = new ArrayList<>();
        if (path != null && path.exists() && path.isDirectory()) {
            File[] files = path.listFiles();
            if (files == null || files.length == 0) {
                return list;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    list.addAll(listFileWithHandler(file, handler));
                } else {
                    File ff = handler.process(file);
                    if (ff != null) {
                        list.add(ff);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 创建文件支持多级目录
     *
     * @param path 需要创建的文件
     * @return 是否成功
     */
    public static boolean createFile(String path) {
        if (path != null && path.length() > 0) {
            try {
                File file = new File(path);
                if (!file.getParentFile().exists() && file.getParentFile().mkdirs()) {
                    return file.createNewFile();
                }
            } catch (Exception e) {
                log.error("create file exception :" + path + ",Exception" + e.getMessage());
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * 获取文件后缀名
     *
     * @param file file
     * @return file's suffix
     */

    public static String suffix(File file) {
        String fileName = file.getName();
        return fileName.substring(fileName.indexOf(".") + 1);
    }

    /**
     * 获取文件的hash
     *
     * @param file     file
     * @param HashTyle MD5,SHA-1,SHA-256
     * @return
     */
    public static String fileHash(File file, String HashTyle) {
        try (InputStream fis = new FileInputStream(file)) {
            MessageDigest md = MessageDigest.getInstance(HashTyle);
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] md5Bytes = md.digest();
            StringBuilder hexValue = new StringBuilder();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            log.error("get filehash error" + e.getMessage());
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 利用字节特征探测文件编码
     *
     * @param file 需要处理的文件
     * @return UTF-8 Unicode UTF-16BE GBK or null
     */
    public static String simpleEncoding(File file) {
        try {
            return FileImpl.guestFileEncoding(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 文件压缩支持文件和文件夹
     *
     * @throws Exception
     */
    public static boolean zipDeCompress(File file, String zipFile) {
        try {
            ZIPUtil.deCompress(file, zipFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 文件压缩
     *
     * @param zipFile
     * @param path
     * @return
     */
    public static boolean zipUnCompress(File zipFile, String path) {
        try {
            ZIPUtil.unCompress(zipFile, path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取文件内容，内容经过BASE64编码
     *
     * @param URL
     * @return
     * @throws IOException
     */
    public static String getSource(String URL) {
        try {
            File file = new File(URL);
            FileInputStream is = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                is.read(bytes);
            }
            is.close();
            return Base64.encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将BASE64的字符串恢复成文件
     *
     * @param filename
     * @param content
     * @return
     */
    public static boolean sourceFile(String filename, String content) {
        File file = new File(filename);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] bytes = Base64.decode(content);
            fos.write(bytes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将文件转换为base64的字符串
     *
     * @param URL
     * @param size 每个字符串的长度（字节）
     * @return
     * @throws IOException
     */
    public static List<String> getSource(String URL, int size) {
        List<String> list = new ArrayList<>();
        try (InputStream fis = new FileInputStream(URL)) {
            byte[] buf = new byte[size];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                if (len < size) {
                    byte[] bs = new byte[len];
                    System.arraycopy(buf, 0, bs, 0, len);
                    String str = (Base64.encodeToString(bs));
                    list.add(str);
                } else {
                    String str = (Base64.encodeToString(buf));
                    list.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将BASE64的字符串恢复成文件
     *
     * @param filename
     * @param contents
     * @return
     */
    public static boolean sourceFile(String filename, List<String> contents) {
        File file = new File(filename);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            for (String str : contents) {
                byte[] bytes = Base64.decode(str);
                fos.write(bytes);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
