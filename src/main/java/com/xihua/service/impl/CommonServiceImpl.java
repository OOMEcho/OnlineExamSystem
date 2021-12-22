package com.xihua.service.impl;

import com.xihua.dao.CommonDao;
import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.service.CommonService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/22 10:56
 * Description: 公共业务实现层
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

    @Transactional
    @Override
    public JsonResult addExamPaper(List<ExamPaperDTO> examPaperDTO) {
        int insert = commonDao.addExamPaper(examPaperDTO);
        if (insert == 0) {
            return JsonResult.error("添加失败");
        }
        return JsonResult.success("添加成功");
    }
}
