/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import avanis.lonjas.model.PrecioLonja;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PrecioLonja. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonjaLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PrecioLonjaLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>avanis.lonjas.service.impl.PrecioLonjaLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the precio lonja local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PrecioLonjaLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public PrecioLonja addPrecioLonja(PrecioLonja precioLonja);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new precio lonja with the primary key. Does not add the precio lonja to the database.
	 *
	 * @param entityId the primary key for the new precio lonja
	 * @return the new precio lonja
	 */
	@Transactional(enabled = false)
	public PrecioLonja createPrecioLonja(long entityId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public PrecioLonja deletePrecioLonja(long entityId) throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public PrecioLonja deletePrecioLonja(PrecioLonja precioLonja);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
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
	public PrecioLonja fetchPrecioLonja(long entityId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	 * Returns the precio lonja with the primary key.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja
	 * @throws PortalException if a precio lonja with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PrecioLonja getPrecioLonja(long entityId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PrecioLonja> getPrecioLonjaByLonjaId(long lonjaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PrecioLonja> getPrecioLonjaByLonjaIdByFecha(
		long lonjaId, Date fecha);

	 @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
     public List<PrecioLonja> getPrecioLonjaByLonjaIdByProductoId(
             long lonjaId, long productoId,
             OrderByComparator<PrecioLonja> orderByComparator);

     @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
     public List<PrecioLonja> getLatestByLonjaIdsAndProductoIds(
             Set<Long> lonjaIds, Set<Long> productoIds,
             OrderByComparator<PrecioLonja> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PrecioLonja> getPrecioLonjas(int start, int end);

	/**
	 * Returns the number of precio lonjas.
	 *
	 * @return the number of precio lonjas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPrecioLonjasCount();

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
	@Indexable(type = IndexableType.REINDEX)
	public PrecioLonja updatePrecioLonja(PrecioLonja precioLonja);

}