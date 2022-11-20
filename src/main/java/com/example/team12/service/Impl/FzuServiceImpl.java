package com.example.team12.service.Impl;

import com.example.team12.bean.fzumap;
import com.example.team12.dao.FzuMapper;
import com.example.team12.service.FzuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public List<fzumap> user_show() {

        return  fzuMapper.user_show();
    }

    @Override
    public void updatedate(Map map) {
         fzuMapper.updatedate((String)map.get("address"),(String) map.get("activity_name"));
    }
}
