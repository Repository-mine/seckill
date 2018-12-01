package com.seckill.controller;

import com.seckill.redis.RedisService;
import com.seckill.result.Result;
import com.seckill.service.MiaoshaUserService;
import com.seckill.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;



@Controller
@Slf4j
@RequestMapping("/login")
public class LoginController {

//	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    MiaoshaUserService userService;
	
	@Autowired
    RedisService redisService;
	
    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }
    
    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
    	log.info(loginVo.toString());
    	//登录
        //d3b1294a61a07da9b49b6e22b2cbd7f9
    	userService.login(response, loginVo);
    	return Result.success(true);
    }
}
