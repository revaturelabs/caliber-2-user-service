package com.revature.caliber.intercomm.perf;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 */
@Profile("perf")
@FeignClient(name = "quality-audit-service", url = "http://qa.caliber-2-perf")
public interface QualityAuditClientPerf {
}
