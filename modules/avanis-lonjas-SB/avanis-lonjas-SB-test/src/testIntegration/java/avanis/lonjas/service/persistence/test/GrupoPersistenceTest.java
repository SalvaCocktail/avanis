/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.test;

import avanis.lonjas.exception.NoSuchGrupoException;
import avanis.lonjas.model.Grupo;
import avanis.lonjas.service.GrupoLocalServiceUtil;
import avanis.lonjas.service.persistence.GrupoPersistence;
import avanis.lonjas.service.persistence.GrupoUtil;

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
public class GrupoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.lonjas.service"));

	@Before
	public void setUp() {
		_persistence = GrupoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Grupo> iterator = _grupos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Grupo grupo = _persistence.create(pk);

		Assert.assertNotNull(grupo);

		Assert.assertEquals(grupo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Grupo newGrupo = addGrupo();

		_persistence.remove(newGrupo);

		Grupo existingGrupo = _persistence.fetchByPrimaryKey(
			newGrupo.getPrimaryKey());

		Assert.assertNull(existingGrupo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addGrupo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Grupo newGrupo = _persistence.create(pk);

		newGrupo.setUuid(RandomTestUtil.randomString());

		newGrupo.setGrupoId(RandomTestUtil.nextLong());

		newGrupo.setNombre(RandomTestUtil.randomString());

		newGrupo.setCreateDate(RandomTestUtil.nextDate());

		newGrupo.setModifiedDate(RandomTestUtil.nextDate());

		_grupos.add(_persistence.update(newGrupo));

		Grupo existingGrupo = _persistence.findByPrimaryKey(
			newGrupo.getPrimaryKey());

		Assert.assertEquals(existingGrupo.getUuid(), newGrupo.getUuid());
		Assert.assertEquals(
			existingGrupo.getEntityId(), newGrupo.getEntityId());
		Assert.assertEquals(existingGrupo.getGrupoId(), newGrupo.getGrupoId());
		Assert.assertEquals(existingGrupo.getNombre(), newGrupo.getNombre());
		Assert.assertEquals(
			Time.getShortTimestamp(existingGrupo.getCreateDate()),
			Time.getShortTimestamp(newGrupo.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingGrupo.getModifiedDate()),
			Time.getShortTimestamp(newGrupo.getModifiedDate()));
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
	public void testCountBygrupoId() throws Exception {
		_persistence.countBygrupoId(RandomTestUtil.nextLong());

		_persistence.countBygrupoId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Grupo newGrupo = addGrupo();

		Grupo existingGrupo = _persistence.findByPrimaryKey(
			newGrupo.getPrimaryKey());

		Assert.assertEquals(existingGrupo, newGrupo);
	}

	@Test(expected = NoSuchGrupoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Grupo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AVANIS_LONJAS_Grupo", "uuid", true, "entityId", true, "grupoId",
			true, "nombre", true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Grupo newGrupo = addGrupo();

		Grupo existingGrupo = _persistence.fetchByPrimaryKey(
			newGrupo.getPrimaryKey());

		Assert.assertEquals(existingGrupo, newGrupo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Grupo missingGrupo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingGrupo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Grupo newGrupo1 = addGrupo();
		Grupo newGrupo2 = addGrupo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGrupo1.getPrimaryKey());
		primaryKeys.add(newGrupo2.getPrimaryKey());

		Map<Serializable, Grupo> grupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, grupos.size());
		Assert.assertEquals(newGrupo1, grupos.get(newGrupo1.getPrimaryKey()));
		Assert.assertEquals(newGrupo2, grupos.get(newGrupo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Grupo> grupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(grupos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Grupo newGrupo = addGrupo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGrupo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Grupo> grupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, grupos.size());
		Assert.assertEquals(newGrupo, grupos.get(newGrupo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Grupo> grupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(grupos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Grupo newGrupo = addGrupo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGrupo.getPrimaryKey());

		Map<Serializable, Grupo> grupos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, grupos.size());
		Assert.assertEquals(newGrupo, grupos.get(newGrupo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			GrupoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Grupo>() {

				@Override
				public void performAction(Grupo grupo) {
					Assert.assertNotNull(grupo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Grupo newGrupo = addGrupo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Grupo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", newGrupo.getEntityId()));

		List<Grupo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Grupo existingGrupo = result.get(0);

		Assert.assertEquals(existingGrupo, newGrupo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Grupo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", RandomTestUtil.nextLong()));

		List<Grupo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Grupo newGrupo = addGrupo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Grupo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		Object newEntityId = newGrupo.getEntityId();

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
			Grupo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Grupo newGrupo = addGrupo();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newGrupo.getPrimaryKey()));
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

		Grupo newGrupo = addGrupo();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Grupo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", newGrupo.getEntityId()));

		List<Grupo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Grupo grupo) {
		Assert.assertEquals(
			Long.valueOf(grupo.getGrupoId()),
			ReflectionTestUtil.<Long>invoke(
				grupo, "getColumnOriginalValue", new Class<?>[] {String.class},
				"grupoId"));
	}

	protected Grupo addGrupo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Grupo grupo = _persistence.create(pk);

		grupo.setUuid(RandomTestUtil.randomString());

		grupo.setGrupoId(RandomTestUtil.nextLong());

		grupo.setNombre(RandomTestUtil.randomString());

		grupo.setCreateDate(RandomTestUtil.nextDate());

		grupo.setModifiedDate(RandomTestUtil.nextDate());

		_grupos.add(_persistence.update(grupo));

		return grupo;
	}

	private List<Grupo> _grupos = new ArrayList<Grupo>();
	private GrupoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}