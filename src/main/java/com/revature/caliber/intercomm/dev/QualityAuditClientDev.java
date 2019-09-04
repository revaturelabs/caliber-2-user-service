package com.revature.caliber.intercomm.dev;

import com.revature.caliber.intercomm.base.QualityAuditClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 * 8/21/2019
 */
@Profile("dev")
@FeignClient(name = "quality-audit-service", url = "http://quality-audit.caliber-2-dev")
public interface QualityAuditClientDev extends QualityAuditClient {
}
