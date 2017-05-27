package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.sql.*;

/**
 * Created by Админ on 20.05.2017.
 */
public class DbConnectionTest {

    @Test
    public void testDbConnection (){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?"
                    +"user=root&password="/* + "&useLegacyDatetimeCode=false&amp&serverTimezone=UTC"*/
                    /*+"&verifyServerCertificate=false" + "&useSSL=false"+ "&requireSSL=false"
                            + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC"*/);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list WHERE group_name = 'name'");
            Groups groups = new Groups();
            while(rs.next()){
                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                        .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(groups);


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
