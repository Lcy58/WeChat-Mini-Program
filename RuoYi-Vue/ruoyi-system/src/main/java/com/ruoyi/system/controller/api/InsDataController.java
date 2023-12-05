package com.ruoyi.system.controller.api;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.system.domain.TbWork;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ITbWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/insData")
public class InsDataController {

    @Autowired
    private ITbWorkService workService;

    @Autowired
    private ISysDictDataService sysDictDataService;

//    Nodejs
    String rz1 = "1、计算机相关专业，本科以上学历\n" +
        "2、熟悉操作系统原理、编译原理、数据库原理\n" +
        "3、熟悉多种开发语言，诸如C、C++、Java、Nodejs、Go等\n" +
        "4、有多种平台程序开发、调试经验（Linux、Windows）\n" +
        "5、能快速学习新的开发语言并上手工作\n" +
        "6、开发作品不限于网站、手机微信程序；开发过自动化程序、接口程序\n" +
        "7、熟悉Redis、MongoDB、Rabbitmq相关API及协议，有相关开发经验\n" +
        "8、有不依赖于IDE的程序调试经验\n" +
        "9、英文阅读水平良好\n" +
        "10、书面表达能力良好";

    String rz2 = "1、3年以上互联网开发经验，对微服务架构有深入了解。\n" +
            "2、出色的编码能力，精通Node.js，熟悉常用的算法，熟悉开源框架，解决问题能力强。\n" +
            "3、对后端程序性能优化有丰富经验。\n" +
            "4、掌握MongoDB、Redis、ES等存储系统原理及应用。\n" +
            "5、对Http协议有深刻的理解，熟悉TCP/IP等网络协议。\n" +
            "6、对分布式计算、分布式存储的架构设计原理有一定理解。\n" +
            "7、熟悉一门后端语言，比如Java/Go等。";

    String rz3 = "1. 本科及以上学历，基础扎实，有2年以上前端开发经验；\n" +
            "\n" +
            "2. 精通javascript（ES5/6）、CSS，Html5等Web前端技术；\n" +
            "\n" +
            "3. 熟练使用vue，并对vue核心原理有较深理解，熟练使用element-ui框架；\n" +
            "\n" +
            "4. 精通nodejs、npm、webpack 等前端工具；\n" +
            "\n" +
            "5. 熟悉http协议，掌握前端调试、性能优化、web安全、工程化等前端技术；\n" +
            "\n" +
            "6．了解后端技术栈,熟悉JAVA语言，熟悉与后端的协作模式，熟练使用SQL语言；\n" +
            "\n" +
            "7．热爱技术，积极主动,认真负责,具有良好的沟通和团队协作能力，以及高度的责任感。";

    String rz4 = "1、3年以上前端开发经验；\n" +
            "2、熟练掌握html5/es6/es7/css3新特性；\n" +
            "3、对Vue、React、jquery、 Bootstrap等技术和框架能熟练运用且深入理解，尤其精通VUE；\n" +
            "4、精通 Web 应用的性能优化，监控，分析方法；\n" +
            "5、掌握前端自动化工具webpack、gulp等，熟悉nodejs;\n" +
            "6、熟悉混合APP开发模式，能协同app研发人员进行jsbridge的设计、开发；\n" +
            "7、深度理解Web标准、浏览器特性及原理，对数据结构、网络编程等技术有扎实掌握\n" +
            "8、熟练掌握 Webpack / Grunt / Gulp 等构建工具的使用和配置，熟悉前端工程化与模块化开发并有丰富的实践经验\n" +
            "9、工具工程化、nodejs 服务、虚拟机引擎等任一项有深入掌握者加分;\n" +
            "10、掌握微信小程序的开发框架及技术，有2款或2款以上的小程序的项目研发经验。";

    String rz5 = "1、统招学信网本科学历相关从业年限不低于5年，计算机相关专业；研究生学历相关从业年限不低于3年，计算机相关专业；\n" +
            "2、熟悉angularJS和java语言；\n" +
            "3、具有大、中型项目经验，并需要在一定的技术领域有较为深入的研究；\n" +
            "4、熟练掌握至少一种开发语言，能根据需求和设计文档完成复杂功能模块的编码工作。并能走查和修改其他工程师编写的代码；\n" +
            "5、能够承担较复杂的工作任务；\n" +
            "6、敬业精神强，能够较好履行岗位职责。";

    @CrossOrigin
    @PostMapping("/zlzp")
    public AjaxResult insZlzp(@RequestBody List<Zlzp> list){
        SysDictData dictData = new SysDictData();
        dictData.setDictType("tb_education");
        List<SysDictData> sysDictData = sysDictDataService.selectDictDataList(dictData);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getSalary().indexOf("薪") != -1
                    || list.get(i).getSalary().indexOf("元/") != -1
                    || list.get(i).getSalary().indexOf("/天") != -1
                    || list.get(i).getSalary().indexOf("/月") != -1
                    || list.get(i).getSalary().indexOf("面议") != -1
            ){
                continue;
            }
            for (int j = 0; j < sysDictData.size(); j++) {
                if(sysDictData.get(j).getDictLabel().equals(list.get(i).getEduLevel())){
                    TbWork tbWork = new TbWork();
                    tbWork.setCompanyName(list.get(i).getCompany());
                    tbWork.setJobTitle(list.get(i).getJobTitle());
                    tbWork.setEducation(Long.valueOf(sysDictData.get(j).getDictValue()));
////                    专业  -- 记住重启服务
                    tbWork.setStudyMajor(7L);
                    if(list.get(i).getJobYear().equals("不限") || list.get(i).getJobYear().indexOf("以下") != -1 || list.get(i).getJobYear().indexOf("无经验") != -1){
                        tbWork.setWorkTimeStart(1L);
                        tbWork.setWorkTimeEnd(3L);
                    }else{
                        String jobYear = list.get(i).getJobYear().replace("年", "");
                        String[] split = jobYear.split("-");
                        tbWork.setWorkTimeStart(Long.valueOf(split[0]));
                        tbWork.setWorkTimeEnd(Long.valueOf(split[1]));
                    }

                    tbWork.setWorkPlace(list.get(i).getLocation());
                    //薪资要求

                    String[] salary = list.get(i).getSalary().split("-");
                    tbWork.setWagesStart(changeWage(salary[0]));
                    tbWork.setWagesEnd(changeWage(salary[1]));
                    tbWork.setHrImg(list.get(i).getHrImg());
                    tbWork.setSourceWebsite(0L);
                    tbWork.setUseRequire(useRequireInfo());
                    int i1 = workService.insertTbWork(tbWork);
                    break;
                }
            }
        }
        return AjaxResult.success();
    }

    public Long changeWage(String wage){
        if(wage.indexOf("千") != -1){
            Long s = Long.valueOf(wage.replace("千", "")) * 1000;
            return s;
        }else{
            Long s = (long)(Double.parseDouble(wage.replace("万", "")) * 10000);
            return s;
        }
    }

    public String useRequireInfo(){

        // Create a Random object
        Random random = new Random();

        // Generate a random number between 1 and 5 (inclusive)
        int randomNumber = random.nextInt(5) + 1;

        if(randomNumber == 1){
            return rz1;
        }else if(randomNumber == 2){
            return rz2;
        }else if(randomNumber == 3){
            return rz3;
        }else if(randomNumber == 4){
            return rz4;
        }else if(randomNumber == 5){
            return rz5;
        }
        return rz3;
    }

}
