package com.example.bookstoreall.poje;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    //private Integer totalCount;
    //private BigDecimal totalPrice;

    // key 编号 value 商品信息
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();


    /*
     * 添加数量
     * */
    public void addItem(CartItem cartItem) {
        //先查看购无车是否有这个商品
        //有的话数量累加 总金额更新 没有的话 直接放到集合种就可以
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            //未添加
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);// 数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }

    }

    public void deleteItem(Integer id) {
        items.remove(id);

    }

    /*
     * 清空购车
     * */
    public void clear() {
        items.clear();

    }

    public void updateCount(Integer id, Integer count) {
//先查看集合种是否有这个数量
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }


    public Integer getTotalCount() {
        Integer totalCount=0;
        for(Map.Entry<Integer,CartItem>entry: items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
       BigDecimal totalPrice=new BigDecimal(0);
        for(Map.Entry<Integer,CartItem>entry: items.entrySet()){
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice()+
                ", items=" + items +
                '}';
    }
}
