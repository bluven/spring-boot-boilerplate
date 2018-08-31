package com.github.bluven.demo.controller;

import com.github.bluven.demo.vo.CredentialVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Api("身份验证")
public class AuthController {

    @ApiOperation("验证用户身份，获取token")
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public Map<String, Object> token(@RequestBody CredentialVO credentialVO) {
        return new HashMap<>();
    }

    @ApiOperation("检验权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @RequestMapping(value = "/check-permission", method = RequestMethod.GET)
    public Boolean checkPermission(@RequestParam Integer userId) {
        return true;
    }
}
