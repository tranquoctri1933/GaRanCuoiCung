package DAO;

import entity.thongke;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Utils.jdbchelper;
import java.sql.SQLException;

public class ThongKeDAO extends chinhDAO<thongke, Integer> {

    String SELECT_ALL_SQL = "select sanpham, soluong, gia, doanhthu from thongke";
    String SELECT_BY_ID_SQL = "select sanpham, thongke.soluong, gia, doanhthu from thongke, daban where thongke.sott = daban.sott and sanpham = %'?'%  ";
    String SELECT_DOANH_THU = "Select sum(doanhthu) as 'tongdoanhthu' from thongke";
    String SELECT_BY_YEAR = "select sanpham, thongke.soluong, gia, doanhthu from thongke, daban where thongke.sott = daban.sott and year(daban.ngaymua) = ?";

    @Override
    public List<thongke> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public thongke selectByid(Integer key) {
        List<thongke> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<thongke> selectByKeyword(String keyword){
        String sql = "select * from thongke where sanpham like ?";
        return select(sql, "%"+keyword+"%");
    }
    
    public List<thongke> selectByYear(String year){
        String sql = "select sanpham, thongke.soluong, gia, doanhthu from thongke, daban where thongke.sott = daban.sott and year(daban.ngaymua) like ?";
        return select(sql, "%" + year +"%");
    }

    @Override
    protected List<thongke> selectBySql(String sql, Object... agrs) {
        List<thongke> list = new ArrayList<>();
        try {
            ResultSet rs = jdbchelper.query(sql, agrs);
            while (rs.next()) {
                thongke entity = new thongke();
                entity.setSanpham(rs.getString("sanpham"));
                entity.setSoluong(rs.getInt("soluong"));
                entity.setGia(rs.getDouble("gia"));
                entity.setDoanhthu(rs.getDouble("doanhthu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void insert(thongke entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(thongke entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    public List<Object[]> getNam(Integer nam) {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "select sanpham, thongke.soluong, gia, doanhthu from thongke, daban where thongke.sott = daban.sott and YEAR(ngaymua) = ?";
//                rs = jdbchelper.query(sql, nam);
//                while (rs.next()) {
//                    Object[] model = {
//                        rs.getString("sanpham"),
//                        rs.getInt("soluong"),
//                        rs.getDouble("gia"),
//                        rs.getDouble("doanhthu")
//                    };
//                    list.add(model);
//                }
//            } finally {
//                rs.getStatement().getConnection().close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//        return list;
//    }

//    private List<thongke> selectAll(String SELECT_DOANH_THU, Integer key) {
//        List<thongke> list = new ArrayList<>();
//        try {
//            ResultSet rs = jdbchelper.query(SELECT_ALL_SQL, key);
//            while (rs.next()) {
//                thongke entity = new thongke();
//                entity.setTongdt(rs.getDouble("tongdoanhthu"));
//                list.add(entity);
//            }
//            rs.getStatement().getConnection().close();
//            return list;
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//
//    }
//    
//    public List<thongke> selectByYear(String nam){
//       String sql = "select sanpham, thongke.soluong, gia, doanhthu from thongke, daban where thongke.sott = daban.sott and YEAR(ngaymua) = ? ";
//       return select(sql, nam);
//    }
//    
//    
    private List<thongke> select(String sql, Object...args){
        List<thongke> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbchelper.query(sql, args);
                while(rs.next()){
                    thongke model=readFromResultSet(rs);
                    list.add(model);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    private thongke readFromResultSet(ResultSet rs) throws SQLException{
        thongke model = new thongke();
        model.setSanpham(rs.getString("sanpham"));
        model.setSoluong(rs.getInt("soluong"));
        model.setGia(rs.getDouble("gia"));
        model.setDoanhthu(rs.getDouble("doanhthu"));
        return model;
    }
}
