package com.swn.main.rest;

import com.swn.main.property.PropertyInfo;
import com.swn.main.property.supplier.StringPropertySupplierImpl;
import com.swn.main.resourceextractor.ResourceExtractor;
import com.swn.main.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RollController {

    @Autowired ResourceExtractor resourceExtractor;

    @PostMapping("/roll/table")
    @ResponseBody
    public ResponseEntity<PropertyInfo> rollTable(@RequestBody Table table) {
        return ResponseEntity.ok(new StringPropertySupplierImpl(resourceExtractor) {
            @Override
            public String getStringToBeMapped() {
                return table.tableValues();
            }

            @Override
            protected String getName() {
                return table.name();
            }
        }.getPropertyInfo());
    }
}
