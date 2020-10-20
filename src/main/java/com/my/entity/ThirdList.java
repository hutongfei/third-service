package com.my.entity;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hutf
 * @createTime 2020年10月18日 09:54:00
 */
public class ThirdList {

    @Valid
    private List<ThirdInfo> dataList ;

    public List<ThirdInfo> getDataList() {
        return dataList;
    }

    public void setDataList(List<ThirdInfo> dataList) {
        this.dataList = dataList;
    }
}
