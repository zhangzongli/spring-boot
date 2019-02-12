package com.wang.miao.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 描述:
 *    salt
 * @author zhangzl
 * @create 2018-12-20 4:53 PM
 */
public class GetNameSalt {

    public static void main(String[] args) {

        //加密方式
        String algorithmName = "md5";
        //盐（用户名+随机数）
        String salt1 = "zhangsan";
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        //原密码
        String password = "123456";
        //散列的次数
        int hashIterations = 1;
        //进行散列获取匹配值
        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);

        String encodedPassword = hash.toHex();

        System.out.println("这个是保存进数据库的密码:"+encodedPassword);

        System.out.println("这个是保存进数据库的盐:"+salt2);
    }
}
