package com.dp.utils;

import com.dp.dto.UserDTO;
import com.dp.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取session中的user
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        // 2.如果user不为空，则放行
        if (user == null) {
            response.setStatus(401); // 未授权
            return false;
        }
        UserDTO userDTO = (UserDTO) user;
        // 3.保存到ThreadLocal
        UserHolder.saveUser(userDTO);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
