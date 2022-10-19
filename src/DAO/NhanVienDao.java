/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utils.jdbchelper;
import Utils.XDate;
import java.sql.PreparedStatement;
import Utils.XDate;
import entity.nhanvien;

/**
 *
 * @author ledut
 */
public class NhanVienDao {
                

    public void insert(nhanvien model){
        
        String sql="INSERT INTO NhanVien (manv, tennv, matkhau, vaitro, diachi, sodt, ngaysinh, email, gioitinh, trangthai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbchelper.update(sql, 
                model.getManv(), 
                model.getTennv(), 
                model.getMatkhau(),
                model.getVaitro()?true:false,
                model.getDiachi(),
                model.getSodt(),
                model.getNgaysinh(),
                model.getEmail(),
                model.getGioitinh()?true:false,
                model.getTrangthai()?true:false);
        
                        
    }
    public void update(nhanvien model){
        String sql="UPDATE NhanVien SET matkhau=?, tennv=?, vaitro=?, diachi=?, email=?, sodt=?, ngaysinh=?, gioitinh=?, trangthai=? WHERE manv=?";
         jdbchelper.update(sql, 
                model.getManv(), 
                model.getTennv(),
                model.getMatkhau(),                
                model.getVaitro()?true:false,
                model.getDiachi(),
                model.getSodt(),
                model.getNgaysinh(), 
                model.getEmail(),
                model.getGioitinh()?true:false,
                model.getTrangthai()?true:false);
    }
    public void delete(String MaNV){
        String sql="DELETE FROM NhanVien WHERE manv=?";
        jdbchelper.update(sql, MaNV);
    }
    public List<nhanvien> select(){
        //manv, tennv, matkhau, vaitro, sodt, email, ngaysinh, gioitinh 
        String sql="SELECT * from NhanVien ";
        return select(sql);
    }   
    public nhanvien findById(String manv){
        String sql="SELECT * FROM NhanVien WHERE manv=?";
        List<nhanvien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }   
    
    public List<nhanvien> selectByKeyword(String keyword){
        String sql="SELECT * FROM nhanvien WHERE tennv LIKE ?";
        return select(sql, "%"+keyword+"%");
    }
    
    public List<nhanvien> selectGioitinh(String keyword){
        String sql="SELECT * FROM nhanvien WHERE nhanvien.gioitinh = Nam";
        return select(sql, "%"+keyword+"%");
    }
    
    private List<nhanvien> select(String sql, Object...args){
        List<nhanvien> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbchelper.query(sql, args);
                while(rs.next()){
                    nhanvien model=load(rs);
                    list.add(model);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    
    private nhanvien load(ResultSet rs) throws SQLException{
        nhanvien model = new nhanvien();
        model.setManv(rs.getString("manv"));
        model.setTennv(rs.getString("tennv"));
        model.setMatkhau(rs.getString("matkhau"));
        model.setVaitro(rs.getBoolean("vaitro"));
        model.setDiachi(rs.getString("diachi"));
        model.setSodt(rs.getString("Sodt"));
        model.setNgaysinh(rs.getDate("ngaysinh"));
        model.setEmail(rs.getString("email"));
        model.setGioitinh(rs.getBoolean("GioiTinh"));
        model.setTrangthai(rs.getBoolean("trangthai"));
        return model;
    }
}
