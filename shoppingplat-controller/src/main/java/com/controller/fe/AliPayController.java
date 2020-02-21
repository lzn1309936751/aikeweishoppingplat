package com.controller.fe;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.entity.fe.ProductEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lzn
 */
@Controller
public class AliPayController {
    private final String APP_ID = "2016101600702677";
    //pkcs8的秘钥格式
    private final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCZ0ze2PKgD4Ler31nWf4hNBnEK1T910/iLBgzvAte9KvOvb7m4+3XNm8HsSEB/oPG3p2BreCdyyE2B2iXnlfUV+As5O7cmWU6c02MdBCs+sLwMUKcIhaaeegPY4qcfetb+kK6s5A/4z5UL52RIFIr3sHdZ/5EqNmDaEQvVtW1PBXhjh5XcChDR0FwWCQKE3ZesnJeYHSL3UnmctmJ4sOivjr8aGDN1d/QxLp2MRynJRawhr9JAST4Pl2c3IRc3cPAuTafGNUYAVad6rfRJBU7IXa0uQiR8NoNwmeHgGPkPMGK/zyd10YvP0dSrynKahKXzLmc/oqRRS0bBuE8BfaiTAgMBAAECggEACv1F+6T1s+E3/fVk66gMysPtC4MUl4xfMz9paSHg28jXw+7Na+O7FMdN4V2ADh4nZqF0h/j7iH26284D6zmRWtJvqtUTTpAOx7FqYUZM+JuTs6WHaVpy/ttkrvfyTJNwDJu1fvCEG5ho44LSbTvaebuHq0xQyJ096hZRrCDcAEsdZYHKwViLLqLg91xgEP6+lvLlrlvGlIW9EmUjLJpl6zrokrI/2BrBy4Vcei/siG/LoMC2u6aRPd4d0k3H0Ty9v67B/AZrEIIvHbdeNWEFT1NdGzvfvly2rH1FXEQ70OCvmEXgnw4InRuBr8pcSGp4t2DcX4ed4Ds64atNevlnAQKBgQDI4RhC3ZzlaVttY+0h5iwnkawnNb6+qOW2eqb7k1GuuyhUKUlk12OupuZ0i6yUdGvLZVrZwaaymKQLgGL4lMlxjwKXcoWtu8B5VUVtYE86ukh59WoTpYsaniDTxdV4vtY+BkNiE5Em93ddmx6CToa2NNl43cizH9QG09kcqaVIwQKBgQDECMRjVbrkX0SCh9MUDRjpEZAQFU2b86SOMquxmYDFExVlfpillwwvU26LOlJCo62V6Cohs5nbYR1eGL8Y5KyUlFR8i6dVZr4Ze8WzmCilCm/w65X2QJwLCgc5irPp49g0M2VyqRPnkkARL0nX3kSElXTEXlo/f+wW3zVONqmSUwKBgQC4FqhgJq1xA8NYlTmsVj5iqLnmWPeLzEZvmylJ5bD2euezcP6knkrotGT/qzyl86cRh7nhUvlMNFwpeie4/Mk6+z75wWbGVwhFaSKt4JPbEvn2YjQq+wtmgkE9MdC2zdSSlLTNvXbJCgHm04/7BLGpavddL4qMtP9enmgaP1GMQQKBgQDD5MbrRPY31AOQNM53UQc9kHFXwRIG75fXCUeNeAm35fQRskoz3xcsC8GBm8wsD4gdLx07BFCRayB/sVb1Nz5GU1uCAcQ7kSoSKR9M8pZbJmzqYWE/7RyB44mItNRIu4iH0Xxk8hST6g/fnFO8Rb5Oh1NiD687mUeBK5gHCpS1RQKBgCkfR8tm332X4QmBy8wBMdZCmi/gJyAtm2EGu56AwAB4M3daz36EpsFsaKWUkbAj/jnxnR/bexIS+s7QZOtlmtj4UWR6DSilSnOG/8SZdlMzqeuJ5bXIz8CAlz/FjmFeaGdiHyqVl49tM2xZP9CO5D+k13C6e+ZoxIppGA6wyjEL";
    private final String CHARSET = "UTF-8";
    //支付宝公匙，不是应用公匙！！！
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoegVaHlrqvKFmUngqylc3DCt2v6coRf7KlMXp6TluXYnLimdEAZkdEFBwNLUpuN7Jr4IOjYbocCJixrJvtnV4/yEorvx+eGZd18tGISOK9IJJw9q2NDmycgJ2K5Fkc7AtpoNvqBUJ/ABXkuMsO21pEogmpA9KuyxhNDI2YSfltZPVo/RsRo7wqpDn7umMgJFji4IZSn/I64Q0WJ9TGBkzRDj8PTl1r+bcGggZoO5BZam7l1uhzLEDSA0lzPglS2/0W0H5jIok5bN0ljsMfTSV2MVb7N8e6o6a/PvIK/QkgLi5sb2EF+CBK3Kkh78BQ47i1y4P04g4eNRPotgAM5tgQIDAQAB";
    //沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://localhost:8080/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8080/returnUrl";

    @RequestMapping("/alipay")
    public void alipay(HttpServletResponse httpResponse, HttpSession session) throws IOException {
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL,
                APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY,
                SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        ProductEntity proInfos = (ProductEntity) session.getAttribute("proInfos");
        Double result = (Double) session.getAttribute("result");
        /**
         * 根据订单编号,查询订单相关信息
         * 商户订单号，商户网站订单系统中唯一订单号，必填
         * 通过正则表达式随机生成长度为10的订单编号
         * 随机数的长度；正则表达式的随机数
         */
        Integer codeLength = 10;
        String[] chars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String code = "2019";
        //循环获取随机数
        for (int i = 0; i < codeLength; i++) {
            String charIndex = String.valueOf((int) (Math.random() * chars.length));
            code += chars[Integer.parseInt(charIndex)];
        }
        String out_trade_no = code;
        //付款金额，必填
        String total_amount = String.valueOf(result);
        //订单名称，必填
        String subject = proInfos.getPro_name();
        //商品描述，可空
        String body = "";
        request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpSession session)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = (Map<String, String[]>) request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用

            //valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");

            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //查看参数都有哪些
        System.out.println(params);
        // 调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params,
                ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE);

        // 商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        if (signVerified) {

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            //支付成功，修复支付状态
            //跳转付款成功页面
            return "/successPay?code="+out_trade_no;
        } else {
            //跳转付款失败页面
            return "/failPay?code="+out_trade_no;
        }
    }

}
