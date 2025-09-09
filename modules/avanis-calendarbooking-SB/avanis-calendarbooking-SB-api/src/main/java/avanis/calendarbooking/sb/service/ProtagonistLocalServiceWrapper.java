/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProtagonistLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProtagonistLocalService
 * @generated
 */
public class ProtagonistLocalServiceWrapper
	implements ProtagonistLocalService,
			   ServiceWrapper<ProtagonistLocalService> {

	public ProtagonistLocalServiceWrapper() {
		this(null);
	}

	public ProtagonistLocalServiceWrapper(
		ProtagonistLocalService protagonistLocalService) {

		_protagonistLocalService = protagonistLocalService;
	}

	@Override
	public avanis.calendarbooking.sb.model.Protagonist addProtagonist(
			long userId, long groupId, long calendarBookingId, String name,
			String lastName, String profession, String bio, String portraitUrl,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.addProtagonist(
			userId, groupId, calendarBookingId, name, lastName, profession, bio,
			portraitUrl, serviceContext);
	}

	/**
	 * Adds the protagonist to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonist the protagonist
	 * @return the protagonist that was added
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist addProtagonist(
		avanis.calendarbooking.sb.model.Protagonist protagonist) {

		return _protagonistLocalService.addProtagonist(protagonist);
	}

	@Override
	public Integer countProtagonistsByCalendarBookingId(
		long calendarBookingId) {

		return _protagonistLocalService.countProtagonistsByCalendarBookingId(
			calendarBookingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new protagonist with the primary key. Does not add the protagonist to the database.
	 *
	 * @param protagonistId the primary key for the new protagonist
	 * @return the new protagonist
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist createProtagonist(
		long protagonistId) {

		return _protagonistLocalService.createProtagonist(protagonistId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the protagonist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist that was removed
	 * @throws PortalException if a protagonist with the primary key could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist deleteProtagonist(
			long protagonistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.deleteProtagonist(protagonistId);
	}

	/**
	 * Deletes the protagonist from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonist the protagonist
	 * @return the protagonist that was removed
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist deleteProtagonist(
		avanis.calendarbooking.sb.model.Protagonist protagonist) {

		return _protagonistLocalService.deleteProtagonist(protagonist);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _protagonistLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _protagonistLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _protagonistLocalService.dynamicQuery();
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

		return _protagonistLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.ProtagonistModelImpl</code>.
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

		return _protagonistLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.ProtagonistModelImpl</code>.
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

		return _protagonistLocalService.dynamicQuery(
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

		return _protagonistLocalService.dynamicQueryCount(dynamicQuery);
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

		return _protagonistLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.calendarbooking.sb.model.Protagonist fetchProtagonist(
		long protagonistId) {

		return _protagonistLocalService.fetchProtagonist(protagonistId);
	}

	/**
	 * Returns the protagonist matching the UUID and group.
	 *
	 * @param uuid the protagonist's UUID
	 * @param groupId the primary key of the group
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist
		fetchProtagonistByUuidAndGroupId(String uuid, long groupId) {

		return _protagonistLocalService.fetchProtagonistByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _protagonistLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _protagonistLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _protagonistLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _protagonistLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the protagonist with the primary key.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist
	 * @throws PortalException if a protagonist with the primary key could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist getProtagonist(
			long protagonistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.getProtagonist(protagonistId);
	}

	/**
	 * Returns the protagonist matching the UUID and group.
	 *
	 * @param uuid the protagonist's UUID
	 * @param groupId the primary key of the group
	 * @return the matching protagonist
	 * @throws PortalException if a matching protagonist could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist
			getProtagonistByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.getProtagonistByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of protagonists
	 */
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Protagonist>
		getProtagonists(int start, int end) {

		return _protagonistLocalService.getProtagonists(start, end);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Protagonist>
		getProtagonistsByCalendarBookingId(long calendarBookingId) {

		return _protagonistLocalService.getProtagonistsByCalendarBookingId(
			calendarBookingId);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Protagonist>
		getProtagonistsByCalendarBookingId(
			long calendarBookingId, int start, int end) {

		return _protagonistLocalService.getProtagonistsByCalendarBookingId(
			calendarBookingId, start, end);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Protagonist>
		getProtagonistsByUserId(long userId) {

		return _protagonistLocalService.getProtagonistsByUserId(userId);
	}

	/**
	 * Returns all the protagonists matching the UUID and company.
	 *
	 * @param uuid the UUID of the protagonists
	 * @param companyId the primary key of the company
	 * @return the matching protagonists, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Protagonist>
		getProtagonistsByUuidAndCompanyId(String uuid, long companyId) {

		return _protagonistLocalService.getProtagonistsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of protagonists matching the UUID and company.
	 *
	 * @param uuid the UUID of the protagonists
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching protagonists, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Protagonist>
		getProtagonistsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<avanis.calendarbooking.sb.model.Protagonist>
					orderByComparator) {

		return _protagonistLocalService.getProtagonistsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of protagonists.
	 *
	 * @return the number of protagonists
	 */
	@Override
	public int getProtagonistsCount() {
		return _protagonistLocalService.getProtagonistsCount();
	}

	@Override
	public avanis.calendarbooking.sb.model.Protagonist updateProtagonist(
			long protagonistId, String name, String lastName, String profession,
			String bio, long portraitId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _protagonistLocalService.updateProtagonist(
			protagonistId, name, lastName, profession, bio, portraitId,
			serviceContext);
	}

	/**
	 * Updates the protagonist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonist the protagonist
	 * @return the protagonist that was updated
	 */
	@Override
	public avanis.calendarbooking.sb.model.Protagonist updateProtagonist(
		avanis.calendarbooking.sb.model.Protagonist protagonist) {

		return _protagonistLocalService.updateProtagonist(protagonist);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _protagonistLocalService.getBasePersistence();
	}

	@Override
	public ProtagonistLocalService getWrappedService() {
		return _protagonistLocalService;
	}

	@Override
	public void setWrappedService(
		ProtagonistLocalService protagonistLocalService) {

		_protagonistLocalService = protagonistLocalService;
	}

	private ProtagonistLocalService _protagonistLocalService;

}