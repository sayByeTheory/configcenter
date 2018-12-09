/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2018-12-06 22:28 创建
 */
package org.antframework.configcenter.dal.dao;

import org.antframework.configcenter.dal.entity.Release;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.RepositoryDefinition;

import javax.persistence.LockModeType;

/**
 * 发布dao
 */
@RepositoryDefinition(domainClass = Release.class, idClass = Long.class)
public interface ReleaseDao {

    void save(Release release);

    void deleteByAppIdAndProfileIdAndVersionGreaterThan(String appId, String profileId, Long version);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Release findLockByAppIdAndProfileIdAndVersion(String appId, String profileId, Long version);
}
