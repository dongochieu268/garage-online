package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Service;

public class serviceDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public List<Service> getAll() {
        List<Service> list = new ArrayList<>();
        String sql = "SELECT * FROM Services";

        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                s.setImg(rs.getString("img"));
                s.setCategoryId(rs.getInt("category_id"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Service getById(int id) {
        String sql = "SELECT * FROM Services WHERE id = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            if (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                s.setImg(rs.getString("img"));
                s.setCategoryId(rs.getInt("category_id"));
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Service s) {
        String sql = "INSERT INTO Services (name, price, description, img, category_id) VALUES (?, ?, ?, ?, ?)";
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getName());
            stm.setDouble(2, s.getPrice());
            stm.setString(3, s.getDescription());
            stm.setString(4, s.getImg());
            stm.setInt(5, s.getCategoryId());
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Service s) {
        String sql = "UPDATE Services SET name=?, price=?, description=?, img=?, category_id=? WHERE id=?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getName());
            stm.setDouble(2, s.getPrice());
            stm.setString(3, s.getDescription());
            stm.setString(4, s.getImg());
            stm.setInt(5, s.getCategoryId());
            stm.setInt(6, s.getId());
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Services WHERE id = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Service> getByCategory(int categoryId) {
        List<Service> list = new ArrayList<>();
        String sql = "SELECT * FROM Services WHERE category_id = ?";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);
            rs = stm.executeQuery();

            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                s.setImg(rs.getString("img"));
                s.setCategoryId(rs.getInt("category_id"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Service> getByPriceRange(double min, double max) {
        List<Service> list = new ArrayList<>();
        String sql = "SELECT * FROM Services WHERE price BETWEEN ? AND ?";

        try {
            stm = connection.prepareStatement(sql);
            stm.setDouble(1, min);
            stm.setDouble(2, max);
            rs = stm.executeQuery();

            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                s.setImg(rs.getString("img"));
                s.setCategoryId(rs.getInt("category_id"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Service> filterServices(Integer categoryId, Double minPrice, Double maxPrice, int page, int pageSize) {
        List<Service> list = new ArrayList<>();

        String sql = "SELECT * FROM Services WHERE 1=1 ";

        if (categoryId != null) sql += "AND category_id = ? ";
        if (minPrice != null) sql += "AND price >= ? ";
        if (maxPrice != null) sql += "AND price <= ? ";

        sql += "ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            stm = connection.prepareStatement(sql);

            int index = 1;
            if (categoryId != null) stm.setInt(index++, categoryId);
            if (minPrice != null) stm.setDouble(index++, minPrice);
            if (maxPrice != null) stm.setDouble(index++, maxPrice);

            stm.setInt(index++, (page - 1) * pageSize);
            stm.setInt(index, pageSize);

            rs = stm.executeQuery();

            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                s.setImg(rs.getString("img"));
                s.setCategoryId(rs.getInt("category_id"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int countFilteredServices(Integer categoryId, Double minPrice, Double maxPrice) {
        String sql = "SELECT COUNT(*) FROM Services WHERE 1=1 ";

        if (categoryId != null) sql += "AND category_id = ? ";
        if (minPrice != null) sql += "AND price >= ? ";
        if (maxPrice != null) sql += "AND price <= ? ";

        try {
            stm = connection.prepareStatement(sql);

            int index = 1;
            if (categoryId != null) stm.setInt(index++, categoryId);
            if (minPrice != null) stm.setDouble(index++, minPrice);
            if (maxPrice != null) stm.setDouble(index++, maxPrice);

            rs = stm.executeQuery();
            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}