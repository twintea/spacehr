package com.twintea.spacehr.service;

import com.twintea.spacehr.Resp.RespBean;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    RespBean upload(MultipartFile file);
}
