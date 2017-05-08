package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.Commodity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangly on 2017/5/8.
 */
@Controller
@Scope("prototype")
@RequestMapping("/classification")
public class ClassificationAction extends BaseAction {

    @RequestMapping("/commoditylist")
    public String commodityList(HttpServletRequest request, Long classId) {
        List<Commodity> commodityList = commodityService.findByClassId(classId);
        request.setAttribute("commodityList", commodityList);
        return "classification";
    }

}
