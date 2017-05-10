package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.Classification;
import cn.zhangly.shop.model.Commodity;
import cn.zhangly.shop.model.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangly on 2017/5/8.
 */
@Controller
@Scope("prototype")
@RequestMapping("/classification")
public class ClassificationAction extends BaseAction {

    @RequestMapping("/commoditylist")
    public String commodityList(HttpServletRequest request, int pageNum, Long classId) {
        int pageSize = 4;
        if (pageNum <= 0) pageNum = 1;
        PageBean<Commodity> pageBean = commodityService.getCommodity(pageNum, pageSize, classId);
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("classId", classId);
        return "classification";
    }

}
