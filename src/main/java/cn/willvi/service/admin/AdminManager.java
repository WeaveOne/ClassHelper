package cn.willvi.service.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.willvi.entity.Chart;
import cn.willvi.entity.Files;
import cn.willvi.entity.Student;
import cn.willvi.entity.Teacher;
import cn.willvi.util.PageData;

/**
 * 管理员共鞥
 * 
 * @author 维
 *
 */
public interface AdminManager {

	public PageData getCnt() throws Exception;
	public List<Chart> getData() throws Exception;
	public List<Teacher> getTeacher() throws Exception;
	public List<Student> getStudent(PageData pd) throws Exception;
	public List<Files> getFiles(PageData pd) throws Exception;
	public Object addTeacher(PageData pd) throws Exception;
	public Object deleteTeacher(PageData pd) throws Exception;
	public Object deleteStudent(PageData pd) throws Exception;
	public PageData getStudentCnt(PageData pd) throws Exception;
	public PageData getFilesCnt(PageData pd) throws Exception;
	public Object deleteFile(PageData pd) throws Exception;
}
