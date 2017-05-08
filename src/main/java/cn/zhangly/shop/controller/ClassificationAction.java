package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.Classification;
import cn.zhangly.shop.model.Commodity;
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
    public String commodityList(HttpServletRequest request, Long classId) {
        Set<Commodity> commoditySet = new HashSet<Commodity>();
        // 准备商品列表
        Classification byId = classificationService.findById(classId);
        // 查询本级
        List<Commodity> commodityList = commodityService.findByClassId(classId);
        commoditySet.addAll(commodityList);
        // 查询子级
        for (Classification classification : byId.getChildren()){
            List<Commodity> byClassId = commodityService.findByClassId(classification.getId());
            if (byClassId != null && byClassId.size() > 0) commoditySet.addAll(byClassId);
        }
        request.setAttribute("commodityList", new ArrayList<Commodity>(commoditySet));
        return "classification";
    }

}
