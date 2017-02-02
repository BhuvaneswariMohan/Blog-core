package com.bhuvana.validator;

import com.bhuvana.exception.RoleInvalidEntriesException;
import com.bhuvana.model.Roles;

public class RoleValidator {
	public void validateSave(Roles role) throws RoleInvalidEntriesException {
		if (role.getId() < 0) {
			throw new RoleInvalidEntriesException("Enter Valid Role ID");
		} else if (role.getRoleName() == null || "".equals(role.getRoleName())) {
			throw new RoleInvalidEntriesException("Enter Valid Role Name");

		}
	}

	public void validateUpdate(Roles role) throws RoleInvalidEntriesException {
		if (role.getId() < 0) {
			throw new RoleInvalidEntriesException("Enter Valid Role ID");
		} else if (role.getRoleName() == null || "".equals(role.getRoleName())) {
			throw new RoleInvalidEntriesException("Enter Valid Role Name");

		}
	}

	public void validateDelete(Roles role) throws RoleInvalidEntriesException {
		if (role.getId() < 0) {
			throw new RoleInvalidEntriesException("Enter Valid Role ID");
		}

	}
}
