package cn.zhangly.shop.server;

import cn.zhangly.shop.base.BaseDao;

import javax.xml.ws.Endpoint;

/**
 * Created by zhangly on 2017/5/17.
 */
public class ShopServer {
    public static void main(String[] args) {
        String address = "http://localhost:7777/shop";
        Endpoint.publish(address, new BaseDao());
    }
}
