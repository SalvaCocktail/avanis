/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.persistence;

import avanis.tu.explotacion.sb.exception.NoSuchExplotacionException;
import avanis.tu.explotacion.sb.model.Explotacion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the explotacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExplotacionUtil
 * @generated
 */
@ProviderType
public interface ExplotacionPersistence extends BasePersistence<Explotacion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExplotacionUtil} to access the explotacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the explotacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching explotacions
	 */
	public java.util.List<Explotacion> findByUuid(String uuid);

	/**
	 * Returns a range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public java.util.List<Explotacion> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the first explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the last explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the last explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public Explotacion[] findByUuid_PrevAndNext(
			long explotacionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Removes all the explotacions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of explotacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching explotacions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the explotacions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching explotacions
	 */
	public java.util.List<Explotacion> findByuserId(long userId);

	/**
	 * Returns a range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public java.util.List<Explotacion> findByuserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where userId = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public Explotacion[] findByuserId_PrevAndNext(
			long explotacionId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Removes all the explotacions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of explotacions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public int countByuserId(long userId);

	/**
	 * Returns all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the matching explotacions
	 */
	public java.util.List<Explotacion> findByuserIdReaded(
		long userId, boolean readed);

	/**
	 * Returns a range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public java.util.List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end);

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByuserIdReaded_First(
			long userId, boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByuserIdReaded_First(
		long userId, boolean readed,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByuserIdReaded_Last(
			long userId, boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByuserIdReaded_Last(
		long userId, boolean readed,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public Explotacion[] findByuserIdReaded_PrevAndNext(
			long explotacionId, long userId, boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Removes all the explotacions where userId = &#63; and readed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 */
	public void removeByuserIdReaded(long userId, boolean readed);

	/**
	 * Returns the number of explotacions where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the number of matching explotacions
	 */
	public int countByuserIdReaded(long userId, boolean readed);

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByexternalCodeReferenceAndUserId(
			String externalCodeReference, long userId)
		throws NoSuchExplotacionException;

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId);

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId, boolean useFinderCache);

	/**
	 * Removes the explotacion where externalCodeReference = &#63; and userId = &#63; from the database.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the explotacion that was removed
	 */
	public Explotacion removeByexternalCodeReferenceAndUserId(
			String externalCodeReference, long userId)
		throws NoSuchExplotacionException;

	/**
	 * Returns the number of explotacions where externalCodeReference = &#63; and userId = &#63;.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public int countByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId);

	/**
	 * Returns all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @return the matching explotacions
	 */
	public java.util.List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId);

	/**
	 * Returns a range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public java.util.List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByisMainAndUser_First(
			boolean isMain, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the first explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByisMainAndUser_First(
		boolean isMain, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the last explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByisMainAndUser_Last(
			boolean isMain, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the last explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByisMainAndUser_Last(
		boolean isMain, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public Explotacion[] findByisMainAndUser_PrevAndNext(
			long explotacionId, boolean isMain, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Removes all the explotacions where isMain = &#63; and userId = &#63; from the database.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 */
	public void removeByisMainAndUser(boolean isMain, long userId);

	/**
	 * Returns the number of explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public int countByisMainAndUser(boolean isMain, long userId);

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByidAndUserId(long explotacionId, long userId)
		throws NoSuchExplotacionException;

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByidAndUserId(long explotacionId, long userId);

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByidAndUserId(
		long explotacionId, long userId, boolean useFinderCache);

	/**
	 * Removes the explotacion where explotacionId = &#63; and userId = &#63; from the database.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the explotacion that was removed
	 */
	public Explotacion removeByidAndUserId(long explotacionId, long userId)
		throws NoSuchExplotacionException;

	/**
	 * Returns the number of explotacions where explotacionId = &#63; and userId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public int countByidAndUserId(long explotacionId, long userId);

	/**
	 * Returns all the explotacions where readed = &#63;.
	 *
	 * @param readed the readed
	 * @return the matching explotacions
	 */
	public java.util.List<Explotacion> findByreaded(boolean readed);

	/**
	 * Returns a range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public java.util.List<Explotacion> findByreaded(
		boolean readed, int start, int end);

	/**
	 * Returns an ordered range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByreaded(
		boolean readed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public java.util.List<Explotacion> findByreaded(
		boolean readed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByreaded_First(
			boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the first explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByreaded_First(
		boolean readed,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the last explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public Explotacion findByreaded_Last(
			boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Returns the last explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public Explotacion fetchByreaded_Last(
		boolean readed,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where readed = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public Explotacion[] findByreaded_PrevAndNext(
			long explotacionId, boolean readed,
			com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
				orderByComparator)
		throws NoSuchExplotacionException;

	/**
	 * Removes all the explotacions where readed = &#63; from the database.
	 *
	 * @param readed the readed
	 */
	public void removeByreaded(boolean readed);

	/**
	 * Returns the number of explotacions where readed = &#63;.
	 *
	 * @param readed the readed
	 * @return the number of matching explotacions
	 */
	public int countByreaded(boolean readed);

	/**
	 * Caches the explotacion in the entity cache if it is enabled.
	 *
	 * @param explotacion the explotacion
	 */
	public void cacheResult(Explotacion explotacion);

	/**
	 * Caches the explotacions in the entity cache if it is enabled.
	 *
	 * @param explotacions the explotacions
	 */
	public void cacheResult(java.util.List<Explotacion> explotacions);

	/**
	 * Creates a new explotacion with the primary key. Does not add the explotacion to the database.
	 *
	 * @param explotacionId the primary key for the new explotacion
	 * @return the new explotacion
	 */
	public Explotacion create(long explotacionId);

	/**
	 * Removes the explotacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion that was removed
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public Explotacion remove(long explotacionId)
		throws NoSuchExplotacionException;

	public Explotacion updateImpl(Explotacion explotacion);

	/**
	 * Returns the explotacion with the primary key or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public Explotacion findByPrimaryKey(long explotacionId)
		throws NoSuchExplotacionException;

	/**
	 * Returns the explotacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion, or <code>null</code> if a explotacion with the primary key could not be found
	 */
	public Explotacion fetchByPrimaryKey(long explotacionId);

	/**
	 * Returns all the explotacions.
	 *
	 * @return the explotacions
	 */
	public java.util.List<Explotacion> findAll();

	/**
	 * Returns a range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of explotacions
	 */
	public java.util.List<Explotacion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of explotacions
	 */
	public java.util.List<Explotacion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of explotacions
	 */
	public java.util.List<Explotacion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Explotacion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the explotacions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of explotacions.
	 *
	 * @return the number of explotacions
	 */
	public int countAll();

}