/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import avanis.lonjas.model.PrecioLonja;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

/**
 * Provides the local service utility for PrecioLonja. This utility wraps
 * <code>avanis.lonjas.service.impl.PrecioLonjaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonjaLocalService
 * @generated
 */
public class PrecioLonjaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.lonjas.service.impl.PrecioLonjaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the precio lonja to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param precioLonja the precio lonja
	 * @return the precio lonja that was added
	 */
	public static PrecioLonja addPrecioLonja(PrecioLonja precioLonja) {
		return getService().addPrecioLonja(precioLonja);
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
	 * Creates a new precio lonja with the primary key. Does not add the precio lonja to the database.
	 *
	 * @param entityId the primary key for the new precio lonja
	 * @return the new precio lonja
	 */
	public static PrecioLonja createPrecioLonja(long entityId) {
		return getService().createPrecioLonja(entityId);
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
	 * Deletes the precio lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja that was removed
	 * @throws PortalException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja deletePrecioLonja(long entityId)
		throws PortalException {

		return getService().deletePrecioLonja(entityId);
	}

	/**
	 * Deletes the precio lonja from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param precioLonja the precio lonja
	 * @return the precio lonja that was removed
	 */
	public static PrecioLonja deletePrecioLonja(PrecioLonja precioLonja) {
		return getService().deletePrecioLonja(precioLonja);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
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

	public static PrecioLonja fetchPrecioLonja(long entityId) {
		return getService().fetchPrecioLonja(entityId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the precio lonja with the primary key.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja
	 * @throws PortalException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja getPrecioLonja(long entityId)
		throws PortalException {

		return getService().getPrecioLonja(entityId);
	}

	public static List<PrecioLonja> getPrecioLonjaByLonjaId(long lonjaId) {
		return getService().getPrecioLonjaByLonjaId(lonjaId);
	}

	public static List<PrecioLonja> getPrecioLonjaByLonjaIdByFecha(
		long lonjaId, java.util.Date fecha) {

		return getService().getPrecioLonjaByLonjaIdByFecha(lonjaId, fecha);
	}

    public static List<PrecioLonja> getPrecioLonjaByLonjaIdByProductoId(
            long lonjaId, long productoId,
            OrderByComparator<PrecioLonja> orderByComparator) {
    	
    	return getService().getPrecioLonjaByLonjaIdByProductoId(
                lonjaId, productoId, orderByComparator);
	}
	
	public static List<PrecioLonja> getLatestByLonjaIdsAndProductoIds(
	        Set<Long> lonjaIds, Set<Long> productoIds,
	        OrderByComparator<PrecioLonja> orderByComparator) {
	
	        return getService().getLatestByLonjaIdsAndProductoIds(
	                lonjaIds, productoIds, orderByComparator);
	}

	/**
	 * Returns a range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of precio lonjas
	 */
	public static List<PrecioLonja> getPrecioLonjas(int start, int end) {
		return getService().getPrecioLonjas(start, end);
	}

	/**
	 * Returns the number of precio lonjas.
	 *
	 * @return the number of precio lonjas
	 */
	public static int getPrecioLonjasCount() {
		return getService().getPrecioLonjasCount();
	}

	/**
	 * Updates the precio lonja in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param precioLonja the precio lonja
	 * @return the precio lonja that was updated
	 */
	public static PrecioLonja updatePrecioLonja(PrecioLonja precioLonja) {
		return getService().updatePrecioLonja(precioLonja);
	}

	public static PrecioLonjaLocalService getService() {
		return _service;
	}

	public static void setService(PrecioLonjaLocalService service) {
		_service = service;
	}

	private static volatile PrecioLonjaLocalService _service;

}