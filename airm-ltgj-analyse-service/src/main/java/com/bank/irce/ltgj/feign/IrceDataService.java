package com.bank.irce.ltgj.feign;

import com.bank.irce.ltgj.entity.dto.ConfirmReadDto;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Api(tags = "科技部接口")
@Component
@FeignClient(name = "irce-data-service")
public interface IrceDataService {

    @PostMapping(value = "/externaldata/query")
    Map confirmRead(ConfirmReadDto param);

}
