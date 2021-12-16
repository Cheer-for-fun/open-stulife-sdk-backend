package com.alibaba.mapper;
/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/11/30 20:58
 */

import com.alibaba.bean.CsdnDownload;
import org.apache.ibatis.annotations.Param;

public interface DownloadMapper {

    int download(@Param("download") CsdnDownload download);

}
