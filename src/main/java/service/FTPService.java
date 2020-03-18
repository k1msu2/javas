package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FTPService {

	private FTPClient ftp = null;

	public FTPClient getFtp() {
		return ftp;
	}

	public void setFtp(FTPClient ftp) {
		this.ftp = ftp;
	}

	// param( host server ip, username, password )
	public FTPService(String host, String user, String pwd) throws Exception {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host);// 호스트 연결
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(user, pwd);// 로그인
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
	}

	// param( 보낼파일경로+파일명, 호스트에서 받을 파일 이름, 호스트 디렉토리 )
	public void uploadFile(String localFileFullName, String fileName, String hostDir) throws Exception {
		try (InputStream input = new FileInputStream(new File(localFileFullName))) {
			System.out.println(hostDir + fileName);
			this.ftp.storeFile(hostDir + fileName, input);
		}
	}

	public void downloadFile(String hostFolder, String fileName, String localDir) throws Exception {
		ftp.changeWorkingDirectory(hostFolder);
		FTPFile files[] = ftp.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().equals(fileName)) {
				System.out.println("\t" + fileName);
				File file = new File(localDir + File.separator + fileName);
				try (FileOutputStream output = new FileOutputStream(file)) {
					this.ftp.retrieveFile(fileName, output);
				}
			}
		}
	}

	public void disconnect() {
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}
	}
	
	public void fileCopyToResource(String resourceDir, String localDir, String fileName) throws IOException {
		InputStream input = new FileInputStream(localDir+fileName);
		MultipartFile uploadFile = new MockMultipartFile(fileName, input);
		byte[] content = uploadFile.getBytes();
		String path = resourceDir + fileName + ".png";
		File f = new File(path);
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(content);
		fos.close();
	}
	/*
	 * public static void main(String[] args) throws Exception {
	 * System.out.println("Start"); FTPController ftpUploader = new
	 * FTPController("127.0.0.1", "test", "1234");
	 * ftpUploader.uploadFile("C:\\Users\\jdg\\Desktop\\jeongpro\\hello.txt",
	 * "hello.txt", "/home/jdk/"); ftpUploader.disconnect();
	 * System.out.println("Done"); }
	 */
}
