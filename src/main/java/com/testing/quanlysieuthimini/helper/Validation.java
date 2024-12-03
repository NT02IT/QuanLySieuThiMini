package com.testing.quanlysieuthimini.helper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Validation {

    public Boolean isEmpty(String input) {
        if (input == null) {
            return true;
        }
        return input.equals("");
    }

    public String isValidFullname(String fullName) {
        fullName = fullName.trim(); // Loại bỏ khoảng trắng ở đầu và cuối

        if (fullName.isEmpty()) {
            return "Họ và tên không được để trống!";
        }
        if (fullName.length() < 2) {
            return "Họ và tên phải có ít nhất 2 ký tự!";
        }
        if (fullName.length() > 20) {
            return "Họ và tên tối đa 20 ký tự!";
        }
        if (!fullName.matches("[\\p{L} ]+")) {
            return "Họ và tên chỉ được chứa chữ cái và khoảng trắng!";
        }
        if (fullName.matches(".*[ ]{2,}.*")) {
            return "Giữa họ và tên không được chứa nhiều hơn 1 khoảng trắng!";
        }

        if (fullName.startsWith("") || fullName.endsWith("")) {
            return "Họ và tên không được bắt đầu hoặc kết thúc bằng khoảng trắng!";
        }

        return null;
    }

    public String isValidUsername(String username) {
        username = username.trim(); // Loại bỏ khoảng trắng ở đầu và cuối

        if (username.isEmpty()) {
            return "Tên đăng nhập không được để trống!";
        }
        if (username.length() < 5) {
            return "Tên đăng nhập phải có ít nhất 5 ký tự!";
        }
        if (username.length() > 15) {
            return "Tên đăng nhập tối đa 15 ký tự!";
        }
        if (!username.matches("[a-zA-Z0-9_]+")) {
            return "Tên đăng nhập chỉ được chứa chữ cái, số và dấu gạch dưới!";
        }

        if (!username.matches(".*[A-Za-z].*")) {
            return "Tên đăng nhập phải chứa ít nhất một chữ cái!";
        }
        if (!username.matches(".*[0-9].*")) {
            return "Tên đăng nhập phải chứa ít nhất một chữ số!";
        }

        if (username.startsWith("_") || username.endsWith("_")) {
            return "Tên đăng nhập không được bắt đầu hoặc kết thúc bằng dấu gạch dưới!";
        }
        return null;
    }


    public String isValidPassword(String password) {
        password = password.trim(); // Loại bỏ khoảng trắng ở đầu và cuối


  


        if (password.isEmpty()) {
            return "Mật khẩu không được để trống!";
        }
        if (password.length() < 5) {
            return "Mật khẩu phải từ 5 ký tự trở lên!";
        }
        if (password.length() > 20) {
            return "Mật khẩu quá dài! Vui lòng nhập mật khẩu dưới 20 ký tự.";
        }
        if (!password.matches(".*[A-Za-z].*")) {
            return "Mật khẩu phải chứa ít nhất một chữ cái!";
        }
        if (!password.matches(".*[0-9].*")) {
            return "Mật khẩu phải chứa ít nhất một chữ số!";
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/`~].*")) {
            return "Mật khẩu phải chứa ít nhất một ký tự đặc biệt!";
        }
        return null;
    }

    public String isValidEmail(String email) {
        email = email.trim(); // Loại bỏ khoảng trắng ở đầu và cuối
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if (email.isEmpty()) {
            return "Email không được để trống!";
        }
        if (!email.matches(emailRegex)) {
            return "Email không hợp lệ! Vui lòng nhập theo định dạng: ten@example.com";
        }
        return null;
    }

    public String isValidPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim(); // Loại bỏ khoảng trắng ở đầu và cuối

        if (phoneNumber.isEmpty()) {
            return "Số điện thoại không được để trống!";
        }
        if (!phoneNumber.matches("\\d+")) {
            return "Số điện thoại chỉ được chứa các chữ số!";
        }
        if (phoneNumber.length() != 10) {
            return "Số điện thoại hợp lệ là 10 chữ số!";
        }
        if (!phoneNumber.matches("0[0-9][1-9]{8}$")) {
            return "Số điện thoại không hợp lệ! Số điện thoại phải bắt đầu bằng 0, theo sau là một chữ số từ 1 đến 9 và sau đó là 8 chữ số bất kỳ.";
        }
        return null;
    }

    public String validateDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            return "Ngày sinh không hợp lệ! Vui lòng nhập theo định dạng yyyy-MM-dd.";
        }

        LocalDate today = LocalDate.now();
        LocalDate dob = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (dob.isAfter(today)) {
            return "Ngày sinh không hợp lệ! Ngày sinh không thể lớn hơn ngày hiện tại.";
        }
        if (dob.isBefore(today.minusYears(100))) {
            return "Ngày sinh không hợp lệ! Ngày sinh không thể lớn hơn 100 năm trước.";
        }
        if (dob.isAfter(today.minusYears(18))) {
            return "Bạn phải ít nhất đủ 18 tuổi để đăng ký!";
        }
        return null;
    }
}
