package com.twintea.spacehr.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.twintea.spacehr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class GetSpecialPropertiesUtils {


    //获得所有的民族、职位、职称、政治面貌、所属部门
    private static GetSpecialPropertiesUtils getSpecialPropertiesUtils;
    @Autowired
    private com.twintea.spacehr.mapper.NationMapper nationMapper;
    @Autowired
    private com.twintea.spacehr.mapper.PositionMapper positionMapper;
    @Autowired
    private com.twintea.spacehr.mapper.JoblevelMapper joblevelMapper;
    @Autowired
    private com.twintea.spacehr.mapper.DepartmentMapper departmentMapper;
    @Autowired
    private com.twintea.spacehr.mapper.PoliticsstatusMapper politicsstatusMapper;

    @PostConstruct
    public void init(){
        getSpecialPropertiesUtils = this;
        getSpecialPropertiesUtils.nationMapper = this.nationMapper;
        getSpecialPropertiesUtils.positionMapper = this.positionMapper;
        getSpecialPropertiesUtils.politicsstatusMapper = this.politicsstatusMapper;
        getSpecialPropertiesUtils.departmentMapper = this.departmentMapper;
        getSpecialPropertiesUtils.joblevelMapper = this.joblevelMapper;
    }

    public static List<com.twintea.spacehr.model.Nation> getAllNations() {
        return getSpecialPropertiesUtils.nationMapper.selectList(new QueryWrapper<>());
    }

    public static List<Position> getAllPosition() {
        return getSpecialPropertiesUtils.positionMapper.selectList(new QueryWrapper<>());
    }

    public static List<com.twintea.spacehr.model.Joblevel> getAllJoblevel() {
        return getSpecialPropertiesUtils.joblevelMapper.selectList(new QueryWrapper<>());
    }

    public static List<com.twintea.spacehr.model.Department> getAllDepts() {
        return getSpecialPropertiesUtils.departmentMapper.selectList(new QueryWrapper<>());
    }

    public static List<com.twintea.spacehr.model.Politicsstatus> getAllPoliticsstatus() {
        return getSpecialPropertiesUtils.politicsstatusMapper.selectList(new QueryWrapper<>());
    }
}
