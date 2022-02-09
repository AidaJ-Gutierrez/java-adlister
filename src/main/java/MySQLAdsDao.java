import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;

//Define your constructor so that it accepts an instance of your Config class so that it can obtain the database credentials.


    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

        }catch(SQLException e){
            e.printStackTrace();

        }

    }


    @Override
    public List<Ad> all() {
        List<Ad> ad = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM ads";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                ad.add(new Ad (rs.getLong("id"), rs.getLong("userId"), rs.getString("title"), rs.getString("description")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ad;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            String qu = String.format("INSERT INTO ads(user_id, title, description) VALUES (%d, '%s','%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
            return (long) stmt.executeUpdate(qu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
