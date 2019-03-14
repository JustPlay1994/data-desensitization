package com.justplay1994.github.dao.ft;

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
public interface FtDbOperateMapper {

    List<HashMap> queryAllByTableName(String tbName);
}
