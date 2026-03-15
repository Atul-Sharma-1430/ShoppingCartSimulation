package com.shopping.dao;

import java.util.*;
import com.shopping.model.Product;
import java.sql.*;
import java.util.*;
import com.shopping.model.Product;

public class CartDAO {

    static List<Product> cart=new ArrayList<>();
    static int idCounter=1;

    public static void addProduct(String name,double price,int quantity){

        try{

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO products(name,price,quantity) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setInt(3,quantity);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static List<Product> getAllProducts(){

        List<Product> list = new ArrayList<>();

        try{

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Product p = new Product();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));

                list.add(p);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public static Product getProductById(int id){

        for(Product p:cart){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public static void updateProduct(int id,String name,double price,int quantity){

        try{

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE products SET name=?,price=?,quantity=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setInt(3,quantity);
            ps.setInt(4,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteProduct(int id){

        try{

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM products WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static double getTotal(){

        double total=0;

        for(Product p:cart){
            total+=p.getTotal();
        }

        return total;
    }
}