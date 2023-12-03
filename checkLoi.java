package Net;

import java.util.regex.*;

public class checkLoi {
    public static boolean checkmatKhau(String matKhau) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{8}$");
        Matcher matcher = pattern.matcher(matKhau);
        return matcher.matches();
    };

    public static boolean checkKyTuDacBiet(String inp) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
        Matcher matcher = pattern.matcher(inp);
        return !matcher.matches();
    }

    public static boolean checkMaNhanvien(String inp) {
        Pattern pattern = Pattern.compile("^NV\\d{1,2}$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }

    public static boolean checkTen(String inp) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+([a-zA-z]{2,}|\\s{1})*$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }

    public static boolean checkMaKhachHang(String inp) {
        Pattern pattern = Pattern.compile("^KH\\d{1,2}$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }

    public static boolean checkNhaPhanPhoi(String inp) {
        Pattern pattern = Pattern.compile("^NPP\\d{1,2}$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }

    public static boolean checkMaPhong(String inp) {
        Pattern pattern = Pattern.compile("^PHG\\d{3,}$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }

    public static boolean checkMaTang(String inp) {
        Pattern pattern = Pattern.compile("^TG\\d{3,}$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }

    public static boolean checkMaThietBi(String inp) {
        Pattern pattern = Pattern.compile("^TB\\d{3,}$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }

    public static boolean checkMaThucAn(String inp) {
        Pattern pattern = Pattern.compile("^TA\\d{3,}$");
        Matcher matcher = pattern.matcher(inp);
        return matcher.matches();
    }
}
