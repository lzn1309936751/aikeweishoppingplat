package com.controller.fe;

import com.entity.fe.AddressEntity;
import com.entity.fe.ReceiptEntity;
import com.entity.fe.UserEntity;
import com.service.fe.AddressService;
import com.service.fe.ReceiptService;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lzn
 */
@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private ReceiptService receiptService;

    /**
     * 新增收货地址
     */
    @RequestMapping("/insertReceipt")
    @ResponseBody
    public RequestVo insertReceipt(String person,String phone, String detail,
                                   String provinceId,String cityId,String countId,
                                   String status,HttpSession session){
        UserEntity user = (UserEntity) session.getAttribute("userinfo");
        System.out.println("provinceId = " + provinceId);
        RequestVo vo =RequestVo.builder().code("200").data("ok").build();
        AddressEntity province=addressService.getAddressName(provinceId);
        System.out.println("---------------"+province.getAddress_name());
        AddressEntity city=addressService.getAddressName(cityId);
        System.out.println("---------------"+city.getAddress_name());
        AddressEntity count=addressService.getAddressName(countId);
        System.out.println("---------------"+count.getAddress_name());

        Integer s=0;
        if("是".equals(status)){
            s=1;
        }

        ReceiptEntity receipts=new ReceiptEntity();
        receipts.setReceipt_name(person);
        receipts.setReceipt_phone(phone);
        receipts.setProvince_id(province.getAddress_name());
        receipts.setCity_id(city.getAddress_name());
        receipts.setCounty_id(count.getAddress_name());
        receipts.setReceipt_detail(detail);
        receipts.setReceipt_bit(s);
        receipts.setUser_id(user.getUser_id());
        receiptService.insert(receipts);

        return vo;
    }


    @RequestMapping("/getProvince")
    @ResponseBody
    public Object getProvince(String parentId){
        List<AddressEntity> province = addressService.getProvince(parentId);
        return province;
    }

    @RequestMapping("/getCity")
    @ResponseBody
    public Object getCity(String parentId){
        List<AddressEntity> city = addressService.getCity(parentId);
        return city;
    }

    @RequestMapping("/getCount")
    @ResponseBody
    public Object getCount(String parentId){
        List<AddressEntity> count = addressService.getCount(parentId);
        return count;
    }
}
