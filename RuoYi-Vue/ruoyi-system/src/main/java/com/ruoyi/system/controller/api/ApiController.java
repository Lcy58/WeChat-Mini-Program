package com.ruoyi.system.controller.api;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.domain.TbWork;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ITbUserService;
import com.ruoyi.system.service.ITbWorkService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {

    @Autowired
    private ITbUserService userService;

    @Autowired
    private ITbWorkService workService;

    @Autowired
    private ISysDictDataService sysDictDataService;

    //AppID
    String appId = "wx761ce85619a10447";
    //密钥
    String secret= "ae8e5982f82aafd1c4ca5f61aba228b8";

    @GetMapping("/getCode")
    @Logger(name = "根据Code 获取微信信息")
    public AjaxResult getCode(String Code){
        if (StringUtils.isBlank(Code)) {
            return AjaxResult.error("没有code");
        }
        String openId = null;
        String session_key = null;
        TbUser tbUserReturn = new TbUser();
        /**
         *  是否有 openid
         *  有openid  就返回 用户信息
         *  没有openid 就 返回 openid 给前段， 前段  调用  getUserinfo  返回信息给  后端  保存到数据库
         */
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String params = "appid="+ appId +"&secret="+ secret +"&js_code="+ Code+"&grant_type=authorization_code";
            OutputStream os = conn.getOutputStream();
            os.write(params.getBytes());
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObject =  JSON.parseObject(response.toString());
            session_key = jsonObject.get("session_key").toString();
            openId = jsonObject.get("openid").toString();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        TbUser tbUser = new TbUser();
        tbUser.setOpenId(openId);
        List<TbUser> tbUsers = userService.selectTbUserList(tbUser);

        tbUserReturn.setOpenId(openId);

        if(tbUsers.size() > 0 && tbUsers.get(0).getUserName() != null){
            return AjaxResult.success(tbUsers.get(0));
        }else if(tbUsers.size() > 0 && tbUsers.get(0).getUserName() == null){
            return AjaxResult.success(tbUserReturn);
        }else if(tbUsers.size() == 0 ){
            return AjaxResult.success(tbUserReturn);
        }

        return  AjaxResult.error("error");
    }

    @PostMapping("/insUser")
    public AjaxResult insUser(@RequestBody TbUser tbUser){
        int i = userService.insertTbUser(tbUser);
        TbUser tbUserNew = userService.selectTbUserById(tbUser.getId());
        return AjaxResult.success(tbUserNew);
    }

    @PostMapping("/editUser")
    public AjaxResult editUser(@RequestBody TbUser tbUser){
        int i = userService.updateTbUser(tbUser);
        TbUser tbUserNew = userService.selectTbUserById(tbUser.getId());
        return AjaxResult.success(tbUserNew);
    }

    @GetMapping("/getDictData")
    public AjaxResult getDictData(String typeName){
        SysDictData dictData = new SysDictData();
        dictData.setDictType(typeName);
        List<SysDictData> sysDictData = sysDictDataService.selectDictDataList(dictData);
        return AjaxResult.success(sysDictData);
    }

    @GetMapping("/getWorkList")
    public AjaxResult getWorkList(String openId, int pageSizeApi, int pageNumApi){

        if(openId.equals("asd")){
            TbWork tbWork = new TbWork();
            tbWork.setPageSizeApi((pageSizeApi - 1) * pageNumApi);
            tbWork.setPageNumApi(pageNumApi);
            List<TbWork> tbWorks = workService.selectTbWorkListByApi(tbWork);
            return AjaxResult.success(tbWorks);
        }else{
//            有openId
            TbUser tbUser = new TbUser();
            tbUser.setOpenId(openId);
            List<TbUser> tbUsers = userService.selectTbUserList(tbUser);
//            用户信息
            TbUser user = tbUsers.get(0);
            TbWork tbWork = new TbWork();
            tbWork.setPageSizeApi((pageSizeApi - 1) * pageNumApi);
            tbWork.setPageNumApi(pageNumApi);
//            学历
            tbWork.setEducation(user.getEducation());
//            专业
            tbWork.setStudyMajor(user.getStudyMajor());
            List<TbWork> tbWorks = workService.selectTbWorkListByApi(tbWork);
            return AjaxResult.success(tbWorks);
        }
    }

    @PostMapping("/getSearchWorkList")
    public AjaxResult getSearchWorkList(@RequestBody TbWork tbWork){
        tbWork.setPageSizeApi((tbWork.getPageSizeApi() - 1) * tbWork.getPageNumApi());
        List<TbWork> tbWorks = workService.selectTbWorkListByApi(tbWork);
        return AjaxResult.success(tbWorks);
    }

    @GetMapping("/getWorkById")
    public AjaxResult getWorkById(Long id){
        TbWork tbWork = workService.selectTbWorkById(id);
        return AjaxResult.success(tbWork);
    }
}
