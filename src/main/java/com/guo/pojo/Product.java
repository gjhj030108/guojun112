package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Integer id;
    private String name;      // 产品名称
    private Double rate;      // 年化利率
    private Double amount;    // 募集总金额
    private Double raised;    // 已募集金额
    private Integer cycle;    // 产品周期
    private String endTime;   // 募集结束日期

    public void setId(Integer id) {
        this.id = id;
    }
}
