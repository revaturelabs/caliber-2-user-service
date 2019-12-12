package com.revature.caliber.intercomm.perf;

import com.revature.caliber.intercomm.base.QualityAuditClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 */
@Profile("perf")
@FeignClient(name = "quality-audit-service", url = "${client.url}")
public interface QualityAuditClientPerf extends QualityAuditClient {
}
