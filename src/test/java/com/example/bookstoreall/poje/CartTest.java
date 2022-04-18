package com.example.bookstoreall.poje;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"真的是最大的傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"真的是最大的傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"真的是最大的傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.clear();
        System.out.println(cart);

    }

    @Test
    public void updateCount() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"真的是傻逼",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.updateCount(1,1000);
        System.out.println(cart);
    }
}