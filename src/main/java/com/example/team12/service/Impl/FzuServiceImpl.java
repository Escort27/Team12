package com.example.team12.service.Impl;

import com.example.team12.bean.fzumap;
import com.example.team12.dao.FzuMapper;
import com.example.team12.service.FzuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cr
 * &#064;date   2022/11/11
 * UserService的具体实现类
 */
@Service
public class FzuServiceImpl implements FzuService {
    //@Resource或者@Autowired注解都可
    @Resource
    //@Autowired
    private FzuMapper fzuMapper;

    @Override
    public String user_show(String address) {

        return  fzuMapper.user_show(address);
    }

    @Override
    public int updatedate(String address,String activity_name) {
        return fzuMapper.updatedate(address,activity_name);
    }
}
