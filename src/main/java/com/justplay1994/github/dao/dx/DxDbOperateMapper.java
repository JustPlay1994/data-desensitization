package com.justplay1994.github.dao.dx;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.justplay1994.github.dao
 * @Project: data-desensitization
 * @Creator: huangzezhou
 * @Create_Date: 2019/3/14 17:07
 * @Updater: huangzezhou
 * @Update_Date: 2019/3/14 17:07
 * @Update_Description: huangzezhou 补充
 * @Description:
 **/
public interface DxDbOperateMapper {

    List<HashMap> queryAllBYTableName(String tbName);
}
