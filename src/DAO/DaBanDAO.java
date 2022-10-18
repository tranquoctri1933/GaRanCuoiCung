package DAO;

import Utils.jdbchelper;
import entity.daban;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DaBanDAO extends chinhDAO<daban, Integer> {
   
    String SELECT_ALL_SQL = "SELECT * FROM daban";

    @Override
    public void insert(daban entity) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(daban entity) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<daban> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public daban selectByid(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected List<daban> selectBySql(String sql, Object... agrs) {
        List<daban> list = new ArrayList<>();
        try {
            ResultSet rs = jdbchelper.query(sql, agrs);
            while(rs.next()){
                daban entity = new daban();
                entity.setSott(rs.getInt("Sott"));
                entity.setManv(rs.getString("manv"));
                entity.setMasp(rs.getString("masp"));
                entity.setMagg(rs.getString("magg"));
                entity.setNgaymua(rs.getString("ngaymua"));
                entity.setDongia(rs.getDouble("dongia"));
                entity.setSoluong(rs.getInt("soluong"));
                entity.setGiamgia(rs.getDouble("giamgia"));
                entity.setTongtt(rs.getDouble("tongtt"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
