package com.pangu.utils.encrypt.signature;

import com.pangu.utils.common.StringUtil;
import com.pangu.utils.enums.ResponseEnum;
import com.pangu.utils.http.R;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 验签工具总入口
 *      ---结合http请求对MD5Util、RSAUtil的再次封装
 * @author LZG
 * @date 2018/10/19
 */
public class VerifySignUtil {

    /**
     * @Description: md5加签
     * @param paramMap
     * @return void
     * @author LZG
     * @date 2018/11/19
     */
    public static void md5Sign(Map<String, Object> paramMap) {
        //一般从配置文件拿，或者从数据库拿，我这写在类里
        String md5SignKey = Md5SignUtil.md5SignKey;

        String paramJsonStr = LinkStrUtil.createLinkString(paramMap, true);
        String signInfo = Md5SignUtil.sign(paramJsonStr, md5SignKey);
        paramMap.put("signInfo", signInfo);
    }

    /**
     * @Description: md5验签
     * @param request
     * @return com.zhurong.utils.response.InfoCoinResponse 这里也可以用boolean接收
     * @author LZG
     * @date 2018/11/19
     */
    public static R md5Verify(HttpServletRequest request) {
        String md5SignKey = Md5SignUtil.md5SignKey;

        //签名验空
        String clientSignInfo = request.getParameter("signInfo");
        if (StringUtil.isBlank(clientSignInfo)) {
            return R.build(ResponseEnum.param_blank);
        }

        Map<String, Object> paraMap = new HashMap<String, Object>();

        //获取所有参数
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            if (paraName.equals("signInfo")) {
                continue;
            }

            paraMap.put(paraName, request.getParameter(paraName));

        }

        String paraJson = LinkStrUtil.createLinkString(paraMap, true);
        boolean verifyResult = Md5SignUtil.verify(paraJson, clientSignInfo, md5SignKey);

        if (!verifyResult) {
            return R.build(ResponseEnum.sign_fail);
        }
        return R.ok();
    }


}