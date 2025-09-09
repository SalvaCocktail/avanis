/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SponsorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SponsorLocalService
 * @generated
 */
public class SponsorLocalServiceWrapper
	implements ServiceWrapper<SponsorLocalService>, SponsorLocalService {

	public SponsorLocalServiceWrapper() {
		this(null);
	}

	public SponsorLocalServiceWrapper(SponsorLocalService sponsorLocalService) {
		_sponsorLocalService = sponsorLocalService;
	}

	@Override
	public avanis.calendarbooking.sb.model.Sponsor addSponsor(
			long userId, long calendarBookingId, String name, String iconUrl,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sponsorLocalService.addSponsor(
			userId, calendarBookingId, name, iconUrl, serviceContext);
	}

	/**
	 * Adds the sponsor to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SponsorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sponsor the sponsor
	 * @return the sponsor that was added
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor addSponsor(
		avanis.calendarbooking.sb.model.Sponsor sponsor) {

		return _sponsorLocalService.addSponsor(sponsor);
	}

	@Override
	public Integer countSponsorsByCalendarBookingId(long calendarBookingId) {
		return _sponsorLocalService.countSponsorsByCalendarBookingId(
			calendarBookingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sponsorLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sponsor with the primary key. Does not add the sponsor to the database.
	 *
	 * @param sponsorId the primary key for the new sponsor
	 * @return the new sponsor
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor createSponsor(
		long sponsorId) {

		return _sponsorLocalService.createSponsor(sponsorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sponsorLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SponsorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor that was removed
	 * @throws PortalException if a sponsor with the primary key could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor deleteSponsor(long sponsorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sponsorLocalService.deleteSponsor(sponsorId);
	}

	/**
	 * Deletes the sponsor from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SponsorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sponsor the sponsor
	 * @return the sponsor that was removed
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor deleteSponsor(
		avanis.calendarbooking.sb.model.Sponsor sponsor) {

		return _sponsorLocalService.deleteSponsor(sponsor);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _sponsorLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _sponsorLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sponsorLocalService.dynamicQuery();
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

		return _sponsorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.SponsorModelImpl</code>.
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

		return _sponsorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.SponsorModelImpl</code>.
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

		return _sponsorLocalService.dynamicQuery(
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

		return _sponsorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sponsorLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public avanis.calendarbooking.sb.model.Sponsor fetchSponsor(
		long sponsorId) {

		return _sponsorLocalService.fetchSponsor(sponsorId);
	}

	/**
	 * Returns the sponsor matching the UUID and group.
	 *
	 * @param uuid the sponsor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor fetchSponsorByUuidAndGroupId(
		String uuid, long groupId) {

		return _sponsorLocalService.fetchSponsorByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sponsorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _sponsorLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sponsorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sponsorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sponsorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sponsor with the primary key.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor
	 * @throws PortalException if a sponsor with the primary key could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor getSponsor(long sponsorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sponsorLocalService.getSponsor(sponsorId);
	}

	/**
	 * Returns the sponsor matching the UUID and group.
	 *
	 * @param uuid the sponsor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sponsor
	 * @throws PortalException if a matching sponsor could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor getSponsorByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sponsorLocalService.getSponsorByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the sponsors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @return the range of sponsors
	 */
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Sponsor> getSponsors(
		int start, int end) {

		return _sponsorLocalService.getSponsors(start, end);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Sponsor>
		getSponsorsByCalendarBookingId(long calendarBookingId) {

		return _sponsorLocalService.getSponsorsByCalendarBookingId(
			calendarBookingId);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Sponsor>
		getSponsorsByCalendarBookingId(
			long calendarBookingId, int start, int end) {

		return _sponsorLocalService.getSponsorsByCalendarBookingId(
			calendarBookingId, start, end);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Sponsor>
		getSponsorsByUserId(long userId) {

		return _sponsorLocalService.getSponsorsByUserId(userId);
	}

	/**
	 * Returns all the sponsors matching the UUID and company.
	 *
	 * @param uuid the UUID of the sponsors
	 * @param companyId the primary key of the company
	 * @return the matching sponsors, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Sponsor>
		getSponsorsByUuidAndCompanyId(String uuid, long companyId) {

		return _sponsorLocalService.getSponsorsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of sponsors matching the UUID and company.
	 *
	 * @param uuid the UUID of the sponsors
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sponsors, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.Sponsor>
		getSponsorsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<avanis.calendarbooking.sb.model.Sponsor> orderByComparator) {

		return _sponsorLocalService.getSponsorsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sponsors.
	 *
	 * @return the number of sponsors
	 */
	@Override
	public int getSponsorsCount() {
		return _sponsorLocalService.getSponsorsCount();
	}

	/**
	 * Updates the sponsor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SponsorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sponsor the sponsor
	 * @return the sponsor that was updated
	 */
	@Override
	public avanis.calendarbooking.sb.model.Sponsor updateSponsor(
		avanis.calendarbooking.sb.model.Sponsor sponsor) {

		return _sponsorLocalService.updateSponsor(sponsor);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _sponsorLocalService.getBasePersistence();
	}

	@Override
	public SponsorLocalService getWrappedService() {
		return _sponsorLocalService;
	}

	@Override
	public void setWrappedService(SponsorLocalService sponsorLocalService) {
		_sponsorLocalService = sponsorLocalService;
	}

	private SponsorLocalService _sponsorLocalService;

}