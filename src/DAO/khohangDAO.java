/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.jdbchelper;
import entity.khohang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class khohangDAO extends chinhDAO<khohang, String>{
    String INSERT_SQL = "INSERT INTO khohang VALUES(malh,tenlh,soluongton)";
    String UPDATE_SQL = "UPDATE khohang SET tenlh=?, soluongton=? WHERE malh=?";
    String DELETE_SQL = "DELETE FROM khohang WHERE malh=?";
    String SELECT_ALL_SQL = "SELECT * FROM khohang";
    String SELECT_BY_ID_SQL = "SELECT * FROM khohang WHERE malh=?";
    @Override
    public void insert(khohang entity) {
        jdbchelper.update(INSERT_SQL, entity.getMalh(), entity.getTenlh(), entity.getSoluongton());
    }

    @Override
    public void update(khohang entity) {
        jdbchelper.update(UPDATE_SQL, entity.getTenlh(), entity.getSoluongton(), entity.getMalh());
    }

    @Override
    public void delete(String key) {
        jdbchelper.update(DELETE_SQL, key);
    }

    @Override
    public List<khohang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public khohang selectByid(String key) {
        List<khohang> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<khohang> selectBySql(String sql, Object... agrs) {
        List<khohang> list = new ArrayList<khohang>();
        try {
            ResultSet rs = jdbchelper.query(sql, agrs);
            while(rs.next()){
                khohang entity = new khohang();
                entity.setMalh(rs.getString("malh"));
                entity.setTenlh(rs.getString("tenlh"));
                entity.setSoluongton(rs.getInt("soluongton"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }    
}
