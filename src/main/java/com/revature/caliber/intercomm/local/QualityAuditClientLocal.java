package com.revature.caliber.intercomm.local;

import com.revature.caliber.intercomm.base.QualityAuditClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 * 8/21/2019
 */
@Profile("local")
@FeignClient(name = "quality-audit-service")
public interface QualityAuditClientLocal extends QualityAuditClient {
}
