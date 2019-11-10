package com.pintu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class SampleServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> fileItems = sf.parseRequest(req);
			for (FileItem file : fileItems) {
				File file2 = new File("/home/ubuntu/" + file.getName());
				file2.createNewFile();
				file.write(file2);
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println("success");
	}

}
