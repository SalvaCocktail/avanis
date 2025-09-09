/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.service.persistence.test;

import avanis.thread.logger.sb.exception.NoSuchThreadLogException;
import avanis.thread.logger.sb.model.ThreadLog;
import avanis.thread.logger.sb.service.ThreadLogLocalServiceUtil;
import avanis.thread.logger.sb.service.persistence.ThreadLogPersistence;
import avanis.thread.logger.sb.service.persistence.ThreadLogUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ThreadLogPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.thread.logger.sb.service"));

	@Before
	public void setUp() {
		_persistence = ThreadLogUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ThreadLog> iterator = _threadLogs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThreadLog threadLog = _persistence.create(pk);

		Assert.assertNotNull(threadLog);

		Assert.assertEquals(threadLog.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ThreadLog newThreadLog = addThreadLog();

		_persistence.remove(newThreadLog);

		ThreadLog existingThreadLog = _persistence.fetchByPrimaryKey(
			newThreadLog.getPrimaryKey());

		Assert.assertNull(existingThreadLog);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addThreadLog();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThreadLog newThreadLog = _persistence.create(pk);

		newThreadLog.setCreateDate(RandomTestUtil.nextDate());

		newThreadLog.setThreadName(RandomTestUtil.randomString());

		newThreadLog.setStackTrace(RandomTestUtil.randomString());

		newThreadLog.setThreadState(RandomTestUtil.randomString());

		newThreadLog.setLockName(RandomTestUtil.randomString());

		newThreadLog.setLockOwnerName(RandomTestUtil.randomString());

		newThreadLog.setLockOwnerId(RandomTestUtil.nextLong());

		_threadLogs.add(_persistence.update(newThreadLog));

		ThreadLog existingThreadLog = _persistence.findByPrimaryKey(
			newThreadLog.getPrimaryKey());

		Assert.assertEquals(
			existingThreadLog.getThreadLogId(), newThreadLog.getThreadLogId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingThreadLog.getCreateDate()),
			Time.getShortTimestamp(newThreadLog.getCreateDate()));
		Assert.assertEquals(
			existingThreadLog.getThreadName(), newThreadLog.getThreadName());
		Assert.assertEquals(
			existingThreadLog.getStackTrace(), newThreadLog.getStackTrace());
		Assert.assertEquals(
			existingThreadLog.getThreadState(), newThreadLog.getThreadState());
		Assert.assertEquals(
			existingThreadLog.getLockName(), newThreadLog.getLockName());
		Assert.assertEquals(
			existingThreadLog.getLockOwnerName(),
			newThreadLog.getLockOwnerName());
		Assert.assertEquals(
			existingThreadLog.getLockOwnerId(), newThreadLog.getLockOwnerId());
	}

	@Test
	public void testCountByCreateDate() throws Exception {
		_persistence.countByCreateDate(RandomTestUtil.nextDate());

		_persistence.countByCreateDate(RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ThreadLog newThreadLog = addThreadLog();

		ThreadLog existingThreadLog = _persistence.findByPrimaryKey(
			newThreadLog.getPrimaryKey());

		Assert.assertEquals(existingThreadLog, newThreadLog);
	}

	@Test(expected = NoSuchThreadLogException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ThreadLog> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ThreadLogger_ThreadLog", "threadLogId", true, "createDate", true,
			"threadName", true, "stackTrace", true, "threadState", true,
			"lockName", true, "lockOwnerName", true, "lockOwnerId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ThreadLog newThreadLog = addThreadLog();

		ThreadLog existingThreadLog = _persistence.fetchByPrimaryKey(
			newThreadLog.getPrimaryKey());

		Assert.assertEquals(existingThreadLog, newThreadLog);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThreadLog missingThreadLog = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingThreadLog);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ThreadLog newThreadLog1 = addThreadLog();
		ThreadLog newThreadLog2 = addThreadLog();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newThreadLog1.getPrimaryKey());
		primaryKeys.add(newThreadLog2.getPrimaryKey());

		Map<Serializable, ThreadLog> threadLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, threadLogs.size());
		Assert.assertEquals(
			newThreadLog1, threadLogs.get(newThreadLog1.getPrimaryKey()));
		Assert.assertEquals(
			newThreadLog2, threadLogs.get(newThreadLog2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ThreadLog> threadLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(threadLogs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ThreadLog newThreadLog = addThreadLog();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newThreadLog.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ThreadLog> threadLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, threadLogs.size());
		Assert.assertEquals(
			newThreadLog, threadLogs.get(newThreadLog.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ThreadLog> threadLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(threadLogs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ThreadLog newThreadLog = addThreadLog();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newThreadLog.getPrimaryKey());

		Map<Serializable, ThreadLog> threadLogs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, threadLogs.size());
		Assert.assertEquals(
			newThreadLog, threadLogs.get(newThreadLog.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ThreadLogLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ThreadLog>() {

				@Override
				public void performAction(ThreadLog threadLog) {
					Assert.assertNotNull(threadLog);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ThreadLog newThreadLog = addThreadLog();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ThreadLog.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"threadLogId", newThreadLog.getThreadLogId()));

		List<ThreadLog> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ThreadLog existingThreadLog = result.get(0);

		Assert.assertEquals(existingThreadLog, newThreadLog);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ThreadLog.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"threadLogId", RandomTestUtil.nextLong()));

		List<ThreadLog> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ThreadLog newThreadLog = addThreadLog();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ThreadLog.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("threadLogId"));

		Object newThreadLogId = newThreadLog.getThreadLogId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"threadLogId", new Object[] {newThreadLogId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingThreadLogId = result.get(0);

		Assert.assertEquals(existingThreadLogId, newThreadLogId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ThreadLog.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("threadLogId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"threadLogId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ThreadLog addThreadLog() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThreadLog threadLog = _persistence.create(pk);

		threadLog.setCreateDate(RandomTestUtil.nextDate());

		threadLog.setThreadName(RandomTestUtil.randomString());

		threadLog.setStackTrace(RandomTestUtil.randomString());

		threadLog.setThreadState(RandomTestUtil.randomString());

		threadLog.setLockName(RandomTestUtil.randomString());

		threadLog.setLockOwnerName(RandomTestUtil.randomString());

		threadLog.setLockOwnerId(RandomTestUtil.nextLong());

		_threadLogs.add(_persistence.update(threadLog));

		return threadLog;
	}

	private List<ThreadLog> _threadLogs = new ArrayList<ThreadLog>();
	private ThreadLogPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}