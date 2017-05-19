package com.chenxin.ftpTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * @author created by licx
 * @data 2017年5月17日---下午2:54:54
 */
public class FtpTest {
	public static void main(String[] args) throws SocketException, IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("115.159.188.223");
		ftpClient.login("www", "p71qOFHAF4n9");
		FileInputStream inputStream = new FileInputStream(new File(
				"D:/1.jpg"));
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.storeFile("123.jpg", inputStream);
		inputStream.close();
		
		ftpClient.logout();

	}

}
