/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.test;

import avanis.lonjas.exception.NoSuchSubGrupoException;
import avanis.lonjas.model.SubGrupo;
import avanis.lonjas.service.SubGrupoLocalServiceUtil;
import avanis.lonjas.service.persistence.SubGrupoPersistence;
import avanis.lonjas.service.persistence.SubGrupoUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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
public class SubGrupoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.lonjas.service"));

	@Before
	public void setUp() {
		_persistence = SubGrupoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SubGrupo> iterator = _subGrupos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubGrupo subGrupo = _persistence.create(pk);

		Assert.assertNotNull(subGrupo);

		Assert.assertEquals(subGrupo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SubGrupo newSubGrupo = addSubGrupo();

		_persistence.remove(newSubGrupo);

		SubGrupo existingSubGrupo = _persistence.fetchByPrimaryKey(
			newSubGrupo.getPrimaryKey());

		Assert.assertNull(existingSubGrupo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSubGrupo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubGrupo newSubGrupo = _persistence.create(pk);

		newSubGrupo.setUuid(RandomTestUtil.randomString());

		newSubGrupo.setSubGrupoId(RandomTestUtil.nextLong());

		newSubGrupo.setGrupoId(RandomTestUtil.nextLong());

		newSubGrupo.setNombre(RandomTestUtil.randomString());

		newSubGrupo.setCreateDate(RandomTestUtil.nextDate());

		newSubGrupo.setModifiedDate(RandomTestUtil.nextDate());

		_subGrupos.add(_persistence.update(newSubGrupo));

		SubGrupo existingSubGrupo = _persistence.findByPrimaryKey(
			newSubGrupo.getPrimaryKey());

		Assert.assertEquals(existingSubGrupo.getUuid(), newSubGrupo.getUuid());
		Assert.assertEquals(
			existingSubGrupo.getEntityId(), newSubGrupo.getEntityId());
		Assert.assertEquals(
			existingSubGrupo.getSubGrupoId(), newSubGrupo.getSubGrupoId());
		Assert.assertEquals(
			existingSubGrupo.getGrupoId(), newSubGrupo.getGrupoId());
		Assert.assertEquals(
			existingSubGrupo.getNombre(), newSubGrupo.getNombre());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubGrupo.getCreateDate()),
			Time.getShortTimestamp(newSubGrupo.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubGrupo.getModifiedDate()),
			Time.getShortTimestamp(newSubGrupo.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountBynombre() throws Exception {
		_persistence.countBynombre("");

		_persistence.countBynombre("null");

		_persistence.countBynombre((String)null);
	}

	@Test
	public void testCountBysubGrupoId() throws Exception {
		_persistence.countBysubGrupoId(RandomTestUtil.nextLong());

		_persistence.countBysubGrupoId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SubGrupo newSubGrupo = addSubGrupo();

		SubGrupo existingSubGrupo = _persistence.findByPrimaryKey(
			newSubGrupo.getPrimaryKey());

		Assert.assertEquals(existingSubGrupo, newSubGrupo);
	}

	@Test(expected = NoSuchSubGrupoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SubGrupo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AVANIS_LONJAS_SubGrupo", "uuid", true, "entityId", true,
			"subGrupoId", true, "grupoId", true, "nombre", true, "createDate",
			true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SubGrupo newSubGrupo = addSubGrupo();

		SubGrupo existingSubGrupo = _persistence.fetchByPrimaryKey(
			newSubGrupo.getPrimaryKey());

		Assert.assertEquals(existingSubGrupo, newSubGrupo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubGrupo missingSubGrupo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSubGrupo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SubGrupo newSubGrupo1 = addSubGrupo();
		SubGrupo newSubGrupo2 = addSubGrupo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubGrupo1.getPrimaryKey());
		primaryKeys.add(newSubGrupo2.getPrimaryKey());

		Map<Serializable, SubGrupo> subGrupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, subGrupos.size());
		Assert.assertEquals(
			newSubGrupo1, subGrupos.get(newSubGrupo1.getPrimaryKey()));
		Assert.assertEquals(
			newSubGrupo2, subGrupos.get(newSubGrupo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SubGrupo> subGrupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subGrupos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SubGrupo newSubGrupo = addSubGrupo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubGrupo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SubGrupo> subGrupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subGrupos.size());
		Assert.assertEquals(
			newSubGrupo, subGrupos.get(newSubGrupo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SubGrupo> subGrupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subGrupos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SubGrupo newSubGrupo = addSubGrupo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubGrupo.getPrimaryKey());

		Map<Serializable, SubGrupo> subGrupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subGrupos.size());
		Assert.assertEquals(
			newSubGrupo, subGrupos.get(newSubGrupo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SubGrupoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SubGrupo>() {

				@Override
				public void performAction(SubGrupo subGrupo) {
					Assert.assertNotNull(subGrupo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SubGrupo newSubGrupo = addSubGrupo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubGrupo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", newSubGrupo.getEntityId()));

		List<SubGrupo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		SubGrupo existingSubGrupo = result.get(0);

		Assert.assertEquals(existingSubGrupo, newSubGrupo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubGrupo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", RandomTestUtil.nextLong()));

		List<SubGrupo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SubGrupo newSubGrupo = addSubGrupo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubGrupo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		Object newEntityId = newSubGrupo.getEntityId();

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
			SubGrupo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SubGrupo newSubGrupo = addSubGrupo();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSubGrupo.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		SubGrupo newSubGrupo = addSubGrupo();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubGrupo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", newSubGrupo.getEntityId()));

		List<SubGrupo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SubGrupo subGrupo) {
		Assert.assertEquals(
			Long.valueOf(subGrupo.getSubGrupoId()),
			ReflectionTestUtil.<Long>invoke(
				subGrupo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "subGrupoId"));
	}

	protected SubGrupo addSubGrupo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubGrupo subGrupo = _persistence.create(pk);

		subGrupo.setUuid(RandomTestUtil.randomString());

		subGrupo.setSubGrupoId(RandomTestUtil.nextLong());

		subGrupo.setGrupoId(RandomTestUtil.nextLong());

		subGrupo.setNombre(RandomTestUtil.randomString());

		subGrupo.setCreateDate(RandomTestUtil.nextDate());

		subGrupo.setModifiedDate(RandomTestUtil.nextDate());

		_subGrupos.add(_persistence.update(subGrupo));

		return subGrupo;
	}

	private List<SubGrupo> _subGrupos = new ArrayList<SubGrupo>();
	private SubGrupoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}