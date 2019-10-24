package cn.io.study02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author dell
 *
 */

public class Copy {
	public static void copy(String srcpath,String destpath) {
		File src=new File(srcpath);
		File dest=new File(destpath);
		InputStream is=null;
		OutputStream os=null;
		try {
			is=new FileInputStream(srcpath);
			os=new FileOutputStream(destpath);
			byte[] flush=new byte[1024];
			int len=0;
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);
				os.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源，分别关闭，先打开的后关闭。
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	//利用递归拷贝文件夹
	public static void copyDir(String srcpath,String destpath) {
		 File src=new File(srcpath);
	        File dest=new File(destpath);
	        if(src!=null&&src.exists()) {
	            if(src.isFile()) {
	                copy(src.getAbsolutePath(),dest.getAbsolutePath());
	            }else {
	                dest.mkdirs();
	                File[] srcs=src.listFiles();
	                for(int i=0;i<srcs.length;i++) {
	                    System.out.println("3");
	                    copyDir(srcs[i].getAbsolutePath(),dest.getAbsolutePath()+"\\"+srcs[i].getName());
	                }
	            }
	        }
		 
	}
	public static void main(String[] args) {
		//copy("E:\\workspace-java\\IO流技术\\src\\cn\\io\\study02\\Copy.java","dest.txt");
		copyDir("E:\\workspace-java\\IO流技术\\src\\cn\\io\\study02","E:\\workspace-java\\IO流技术\\copydir");
		
	}

}
