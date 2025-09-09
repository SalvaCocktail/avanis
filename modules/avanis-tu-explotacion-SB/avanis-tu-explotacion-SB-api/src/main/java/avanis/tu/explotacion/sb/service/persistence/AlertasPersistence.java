/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.persistence;

import avanis.tu.explotacion.sb.exception.NoSuchAlertasException;
import avanis.tu.explotacion.sb.model.Alertas;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the alertas service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AlertasUtil
 * @generated
 */
@ProviderType
public interface AlertasPersistence extends BasePersistence<Alertas> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AlertasUtil} to access the alertas persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the alertases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching alertases
	 */
	public java.util.List<Alertas> findByUuid(String uuid);

	/**
	 * Returns a range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	public java.util.List<Alertas> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	public java.util.List<Alertas> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns an ordered range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	public java.util.List<Alertas> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public Alertas findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Returns the first alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public Alertas fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns the last alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public Alertas findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Returns the last alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public Alertas fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where uuid = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public Alertas[] findByUuid_PrevAndNext(
			long alertaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Removes all the alertases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of alertases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching alertases
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the alertases where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching alertases
	 */
	public java.util.List<Alertas> findByuserId(long userId);

	/**
	 * Returns a range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	public java.util.List<Alertas> findByuserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	public java.util.List<Alertas> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns an ordered range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	public java.util.List<Alertas> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public Alertas findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Returns the first alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public Alertas fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns the last alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public Alertas findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Returns the last alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public Alertas fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where userId = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public Alertas[] findByuserId_PrevAndNext(
			long alertaId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Removes all the alertases where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of alertases where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching alertases
	 */
	public int countByuserId(long userId);

	/**
	 * Returns all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the matching alertases
	 */
	public java.util.List<Alertas> findByuserIdReaded(
		long userId, boolean readed);

	/**
	 * Returns a range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	public java.util.List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end);

	/**
	 * Returns an ordered range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	public java.util.List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns an ordered range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	public java.util.List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public Alertas findByuserIdReaded_First(
			long userId, boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Returns the first alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public Alertas fetchByuserIdReaded_First(
		long userId, boolean readed,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns the last alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public Alertas findByuserIdReaded_Last(
			long userId, boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Returns the last alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public Alertas fetchByuserIdReaded_Last(
		long userId, boolean readed,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public Alertas[] findByuserIdReaded_PrevAndNext(
			long alertaId, long userId, boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Alertas>
				orderByComparator)
		throws NoSuchAlertasException;

	/**
	 * Removes all the alertases where userId = &#63; and readed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 */
	public void removeByuserIdReaded(long userId, boolean readed);

	/**
	 * Returns the number of alertases where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the number of matching alertases
	 */
	public int countByuserIdReaded(long userId, boolean readed);

	/**
	 * Caches the alertas in the entity cache if it is enabled.
	 *
	 * @param alertas the alertas
	 */
	public void cacheResult(Alertas alertas);

	/**
	 * Caches the alertases in the entity cache if it is enabled.
	 *
	 * @param alertases the alertases
	 */
	public void cacheResult(java.util.List<Alertas> alertases);

	/**
	 * Creates a new alertas with the primary key. Does not add the alertas to the database.
	 *
	 * @param alertaId the primary key for the new alertas
	 * @return the new alertas
	 */
	public Alertas create(long alertaId);

	/**
	 * Removes the alertas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas that was removed
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public Alertas remove(long alertaId) throws NoSuchAlertasException;

	public Alertas updateImpl(Alertas alertas);

	/**
	 * Returns the alertas with the primary key or throws a <code>NoSuchAlertasException</code> if it could not be found.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public Alertas findByPrimaryKey(long alertaId)
		throws NoSuchAlertasException;

	/**
	 * Returns the alertas with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas, or <code>null</code> if a alertas with the primary key could not be found
	 */
	public Alertas fetchByPrimaryKey(long alertaId);

	/**
	 * Returns all the alertases.
	 *
	 * @return the alertases
	 */
	public java.util.List<Alertas> findAll();

	/**
	 * Returns a range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of alertases
	 */
	public java.util.List<Alertas> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of alertases
	 */
	public java.util.List<Alertas> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator);

	/**
	 * Returns an ordered range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of alertases
	 */
	public java.util.List<Alertas> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Alertas>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the alertases from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of alertases.
	 *
	 * @return the number of alertases
	 */
	public int countAll();

}