package com.tuling.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库信息表
 */
@Data
public class BaikWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    // ID
    private Integer id;

    // 仓库名称
    private String warehouseName;

    // 仓库编码
    private String warehouseCode;

    // 地址
    private String addr;

    // 状态，0：已禁用，1：已启用
    private Integer state;

    // 详细地址
    private String addrDetail;

    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
