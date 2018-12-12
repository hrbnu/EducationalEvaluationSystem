package edu.cs.hrbnu.uitl;

public class PathUitl {

    // 获取excel上传存放路径
    public static String getExcelSavePath(String requestPath){
        String[] s = requestPath.split("out");
        String res = s[0];
        res += "src/main/webapp/excel";
        return res;
    }
}
