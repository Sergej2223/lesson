package org.maslov.less.dao;

import org.maslov.less.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;

import java.util.List;
;

@Component
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection conn;

    public List<User> getAll() {
        return jdbcTemplate.query("select * from users", (rs, rowNum) -> {
            User user = new User();
            user.setName(rs.getString(1));
            user.setSurname(rs.getString(2));
            user.setSurname(rs.getString(3));
            return user;
        });
    }
}

    //public User getOne(String email) {
      //  try {
        //    PreparedStatement ps = conn.prepareStatement("select * from users where email = ?");
         //   ps.setString(1, email);
         //   ResultSet rs = ps.executeQuery();
         //   if (rs.next()) {
          //      User user = new User();
              //  user.setName(rs.getString(1 ));
             //   user.setSurname(rs.getString(2 ));
             //   user.setEmail(rs.getString(3 ));
            //    return user;
        //    }
     //   } catch (SQLException igonred) {
     //   }
    //    return null;
  //  }

   // public void add(User user) throws SQLException {
    //    PreparedStatement ps = conn.prepareStatement("insert into users values (?, ?, ?)" );
     //   ps.setString(1, user.getName() );
     //   ps.setString(2, user.getSurname() );
    //    ps.setString(3, user.getEmail() );
    //    ps.execute();
  //  }
//}
