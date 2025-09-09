/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.test;

import avanis.lonjas.exception.NoSuchPrecioLonjaException;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.service.PrecioLonjaLocalServiceUtil;
import avanis.lonjas.service.persistence.PrecioLonjaPersistence;
import avanis.lonjas.service.persistence.PrecioLonjaUtil;

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
public class PrecioLonjaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.lonjas.service"));

	@Before
	public void setUp() {
		_persistence = PrecioLonjaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PrecioLonja> iterator = _precioLonjas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PrecioLonja precioLonja = _persistence.create(pk);

		Assert.assertNotNull(precioLonja);

		Assert.assertEquals(precioLonja.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PrecioLonja newPrecioLonja = addPrecioLonja();

		_persistence.remove(newPrecioLonja);

		PrecioLonja existingPrecioLonja = _persistence.fetchByPrimaryKey(
			newPrecioLonja.getPrimaryKey());

		Assert.assertNull(existingPrecioLonja);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPrecioLonja();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PrecioLonja newPrecioLonja = _persistence.create(pk);

		newPrecioLonja.setUuid(RandomTestUtil.randomString());

		newPrecioLonja.setProductoId(RandomTestUtil.nextLong());

		newPrecioLonja.setLonjaId(RandomTestUtil.nextLong());

		newPrecioLonja.setGrupoId(RandomTestUtil.nextLong());

		newPrecioLonja.setSubGrupoId(RandomTestUtil.nextLong());

		newPrecioLonja.setAreaId(RandomTestUtil.nextLong());

		newPrecioLonja.setFecha(RandomTestUtil.nextDate());

		newPrecioLonja.setNombreProducto(RandomTestUtil.randomString());

		newPrecioLonja.setPrecioAnterior(RandomTestUtil.randomString());

		newPrecioLonja.setPrecioUltimo(RandomTestUtil.randomString());

		newPrecioLonja.setPrecioMaximo(RandomTestUtil.randomString());

		newPrecioLonja.setPrecioMedio(RandomTestUtil.randomString());

		newPrecioLonja.setPrecioMinimo(RandomTestUtil.randomString());

		newPrecioLonja.setPrecioOrigen(RandomTestUtil.randomString());

		newPrecioLonja.setAnteriorEuros(RandomTestUtil.randomString());

		newPrecioLonja.setUltimoEuros(RandomTestUtil.randomString());

		newPrecioLonja.setUnidadMedida(RandomTestUtil.randomString());

		newPrecioLonja.setUnidadLarga(RandomTestUtil.randomString());

		newPrecioLonja.setCreateDate(RandomTestUtil.nextDate());

		newPrecioLonja.setModifiedDate(RandomTestUtil.nextDate());

		_precioLonjas.add(_persistence.update(newPrecioLonja));

		PrecioLonja existingPrecioLonja = _persistence.findByPrimaryKey(
			newPrecioLonja.getPrimaryKey());

		Assert.assertEquals(
			existingPrecioLonja.getUuid(), newPrecioLonja.getUuid());
		Assert.assertEquals(
			existingPrecioLonja.getEntityId(), newPrecioLonja.getEntityId());
		Assert.assertEquals(
			existingPrecioLonja.getProductoId(),
			newPrecioLonja.getProductoId());
		Assert.assertEquals(
			existingPrecioLonja.getLonjaId(), newPrecioLonja.getLonjaId());
		Assert.assertEquals(
			existingPrecioLonja.getGrupoId(), newPrecioLonja.getGrupoId());
		Assert.assertEquals(
			existingPrecioLonja.getSubGrupoId(),
			newPrecioLonja.getSubGrupoId());
		Assert.assertEquals(
			existingPrecioLonja.getAreaId(), newPrecioLonja.getAreaId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrecioLonja.getFecha()),
			Time.getShortTimestamp(newPrecioLonja.getFecha()));
		Assert.assertEquals(
			existingPrecioLonja.getNombreProducto(),
			newPrecioLonja.getNombreProducto());
		Assert.assertEquals(
			existingPrecioLonja.getPrecioAnterior(),
			newPrecioLonja.getPrecioAnterior());
		Assert.assertEquals(
			existingPrecioLonja.getPrecioUltimo(),
			newPrecioLonja.getPrecioUltimo());
		Assert.assertEquals(
			existingPrecioLonja.getPrecioMaximo(),
			newPrecioLonja.getPrecioMaximo());
		Assert.assertEquals(
			existingPrecioLonja.getPrecioMedio(),
			newPrecioLonja.getPrecioMedio());
		Assert.assertEquals(
			existingPrecioLonja.getPrecioMinimo(),
			newPrecioLonja.getPrecioMinimo());
		Assert.assertEquals(
			existingPrecioLonja.getPrecioOrigen(),
			newPrecioLonja.getPrecioOrigen());
		Assert.assertEquals(
			existingPrecioLonja.getAnteriorEuros(),
			newPrecioLonja.getAnteriorEuros());
		Assert.assertEquals(
			existingPrecioLonja.getUltimoEuros(),
			newPrecioLonja.getUltimoEuros());
		Assert.assertEquals(
			existingPrecioLonja.getUnidadMedida(),
			newPrecioLonja.getUnidadMedida());
		Assert.assertEquals(
			existingPrecioLonja.getUnidadLarga(),
			newPrecioLonja.getUnidadLarga());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrecioLonja.getCreateDate()),
			Time.getShortTimestamp(newPrecioLonja.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPrecioLonja.getModifiedDate()),
			Time.getShortTimestamp(newPrecioLonja.getModifiedDate()));
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
	public void testCountByproductoId() throws Exception {
		_persistence.countByproductoId(RandomTestUtil.nextLong());

		_persistence.countByproductoId(0L);
	}

	@Test
	public void testCountBylonjaIdProductoId() throws Exception {
		_persistence.countBylonjaIdProductoId(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countBylonjaIdProductoId(0L, 0L);
	}

	@Test
	public void testCountBylonjaIdFecha() throws Exception {
		_persistence.countBylonjaIdFecha(
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate());

		_persistence.countBylonjaIdFecha(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountBylonjaIdGrupoIdFecha() throws Exception {
		_persistence.countBylonjaIdGrupoIdFecha(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countBylonjaIdGrupoIdFecha(
			0L, 0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountBylonjaIdGrupoIdSubGrupoIdFecha() throws Exception {
		_persistence.countBylonjaIdGrupoIdSubGrupoIdFecha(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate());

		_persistence.countBylonjaIdGrupoIdSubGrupoIdFecha(
			0L, 0L, 0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountBylonjaIdGrupoIdSubGrupoIdAreaIdFecha()
		throws Exception {

		_persistence.countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			0L, 0L, 0L, 0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PrecioLonja newPrecioLonja = addPrecioLonja();

		PrecioLonja existingPrecioLonja = _persistence.findByPrimaryKey(
			newPrecioLonja.getPrimaryKey());

		Assert.assertEquals(existingPrecioLonja, newPrecioLonja);
	}

	@Test(expected = NoSuchPrecioLonjaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PrecioLonja> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AVANIS_LONJAS_PrecioLonja", "uuid", true, "entityId", true,
			"productoId", true, "lonjaId", true, "grupoId", true, "subGrupoId",
			true, "areaId", true, "fecha", true, "nombreProducto", true,
			"precioAnterior", true, "precioUltimo", true, "precioMaximo", true,
			"precioMedio", true, "precioMinimo", true, "precioOrigen", true,
			"anteriorEuros", true, "ultimoEuros", true, "unidadMedida", true,
			"unidadLarga", true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PrecioLonja newPrecioLonja = addPrecioLonja();

		PrecioLonja existingPrecioLonja = _persistence.fetchByPrimaryKey(
			newPrecioLonja.getPrimaryKey());

		Assert.assertEquals(existingPrecioLonja, newPrecioLonja);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PrecioLonja missingPrecioLonja = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPrecioLonja);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PrecioLonja newPrecioLonja1 = addPrecioLonja();
		PrecioLonja newPrecioLonja2 = addPrecioLonja();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrecioLonja1.getPrimaryKey());
		primaryKeys.add(newPrecioLonja2.getPrimaryKey());

		Map<Serializable, PrecioLonja> precioLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, precioLonjas.size());
		Assert.assertEquals(
			newPrecioLonja1, precioLonjas.get(newPrecioLonja1.getPrimaryKey()));
		Assert.assertEquals(
			newPrecioLonja2, precioLonjas.get(newPrecioLonja2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PrecioLonja> precioLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(precioLonjas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PrecioLonja newPrecioLonja = addPrecioLonja();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrecioLonja.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PrecioLonja> precioLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, precioLonjas.size());
		Assert.assertEquals(
			newPrecioLonja, precioLonjas.get(newPrecioLonja.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PrecioLonja> precioLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(precioLonjas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PrecioLonja newPrecioLonja = addPrecioLonja();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPrecioLonja.getPrimaryKey());

		Map<Serializable, PrecioLonja> precioLonjas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, precioLonjas.size());
		Assert.assertEquals(
			newPrecioLonja, precioLonjas.get(newPrecioLonja.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PrecioLonjaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PrecioLonja>() {

				@Override
				public void performAction(PrecioLonja precioLonja) {
					Assert.assertNotNull(precioLonja);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PrecioLonja newPrecioLonja = addPrecioLonja();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PrecioLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"entityId", newPrecioLonja.getEntityId()));

		List<PrecioLonja> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PrecioLonja existingPrecioLonja = result.get(0);

		Assert.assertEquals(existingPrecioLonja, newPrecioLonja);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PrecioLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", RandomTestUtil.nextLong()));

		List<PrecioLonja> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PrecioLonja newPrecioLonja = addPrecioLonja();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PrecioLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		Object newEntityId = newPrecioLonja.getEntityId();

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
			PrecioLonja.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected PrecioLonja addPrecioLonja() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PrecioLonja precioLonja = _persistence.create(pk);

		precioLonja.setUuid(RandomTestUtil.randomString());

		precioLonja.setProductoId(RandomTestUtil.nextLong());

		precioLonja.setLonjaId(RandomTestUtil.nextLong());

		precioLonja.setGrupoId(RandomTestUtil.nextLong());

		precioLonja.setSubGrupoId(RandomTestUtil.nextLong());

		precioLonja.setAreaId(RandomTestUtil.nextLong());

		precioLonja.setFecha(RandomTestUtil.nextDate());

		precioLonja.setNombreProducto(RandomTestUtil.randomString());

		precioLonja.setPrecioAnterior(RandomTestUtil.randomString());

		precioLonja.setPrecioUltimo(RandomTestUtil.randomString());

		precioLonja.setPrecioMaximo(RandomTestUtil.randomString());

		precioLonja.setPrecioMedio(RandomTestUtil.randomString());

		precioLonja.setPrecioMinimo(RandomTestUtil.randomString());

		precioLonja.setPrecioOrigen(RandomTestUtil.randomString());

		precioLonja.setAnteriorEuros(RandomTestUtil.randomString());

		precioLonja.setUltimoEuros(RandomTestUtil.randomString());

		precioLonja.setUnidadMedida(RandomTestUtil.randomString());

		precioLonja.setUnidadLarga(RandomTestUtil.randomString());

		precioLonja.setCreateDate(RandomTestUtil.nextDate());

		precioLonja.setModifiedDate(RandomTestUtil.nextDate());

		_precioLonjas.add(_persistence.update(precioLonja));

		return precioLonja;
	}

	private List<PrecioLonja> _precioLonjas = new ArrayList<PrecioLonja>();
	private PrecioLonjaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}