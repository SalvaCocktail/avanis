/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ThreadLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ThreadLogLocalService
 * @generated
 */
public class ThreadLogLocalServiceWrapper
	implements ServiceWrapper<ThreadLogLocalService>, ThreadLogLocalService {

	public ThreadLogLocalServiceWrapper() {
		this(null);
	}

	public ThreadLogLocalServiceWrapper(
		ThreadLogLocalService threadLogLocalService) {

		_threadLogLocalService = threadLogLocalService;
	}

	/**
	 * Adds the thread log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThreadLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param threadLog the thread log
	 * @return the thread log that was added
	 */
	@Override
	public avanis.thread.logger.sb.model.ThreadLog addThreadLog(
		avanis.thread.logger.sb.model.ThreadLog threadLog) {

		return _threadLogLocalService.addThreadLog(threadLog);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _threadLogLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new thread log with the primary key. Does not add the thread log to the database.
	 *
	 * @param threadLogId the primary key for the new thread log
	 * @return the new thread log
	 */
	@Override
	public avanis.thread.logger.sb.model.ThreadLog createThreadLog(
		long threadLogId) {

		return _threadLogLocalService.createThreadLog(threadLogId);
	}

	@Override
	public void deleteAll() {
		_threadLogLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _threadLogLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the thread log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThreadLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log that was removed
	 * @throws PortalException if a thread log with the primary key could not be found
	 */
	@Override
	public avanis.thread.logger.sb.model.ThreadLog deleteThreadLog(
			long threadLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _threadLogLocalService.deleteThreadLog(threadLogId);
	}

	/**
	 * Deletes the thread log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThreadLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param threadLog the thread log
	 * @return the thread log that was removed
	 */
	@Override
	public avanis.thread.logger.sb.model.ThreadLog deleteThreadLog(
		avanis.thread.logger.sb.model.ThreadLog threadLog) {

		return _threadLogLocalService.deleteThreadLog(threadLog);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _threadLogLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _threadLogLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _threadLogLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _threadLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.thread.logger.sb.model.impl.ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _threadLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.thread.logger.sb.model.impl.ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _threadLogLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _threadLogLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _threadLogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.thread.logger.sb.model.ThreadLog fetchThreadLog(
		long threadLogId) {

		return _threadLogLocalService.fetchThreadLog(threadLogId);
	}

	@Override
	public java.util.List<avanis.thread.logger.sb.model.ThreadLog>
		findByCreateDate(java.util.Date fecha) {

		return _threadLogLocalService.findByCreateDate(fecha);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _threadLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _threadLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _threadLogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _threadLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the thread log with the primary key.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log
	 * @throws PortalException if a thread log with the primary key could not be found
	 */
	@Override
	public avanis.thread.logger.sb.model.ThreadLog getThreadLog(
			long threadLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _threadLogLocalService.getThreadLog(threadLogId);
	}

	/**
	 * Returns a range of all the thread logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.thread.logger.sb.model.impl.ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thread logs
	 * @param end the upper bound of the range of thread logs (not inclusive)
	 * @return the range of thread logs
	 */
	@Override
	public java.util.List<avanis.thread.logger.sb.model.ThreadLog>
		getThreadLogs(int start, int end) {

		return _threadLogLocalService.getThreadLogs(start, end);
	}

	/**
	 * Returns the number of thread logs.
	 *
	 * @return the number of thread logs
	 */
	@Override
	public int getThreadLogsCount() {
		return _threadLogLocalService.getThreadLogsCount();
	}

	/**
	 * Updates the thread log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThreadLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param threadLog the thread log
	 * @return the thread log that was updated
	 */
	@Override
	public avanis.thread.logger.sb.model.ThreadLog updateThreadLog(
		avanis.thread.logger.sb.model.ThreadLog threadLog) {

		return _threadLogLocalService.updateThreadLog(threadLog);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _threadLogLocalService.getBasePersistence();
	}

	@Override
	public ThreadLogLocalService getWrappedService() {
		return _threadLogLocalService;
	}

	@Override
	public void setWrappedService(ThreadLogLocalService threadLogLocalService) {
		_threadLogLocalService = threadLogLocalService;
	}

	private ThreadLogLocalService _threadLogLocalService;

}