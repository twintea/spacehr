package com.twintea.spacehr.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.twintea.spacehr.mapper.EmployeeMapper;
import com.twintea.spacehr.model.*;
import com.twintea.spacehr.model.vo.EmployeeVo;
import com.twintea.spacehr.utils.GetSpecialPropertiesUtils;
import com.twintea.spacehr.model.*;
import org.springframework.beans.BeanUtils;

import java.util.List;


public class ExcelListener implements ReadListener<EmployeeVo> {

    private static final int BATCH_COUNT = 100;

    private EmployeeMapper employeeMapper;

    //获得所有的民族、职位、职称、政治面貌、所属部门
    private List<Nation> allNations = GetSpecialPropertiesUtils.getAllNations();;
    private List<Department> allDepts = GetSpecialPropertiesUtils.getAllDepts();;
    private List<Joblevel> allJoblevel = GetSpecialPropertiesUtils.getAllJoblevel();
    private List<Position> allPosition = GetSpecialPropertiesUtils.getAllPosition();;
    private List<Politicsstatus> allPoliticsstatus = GetSpecialPropertiesUtils.getAllPoliticsstatus();;

    /**
     * 缓存的数据
     */
    private List<EmployeeVo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private List<Employee> employeeList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    public ExcelListener(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public void savaData(){
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        Employee employee = new Employee();
        for (EmployeeVo empVo : cachedDataList) {
            BeanUtils.copyProperties(empVo, employee);
            //设置id为空
            employee.setId(null);
            //根据名称找出下标，然后找到对象的id，从而减少和数据库交互的次数
            int nationIndex = allNations.indexOf(new Nation(empVo.getNationName()));
            int deptIndex = allDepts.indexOf(new Department(empVo.getDepartmentName()));
            int jlIndex = allJoblevel.indexOf(new Joblevel(empVo.getJoblevelName()));
            int plIndex = allPoliticsstatus.indexOf(new Politicsstatus(empVo.getPoliticsstatusName()));
            int posIndex = allPosition.indexOf(new Position(empVo.getPositionName()));
            //TODO 判断下标是否为空
            employee.setNationId(allNations.get(nationIndex).getId());
            employee.setDepartmentId(allDepts.get(deptIndex).getId());
            employee.setJobLevelId(allJoblevel.get(jlIndex).getId());
            employee.setPoliticId(allPoliticsstatus.get(plIndex).getId());
            employee.setPosId(allPosition.get(posIndex).getId());
            employeeList.add(employee);
        }
        employeeMapper.insertBatch(employeeList);
    }

//        一行一行扫描
    @Override
    public void invoke(EmployeeVo employeeVo, AnalysisContext analysisContext) {
        cachedDataList.add(employeeVo);
        if (cachedDataList.size() >= BATCH_COUNT) {
            savaData();
            System.out.println("执行中------------" + employeeList);
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
            employeeList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        savaData();
        System.out.println("执行剩余的数量"+employeeList.size());
        System.out.println("执行完成后---------" + employeeList);
    }
}
