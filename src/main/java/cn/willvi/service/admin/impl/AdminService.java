package cn.willvi.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.willvi.dao.DaoSupport;
import cn.willvi.entity.Chart;
import cn.willvi.entity.Files;
import cn.willvi.entity.Student;
import cn.willvi.entity.Teacher;
import cn.willvi.service.admin.AdminManager;
import cn.willvi.util.PageData;

@Service("adminService")
public class AdminService implements AdminManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Override
	public PageData getCnt() throws Exception {
		return (PageData) dao.findForObject("AdminMapper.getCnt", null);
	}

	@Override
	public List<Chart> getData() throws Exception {
		return (List<Chart>) dao.findForList("AdminMapper.getData", null);
	}

	@Override
	public List<Teacher> getTeacher() throws Exception {
		return (List<Teacher>) dao.findForList("AdminMapper.getTeacher", null);
	}

	@Override
	public List<Student> getStudent(PageData pd) throws Exception {
		return (List<Student>) dao.findForList("AdminMapper.getStudent", pd);
	}

	@Override
	public Object addTeacher(PageData pd) throws Exception {
		return dao.save("AdminMapper.addTeacher", pd);
	}

	@Override
	public Object deleteTeacher(PageData pd) throws Exception {
		return dao.delete("AdminMapper.deleteTeacher", pd);
	}

	@Override
	public Object deleteStudent(PageData pd) throws Exception {
		return dao.delete("AdminMapper.deleteStudent", pd);
	}

	@Override
	public PageData getStudentCnt(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AdminMapper.getStudentCnt", pd);
	}

	@Override
	public List<Files> getFiles(PageData pd) throws Exception {
		return (List<Files>) dao.findForList("AdminMapper.getFile", pd);
	}

	@Override
	public PageData getFilesCnt(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AdminMapper.getFileCnt", pd);
	}

	@Override
	public Object deleteFile(PageData pd) throws Exception {
		return dao.delete("AdminMapper.deleteFile", pd);
	}

}
