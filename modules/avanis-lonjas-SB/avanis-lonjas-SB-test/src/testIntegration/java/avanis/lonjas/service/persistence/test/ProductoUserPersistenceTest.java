/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.test;

import avanis.lonjas.exception.NoSuchProductoUserException;
import avanis.lonjas.model.ProductoUser;
import avanis.lonjas.service.ProductoUserLocalServiceUtil;
import avanis.lonjas.service.persistence.ProductoUserPersistence;
import avanis.lonjas.service.persistence.ProductoUserUtil;

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
public class ProductoUserPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "avanis.lonjas.service"));

	@Before
	public void setUp() {
		_persistence = ProductoUserUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ProductoUser> iterator = _productoUsers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoUser productoUser = _persistence.create(pk);

		Assert.assertNotNull(productoUser);

		Assert.assertEquals(productoUser.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ProductoUser newProductoUser = addProductoUser();

		_persistence.remove(newProductoUser);

		ProductoUser existingProductoUser = _persistence.fetchByPrimaryKey(
			newProductoUser.getPrimaryKey());

		Assert.assertNull(existingProductoUser);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addProductoUser();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoUser newProductoUser = _persistence.create(pk);

		newProductoUser.setUuid(RandomTestUtil.randomString());

		newProductoUser.setLonjaId(RandomTestUtil.nextLong());

		newProductoUser.setProductoId(RandomTestUtil.nextLong());

		newProductoUser.setPrecioLonjaId(RandomTestUtil.nextLong());

		newProductoUser.setUserId(RandomTestUtil.nextLong());

		newProductoUser.setOrden(RandomTestUtil.nextLong());

		newProductoUser.setCreateDate(RandomTestUtil.nextDate());

		newProductoUser.setModifiedDate(RandomTestUtil.nextDate());

		_productoUsers.add(_persistence.update(newProductoUser));

		ProductoUser existingProductoUser = _persistence.findByPrimaryKey(
			newProductoUser.getPrimaryKey());

		Assert.assertEquals(
			existingProductoUser.getUuid(), newProductoUser.getUuid());
		Assert.assertEquals(
			existingProductoUser.getEntityId(), newProductoUser.getEntityId());
		Assert.assertEquals(
			existingProductoUser.getLonjaId(), newProductoUser.getLonjaId());
		Assert.assertEquals(
			existingProductoUser.getProductoId(),
			newProductoUser.getProductoId());
		Assert.assertEquals(
			existingProductoUser.getPrecioLonjaId(),
			newProductoUser.getPrecioLonjaId());
		Assert.assertEquals(
			existingProductoUser.getUserId(), newProductoUser.getUserId());
		Assert.assertEquals(
			existingProductoUser.getOrden(), newProductoUser.getOrden());
		Assert.assertEquals(
			Time.getShortTimestamp(existingProductoUser.getCreateDate()),
			Time.getShortTimestamp(newProductoUser.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingProductoUser.getModifiedDate()),
			Time.getShortTimestamp(newProductoUser.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByuserId() throws Exception {
		_persistence.countByuserId(RandomTestUtil.nextLong());

		_persistence.countByuserId(0L);
	}

	@Test
	public void testCountByuserIdlonjaIdproductoId() throws Exception {
		_persistence.countByuserIdlonjaIdproductoId(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByuserIdlonjaIdproductoId(0L, 0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ProductoUser newProductoUser = addProductoUser();

		ProductoUser existingProductoUser = _persistence.findByPrimaryKey(
			newProductoUser.getPrimaryKey());

		Assert.assertEquals(existingProductoUser, newProductoUser);
	}

	@Test(expected = NoSuchProductoUserException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ProductoUser> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AVANIS_LONJAS_ProductoUser", "uuid", true, "entityId", true,
			"lonjaId", true, "productoId", true, "precioLonjaId", true,
			"userId", true, "orden", true, "createDate", true, "modifiedDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ProductoUser newProductoUser = addProductoUser();

		ProductoUser existingProductoUser = _persistence.fetchByPrimaryKey(
			newProductoUser.getPrimaryKey());

		Assert.assertEquals(existingProductoUser, newProductoUser);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoUser missingProductoUser = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingProductoUser);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ProductoUser newProductoUser1 = addProductoUser();
		ProductoUser newProductoUser2 = addProductoUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductoUser1.getPrimaryKey());
		primaryKeys.add(newProductoUser2.getPrimaryKey());

		Map<Serializable, ProductoUser> productoUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, productoUsers.size());
		Assert.assertEquals(
			newProductoUser1,
			productoUsers.get(newProductoUser1.getPrimaryKey()));
		Assert.assertEquals(
			newProductoUser2,
			productoUsers.get(newProductoUser2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ProductoUser> productoUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(productoUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ProductoUser newProductoUser = addProductoUser();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductoUser.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ProductoUser> productoUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, productoUsers.size());
		Assert.assertEquals(
			newProductoUser,
			productoUsers.get(newProductoUser.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ProductoUser> productoUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(productoUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ProductoUser newProductoUser = addProductoUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductoUser.getPrimaryKey());

		Map<Serializable, ProductoUser> productoUsers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, productoUsers.size());
		Assert.assertEquals(
			newProductoUser,
			productoUsers.get(newProductoUser.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ProductoUserLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ProductoUser>() {

				@Override
				public void performAction(ProductoUser productoUser) {
					Assert.assertNotNull(productoUser);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ProductoUser newProductoUser = addProductoUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductoUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"entityId", newProductoUser.getEntityId()));

		List<ProductoUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ProductoUser existingProductoUser = result.get(0);

		Assert.assertEquals(existingProductoUser, newProductoUser);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductoUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entityId", RandomTestUtil.nextLong()));

		List<ProductoUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ProductoUser newProductoUser = addProductoUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductoUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		Object newEntityId = newProductoUser.getEntityId();

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
			ProductoUser.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entityId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entityId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ProductoUser newProductoUser = addProductoUser();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newProductoUser.getPrimaryKey()));
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

		ProductoUser newProductoUser = addProductoUser();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductoUser.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"entityId", newProductoUser.getEntityId()));

		List<ProductoUser> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(ProductoUser productoUser) {
		Assert.assertEquals(
			Long.valueOf(productoUser.getUserId()),
			ReflectionTestUtil.<Long>invoke(
				productoUser, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "userId"));
		Assert.assertEquals(
			Long.valueOf(productoUser.getLonjaId()),
			ReflectionTestUtil.<Long>invoke(
				productoUser, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "lonjaId"));
		Assert.assertEquals(
			Long.valueOf(productoUser.getProductoId()),
			ReflectionTestUtil.<Long>invoke(
				productoUser, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "productoId"));
	}

	protected ProductoUser addProductoUser() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductoUser productoUser = _persistence.create(pk);

		productoUser.setUuid(RandomTestUtil.randomString());

		productoUser.setLonjaId(RandomTestUtil.nextLong());

		productoUser.setProductoId(RandomTestUtil.nextLong());

		productoUser.setPrecioLonjaId(RandomTestUtil.nextLong());

		productoUser.setUserId(RandomTestUtil.nextLong());

		productoUser.setOrden(RandomTestUtil.nextLong());

		productoUser.setCreateDate(RandomTestUtil.nextDate());

		productoUser.setModifiedDate(RandomTestUtil.nextDate());

		_productoUsers.add(_persistence.update(productoUser));

		return productoUser;
	}

	private List<ProductoUser> _productoUsers = new ArrayList<ProductoUser>();
	private ProductoUserPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}