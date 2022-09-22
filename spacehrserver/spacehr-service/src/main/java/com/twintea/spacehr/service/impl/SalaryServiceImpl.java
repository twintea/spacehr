package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.model.Salary;
import com.twintea.spacehr.service.SalaryService;
import com.twintea.spacehr.mapper.SalaryMapper;
import org.springframework.stereotype.Service;

/**
* @author Pixar
* @description 针对表【salary】的数据库操作Service实现
* @createDate 2022-06-22 00:42:40
*/
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary>
    implements SalaryService{

}




