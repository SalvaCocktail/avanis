/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import avanis.calendarbooking.sb.model.Sponsor;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Sponsor. This utility wraps
 * <code>avanis.calendarbooking.sb.service.impl.SponsorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SponsorLocalService
 * @generated
 */
public class SponsorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.calendarbooking.sb.service.impl.SponsorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Sponsor addSponsor(
			long userId, long calendarBookingId, String name, String iconUrl,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSponsor(
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
	public static Sponsor addSponsor(Sponsor sponsor) {
		return getService().addSponsor(sponsor);
	}

	public static Integer countSponsorsByCalendarBookingId(
		long calendarBookingId) {

		return getService().countSponsorsByCalendarBookingId(calendarBookingId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sponsor with the primary key. Does not add the sponsor to the database.
	 *
	 * @param sponsorId the primary key for the new sponsor
	 * @return the new sponsor
	 */
	public static Sponsor createSponsor(long sponsorId) {
		return getService().createSponsor(sponsorId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Sponsor deleteSponsor(long sponsorId) throws PortalException {
		return getService().deleteSponsor(sponsorId);
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
	public static Sponsor deleteSponsor(Sponsor sponsor) {
		return getService().deleteSponsor(sponsor);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Sponsor fetchSponsor(long sponsorId) {
		return getService().fetchSponsor(sponsorId);
	}

	/**
	 * Returns the sponsor matching the UUID and group.
	 *
	 * @param uuid the sponsor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchSponsorByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSponsorByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sponsor with the primary key.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor
	 * @throws PortalException if a sponsor with the primary key could not be found
	 */
	public static Sponsor getSponsor(long sponsorId) throws PortalException {
		return getService().getSponsor(sponsorId);
	}

	/**
	 * Returns the sponsor matching the UUID and group.
	 *
	 * @param uuid the sponsor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sponsor
	 * @throws PortalException if a matching sponsor could not be found
	 */
	public static Sponsor getSponsorByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getSponsorByUuidAndGroupId(uuid, groupId);
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
	public static List<Sponsor> getSponsors(int start, int end) {
		return getService().getSponsors(start, end);
	}

	public static List<Sponsor> getSponsorsByCalendarBookingId(
		long calendarBookingId) {

		return getService().getSponsorsByCalendarBookingId(calendarBookingId);
	}

	public static List<Sponsor> getSponsorsByCalendarBookingId(
		long calendarBookingId, int start, int end) {

		return getService().getSponsorsByCalendarBookingId(
			calendarBookingId, start, end);
	}

	public static List<Sponsor> getSponsorsByUserId(long userId) {
		return getService().getSponsorsByUserId(userId);
	}

	/**
	 * Returns all the sponsors matching the UUID and company.
	 *
	 * @param uuid the UUID of the sponsors
	 * @param companyId the primary key of the company
	 * @return the matching sponsors, or an empty list if no matches were found
	 */
	public static List<Sponsor> getSponsorsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSponsorsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Sponsor> getSponsorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Sponsor> orderByComparator) {

		return getService().getSponsorsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sponsors.
	 *
	 * @return the number of sponsors
	 */
	public static int getSponsorsCount() {
		return getService().getSponsorsCount();
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
	public static Sponsor updateSponsor(Sponsor sponsor) {
		return getService().updateSponsor(sponsor);
	}

	public static SponsorLocalService getService() {
		return _service;
	}

	public static void setService(SponsorLocalService service) {
		_service = service;
	}

	private static volatile SponsorLocalService _service;

}