/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import Utils.jdbchelper;
import entity.sanpham;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad T490
 */
public class sanphamDAO extends chinhDAO<sanpham, String> {

    String INSERT_SQL = "INSERT INTO sanpham(masp,tensp,dongia,giamgia,soluongton,hinh) VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE sanpham SET tensp=?, dongia=?, giamgia=?, soluongton=?, hinh=? WHERE masp=?";
    String DELETE_SQL = "DELETE FROM sanpham WHERE masp=?";
    String SELECT_ALL_SQL = "SELECT * FROM sanpham";
    String SELECT_BY_ID_SQL = "SELECT * FROM sanpham WHERE masp=?";

    @Override
    public void insert(sanpham entity) {
        jdbchelper.update(INSERT_SQL,
                entity.getMasp(), entity.getTensp(), entity.getDongia(), entity.getGiamgia(), entity.getSoluongton(), entity.getHinh());
    }

    @Override
    public void update(sanpham entity) {
        jdbchelper.update(UPDATE_SQL,
                entity.getTensp(), entity.getDongia(), entity.getGiamgia(), entity.getSoluongton(), entity.getHinh(), entity.getMasp());
    }

    @Override
    public void delete(String key) {
        jdbchelper.update(DELETE_SQL, key);
    }

    @Override
    public List<sanpham> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public sanpham selectByid(String key) {
        List<sanpham> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<sanpham> selectBySql(String sql, Object... agrs) {
        List<sanpham> list = new ArrayList<sanpham>();
        try {
            ResultSet rs = jdbchelper.query(sql, agrs);
            while (rs.next()) {
                sanpham entity = new sanpham();
                entity.setMasp(rs.getString("masp"));
                entity.setTensp(rs.getString("tensp"));
                entity.setDongia(rs.getDouble("dongia"));
                entity.setGiamgia(rs.getDouble("giamgia"));
                entity.setSoluongton(rs.getInt("soluongton"));
                entity.setHinh(rs.getString("hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<sanpham> selectByKeyword(String keyword){
        String sql = "select * from sanpham where tensp like ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
    
    public void updategiohang(int soluong, Object masp) {
        String sql="update sanpham set soluongton=soluongton - ? where masp=?";
        jdbchelper.update(sql,soluong,masp);        
    }
    
    public void updategiohangtru(int soluong, Object masp) {
        String sql="update sanpham set soluongton=soluongton - ? where masp=?";
        jdbchelper.update(sql,soluong,masp);        
    }
    
    public void updategiohangcong(Object soluong, Object masp) {
        String sql="update sanpham set soluongton=soluongton + CAST(? AS int) where masp=?";
        jdbchelper.update(sql,soluong,masp);        
    } 
    
    public double tongtien(Object dongia, int soluong, Object giamgia, Object masp) throws SQLException{
        String sql="select CAST(? AS float) * ? - cast(? as float) from sanpham where masp=?";
        double tongtien=(Double)jdbchelper.vaule(sql, dongia,soluong,giamgia,masp);
        return tongtien;
    }
    
    public double tongtientru(Object soluong, Object masp){
        String sql="select dongia * cast(? as int) - giamgia from sanpham where masp=?";
        double tongtien=(Double)jdbchelper.vaule(sql,soluong,masp);
        return tongtien;
    }
    //public int dem(){
       //String sql="select count(*) from sanpham";
        //int count=(Integer)jdbchelper.vaule(sql);
       // return count;

//    public List<sanpham> selectByKhoHang(String malh) {
//        String sql = "select * from sanpham where malh=?";
//        return this.selectBySql(sql, malh);
//    }
    
}
