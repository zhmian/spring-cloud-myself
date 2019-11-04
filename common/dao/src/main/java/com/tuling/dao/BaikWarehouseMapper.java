package com.tuling.dao;

import com.tuling.entity.BaikWarehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BaikWarehouseMapper {

    @Select("select * from baik_warehouse_info where id = ${id}")
    BaikWarehouse getBaikWarehouseById(Integer id);

}
