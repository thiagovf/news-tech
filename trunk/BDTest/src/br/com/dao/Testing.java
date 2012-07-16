package br.com.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class Testing {
	public static void main(String[] args)  {
		try {
			removing();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void removing() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();

		dataSource.setURL("jdbc:oracle:thin:@10.218.20.68:9101:HYTMGMT");
		dataSource.setUser("VCMMGMT");
		dataSource.setPassword("VCMMGMT");
		
		Connection conn = dataSource.getConnection();
		
		StringBuffer sql = new StringBuffer();
		PreparedStatement pstmt = null;
		sql.append("delete from hg_content_file where id = ?");

		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, "hydrangeas.jpg_FILEALBUM_123");
		pstmt.execute();
		pstmt.close();
		conn.close();
	}
	
	public static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}
	
	@SuppressWarnings("unused")
	private static void inserting() throws SQLException, FileNotFoundException {
		File file = new File("C:\\Zz\\Workspaces\\workspace_Hyatt_album\\BDTest\\src\\br\\com\\dao\\Lighthouse.jpg");
		FileInputStream fis = new FileInputStream(file);
		//	byte[] bytes = getBytes(fis);
		OracleDataSource dataSource = new OracleDataSource();

		dataSource.setURL("jdbc:oracle:thin:@10.218.20.68:9101:HYTMGMT");

		dataSource.setUser("VCMMGMT");

		dataSource.setPassword("VCMMGMT");
		Connection conn = dataSource.getConnection();
		StringBuffer sql = new StringBuffer();
		PreparedStatement pstmt = null;
		sql.append("insert into HG_CONTENT_FILE");
		sql.append("(id,bytes,title,album_id,file_name,description,create_user)");
		sql.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, "testing123_BLOB");
		pstmt.setBinaryStream(2, fis,(int)file.length());
		pstmt.setString(3, "testing123_BLOB");
		pstmt.setString(4, "testing123_BLOB");
		pstmt.setString(5, "321");
		pstmt.setString(6, "testing123_BLOB");
		pstmt.setString(7, "test");
		pstmt.execute();
		pstmt.close();
		conn.close();
	}


}
