package com.primeton.utils;

import java.io.*;
import java.util.Properties;
import java.util.StringTokenizer;

public class LinuxSystemTool {


    public  static  int [] getMemInfo() throws IOException, InterruptedException
    {
        File file = new File( "/proc/meminfo" );
        BufferedReader br = new BufferedReader( new InputStreamReader(
                new FileInputStream(file)));
        int [] result = new  int [ 4 ];
        String str = null ;
        StringTokenizer token = null ;
        while ((str = br.readLine()) != null )
        {
            token = new StringTokenizer(str);
            if (!token.hasMoreTokens())
                continue ;

            str = token.nextToken();
            if (!token.hasMoreTokens())
                continue ;

            if (str.equalsIgnoreCase( "MemTotal:" ))
                result[0 ] = Integer.parseInt(token.nextToken());
            else  if (str.equalsIgnoreCase( "MemFree:" ))
                result[1 ] = Integer.parseInt(token.nextToken());
            else  if (str.equalsIgnoreCase( "SwapTotal:" ))
                result[2 ] = Integer.parseInt(token.nextToken());
            else  if (str.equalsIgnoreCase( "SwapFree:" ))
                result[3 ] = Integer.parseInt(token.nextToken());
        }

        return result;
    }

    public  static  float getCpuInfo() throws IOException, InterruptedException
    {
        File file = new File( "/proc/stat" );
        BufferedReader br = new BufferedReader( new InputStreamReader(
                new FileInputStream(file)));
        StringTokenizer token = new StringTokenizer(br.readLine());
        token.nextToken();
        int user1 = Integer.parseInt(token.nextToken());
        int nice1 = Integer.parseInt(token.nextToken());
        int sys1 = Integer.parseInt(token.nextToken());
        int idle1 = Integer.parseInt(token.nextToken());

        Thread.sleep(1000 );

        br = new BufferedReader(
                new InputStreamReader( new FileInputStream(file)));
        token = new StringTokenizer(br.readLine());
        token.nextToken();
        int user2 = Integer.parseInt(token.nextToken());
        int nice2 = Integer.parseInt(token.nextToken());
        int sys2 = Integer.parseInt(token.nextToken());
        int idle2 = Integer.parseInt(token.nextToken());

        return ( float )((user2 + sys2 + nice2) - (user1 + sys1 + nice1)) / ( float )((user2 + nice2 + sys2 + idle2) - (user1 + nice1 + sys1 + idle1));
    }


    public static void main (String args[]){
        Properties props=System.getProperties(); //系统属性

        System.out.println("Java的运行环境版本："+props.getProperty("java.version"));
        System.out.println("Java的运行环境供应商："+props.getProperty("java.vendor"));
        System.out.println("Java供应商的URL："+props.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径："+props.getProperty("java.home"));
        System.out.println("Java的虚拟机规范版本："+props.getProperty("java.vm.specification.version"));
        System.out.println("Java的虚拟机规范供应商："+props.getProperty("java.vm.specification.vendor"));
        System.out.println("Java的虚拟机规范名称："+props.getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本："+props.getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商："+props.getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称："+props.getProperty("java.vm.name"));
        System.out.println("Java运行时环境规范版本："+props.getProperty("java.specification.version"));
        System.out.println("Java运行时环境规范供应商："+props.getProperty("java.specification.vender"));
        System.out.println("Java运行时环境规范名称："+props.getProperty("java.specification.name"));
        System.out.println("Java的类格式版本号："+props.getProperty("java.class.version"));
        System.out.println("Java的类路径："+props.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表："+props.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径："+props.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径："+props.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称："+props.getProperty("os.name"));
        System.out.println("操作系统的构架："+props.getProperty("os.arch"));
        System.out.println("操作系统的版本："+props.getProperty("os.version"));
        System.out.println("文件分隔符："+props.getProperty("file.separator")); //在 unix 系统中是”／”
        System.out.println("路径分隔符："+props.getProperty("path.separator")); //在 unix 系统中是”:”
        System.out.println("行分隔符："+props.getProperty("line.separator")); //在 unix 系统中是”/n”
        System.out.println("用户的账户名称："+props.getProperty("user.name"));
        System.out.println("用户的主目录："+props.getProperty("user.home"));
        System.out.println("用户的当前工作目录："+props.getProperty("user.dir"));

    }

}
