package com.bhuvana.service;

import com.bhuvana.dao.RoleDAO;
import com.bhuvana.exception.RoleInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.Roles;
import com.bhuvana.validator.RoleValidator;

public class RolesService {
	public void provideSave(Roles role) throws ServiceException
	{
		RoleValidator roleValidator= new RoleValidator();
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleValidator.validateSave(role);
			roleDAO.save(role);
		} catch (RoleInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void provideUpdate(Roles role) throws ServiceException
	{
		RoleValidator roleValidator= new RoleValidator();
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleValidator.validateUpdate(role);
			roleDAO.update(role);
		} catch (RoleInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void provideDelete(Roles role) throws ServiceException
	{
		RoleValidator roleValidator= new RoleValidator();
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleValidator.validateDelete(role);
			roleDAO.delete(role);
		} catch (RoleInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void listAllRoles()
	{
		RoleDAO roleDao=new RoleDAO();
		roleDao.list();
	}
}
