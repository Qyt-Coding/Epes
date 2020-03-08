package com.gunners.epes.service;

import com.gunners.epes.entity.PrjTask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gunners
 * @since 2020-02-27
 */
public interface IPrjTaskService extends IService<PrjTask> {

    Integer countTaskNum(Integer prjId);

}
