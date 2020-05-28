/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2019. All rights reserved.
 */
package org.randy.domain.user.root;

/**
 * 地址值对象
 * 
 * @author x00418543
 * @since 2019年12月18日
 */
public class Address {

    private final String country;

    private final String city;

    Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

}
