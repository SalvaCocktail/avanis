/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import avanis.calendarbooking.sb.model.BookingAgenda;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for BookingAgenda. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgendaLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BookingAgendaLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>avanis.calendarbooking.sb.service.impl.BookingAgendaLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the booking agenda local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BookingAgendaLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the booking agenda to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingAgenda the booking agenda
	 * @return the booking agenda that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BookingAgenda addBookingAgenda(BookingAgenda bookingAgenda);

	public BookingAgenda addBookingAgenda(
			long userId, long groupId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new booking agenda with the primary key. Does not add the booking agenda to the database.
	 *
	 * @param calendarBookingAgendaId the primary key for the new booking agenda
	 * @return the new booking agenda
	 */
	@Transactional(enabled = false)
	public BookingAgenda createBookingAgenda(long calendarBookingAgendaId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the booking agenda from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingAgenda the booking agenda
	 * @return the booking agenda that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public BookingAgenda deleteBookingAgenda(BookingAgenda bookingAgenda);

	/**
	 * Deletes the booking agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda that was removed
	 * @throws PortalException if a booking agenda with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public BookingAgenda deleteBookingAgenda(long calendarBookingAgendaId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BookingAgenda fetchBookingAgenda(long calendarBookingAgendaId);

	/**
	 * Returns the booking agenda matching the UUID and group.
	 *
	 * @param uuid the booking agenda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BookingAgenda fetchBookingAgendaByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the booking agenda with the primary key.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda
	 * @throws PortalException if a booking agenda with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BookingAgenda getBookingAgenda(long calendarBookingAgendaId)
		throws PortalException;

	/**
	 * Returns the booking agenda matching the UUID and group.
	 *
	 * @param uuid the booking agenda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching booking agenda
	 * @throws PortalException if a matching booking agenda could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BookingAgenda getBookingAgendaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of booking agendas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BookingAgenda> getBookingAgendas(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BookingAgenda> getBookingAgendasByCalendarBookingId(
		long calendarBookingId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BookingAgenda> getBookingAgendasByUserId(long userId);

	/**
	 * Returns all the booking agendas matching the UUID and company.
	 *
	 * @param uuid the UUID of the booking agendas
	 * @param companyId the primary key of the company
	 * @return the matching booking agendas, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BookingAgenda> getBookingAgendasByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of booking agendas matching the UUID and company.
	 *
	 * @param uuid the UUID of the booking agendas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching booking agendas, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BookingAgenda> getBookingAgendasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator);

	/**
	 * Returns the number of booking agendas.
	 *
	 * @return the number of booking agendas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBookingAgendasCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the booking agenda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingAgenda the booking agenda
	 * @return the booking agenda that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BookingAgenda updateBookingAgenda(BookingAgenda bookingAgenda);

	public BookingAgenda updateBookingAgenda(
			long bookingAgendaId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			ServiceContext serviceContext)
		throws PortalException;

}