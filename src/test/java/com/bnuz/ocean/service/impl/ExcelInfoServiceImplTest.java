package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.ExcelInfo;
import com.bnuz.ocean.service.ExcelInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelInfoServiceImplTest {

    @Autowired
    private ExcelInfoService excelInfoService;

    @Test
    public void getExcelInfo() {
        List<ExcelInfo> excelInfo = excelInfoService.getExcelInfo("25");
        assertNotNull(excelInfo);
    }
}