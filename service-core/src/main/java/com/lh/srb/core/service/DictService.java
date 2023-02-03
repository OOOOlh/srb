package com.lh.srb.core.service;

import com.alibaba.excel.EasyExcel;
import com.lh.srb.core.listener.ExcelDictDTOListener;
import com.lh.srb.core.pojo.dto.ExcelDictDTO;
import com.lh.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author Helen
 * @since 2022-04-30
 */
@Service
public interface DictService extends IService<Dict>{
    void importData(InputStream inputStream);
    List<ExcelDictDTO> listDictData();
    List<Dict> listByParentId(Long parentId);
}
