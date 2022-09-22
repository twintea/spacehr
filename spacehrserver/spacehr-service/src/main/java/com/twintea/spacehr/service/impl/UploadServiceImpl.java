package com.twintea.spacehr.service.impl;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.service.UploadService;
import com.twintea.spacehr.utils.OssPathUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
//@ConfigurationProperties(prefix = "qiniu")
public class UploadServiceImpl implements UploadService {
    private String accessKey="DeUnKc0owd9yJRZd0axw6xuhx9ypGI5x01Z521UN";
    private String secretKey="7vnBHPs3p2883mHxGjS11rBxQ6wfFSiylgjeZ-jp";
    private String bucket="twintee";
    @Override
    public RespBean upload(MultipartFile file) {
        //判断文件类型 只能上传png格式
        if (!file.getOriginalFilename().endsWith(".png")){
            return RespBean.error("请上传png格式的图片！");
        }
        //如果文件类型通过，上传文件
        String filePath = OssPathUtils.generateFilePath(file.getOriginalFilename());
        String url = qiNiuUpload(file,filePath);
        return RespBean.ok(null,url);
    }
    public String qiNiuUpload(MultipartFile file,String filePath) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);

//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath;

        String url = "http://pic.hungrycloud.space/"+key;
        try {
            InputStream inputStream = file.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(inputStream, key, upToken, null, null);
                //解析上传成功的结果
//                DefaultPutRet putRet = new Gson.fromJson(response.bodyString(), DefaultPutRet.class);
//                System.out.println(putRet.key);
//                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return url;
    }
}
