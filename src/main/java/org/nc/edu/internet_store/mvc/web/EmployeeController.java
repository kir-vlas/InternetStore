package org.nc.edu.internet_store.mvc.web;


import org.nc.edu.internet_store.mvc.domain.Order;
import org.nc.edu.internet_store.mvc.service.OrderService;
import org.nc.edu.internet_store.mvc.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/employee")
    public String employeeIndex(HttpServletRequest request, Map<String, Object> map){
        map.put("orders", orderService.listOrders());
        return "/viewEmployee";
    }

    @RequestMapping("/employee/order")
    public String orderDetails(@RequestParam(value = "id", defaultValue = "0") Integer id, Map<String,Object> map){
        map.put("OrderLines", orderService.listOrderLines(id));
        map.put("statuses", Order.getStatusesList());
        map.put("selectedStatus", new Status());
        return "/viewEmployeeOrderDetails";
    }

    @RequestMapping(value = "/employee/order/changestatus", method = RequestMethod.POST)
    public String orderChangeStatus(@ModelAttribute("selectedStatus") Status status){
        String[] statuses = Order.getStatusesList();
        Integer code = 0;
        for (int i=0;i<statuses.length;i++){
            if (statuses[i].equals(status.getStatus())) {
                code = i;
                break;
            }
        }
        orderService.changeStatus(status.getOrderId(),code);
        return "redirect:/employee/order?id=" + status.getOrderId().toString();
    }
}
