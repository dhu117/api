package com.dhu.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.dhu.api.model.ApiConfig;
import com.dhu.api.service.ApiConfigService;
import com.dhu.api.service.SysCodeService;
import com.dhu.common.ApiJsonResult;
import com.dhu.common.base.ApiBaseController;

@Controller
@RequestMapping(value = "/admin/api")
public class APIConfigController extends ApiBaseController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ApiConfigService apiConfigService;
	@Autowired
	SysCodeService sysCodeService;

	@ResponseBody
	@RequestMapping(value = "/{version}/{hostCode}")
	public Object apiRoute(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("version") String version, @PathVariable("hostCode") String hostCode) {
		ApiJsonResult result=ok();
		List<ApiConfig> apiConfig = apiConfigService.listApiConfigByParams(version);
		
		return result.put("data",apiConfig);
	}
}