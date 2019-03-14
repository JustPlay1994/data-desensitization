package com.justplay1994.github.dao.dx;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.justplay1994.github.dao
 * @Project: data-desensitization
 * @Creator: huangzezhou
 * @Create_Date: 2019/3/14 17:14
 * @Updater: huangzezhou
 * @Update_Date: 2019/3/14 17:14
 * @Update_Description: huangzezhou 补充
 * @Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DxDbOperateMapperTest {

    @Autowired
    DxDbOperateMapper dxDbOperateMapper;

    @Test
    public void test(){
        List<HashMap> list = dxDbOperateMapper.test();
        System.out.println();
    }

}
