/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.test;

import avanis.lonjas.exception.NoSuchProductoExplotException;
import avanis.lonjas.model.ProductoExplot;
import avanis.lonjas.service.ProductoExplotLocalServiceUtil;
import avanis.lonjas.service.persistence.ProductoExplotPersistence;
import avanis.lonjas.service.persistence.ProductoExplotUtil;

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
public class ProductoExplotPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.lonjas.service"));

	@Before
	public void setUp() {
		_persistence = ProductoExplotUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ProductoExplot> iterator = _productoExplots.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoExplot productoExplot = _persistence.create(pk);

		Assert.assertNotNull(productoExplot);

		Assert.assertEquals(productoExplot.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ProductoExplot newProductoExplot = addProductoExplot();

		_persistence.remove(newProductoExplot);

		ProductoExplot existingProductoExplot = _persistence.fetchByPrimaryKey(
			newProductoExplot.getPrimaryKey());

		Assert.assertNull(existingProductoExplot);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addProductoExplot();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoExplot newProductoExplot = _persistence.create(pk);

		newProductoExplot.setUuid(RandomTestUtil.randomString());

		newProductoExplot.setLonjaId(RandomTestUtil.nextLong());

		newProductoExplot.setProductoId(RandomTestUtil.nextLong());

		newProductoExplot.setPrecioLonjaId(RandomTestUtil.nextLong());

		newProductoExplot.setExplotacionId(RandomTestUtil.nextLong());

		newProductoExplot.setOrden(RandomTestUtil.nextLong());

		newProductoExplot.setCreateDate(RandomTestUtil.nextDate());

		newProductoExplot.setModifiedDate(RandomTestUtil.nextDate());

		_productoExplots.add(_persistence.update(newProductoExplot));

		ProductoExplot existingProductoExplot = _persistence.findByPrimaryKey(
			newProductoExplot.getPrimaryKey());

		Assert.assertEquals(
			existingProductoExplot.getUuid(), newProductoExplot.getUuid());
		Assert.assertEquals(
			existingProductoExplot.getEntityId(),
			newProductoExplot.getEntityId());
		Assert.assertEquals(
			existingProductoExplot.getLonjaId(),
			newProductoExplot.getLonjaId());
		Assert.assertEquals(
			existingProductoExplot.getProductoId(),
			newProductoExplot.getProductoId());
		Assert.assertEquals(
			existingProductoExplot.getPrecioLonjaId(),
			newProductoExplot.getPrecioLonjaId());
		Assert.assertEquals(
			existingProductoExplot.getExplotacionId(),
			newProductoExplot.getExplotacionId());
		Assert.assertEquals(
			existingProductoExplot.getOrden(), newProductoExplot.getOrden());
		Assert.assertEquals(
			Time.getShortTimestamp(existingProductoExplot.getCreateDate()),
			Time.getShortTimestamp(newProductoExplot.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingProductoExplot.getModifiedDate()),
			Time.getShortTimestamp(newProductoExplot.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByexplotacionId() throws Exception {
		_persistence.countByexplotacionId(RandomTestUtil.nextLong());

		_persistence.countByexplotacionId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ProductoExplot newProductoExplot = addProductoExplot();

		ProductoExplot existingProductoExplot = _persistence.findByPrimaryKey(
			newProductoExplot.getPrimaryKey());

		Assert.assertEquals(existingProductoExplot, newProductoExplot);
	}

	@Test(expected = NoSuchProductoExplotException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ProductoExplot> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AVANIS_LONJAS_ProductoExplot", "uuid", true, "entityId", true,
			"lonjaId", true, "productoId", true, "precioLonjaId", true,
			"explotacionId", true, "orden", true, "createDate", true,
			"modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ProductoExplot newProductoExplot = addProductoExplot();

		ProductoExplot existingProductoExplot = _persistence.fetchByPrimaryKey(
			newProductoExplot.getPrimaryKey());

		Assert.assertEquals(existingProductoExplot, newProductoExplot);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoExplot missingProductoExplot = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingProductoExplot);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ProductoExplot newProductoExplot1 = addProductoExplot();
		ProductoExplot newProductoExplot2 = addProductoExplot();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductoExplot1.getPrimaryKey());
		primaryKeys.add(newProductoExplot2.getPrimaryKey());

		Map<Serializable, ProductoExplot> productoExplots =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, productoExplots.size());
		Assert.assertEquals(
			newProductoExplot1,
			productoExplots.get(newProductoExplot1.getPrimaryKey()));
		Assert.assertEquals(
			newProductoExplot2,
			productoExplots.get(newProductoExplot2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ProductoExplot> productoExplots =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(productoExplots.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ProductoExplot newProductoExplot = addProductoExplot();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductoExplot.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ProductoExplot> productoExplots =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, productoExplots.size());
		Assert.assertEquals(
			newProductoExplot,
			productoExplots.get(newProductoExplot.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ProductoExplot> productoExplots =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(productoExplots.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ProductoExplot newProductoExplot = addProductoExplot();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductoExplot.getPrimaryKey());

		Map<Serializable, ProductoExplot> productoExplots =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, productoExplots.size());
		Assert.assertEquals(
			newProductoExplot,
			productoExplots.get(newProductoExplot.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ProductoExplotLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ProductoExplot>() {

				@Override
				public void performAction(ProductoExplot productoExplot) {
					Assert.assertNotNull(productoExplot);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ProductoExplot newProductoExplot = addProductoExplot();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductoExplot.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"entityId", newProductoExplot.getEntityId()));

		List<ProductoExplot> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ProductoExplot existingProductoExplot = result.get(0);

		Assert.assertEquals(existingProductoExplot, newProductoExplot);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductoExplot.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", RandomTestUtil.nextLong()));

		List<ProductoExplot> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ProductoExplot newProductoExplot = addProductoExplot();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductoExplot.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		Object newEntityId = newProductoExplot.getEntityId();

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
			ProductoExplot.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ProductoExplot addProductoExplot() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoExplot productoExplot = _persistence.create(pk);

		productoExplot.setUuid(RandomTestUtil.randomString());

		productoExplot.setLonjaId(RandomTestUtil.nextLong());

		productoExplot.setProductoId(RandomTestUtil.nextLong());

		productoExplot.setPrecioLonjaId(RandomTestUtil.nextLong());

		productoExplot.setExplotacionId(RandomTestUtil.nextLong());

		productoExplot.setOrden(RandomTestUtil.nextLong());

		productoExplot.setCreateDate(RandomTestUtil.nextDate());

		productoExplot.setModifiedDate(RandomTestUtil.nextDate());

		_productoExplots.add(_persistence.update(productoExplot));

		return productoExplot;
	}

	private List<ProductoExplot> _productoExplots =
		new ArrayList<ProductoExplot>();
	private ProductoExplotPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}