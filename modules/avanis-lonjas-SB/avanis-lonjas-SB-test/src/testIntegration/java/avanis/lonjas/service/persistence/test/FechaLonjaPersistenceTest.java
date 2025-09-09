/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.test;

import avanis.lonjas.exception.NoSuchFechaLonjaException;
import avanis.lonjas.model.FechaLonja;
import avanis.lonjas.service.FechaLonjaLocalServiceUtil;
import avanis.lonjas.service.persistence.FechaLonjaPersistence;
import avanis.lonjas.service.persistence.FechaLonjaUtil;

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
public class FechaLonjaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.lonjas.service"));

	@Before
	public void setUp() {
		_persistence = FechaLonjaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<FechaLonja> iterator = _fechaLonjas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FechaLonja fechaLonja = _persistence.create(pk);

		Assert.assertNotNull(fechaLonja);

		Assert.assertEquals(fechaLonja.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		FechaLonja newFechaLonja = addFechaLonja();

		_persistence.remove(newFechaLonja);

		FechaLonja existingFechaLonja = _persistence.fetchByPrimaryKey(
			newFechaLonja.getPrimaryKey());

		Assert.assertNull(existingFechaLonja);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addFechaLonja();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FechaLonja newFechaLonja = _persistence.create(pk);

		newFechaLonja.setUuid(RandomTestUtil.randomString());

		newFechaLonja.setLonjaId(RandomTestUtil.nextLong());

		newFechaLonja.setFecha(RandomTestUtil.nextDate());

		newFechaLonja.setCreateDate(RandomTestUtil.nextDate());

		newFechaLonja.setModifiedDate(RandomTestUtil.nextDate());

		_fechaLonjas.add(_persistence.update(newFechaLonja));

		FechaLonja existingFechaLonja = _persistence.findByPrimaryKey(
			newFechaLonja.getPrimaryKey());

		Assert.assertEquals(
			existingFechaLonja.getUuid(), newFechaLonja.getUuid());
		Assert.assertEquals(
			existingFechaLonja.getEntityId(), newFechaLonja.getEntityId());
		Assert.assertEquals(
			existingFechaLonja.getLonjaId(), newFechaLonja.getLonjaId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingFechaLonja.getFecha()),
			Time.getShortTimestamp(newFechaLonja.getFecha()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingFechaLonja.getCreateDate()),
			Time.getShortTimestamp(newFechaLonja.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingFechaLonja.getModifiedDate()),
			Time.getShortTimestamp(newFechaLonja.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountBylonjaId() throws Exception {
		_persistence.countBylonjaId(RandomTestUtil.nextLong());

		_persistence.countBylonjaId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		FechaLonja newFechaLonja = addFechaLonja();

		FechaLonja existingFechaLonja = _persistence.findByPrimaryKey(
			newFechaLonja.getPrimaryKey());

		Assert.assertEquals(existingFechaLonja, newFechaLonja);
	}

	@Test(expected = NoSuchFechaLonjaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<FechaLonja> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AVANIS_LONJAS_FechaLonja", "uuid", true, "entityId", true,
			"lonjaId", true, "fecha", true, "createDate", true, "modifiedDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		FechaLonja newFechaLonja = addFechaLonja();

		FechaLonja existingFechaLonja = _persistence.fetchByPrimaryKey(
			newFechaLonja.getPrimaryKey());

		Assert.assertEquals(existingFechaLonja, newFechaLonja);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FechaLonja missingFechaLonja = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingFechaLonja);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		FechaLonja newFechaLonja1 = addFechaLonja();
		FechaLonja newFechaLonja2 = addFechaLonja();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFechaLonja1.getPrimaryKey());
		primaryKeys.add(newFechaLonja2.getPrimaryKey());

		Map<Serializable, FechaLonja> fechaLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, fechaLonjas.size());
		Assert.assertEquals(
			newFechaLonja1, fechaLonjas.get(newFechaLonja1.getPrimaryKey()));
		Assert.assertEquals(
			newFechaLonja2, fechaLonjas.get(newFechaLonja2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, FechaLonja> fechaLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(fechaLonjas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		FechaLonja newFechaLonja = addFechaLonja();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFechaLonja.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, FechaLonja> fechaLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, fechaLonjas.size());
		Assert.assertEquals(
			newFechaLonja, fechaLonjas.get(newFechaLonja.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, FechaLonja> fechaLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(fechaLonjas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		FechaLonja newFechaLonja = addFechaLonja();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newFechaLonja.getPrimaryKey());

		Map<Serializable, FechaLonja> fechaLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, fechaLonjas.size());
		Assert.assertEquals(
			newFechaLonja, fechaLonjas.get(newFechaLonja.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			FechaLonjaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<FechaLonja>() {

				@Override
				public void performAction(FechaLonja fechaLonja) {
					Assert.assertNotNull(fechaLonja);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		FechaLonja newFechaLonja = addFechaLonja();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FechaLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"entityId", newFechaLonja.getEntityId()));

		List<FechaLonja> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		FechaLonja existingFechaLonja = result.get(0);

		Assert.assertEquals(existingFechaLonja, newFechaLonja);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FechaLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", RandomTestUtil.nextLong()));

		List<FechaLonja> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		FechaLonja newFechaLonja = addFechaLonja();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FechaLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		Object newEntityId = newFechaLonja.getEntityId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("entityId", new Object[] {newEntityId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEntityId = result.get(0);

		Assert.assertEquals(existingEntityId, newEntityId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			FechaLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected FechaLonja addFechaLonja() throws Exception {
		long pk = RandomTestUtil.nextLong();

		FechaLonja fechaLonja = _persistence.create(pk);

		fechaLonja.setUuid(RandomTestUtil.randomString());

		fechaLonja.setLonjaId(RandomTestUtil.nextLong());

		fechaLonja.setFecha(RandomTestUtil.nextDate());

		fechaLonja.setCreateDate(RandomTestUtil.nextDate());

		fechaLonja.setModifiedDate(RandomTestUtil.nextDate());

		_fechaLonjas.add(_persistence.update(fechaLonja));

		return fechaLonja;
	}

	private List<FechaLonja> _fechaLonjas = new ArrayList<FechaLonja>();
	private FechaLonjaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}