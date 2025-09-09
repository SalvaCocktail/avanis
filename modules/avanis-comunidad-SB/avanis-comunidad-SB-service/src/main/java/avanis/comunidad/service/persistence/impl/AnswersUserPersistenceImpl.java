/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence.impl;

import avanis.comunidad.exception.NoSuchAnswersUserException;
import avanis.comunidad.model.AnswersUser;
import avanis.comunidad.model.AnswersUserTable;
import avanis.comunidad.model.impl.AnswersUserImpl;
import avanis.comunidad.model.impl.AnswersUserModelImpl;
import avanis.comunidad.service.persistence.AnswersUserPersistence;
import avanis.comunidad.service.persistence.AnswersUserUtil;
import avanis.comunidad.service.persistence.impl.constants.AVANIS_COMUNIDADPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the answers user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AnswersUserPersistence.class)
public class AnswersUserPersistenceImpl
	extends BasePersistenceImpl<AnswersUser> implements AnswersUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnswersUserUtil</code> to access the answers user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnswersUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the answers users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answers users
	 */
	@Override
	public List<AnswersUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<AnswersUser> list = null;

		if (useFinderCache) {
			list = (List<AnswersUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnswersUser answersUser : list) {
					if (!uuid.equals(answersUser.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<AnswersUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findByUuid_First(
			String uuid, OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchByUuid_First(uuid, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the first answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchByUuid_First(
		String uuid, OrderByComparator<AnswersUser> orderByComparator) {

		List<AnswersUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findByUuid_Last(
			String uuid, OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchByUuid_Last(uuid, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the last answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchByUuid_Last(
		String uuid, OrderByComparator<AnswersUser> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AnswersUser> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where uuid = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser[] findByUuid_PrevAndNext(
			long answerUserId, String uuid,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		uuid = Objects.toString(uuid, "");

		AnswersUser answersUser = findByPrimaryKey(answerUserId);

		Session session = null;

		try {
			session = openSession();

			AnswersUser[] array = new AnswersUserImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, answersUser, uuid, orderByComparator, true);

			array[1] = answersUser;

			array[2] = getByUuid_PrevAndNext(
				session, answersUser, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnswersUser getByUuid_PrevAndNext(
		Session session, AnswersUser answersUser, String uuid,
		OrderByComparator<AnswersUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(answersUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnswersUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AnswersUser answersUser :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(answersUser);
		}
	}

	/**
	 * Returns the number of answers users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answers users
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANSWERSUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"answersUser.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(answersUser.uuid IS NULL OR answersUser.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBysurveyId;
	private FinderPath _finderPathWithoutPaginationFindBysurveyId;
	private FinderPath _finderPathCountBysurveyId;

	/**
	 * Returns all the answers users where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyId(long surveyId) {
		return findBysurveyId(
			surveyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers users where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyId(long surveyId, int start, int end) {
		return findBysurveyId(surveyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return findBysurveyId(surveyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysurveyId;
				finderArgs = new Object[] {surveyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysurveyId;
			finderArgs = new Object[] {surveyId, start, end, orderByComparator};
		}

		List<AnswersUser> list = null;

		if (useFinderCache) {
			list = (List<AnswersUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnswersUser answersUser : list) {
					if (surveyId != answersUser.getSurveyId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_SURVEYID_SURVEYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(surveyId);

				list = (List<AnswersUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findBysurveyId_First(
			long surveyId, OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchBysurveyId_First(
			surveyId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surveyId=");
		sb.append(surveyId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchBysurveyId_First(
		long surveyId, OrderByComparator<AnswersUser> orderByComparator) {

		List<AnswersUser> list = findBysurveyId(
			surveyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findBysurveyId_Last(
			long surveyId, OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchBysurveyId_Last(
			surveyId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surveyId=");
		sb.append(surveyId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchBysurveyId_Last(
		long surveyId, OrderByComparator<AnswersUser> orderByComparator) {

		int count = countBysurveyId(surveyId);

		if (count == 0) {
			return null;
		}

		List<AnswersUser> list = findBysurveyId(
			surveyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser[] findBysurveyId_PrevAndNext(
			long answerUserId, long surveyId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = findByPrimaryKey(answerUserId);

		Session session = null;

		try {
			session = openSession();

			AnswersUser[] array = new AnswersUserImpl[3];

			array[0] = getBysurveyId_PrevAndNext(
				session, answersUser, surveyId, orderByComparator, true);

			array[1] = answersUser;

			array[2] = getBysurveyId_PrevAndNext(
				session, answersUser, surveyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnswersUser getBysurveyId_PrevAndNext(
		Session session, AnswersUser answersUser, long surveyId,
		OrderByComparator<AnswersUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

		sb.append(_FINDER_COLUMN_SURVEYID_SURVEYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(surveyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(answersUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnswersUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers users where surveyId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 */
	@Override
	public void removeBysurveyId(long surveyId) {
		for (AnswersUser answersUser :
				findBysurveyId(
					surveyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(answersUser);
		}
	}

	/**
	 * Returns the number of answers users where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the number of matching answers users
	 */
	@Override
	public int countBysurveyId(long surveyId) {
		FinderPath finderPath = _finderPathCountBysurveyId;

		Object[] finderArgs = new Object[] {surveyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_SURVEYID_SURVEYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(surveyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURVEYID_SURVEYID_2 =
		"answersUser.surveyId = ?";

	private FinderPath _finderPathWithPaginationFindBysurveyIdUserId;
	private FinderPath _finderPathWithoutPaginationFindBysurveyIdUserId;
	private FinderPath _finderPathCountBysurveyIdUserId;

	/**
	 * Returns all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyIdUserId(long surveyId, long userId) {
		return findBysurveyIdUserId(
			surveyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end) {

		return findBysurveyIdUserId(surveyId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return findBysurveyIdUserId(
			surveyId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysurveyIdUserId;
				finderArgs = new Object[] {surveyId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysurveyIdUserId;
			finderArgs = new Object[] {
				surveyId, userId, start, end, orderByComparator
			};
		}

		List<AnswersUser> list = null;

		if (useFinderCache) {
			list = (List<AnswersUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnswersUser answersUser : list) {
					if ((surveyId != answersUser.getSurveyId()) ||
						(userId != answersUser.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_SURVEYIDUSERID_SURVEYID_2);

			sb.append(_FINDER_COLUMN_SURVEYIDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(surveyId);

				queryPos.add(userId);

				list = (List<AnswersUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findBysurveyIdUserId_First(
			long surveyId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchBysurveyIdUserId_First(
			surveyId, userId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surveyId=");
		sb.append(surveyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchBysurveyIdUserId_First(
		long surveyId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		List<AnswersUser> list = findBysurveyIdUserId(
			surveyId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findBysurveyIdUserId_Last(
			long surveyId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchBysurveyIdUserId_Last(
			surveyId, userId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surveyId=");
		sb.append(surveyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchBysurveyIdUserId_Last(
		long surveyId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		int count = countBysurveyIdUserId(surveyId, userId);

		if (count == 0) {
			return null;
		}

		List<AnswersUser> list = findBysurveyIdUserId(
			surveyId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser[] findBysurveyIdUserId_PrevAndNext(
			long answerUserId, long surveyId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = findByPrimaryKey(answerUserId);

		Session session = null;

		try {
			session = openSession();

			AnswersUser[] array = new AnswersUserImpl[3];

			array[0] = getBysurveyIdUserId_PrevAndNext(
				session, answersUser, surveyId, userId, orderByComparator,
				true);

			array[1] = answersUser;

			array[2] = getBysurveyIdUserId_PrevAndNext(
				session, answersUser, surveyId, userId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnswersUser getBysurveyIdUserId_PrevAndNext(
		Session session, AnswersUser answersUser, long surveyId, long userId,
		OrderByComparator<AnswersUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

		sb.append(_FINDER_COLUMN_SURVEYIDUSERID_SURVEYID_2);

		sb.append(_FINDER_COLUMN_SURVEYIDUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(surveyId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(answersUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnswersUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers users where surveyId = &#63; and userId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 */
	@Override
	public void removeBysurveyIdUserId(long surveyId, long userId) {
		for (AnswersUser answersUser :
				findBysurveyIdUserId(
					surveyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(answersUser);
		}
	}

	/**
	 * Returns the number of answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	@Override
	public int countBysurveyIdUserId(long surveyId, long userId) {
		FinderPath finderPath = _finderPathCountBysurveyIdUserId;

		Object[] finderArgs = new Object[] {surveyId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_SURVEYIDUSERID_SURVEYID_2);

			sb.append(_FINDER_COLUMN_SURVEYIDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(surveyId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURVEYIDUSERID_SURVEYID_2 =
		"answersUser.surveyId = ? AND ";

	private static final String _FINDER_COLUMN_SURVEYIDUSERID_USERID_2 =
		"answersUser.userId = ?";

	private FinderPath _finderPathWithPaginationFindByanswerIdUserId;
	private FinderPath _finderPathWithoutPaginationFindByanswerIdUserId;
	private FinderPath _finderPathCountByanswerIdUserId;

	/**
	 * Returns all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	@Override
	public List<AnswersUser> findByanswerIdUserId(long answerId, long userId) {
		return findByanswerIdUserId(
			answerId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end) {

		return findByanswerIdUserId(answerId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return findByanswerIdUserId(
			answerId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByanswerIdUserId;
				finderArgs = new Object[] {answerId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByanswerIdUserId;
			finderArgs = new Object[] {
				answerId, userId, start, end, orderByComparator
			};
		}

		List<AnswersUser> list = null;

		if (useFinderCache) {
			list = (List<AnswersUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnswersUser answersUser : list) {
					if ((answerId != answersUser.getAnswerId()) ||
						(userId != answersUser.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_ANSWERIDUSERID_ANSWERID_2);

			sb.append(_FINDER_COLUMN_ANSWERIDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(answerId);

				queryPos.add(userId);

				list = (List<AnswersUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findByanswerIdUserId_First(
			long answerId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchByanswerIdUserId_First(
			answerId, userId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("answerId=");
		sb.append(answerId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the first answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchByanswerIdUserId_First(
		long answerId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		List<AnswersUser> list = findByanswerIdUserId(
			answerId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findByanswerIdUserId_Last(
			long answerId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchByanswerIdUserId_Last(
			answerId, userId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("answerId=");
		sb.append(answerId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the last answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchByanswerIdUserId_Last(
		long answerId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		int count = countByanswerIdUserId(answerId, userId);

		if (count == 0) {
			return null;
		}

		List<AnswersUser> list = findByanswerIdUserId(
			answerId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser[] findByanswerIdUserId_PrevAndNext(
			long answerUserId, long answerId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = findByPrimaryKey(answerUserId);

		Session session = null;

		try {
			session = openSession();

			AnswersUser[] array = new AnswersUserImpl[3];

			array[0] = getByanswerIdUserId_PrevAndNext(
				session, answersUser, answerId, userId, orderByComparator,
				true);

			array[1] = answersUser;

			array[2] = getByanswerIdUserId_PrevAndNext(
				session, answersUser, answerId, userId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnswersUser getByanswerIdUserId_PrevAndNext(
		Session session, AnswersUser answersUser, long answerId, long userId,
		OrderByComparator<AnswersUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

		sb.append(_FINDER_COLUMN_ANSWERIDUSERID_ANSWERID_2);

		sb.append(_FINDER_COLUMN_ANSWERIDUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(answerId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(answersUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnswersUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers users where answerId = &#63; and userId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByanswerIdUserId(long answerId, long userId) {
		for (AnswersUser answersUser :
				findByanswerIdUserId(
					answerId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(answersUser);
		}
	}

	/**
	 * Returns the number of answers users where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	@Override
	public int countByanswerIdUserId(long answerId, long userId) {
		FinderPath finderPath = _finderPathCountByanswerIdUserId;

		Object[] finderArgs = new Object[] {answerId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_ANSWERIDUSERID_ANSWERID_2);

			sb.append(_FINDER_COLUMN_ANSWERIDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(answerId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ANSWERIDUSERID_ANSWERID_2 =
		"answersUser.answerId = ? AND ";

	private static final String _FINDER_COLUMN_ANSWERIDUSERID_USERID_2 =
		"answersUser.userId = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the answers users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	@Override
	public List<AnswersUser> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	@Override
	public List<AnswersUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<AnswersUser> list = null;

		if (useFinderCache) {
			list = (List<AnswersUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnswersUser answersUser : list) {
					if (userId != answersUser.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<AnswersUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findByuserId_First(
			long userId, OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchByuserId_First(
			userId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the first answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchByuserId_First(
		long userId, OrderByComparator<AnswersUser> orderByComparator) {

		List<AnswersUser> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	@Override
	public AnswersUser findByuserId_Last(
			long userId, OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchByuserId_Last(userId, orderByComparator);

		if (answersUser != null) {
			return answersUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAnswersUserException(sb.toString());
	}

	/**
	 * Returns the last answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	@Override
	public AnswersUser fetchByuserId_Last(
		long userId, OrderByComparator<AnswersUser> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<AnswersUser> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where userId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser[] findByuserId_PrevAndNext(
			long answerUserId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = findByPrimaryKey(answerUserId);

		Session session = null;

		try {
			session = openSession();

			AnswersUser[] array = new AnswersUserImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, answersUser, userId, orderByComparator, true);

			array[1] = answersUser;

			array[2] = getByuserId_PrevAndNext(
				session, answersUser, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnswersUser getByuserId_PrevAndNext(
		Session session, AnswersUser answersUser, long userId,
		OrderByComparator<AnswersUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANSWERSUSER_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnswersUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(answersUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnswersUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (AnswersUser answersUser :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(answersUser);
		}
	}

	/**
	 * Returns the number of answers users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANSWERSUSER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"answersUser.userId = ?";

	public AnswersUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnswersUser.class);

		setModelImplClass(AnswersUserImpl.class);
		setModelPKClass(long.class);

		setTable(AnswersUserTable.INSTANCE);
	}

	/**
	 * Caches the answers user in the entity cache if it is enabled.
	 *
	 * @param answersUser the answers user
	 */
	@Override
	public void cacheResult(AnswersUser answersUser) {
		entityCache.putResult(
			AnswersUserImpl.class, answersUser.getPrimaryKey(), answersUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the answers users in the entity cache if it is enabled.
	 *
	 * @param answersUsers the answers users
	 */
	@Override
	public void cacheResult(List<AnswersUser> answersUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (answersUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnswersUser answersUser : answersUsers) {
			if (entityCache.getResult(
					AnswersUserImpl.class, answersUser.getPrimaryKey()) ==
						null) {

				cacheResult(answersUser);
			}
		}
	}

	/**
	 * Clears the cache for all answers users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnswersUserImpl.class);

		finderCache.clearCache(AnswersUserImpl.class);
	}

	/**
	 * Clears the cache for the answers user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnswersUser answersUser) {
		entityCache.removeResult(AnswersUserImpl.class, answersUser);
	}

	@Override
	public void clearCache(List<AnswersUser> answersUsers) {
		for (AnswersUser answersUser : answersUsers) {
			entityCache.removeResult(AnswersUserImpl.class, answersUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AnswersUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnswersUserImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new answers user with the primary key. Does not add the answers user to the database.
	 *
	 * @param answerUserId the primary key for the new answers user
	 * @return the new answers user
	 */
	@Override
	public AnswersUser create(long answerUserId) {
		AnswersUser answersUser = new AnswersUserImpl();

		answersUser.setNew(true);
		answersUser.setPrimaryKey(answerUserId);

		String uuid = PortalUUIDUtil.generate();

		answersUser.setUuid(uuid);

		return answersUser;
	}

	/**
	 * Removes the answers user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user that was removed
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser remove(long answerUserId)
		throws NoSuchAnswersUserException {

		return remove((Serializable)answerUserId);
	}

	/**
	 * Removes the answers user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the answers user
	 * @return the answers user that was removed
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser remove(Serializable primaryKey)
		throws NoSuchAnswersUserException {

		Session session = null;

		try {
			session = openSession();

			AnswersUser answersUser = (AnswersUser)session.get(
				AnswersUserImpl.class, primaryKey);

			if (answersUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnswersUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(answersUser);
		}
		catch (NoSuchAnswersUserException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AnswersUser removeImpl(AnswersUser answersUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(answersUser)) {
				answersUser = (AnswersUser)session.get(
					AnswersUserImpl.class, answersUser.getPrimaryKeyObj());
			}

			if (answersUser != null) {
				session.delete(answersUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (answersUser != null) {
			clearCache(answersUser);
		}

		return answersUser;
	}

	@Override
	public AnswersUser updateImpl(AnswersUser answersUser) {
		boolean isNew = answersUser.isNew();

		if (!(answersUser instanceof AnswersUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(answersUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(answersUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in answersUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnswersUser implementation " +
					answersUser.getClass());
		}

		AnswersUserModelImpl answersUserModelImpl =
			(AnswersUserModelImpl)answersUser;

		if (Validator.isNull(answersUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			answersUser.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (answersUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				answersUser.setCreateDate(date);
			}
			else {
				answersUser.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!answersUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				answersUser.setModifiedDate(date);
			}
			else {
				answersUser.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(answersUser);
			}
			else {
				answersUser = (AnswersUser)session.merge(answersUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnswersUserImpl.class, answersUserModelImpl, false, true);

		if (isNew) {
			answersUser.setNew(false);
		}

		answersUser.resetOriginalValues();

		return answersUser;
	}

	/**
	 * Returns the answers user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the answers user
	 * @return the answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnswersUserException {

		AnswersUser answersUser = fetchByPrimaryKey(primaryKey);

		if (answersUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnswersUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return answersUser;
	}

	/**
	 * Returns the answers user with the primary key or throws a <code>NoSuchAnswersUserException</code> if it could not be found.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser findByPrimaryKey(long answerUserId)
		throws NoSuchAnswersUserException {

		return findByPrimaryKey((Serializable)answerUserId);
	}

	/**
	 * Returns the answers user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user, or <code>null</code> if a answers user with the primary key could not be found
	 */
	@Override
	public AnswersUser fetchByPrimaryKey(long answerUserId) {
		return fetchByPrimaryKey((Serializable)answerUserId);
	}

	/**
	 * Returns all the answers users.
	 *
	 * @return the answers users
	 */
	@Override
	public List<AnswersUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of answers users
	 */
	@Override
	public List<AnswersUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answers users
	 */
	@Override
	public List<AnswersUser> findAll(
		int start, int end, OrderByComparator<AnswersUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of answers users
	 */
	@Override
	public List<AnswersUser> findAll(
		int start, int end, OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AnswersUser> list = null;

		if (useFinderCache) {
			list = (List<AnswersUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANSWERSUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANSWERSUSER;

				sql = sql.concat(AnswersUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnswersUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the answers users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnswersUser answersUser : findAll()) {
			remove(answersUser);
		}
	}

	/**
	 * Returns the number of answers users.
	 *
	 * @return the number of answers users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANSWERSUSER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "answerUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ANSWERSUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnswersUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the answers user persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindBysurveyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysurveyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"surveyId"}, true);

		_finderPathWithoutPaginationFindBysurveyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysurveyId",
			new String[] {Long.class.getName()}, new String[] {"surveyId"},
			true);

		_finderPathCountBysurveyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysurveyId",
			new String[] {Long.class.getName()}, new String[] {"surveyId"},
			false);

		_finderPathWithPaginationFindBysurveyIdUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysurveyIdUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"surveyId", "userId"}, true);

		_finderPathWithoutPaginationFindBysurveyIdUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysurveyIdUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"surveyId", "userId"}, true);

		_finderPathCountBysurveyIdUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysurveyIdUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"surveyId", "userId"}, false);

		_finderPathWithPaginationFindByanswerIdUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByanswerIdUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"answerId", "userId"}, true);

		_finderPathWithoutPaginationFindByanswerIdUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByanswerIdUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"answerId", "userId"}, true);

		_finderPathCountByanswerIdUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByanswerIdUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"answerId", "userId"}, false);

		_finderPathWithPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		AnswersUserUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AnswersUserUtil.setPersistence(null);

		entityCache.removeCache(AnswersUserImpl.class.getName());
	}

	@Override
	@Reference(
		target = AVANIS_COMUNIDADPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AVANIS_COMUNIDADPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AVANIS_COMUNIDADPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ANSWERSUSER =
		"SELECT answersUser FROM AnswersUser answersUser";

	private static final String _SQL_SELECT_ANSWERSUSER_WHERE =
		"SELECT answersUser FROM AnswersUser answersUser WHERE ";

	private static final String _SQL_COUNT_ANSWERSUSER =
		"SELECT COUNT(answersUser) FROM AnswersUser answersUser";

	private static final String _SQL_COUNT_ANSWERSUSER_WHERE =
		"SELECT COUNT(answersUser) FROM AnswersUser answersUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "answersUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnswersUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnswersUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnswersUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}