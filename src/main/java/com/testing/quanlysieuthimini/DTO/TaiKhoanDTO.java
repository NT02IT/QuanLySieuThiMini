package com.testing.quanlysieuthimini.DTO;

import java.util.Objects;

public class TaiKhoanDTO {

    private int accountId;
    private int staffId;
    private String username;
    private String password;
    private int roleId;
    private int status;

    public TaiKhoanDTO() {

    }

    // Constructor đầy đủ
    public TaiKhoanDTO(int accountId, int staff, String username, String password, int roleId, int status) {
        this.accountId = accountId;
        this.staffId = staff;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
    }
    
    // Constructor chỉ lấy nhân viên
    public TaiKhoanDTO(int staff, String username, String password, int roleId, int status) {
        this.staffId = staff;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setStaffId(int staff) {
        this.staffId = staff;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.accountId;
        hash = 83 * hash + Objects.hash(this.staffId);
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + this.roleId;
        hash = 83 * hash + this.status;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoanDTO other = (TaiKhoanDTO) obj;
        if (this.accountId != other.accountId) {
            return false;
        }
        if (!Objects.equals(this.staffId, other.staffId)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaiKhoanDTO{"
                + "accountId=" + accountId
                + "staff=" + staffId
                + ", username='" + username + '\''
                + ", password='" + password + '\''
                + ", roleId=" + roleId
                + ", status=" + status
                + "}";
    }
}
