package servlets.jsp;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Андрей on 29.11.2017.
 */
public class JspAddUserTest {
    @Test
    public void addUser() throws ServletException, IOException {
        JspAddUser adduser = new JspAddUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("login")).thenReturn("user");
        adduser.doPost(request, response);
        List<Jsp_User> users = JspUserStorage.getInstance().getUsers();

        assertThat(users.get(0).getLogin(), is("user"));
    }

}