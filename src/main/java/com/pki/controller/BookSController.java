package com.pki.controller;

import com.pki.entity.Cabook;
import com.pki.entity.User;
import com.pki.enums.CAState;
import com.pki.service.Impl.CABookService;
import com.pki.service.Impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author by twjitm on 2018/12/21/11:05
 */
@Controller
@RequestMapping("books")
public class BookSController extends BaseController {

    private static Logger logger= LoggerFactory.getLogger(BookSController.class);
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private CABookService cABookService;
    @Autowired
    private UserService userService;


    //-------该写证书的啦
    //普通用户申请证书
    @RequestMapping("apply")
    public String apply(HttpServletRequest request, Cabook cabook) {
        User user = getconcurrentUser(request);
        if (null == user) {
            logger.info("--------------null---------");
            return "login";
        } else {
            Date d = new Date();
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String url = f.format(d);
            String caUrl = "d:/" + user.getUName() + url + ".keystore";
            cabook.setCaUrl(caUrl);
            cABookService.Save(cabook);
            genkey(cabook);
            return "success";
        }
    }

    //普通用户默认查询
    @RequestMapping("selectdef")
    public String selectdef(HttpServletRequest request) {
        User user = getconcurrentUser(request);
        List<Cabook> list = cABookService.getBooKById(user.getUId());
        request.setAttribute("list", list);
        return "select";
    }

    private String caselecttype;

    //普通用户按状态查询
    @RequestMapping("select")
    public String select(HttpServletRequest request) {
        User user = getconcurrentUser(request);
        List<Cabook> list = cABookService.getBookByUId(user.getUId(), caselecttype);
        request.setAttribute("list", list);
        return "select";
    }


    //管理员条件查询证书
    @RequestMapping("adminquery")
    public List<Cabook> adminquery(HttpServletRequest request, String adcaState) {
        User user = getconcurrentUser(request);
        List<Cabook> list = new ArrayList<>();
        if (null == user) {
        } else {
            list = cABookService.getBookByStart(adcaState);
        }
        return list;
    }

    //管理员默认查询所有证书
    @RequestMapping("adminQueryNoParams")
    public String adminQueryNoParams(HttpServletRequest request) {
        User user = getconcurrentUser(request);
        if (null == user) {
            return "login";
        } else {
            List<Cabook> list = cABookService.getBookByStart();
            request.setAttribute("list", list);
            return "adminselect";
        }
    }

    //管理员查看证书详细信息
    @RequestMapping("adminselectCaInfor")
    public String adminselectCaInfor(HttpServletRequest request, Integer caBookId) {
        User user = getconcurrentUser(request);
        if (null == user) {
            return "login";
        } else {
            Cabook cabook = cABookService.getCaBookById(caBookId);
            request.setAttribute("cabook", cabook);
            return "cainfo";
        }
    }

    private Integer caBookId;

    //管理员签发证书
    @RequestMapping("adminsetCAbook")
    public String adminsetCAbook(HttpServletRequest request, Integer caBookId) {
        User user = getconcurrentUser(request);
        if (null == user) {
            return "login";
        } else {

            Cabook cabook = cABookService.getCaBookById(caBookId);
            System.out.println("------------>>" + cabook.getCaCn());

            export(cabook);
            return "getbookcar";
        }
    }

    //管理员删除证书
    @RequestMapping("deleteca")
    public String deleteca() {
        Cabook cabook = cABookService.getCaBookById(caBookId);
        java.io.File file = new java.io.File(cabook.getCaUrl());
        cABookService.delete(cabook);
        if (file.exists())
            file.delete();
        return "getbookcar";

    }


    //--------------证书下载
    @RequestMapping("getDownloadFile")
    public String getDownloadFile(HttpServletRequest request, HttpServletResponse response, Integer downCaBookId) {
        Cabook car = cABookService.getCaBookById(downCaBookId);
        String inputPath = car.getCaUrl();
        if (inputPath != null && !"".equals(inputPath)) {
            response.setHeader("content-disposition", "attachment;filename=certificate" + car.getCaC() + inputPath.substring(inputPath.indexOf("."), inputPath.length()));
            byte[] buf = new byte[1000];
            FileInputStream fos = null;
            try {
                String file = car.getCaUrl();
                fos = new FileInputStream(file);
                ServletOutputStream out = response.getOutputStream();
                while (fos.read(buf) != -1) {
                    out.write(buf);
                }
                response.flushBuffer();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (Exception f) {
                }
            }
        } else {
            try {
                String message = "还没有上传文件";
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.write(message);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //--------------------

    /**
     * 生成密钥
     */
    public void genkey(Cabook cabook) {
        String[] arstringCommand = new String[]{
                "cmd ", "/k",
                "start", // cmd Shell命令
                "G:\\java\\jdk1.8.0_91\\bin\\keytool",
                "-genkey", // -genkey表示生成密钥
                "-validity", // -validity指定证书有效期(单位：天)，这里是36500天
                "36500",
                "-keysize",//     指定密钥长度
                "1024",
                "-alias", // -alias指定别名，这里是ss
                "ss",
                "-keyalg", // -keyalg 指定密钥的算法 (如 RSA DSA（如果不指定默认采用DSA）)
                "RSA",
                "-keystore", // -keystore指定存储位置，这里是d:/demo.keystore
                cabook.getCaUrl(),
                "-dname",// CN=(名字与姓氏), OU=(组织单位名称), O=(组织名称), L=(城市或区域名称),
                // ST=(州或省份名称), C=(单位的两字母国家代码)"
                "CN=(" + cabook.getCaCn() + "), OU=(" + cabook.getCaOu() + "), O=(" + cabook.getCaO() + "), L=(" + cabook.getCaL() + "),ST=("
                        + cabook.getCaSt() + "), C=(" + cabook.getCaC() + ")",
                "-storepass", // 指定密钥库的密码(获取keystore信息所需的密码)
                "123456",
                "-keypass",// 指定别名条目的密码(私钥的密码)
                cabook.getCaKeypass(),
                "-v"// -v 显示密钥库中的证书详细信息
        };

        execCommand(arstringCommand);
    }

    /**
     * 管理员 导出证书文件
     */
    public void export(Cabook cabook) {
        User user = userService.getUserById(cabook.getUId());
        String url = "d:/" + user.getUName() + cabook.getCaId() + ".cer";
        String[] arstringCommand = new String[]{

                "cmd ", "/k",
                "start", // cmd Shell命令
                "G:\\java\\jdk1.8.0_91\\bin\\keytool",
                "-export", // - export指定为导出操作
                "-keystore", // -keystore指定keystore文件，这里是d:/demo.keystore
                cabook.getCaUrl(),
                "-alias", // -alias指定别名，这里是ss
                "ss",
                "-file",//-file指向导出路径
                "d:/" + user.getUName() + cabook.getCaId() + ".cer",
                "-storepass",// 指定密钥库的密码
                "123456"
        };
        execCommand(arstringCommand);
        cabook.setCaStart(CAState.PASS.getDiscribe());
        cabook.setCaUrl(url);
        cABookService.updata(cabook);

    }

    public void execCommand(String[] arstringCommand) {
        for (int i = 0; i < arstringCommand.length; i++) {
            System.out.print(arstringCommand[i] + " ");
        }
        try {
            Runtime.getRuntime().exec(arstringCommand);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
