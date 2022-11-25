package com.Team12.YQdemo.service;

import com.Team12.YQdemo.bean.fzumap;

import java.util.List;
import java.util.Map;

/**
 * @author cr
 * &#064;date   2022/11/11
 */
public interface FzuService {
    List<fzumap> user_show();
    void updatedate(Map map);
}
