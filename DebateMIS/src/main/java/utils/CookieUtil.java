package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    /**
     *保存cookie
     * @param response
     * @param key
     * @param value
     * @param time
     * @return
     */
    public static HttpServletResponse setCookie(
            HttpServletResponse response,String key,String value,int time){
        //new 一个Cookie对象，键值对是参数
        Cookie cookie = new Cookie(key,value);
        //以"/"开头的url都能访问cookie
        cookie.setPath("/");

        //对cookie编码进行设置
        try{
            URLEncoder.encode(value,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置cookie生命周期
        cookie.setMaxAge(time);
        //将cookie添加到Response中，cookie没有更新，只能覆盖
        response.addCookie(cookie);
        System.out.println(cookie);
        return response;
    }

    /**
     * 将cookie封装到Map中
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies){
            for (Cookie cookie:cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 根据名字获取Cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)){
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        }else {
            return null;
        }
    }

    /**
     * 删除无效cookie
     * @param response
     * @param request
     * @param deleteKey
     */
    private void delectCookieByName(
            HttpServletResponse response,HttpServletRequest request,String deleteKey){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        for (String key:cookieMap.keySet()){
            if (key==deleteKey && key.equals(deleteKey)){
                Cookie cookie = cookieMap.get(key);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }
}
