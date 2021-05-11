package commons;

public class ValidatePhone {
    public boolean validateGiaBan(String giaBan) {
        String regex = "([1-9]|[1-9][0-9]+)";
        return giaBan.matches( regex );
    }

    public boolean validateThoiGianBaoHanh(String thoiGianBaoHanh) {
        String regex = "([1-9]|[1-9][0-9]|[1-6][0-9][0-9]|(7)[0-2][0-9])";
        return thoiGianBaoHanh.matches( regex );
    }

    public boolean validatePhamViBaoHanh(String phamViBaoHanh) {
        String regex = "((Toan Quoc)|(Quoc Te))";
        return phamViBaoHanh.matches( regex );
    }

    public boolean validateQuocGiaXachTay(String quocGiaXachTay) {
        String regex = "(Viet Nam)";
        return !quocGiaXachTay.matches( regex );
    }

    public boolean validateTrangThai(String trangThai) {
        String regex = "((Da sua chua)|(Chua sua chua))";
        return trangThai.matches( regex );
    }
}
