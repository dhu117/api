package com.dhu.api.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.dhu.api.enums.SysCodeType;
import com.dhu.api.model.ApiConfig;
import com.dhu.api.service.ApiConfigService;
import com.dhu.api.service.SysCodeService;
import com.dhu.common.ApiJsonResult;
import com.dhu.common.base.ApiBaseController;
import com.dhu.common.util.StringUtil;
/**
 * 路由控制
 * @author lizehua
 *
 */
@Controller
@RequestMapping(value = "/api")
public class APIRouteController extends ApiBaseController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ApiConfigService apiConfigService;
	@Autowired
	SysCodeService sysCodeService;

	@ResponseBody
	@RequestMapping(value = "/{version}/{hostCode}/{apiPath}")
	public Object apiRoute(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("version") String version, @PathVariable("hostCode") String hostCode,
			@PathVariable("apiPath") String apiPath) {
		ApiConfig apiConfig = apiConfigService.getApiConfigByParams(version, hostCode, apiPath);
		if (apiConfig == null) {
			return fail(ApiJsonResult.ERRNO_NOT_FIND, "未找到接口");
		}
		Map<String, Object> hostMap = sysCodeService.getHostMap(SysCodeType.HOST.name().toLowerCase());
		String remoteHost = hostMap.get(apiConfig.getHostCode()).toString();
		String remoteApiUrl = remoteHost + "/" + apiConfig.getHostRestApi();
		StringBuffer paramBuffer=new StringBuffer("");
		if(request.getParameterMap()!=null&&request.getParameterMap().size()>0){
			Iterator entries=request.getParameterMap().entrySet().iterator();
			while(entries.hasNext()){
				Map.Entry<String,String[]> entry=(Entry<String,String[]>) entries.next();
				paramBuffer.append('&');
				paramBuffer.append(entry.getKey()+"="+entry.getValue()[0]);
			}
			paramBuffer.replace(0, 1, "?");
		}
		remoteApiUrl+=paramBuffer.toString();
		try {
			if (StringUtil.equals(HttpMethod.GET.name(), apiConfig.getRequestMethod())) {
				return restTemplate.getForObject(remoteApiUrl, Object.class);
			} else {
				return restTemplate.postForObject(remoteApiUrl, null, Object.class);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return fail(ApiJsonResult.ERRNO_EXCEPTION, "接口请求异常");
	}
}
