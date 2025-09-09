/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.test;

import avanis.lonjas.exception.NoSuchLonjaException;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.service.LonjaLocalServiceUtil;
import avanis.lonjas.service.persistence.LonjaPersistence;
import avanis.lonjas.service.persistence.LonjaUtil;

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
public class LonjaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.lonjas.service"));

	@Before
	public void setUp() {
		_persistence = LonjaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Lonja> iterator = _lonjas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lonja lonja = _persistence.create(pk);

		Assert.assertNotNull(lonja);

		Assert.assertEquals(lonja.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Lonja newLonja = addLonja();

		_persistence.remove(newLonja);

		Lonja existingLonja = _persistence.fetchByPrimaryKey(
			newLonja.getPrimaryKey());

		Assert.assertNull(existingLonja);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLonja();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lonja newLonja = _persistence.create(pk);

		newLonja.setUuid(RandomTestUtil.randomString());

		newLonja.setLonjaId(RandomTestUtil.nextLong());

		newLonja.setNombre(RandomTestUtil.randomString());

		newLonja.setPais(RandomTestUtil.randomString());

		newLonja.setCreateDate(RandomTestUtil.nextDate());

		newLonja.setModifiedDate(RandomTestUtil.nextDate());

		_lonjas.add(_persistence.update(newLonja));

		Lonja existingLonja = _persistence.findByPrimaryKey(
			newLonja.getPrimaryKey());

		Assert.assertEquals(existingLonja.getUuid(), newLonja.getUuid());
		Assert.assertEquals(
			existingLonja.getEntityId(), newLonja.getEntityId());
		Assert.assertEquals(existingLonja.getLonjaId(), newLonja.getLonjaId());
		Assert.assertEquals(existingLonja.getNombre(), newLonja.getNombre());
		Assert.assertEquals(existingLonja.getPais(), newLonja.getPais());
		Assert.assertEquals(
			Time.getShortTimestamp(existingLonja.getCreateDate()),
			Time.getShortTimestamp(newLonja.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingLonja.getModifiedDate()),
			Time.getShortTimestamp(newLonja.getModifiedDate()));
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
	public void testCountBynombre() throws Exception {
		_persistence.countBynombre("");

		_persistence.countBynombre("null");

		_persistence.countBynombre((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Lonja newLonja = addLonja();

		Lonja existingLonja = _persistence.findByPrimaryKey(
			newLonja.getPrimaryKey());

		Assert.assertEquals(existingLonja, newLonja);
	}

	@Test(expected = NoSuchLonjaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Lonja> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AVANIS_LONJAS_Lonja", "uuid", true, "entityId", true, "lonjaId",
			true, "nombre", true, "pais", true, "createDate", true,
			"modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Lonja newLonja = addLonja();

		Lonja existingLonja = _persistence.fetchByPrimaryKey(
			newLonja.getPrimaryKey());

		Assert.assertEquals(existingLonja, newLonja);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lonja missingLonja = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLonja);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Lonja newLonja1 = addLonja();
		Lonja newLonja2 = addLonja();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLonja1.getPrimaryKey());
		primaryKeys.add(newLonja2.getPrimaryKey());

		Map<Serializable, Lonja> lonjas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, lonjas.size());
		Assert.assertEquals(newLonja1, lonjas.get(newLonja1.getPrimaryKey()));
		Assert.assertEquals(newLonja2, lonjas.get(newLonja2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Lonja> lonjas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(lonjas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Lonja newLonja = addLonja();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLonja.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Lonja> lonjas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, lonjas.size());
		Assert.assertEquals(newLonja, lonjas.get(newLonja.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Lonja> lonjas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(lonjas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Lonja newLonja = addLonja();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLonja.getPrimaryKey());

		Map<Serializable, Lonja> lonjas = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, lonjas.size());
		Assert.assertEquals(newLonja, lonjas.get(newLonja.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LonjaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Lonja>() {

				@Override
				public void performAction(Lonja lonja) {
					Assert.assertNotNull(lonja);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Lonja newLonja = addLonja();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lonja.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", newLonja.getEntityId()));

		List<Lonja> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Lonja existingLonja = result.get(0);

		Assert.assertEquals(existingLonja, newLonja);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lonja.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", RandomTestUtil.nextLong()));

		List<Lonja> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Lonja newLonja = addLonja();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lonja.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		Object newEntityId = newLonja.getEntityId();

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
			Lonja.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Lonja addLonja() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lonja lonja = _persistence.create(pk);

		lonja.setUuid(RandomTestUtil.randomString());

		lonja.setLonjaId(RandomTestUtil.nextLong());

		lonja.setNombre(RandomTestUtil.randomString());

		lonja.setPais(RandomTestUtil.randomString());

		lonja.setCreateDate(RandomTestUtil.nextDate());

		lonja.setModifiedDate(RandomTestUtil.nextDate());

		_lonjas.add(_persistence.update(lonja));

		return lonja;
	}

	private List<Lonja> _lonjas = new ArrayList<Lonja>();
	private LonjaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}