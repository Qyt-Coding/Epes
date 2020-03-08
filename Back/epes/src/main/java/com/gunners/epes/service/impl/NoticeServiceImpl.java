package com.gunners.epes.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gunners.epes.entity.Employee;
import com.gunners.epes.entity.Notice;
import com.gunners.epes.entity.vo.NoticeVo;
import com.gunners.epes.mapper.NoticeMapper;
import com.gunners.epes.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jodd.time.TimeUtil;
import org.mockito.internal.matchers.Not;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gunners
 * @since 2020-02-27
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Override
    public List<Notice> listNotice(NoticeVo noticeVo) {
        QueryWrapper queryWrapper = new QueryWrapper<Notice>();
        queryWrapper.orderByDesc("nt_id");
        queryWrapper.like("title", Objects.isNull(noticeVo.getTitle()) ? "" : noticeVo.getTitle());
        Page page = new Page(noticeVo.getPage(), noticeVo.getSize());
        IPage<Notice> noticePage = this.page(page, queryWrapper);
        List<Notice> list = noticePage.getRecords();
        return list;
    }
}
